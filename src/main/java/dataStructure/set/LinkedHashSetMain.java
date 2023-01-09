package dataStructure.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMain {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<String>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        hashSet.add("four");
        hashSet.add("five");
        hashSet.add("six");

        System.out.println(hashSet);

        Set<String> linkedhashSet = new LinkedHashSet<String>();
        linkedhashSet.add("one");
        linkedhashSet.add("two");
        linkedhashSet.add("three");
        linkedhashSet.add("four");
        linkedhashSet.add("five");
        linkedhashSet.add("six");

        System.out.println(linkedhashSet);
    }
}
