package stream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectMain {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen",
                "George", "Alan", "Stacy", "Michelle", "john"};
        //把字串相加並且計算字串長度
        System.out.println(Stream.of(names).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).length());

        //轉換成list
        //寫法1
        List<String> list = Stream.of(names).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list.toString());
        //寫法2
        List<String> list2 = Stream.of(names).collect(Collectors.toList());
        System.out.println(list2.toString());

        //轉換成set(重複元素將會被剃除)
        Set<String> set =Stream.of(names).map(p -> p.toUpperCase()).collect(Collectors.toSet());
        System.out.println(set.toString());

        //轉換成map
        Map<String, Integer> map = Stream.of(names).collect(Collectors.toMap(p -> p, p -> p.length()));
        System.out.println(map);

        //計算元素總和
        System.out.println(Stream.of(names).collect(Collectors.summingInt(p -> p.length())));

        //取得計數統計
        java.util.IntSummaryStatistics iss = Stream.of(names).collect(Collectors.summarizingInt(p -> p.length()));
        System.out.println("Max is " + iss.getMax());
        System.out.println("Min is " + iss.getMin());
        System.out.println("Average is " + iss.getAverage());
    }
}
