package staticfactorymethod;

// 정적 팩토리 메서드의 장점 두 번째

public class Settings {

    // 객체를 생성할 사용자가 객체를 직접 컨트롤하지 못하도록 해당 클래스에서
    // 객체를 미리 생성하고 동일한 객체를 받도록 강제할 수 있다
    private Settings() {}
    private static final Settings SETTINGS = new Settings();

    // 사용자는 메서드로만 객체를 받을 수 있음
    public static Settings getInstance() {
        return SETTINGS;
    }
}
