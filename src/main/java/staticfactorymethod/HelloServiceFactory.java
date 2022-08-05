package staticfactorymethod;

// 정적 팩토리 메서드의 장점 세 번째 ~ 다섯 번째 장점

public interface HelloServiceFactory {
    void message();

    // 세 번째
    // 생성자를 사용할 경우 클래스 타입만 가능하며 정적 팩토리 메서드의 경우
    // 인터페이스 타입으로 받을 수 있다

    // 네 번째
    // 매개변수를 이용하여 동일한 인터페이스 타입의 다양한 구현체를 생성할 수 있다

    // 다섯 번째
    // 컴파일 단계에 직접적인 구현체가 없어도 된다 (HelloServiceLoaderFactory 코드 참조)
    // 특정 인터페이스를 구현하고 있는 구현체를 jar 파일로 의존성을 주입하고
    // ServiceLoader 를 사용하여 직접적인 구현 생성 코드 없이 서비스로더에 할당 된 구현 객체를
    // 사용할 수 있으며 ServiceLoader 를 사용하지 않고 직접 객체를 생성하여 처리할 수 있지만 의존성의 차이가 있다
    // ServiceLoader 를 사용하지는 않았지만 비슷한 방법으로 사용되는 JDBC 가 있다

    // 서비스 로더: 어플리케이션 내부에서 플러그인 제공에 사용되며 특정 기능을 제공하기 위한 인터페이스가 있으며
    // 해당 인터페이스의 다양한 구현체를 적용하기 위한 용도
    static HelloServiceFactory of(String lang) {
        if ("ko".equals(lang)) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }

    // 첫 번째 단점 상속 불가
    // mvn javadoc:javadoc 으로 생성한 문서에서 정적 팩토리 메서드를 사용한 객체 생성법을 찾기가 어려움
    // 네이밍 패턴을 사용한 of, getInstance 등 알아보기 쉬운 이름을 사용하여 Method Summary 에서 쉽게 찾을 수 있도록 정의
    // 또는 javadoc 주석(/** */)을 사용하여 해당 객체는 정적 팩터리 메서드를 사용하여 객체를 사용한다고 명시
}