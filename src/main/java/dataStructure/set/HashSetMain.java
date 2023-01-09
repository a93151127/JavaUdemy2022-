package dataStructure.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<String>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");

        //因為set是不能重複的,所以這一筆不會被添加進set裡面
        hashSet.add("one");

        System.out.println(hashSet);

        //移除元素
        hashSet.remove("one");
        System.out.println(hashSet);

        //檢查是否包含某元素
        System.out.println(hashSet.contains("two"));

        Set<String> hashSet2 = new HashSet<String>();
        hashSet2.add("three");
        hashSet2.add("four");
        hashSet2.add("five");

        //移除一樣的元素
        hashSet.removeAll(hashSet2);
        System.out.println(hashSet);

        //加入另一個set
        hashSet.addAll(hashSet2);
        System.out.println(hashSet);

        //取出交集的元素
        hashSet.retainAll(hashSet2);
        System.out.println(hashSet);
    }
}
