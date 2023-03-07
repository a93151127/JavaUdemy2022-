package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DynamicReflectionMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //new 一個物件的方法
        Class c1 = Class.forName("reflection.User");

        Constructor con = c1.getDeclaredConstructor(String.class,
                String.class, int.class);
        User u1 = (User) con.newInstance("1", "martin", 36);
        System.out.println(u1);

        //使用reflection設置屬性
        Field field = c1.getDeclaredField("name");
        //只要有使用setAccessible,即使name這個屬性為private都可以修改
        field.setAccessible(true);
        field.set(u1, "wilson");

        System.out.println(u1);

    }
}
