package staticfactorymethod;

public class EnglishHelloService implements HelloServiceFactory {
    @Override
    public void message() {
        System.out.println("hello english");
    }
}
