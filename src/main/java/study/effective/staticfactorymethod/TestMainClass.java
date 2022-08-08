package study.effective.staticfactorymethod;

public class TestMainClass {
    public static void main(String[] args) {
        HelloServiceFactory ko = HelloServiceFactory.of("ko");
        ko.message();

        HelloServiceFactory eng = HelloServiceFactory.of("eng");
        eng.message();
    }
}
