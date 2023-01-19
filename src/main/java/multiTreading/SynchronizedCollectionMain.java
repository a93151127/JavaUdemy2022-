package multiTreading;

import java.util.*;

public class SynchronizedCollectionMain {
    public static void main(String[] args) {
        Set hashSet = Collections.synchronizedSet(new HashSet());
        hashSet.add(1);
        hashSet.add(2);

        Iterator itr = hashSet.iterator();

        synchronized (hashSet){
            while(itr.hasNext()){
                System.out.println(itr.next());
                hashSet.add(3);//這邊是模擬多線程對hashSet的動作
            }
        }

    }
}
