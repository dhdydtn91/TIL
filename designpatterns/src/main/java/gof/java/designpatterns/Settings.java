package gof.java.designpatterns;

import java.io.Serializable;

public class Settings implements Serializable {

    private Settings() {}

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance(){
        return SettingsHolder.INSTANCE;
    }

    //역직렬화 직렬화 사용 시 대응 방안
    protected Object readResolve(){
        return getInstance();
    }
}
