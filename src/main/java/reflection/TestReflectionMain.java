package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflectionMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 =Class.forName("reflection.User");
        //獲得package和類的名稱
        System.out.println(c1.getName());
        //獲得類的名稱
        System.out.println(c1.getSimpleName());

        System.out.println("=========取得指定的屬性值==========");
        /*
        getDeclaredField()可以取得private的屬性
        getField()只能取得public的屬性
         */
        Field c1Field = c1.getDeclaredField("name");
        System.out.println(c1Field);

        System.out.println("=======獲取指定的方法======");
        /*
        getDeclaredMethod()可以取得private的屬性
        getMethod()只能取得public的屬性
         */
        //因為getId()不需要放任何參數,因此getDeclaredMethod()的第二個參數只要放null即可
        Method method = c1.getDeclaredMethod("getId", null);
        System.out.println(method);

        System.out.println("=======獲取Constructor的方法======");
        Constructor[] con = c1.getConstructors();

        for(Constructor c:con){
            System.out.println(c);
        }
    }
}
