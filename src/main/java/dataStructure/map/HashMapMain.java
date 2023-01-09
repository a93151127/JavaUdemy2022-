package dataStructure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, Integer> incomeMap = new HashMap<>();
        incomeMap.put("Martin", 50000);
        incomeMap.put("Abi", 30000);

        for(Map.Entry<String, Integer> entry:incomeMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //lamda寫法
        incomeMap.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });

        //iterator寫法
        Set set = incomeMap.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //============修改元素的value=======
        //修改元素的value
        incomeMap.put("Martin", 55000);//這裡會直接覆蓋原本Key是Martin的value
        System.out.println(incomeMap);

        //============刪除元素=======
        incomeMap.remove("Abi");
        System.out.println(incomeMap);
        incomeMap.remove("Martin", 55000);
        System.out.println(incomeMap);
    }
}
