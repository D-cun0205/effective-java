## 메시지 체인(Message Chains)

    레퍼런스를 따라 계속해서 메서드 호출이 이어지는 코드
    해당 코드의 클라이언트가 코드 체인을 모두 이해해야 한다
    체인 중 일부가 변경되면 클라이언트의 코드도 변경이 필요해진다

---

### 위임 숨기기(Hide Delegate)

* 캡슐화란 어떤 모듈이 시스템의 다른 모듈을 최소한으로 알아야 하는 것


    아래 코드를 사용하는 메인 함수에서 Person.getDepartment.getManger 를 이용하는 경우
    afterPerson 코드의 getManager 만 호출하고 Department 를 통해 생성된다는 정보를 은닉할 수 있다

```java
class beforeDepartment {
    private String chargeCode;
    private Person manager;
    
    // ...getter, constructor
}

class beforePerson {
    private String name;
    private Department department;
    
    // ...getter, setter, constructor
}

class afterPerson {
    afterPerson getManager() {
        return getDepartment.getManager();
    }
}
```

## 중재자(Middle Man)

    캡슐화를 통해 내부의 구체적인 정보를 최대한 감춤
    어떤 클래스의 메서드가 대부분 다른 클래스로 메서드 호출을 위임하면 중재자를 제거하고 직접 사용하도록 개선

---

### 중재자 제거하기(Remove Middle Man)

* 위임숨기기의 반대
* encapsulation 의 정도에 따라 바뀔 수 있음
* 중재자 제거하기, 위임 숨기기로 조절
* Low of Demeter(디미터 법칙: 가장 가까운 객체 사용) 를 지나치게 따르지 말고 상황에 맞게 사용


    beforePerson - getManager 메서드를 보면 department 를 통한 manager 호출이 캡슐화 되어 있다
    위임 숨기기의 반대로 getter 를 생성하여 department 를 접근하여 manager 를 호출하도록 변경

```java
class beforeDepartment {
    private Person manager;
    
    // ...getter, constructor
}

class beforePerson {
    private Department department;
    private String name;
    
    // ...constructor
    
    public Person getManager() {
        return this.department.getManager();
    }
}

class afterPerson {
    private Department department;
    private String name;

    // ...constructor

    // ...getManager 제거

    public Department getDepartment() {
        return this.department;
    }
}
```

### 슈퍼클래스를 위임으로 바꾸기(Replace Superclass with Delegate)

* 객체지향에서 상속은 기존의 기능을 재사용하는 쉬우면서 강력한 방법
* 서브클래스는 슈퍼클래스의 모든 기능을 지원
* 리스코프 치환 원칙
* 서브클래스는 슈퍼클래스의 변경에 취약


    afterscroll 클래스에 상속을 제거하고 생성자에 위임

```java
class beforeCategoryItem {
    private Integer id;
    private String title;
    private List<String> tags;
    
    // ...getter, constructor

    public boolean hasTag(String tag) {
        return this.tags.contains(tag);
    }
}

class beforeScroll extends beforeCategoryItem {
    private LocalDate dateLastCleaned;

    public Scroll(Integer id, String title, List<String> tags, LocalDate dateLastCleaned) {
        super(id, title, tags);
        this.dateLastCleaned = dateLastCleaned;
    }

    public long daysSinceLastCleaning(LocalDate targetDate) {
        return this.dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
    }
}

class afterScroll {
    private LocalDate dateLastCleaned;
    private CategoryItem categoryItem;

    public Scroll(Integer id, String title, List<String> tags, LocalDate dateLastCleaned) {
        this.dateLastCleaned = dateLastCleaned;
        this.categoryItem = new CategoryItem(id, title, tags);
    }

    public long daysSinceLastCleaning(LocalDate targetDate) {
        return this.dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
    }
}
```

### 서브클래스를 위임으로 바꾸기(Replace Subclass with Delegate)

* 어떤 객체의 행동이 카테고리에 따라 바뀌는 경우 상속을 사용해 표현
* 여러가지의 카테고리로 구분하는 경우 중복 상속을 허용하지 않으며 위임으로 해결해야 한다


    유연한 객체 생성을 위해 afterBooking 클래스에서 스테틱 팩토리 메서드를 이용
    기존 서브클래스에 있던 기능들을 afterPremiumDelegation 에 옮긴 후 서브 클래스 제거
    상속구조는 제거되고 afterPremiumDelegation 객체 생성 여부를 알고 있는 Booking 클래스에서
    분기에 의해 처리되도록 코드 수정

