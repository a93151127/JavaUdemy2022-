package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //取得類對象
        Class c1 = Class.forName("reflection.User");
        System.out.println(c1);


        //使用取得的實體對象查看類裡面的資訊(若class裡面設為private則查詢不到)
        Method[] methods = c1.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println("============");
        Field[] fs = c1.getFields();
        for(Field f : fs){
            System.out.println(f);
        }

        //比較是否創建出唯一的類對象
        Class c2 = Class.forName("reflection.User");
        Class c3 = Class.forName("reflection.User");
        System.out.println(c2.hashCode() == c3.hashCode());

        //創建實例(原本寫法:User u = new User())
        User user = (User) c1.newInstance();
        System.out.println("user是否是User的實例 : " + (user instanceof User));
    }
}
