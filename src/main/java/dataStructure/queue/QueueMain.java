package dataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        //因LinkedList有繼承Queue,因此可以用來實作
        Queue<Integer> queue = new LinkedList<>();

        /*
        add和offer都可以新增,remove和poll都可以移除
        queue若滿額的情況,add和remove會丟exception,offer和poll會丟false
         */
        queue.add(1);
        queue.offer(2);
        queue.add(3);
        System.out.println(queue);
        //移除元素
        System.out.println(queue.poll());
        System.out.println(queue);
        //查看目前隊首的元素
        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
