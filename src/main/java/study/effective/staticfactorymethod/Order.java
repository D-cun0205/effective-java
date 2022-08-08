package study.effective.staticfactorymethod;

// 정적 팩토리 메서드의 장점 첫 번째

class Product { }

public class Order {
    private boolean prime;
    private boolean urgent;
    private Product product;

    //일반적인 생성자
//    Order(Product product, boolean prime) {
//        this.product = product;
//        this.prime = prime;
//    }

    //prime 을 사용하지 않고 urgent 를 포함한 생성자를 만들 경우 동일한 시그니처로 인해 컴파일 에러 발생
//    Order(Product product, boolean urgent) {
//        this.product = product;
//        this.prime = prime;
//    }

    //순서를 다르게 하여 문제를 해결할 수 있으나 정적 팩토리 메서드를 사용하여 해결
//    Order(boolean urgent, Product product) {
//        this.urgent = urgent;
//        this.product = product;
//    }

    //아래 기본 생성자가 없어서 에러가 발생하나 위에 생성자 코드를 제거하면 기본 생성자가 생성되어 컴파일 에러 제거됨
    //필요한 메서드 시그니처를 만들어 유연한 정적 팩터리 메서드로 객체를 생성할 수 있다
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.product = product;
        order.prime = true;
        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.product = product;
        order.urgent = false;
        return order;
    }
}
