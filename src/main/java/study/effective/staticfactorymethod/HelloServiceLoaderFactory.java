package study.effective.staticfactorymethod;

import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceLoaderFactory {
    public static void main(String[] args) {
        ServiceLoader<HelloServiceFactory> loader = ServiceLoader.load(HelloServiceFactory.class);
        Optional<HelloServiceFactory> helloService = loader.findFirst();
        helloService.ifPresent(h -> {
            h.message();
        });

        // 직접 호출하여 ChineseHelloService 에 의존적이다
//        HelloServiceFactory helloService = new ChineseHelloService();
//        helloService.message();
    }
}
