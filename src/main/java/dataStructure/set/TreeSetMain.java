package dataStructure.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        //按照升冪排序
        System.out.println(set);

        //按照降冪排序
        Set set2 = ((TreeSet<Integer>) set).descendingSet();
        System.out.println(set2);
    }
}
