package dataStructure.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(list);
        //在某元素前面添加新的元素
        list.add(1, 10000);
        System.out.println(list);
        //移除元素
        list.remove(0);
        System.out.println(list);
    }
}
