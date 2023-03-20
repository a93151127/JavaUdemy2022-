package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        //傳統方法
        for(Map.Entry m: map.entrySet()){
            System.out.println("key :" + m.getKey() + "\tvalue : " + m.getValue());
        }

        System.out.println("==========lambda==========");
        //lambda 方法
        map.forEach((k, v)->{
            System.out.println("key :" + k + "\tvalue : " + v);
        });

        System.out.println("==========list==========");
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(e -> System.out.println(e));

        System.out.println("==========傳統Thread==========");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread");
            }
        });

        /*
        前提:這個接口interface(Runable)裡面只能有一個方法
        進去Runable裡面可以看到Runable有一個@FunctionalInterface的標籤
        =>有@FunctionalInterface這個標籤的都可以使用lambda
         */
        System.out.println("==========lambda Thread==========");
        new Thread(()-> {
            System.out.println("hello lambda thread");
        });

    }
}
