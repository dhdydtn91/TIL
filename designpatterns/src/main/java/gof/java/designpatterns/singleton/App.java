package gof.java.designpatterns.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Settings settings = Settings.INSTANCE;
        Settings settings1 = null;

        Constructor<?>[] constructor = Settings.class.getDeclaredConstructors();
        for (Constructor<?> construct : constructor) {
            construct.setAccessible(true);
            settings1 = (Settings) construct.newInstance("INSTANCE");
        }
        System.out.println(settings == settings1);
        Settings settings2 = null;

        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("settings.obj"))){
            output.writeObject(settings);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))){
            settings2 = (Settings) in.readObject();
        }
        System.out.println(settings == settings2);
    }
}