```java
class beforeBooking {
    protected Show show;

    protected LocalDateTime time;

    public Booking(Show show, LocalDateTime time) {
        this.show = show;
        this.time = time;
    }

    public boolean hasTalkback() {
        return this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    protected boolean isPeakDay() {
        DayOfWeek dayOfWeek = this.time.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public double basePrice() {
        double result = this.show.getPrice();
        if (this.isPeakDay()) result += Math.round(result * 0.15);
        return result;
    }
}

class beforePremiumBooking {
    private PremiumExtra extra;

    public PremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
        super(show, time);
        this.extra = extra;
    }

    @Override
    public boolean hasTalkback() {
        return this.show.hasOwnProperty("talkback");
    }

    @Override
    public double basePrice() {
        return Math.round(super.basePrice() + this.extra.getPremiumFee());
    }

    public boolean hasDinner() {
        return this.extra.hasOwnProperty("dinner") && !this.isPeakDay();
    }
}

class beforePremiumExtra {
    private List<String> properties;
    private double premiumFee;

    // ...getPremiumFee, constructor

    public boolean hasOwnProperty(String property) {
        return this.properties.contains(property);
    }
}

class beforeShow {
    private List<String> properties;
    private double price;

    // ...getPrice, constructor

    public boolean hasOwnProperty(String property) {
        return this.properties.contains(property);
    }
}

class afterBooking {
    protected Show show;
    protected LocalDateTime time;
    protected PremiumDelegation premiumDelegation;

    public Booking(Show show, LocalDateTime time) {
        this.show = show;
        this.time = time;
    }

    public static Booking createBooking(Show show, LocalDateTime time) {
        return new Booking(show, time);
    }

    public static Booking createPremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
        Booking booking = new Booking(show, time);
        booking.premiumDelegation = new PremiumDelegation(new Booking(show, time), extra);
        return booking;
    }

    public boolean hasTalkback() {
        return (this.premiumDelegation != null) ? this.premiumDelegation.hasTalkback() :
                this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    protected boolean isPeakDay() {
        DayOfWeek dayOfWeek = this.time.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public double basePrice() {
        double result = this.show.getPrice();
        if (this.isPeakDay()) result += Math.round(result * 0.15);
        return (this.premiumDelegation != null) ? this.premiumDelegation.basePrice(result) : result;
    }

    public boolean hasDinner() {
        return (this.premiumDelegation != null) ? this.premiumDelegation.hasDinner() : false;
    }
}

class afterPremiumDelegation {
    private Booking booking;
    private PremiumExtra extra;

    public PremiumDelegation(Booking booking, PremiumExtra extra) {
        this.booking = booking;
        this.extra = extra;
    }

    public boolean hasTalkback() {
        return this.booking.show.hasOwnProperty("talkback");
    }

    public double basePrice(double result) {
        return this.extra.getPremiumFee() + result;
    }

    public boolean hasDinner() {
        return this.extra.hasOwnProperty("dinner") && !this.booking.isPeakDay();
    }
}

// beforePremiumBooking 제거 
```

## 내부자 거래(Insider Trading)

    어떤 모듈이 다른 모듈의 내부 정보를 지나치게 많이 알고 있는 코드(강한 결합도)

---

    beforeCheckIn - isFastPass 에서 불필요하게 많은 beforeTicket 클래스의 메서드에 접근한다
    isFastPass 메서드를 beforeTicket 클래스로 옮기고 beforeCheckIn 클래스를 제거

```java
class beforeCheckIn {
    public boolean isFastPass(Ticket ticket) {
        LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
        return ticket.isPrime() && ticket.getPurchasedDate().isBefore(earlyBirdDate);
    }
}

class beforeTicket {
    private LocalDate purchasedDate;
    private boolean prime;

    // ...constructor, getPurchasedDate, isPrime
}

// beforeCheckIn 클래스 제거

class afterTicket {
    private LocalDate purchasedDate;
    private boolean prime;

    // ...constructor, getPurchasedDate, isPrime

    public boolean isFastPass() {
        LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
        return isPrime() && getPurchasedDate().isBefore(earlyBirdDate);
    }
}
```

## 거대한 클래스(Large Class)

    어떤 클래스가 너무 많은 일을 하다보면 필드도 많아지고 중복 코드가 보이기 시작
    상속 구조를 만들 수 있다면 슈퍼클래스 추출하기 또는 타입 코드를 서브클래스로 교체하기 적용 가능
    클래스 내부에 산재하는 중복 코드는 메서드를 추출하여 제거 가능

---

### 슈퍼클래스 추출하기(Extract Superclass)

* 두 개의 클래스에서 비슷한 것들이 보인다면 상속을 적용하고 슈퍼클래스로 필드, 메서드 올리기 적용
* 대안으로 클래스 추출하기 사용 가능


```java
class beforeDepartment {
    
}

class beforeEmployee {
    
}
```