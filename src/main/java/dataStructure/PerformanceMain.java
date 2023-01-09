package dataStructure;

import java.sql.SQLOutput;
import java.util.*;

public class PerformanceMain {
    static final int N = 50000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < N; i ++){
            list.add(i);
        }
        //把順序洗亂
        Collections.shuffle(list);
        //測試HashSet
        System.out.println("=========HashSet============");
        Collection<Integer> hashSet = new HashSet<>(list);
        System.out.println("get test waste : " + getTestTime(hashSet) + " millinseconds");
        System.out.println("remove test waste : " + getRemoveTime(hashSet) + " millinseconds");
        //測試LinkedHashSet
        System.out.println("=========LinkedHashSet============");
        Collection<Integer> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println("get test waste : " + getTestTime(linkedHashSet) + " millinseconds");
        System.out.println("remove test waste : " + getRemoveTime(linkedHashSet) + " millinseconds");
        /*
        結論1:HashSet和LinkedHashSet的運行效率差不多
         */
        //測試TreeSet
        System.out.println("=========測試TreeSet============");
        Collection<Integer> treeSet = new TreeSet<>(list);
        System.out.println("get test waste : " + getTestTime(treeSet) + " millinseconds");
        System.out.println("remove test waste : " + getRemoveTime(treeSet) + " millinseconds");
        /*
        結論2:TreeSet比HashSet和LinkedHashSet的運行效率更差
        (因為多了一個"排序"的動作)
         */
        //測試ArrayList
        System.out.println("=========測試ArrayList============");
        Collection<Integer> arrayList = new ArrayList<>(list);
        System.out.println("get test waste : " + getTestTime(arrayList) + " millinseconds");
        System.out.println("remove test waste : " + getRemoveTime(arrayList) + " millinseconds");
        /*
        結論3:LinkedList比ArrayList查找效率更差,remove效率也差(因為要先找到才能刪除)
         */
        //測試LinkedList
        System.out.println("=========測試LinkedList============");
        Collection<Integer> linkedList = new LinkedList<>(list);
        System.out.println("get test waste : " + getTestTime(linkedList) + " millinseconds");
        System.out.println("remove test waste : " + getRemoveTime(linkedList) + " millinseconds");
        /*
        結論4:Set的執行效率比List更好
         */
    }

    public static Long getTestTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            c.contains((int) (Math.random() * 2 * N));
        }
        return System.currentTimeMillis()-startTime;
    }

    public static Long getRemoveTime(Collection<Integer> c){
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < N; i ++){
            c.remove(i);
        }
        return System.currentTimeMillis() - startTime;
    }
}
