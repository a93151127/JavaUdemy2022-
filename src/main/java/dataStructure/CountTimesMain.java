package dataStructure;

import java.util.*;

public class CountTimesMain {
    public static void main(String[] args) {
        String text = "I love java programing because java programming is interesting!";

        //這個是每個字元,例如a,i,o的寫法
        String[] words = text.split("");
        //這個是每個單字的寫法,例如love, java
//        String[] words = text.split(" ");
        Map<String, Integer> map = new TreeMap<>();

        for(int i = 0; i< words.length; i++){
            String key = words[i].toLowerCase();

            if(key.length() > 0 && !key.equals(" ")){
                if(!map.containsKey(key)){
                    map.put(key, 1);
                }else{
                    int value = map.get(key);
                    value += 1;
                    map.put(key, value);
                }
            }
        }
        List<Map.Entry<String, Integer>> lists = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(lists, new MapValueCompare());
        lists.forEach(s-> System.out.println(s));

    }
}

class MapValueCompare implements Comparator<Map.Entry<String, Integer>>{

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue() - o1.getValue();
    }
}