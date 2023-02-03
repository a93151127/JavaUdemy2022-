package generic;

import java.sql.Array;
import java.util.ArrayList;

public class GenericMain {
    public static void main(String[] args) {

        //沒有添加泛型,可以在array裡面添加任何資料
        ArrayList array = new ArrayList();
        array.add(1);
        array.add("abc");
        System.out.println((int)array.get(1) + 2);
    }
}
