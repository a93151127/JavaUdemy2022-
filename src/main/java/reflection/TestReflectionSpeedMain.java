package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectionSpeedMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //一般new的方法
        User u1 = new User();
        Long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            u1.getName();
        }
        Long end = System.currentTimeMillis();
        System.out.println("一般time spend : " + (end - start));

        //反射的方法關閉"安全機制"
        Class c2 = u1.getClass();
        Method getName = c2.getDeclaredMethod("getName");
        getName.setAccessible(true);
        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            getName.invoke(u1, null);
        }
        end = System.currentTimeMillis();
        System.out.println("關閉安全機制time spend : " + (end - start));

        //反射的方法啟動"安全機制"
        Class c1 = u1.getClass();
        Method method = c1.getDeclaredMethod("getName");
        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            method.invoke(u1, null);
        }
         end = System.currentTimeMillis();
        System.out.println("不關閉安全機制time spend : " + (end - start));
    }
}
