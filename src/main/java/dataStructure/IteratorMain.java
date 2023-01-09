package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorMain {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<>();
        col.add("apple");
        col.add("orange");
        col.add("banana");

        Iterator<String> itr = col.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().toUpperCase());
        }

    }
}
