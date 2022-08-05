package staticfactorymethod;

public class KoreanHelloService implements HelloServiceFactory {
    @Override
    public void message() {
        System.out.println("hello korea");
    }
}
