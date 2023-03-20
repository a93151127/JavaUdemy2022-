package stream;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle",
                "john"};

        //找出數組前四個排序然後輸出
        Stream.of(names)
                .limit(4)
                .sorted()
                .forEach(p -> System.out.print(p + " "));
        System.out.println("");
        //把除了前四個的數組進行忽略大小寫的排序並且輸出

        //寫法1
        Stream.of(names)
                .skip(4)
                .sorted((p1, p2) -> p1.compareToIgnoreCase(p2))
                .forEach(p -> System.out.print(p + " "));
        System.out.println("");
        //寫法2
        Stream.of(names)
                .skip(4)
                .sorted(String::compareToIgnoreCase)
                .forEach(p -> System.out.print(p + " "));
        System.out.println("");
        //查找值為"Stacy"的元素
        System.out.println(Stream.of(names).anyMatch(p -> p.equals("Stacy")));

        //檢查是否每個元素的首個字母都是大寫
        System.out.println(Stream.of(names).allMatch(p -> Character.isUpperCase(p.charAt(0))));

        //檢查是否有ko開頭的元素
        System.out.println(Stream.of(names).noneMatch(p -> p.startsWith("ko")));

        /*
        找出不重複的元素有幾個(忽略大小寫)
        map()=>把元素做轉換
        distinct()=>找不重複的
        count()=>計算有幾個
         */
        System.out.println(Stream.of(names).map(p -> p.toUpperCase()).distinct().count());

        //把元素都換成小寫並輸出
        Object[] objArr = Stream.of(names).map(String::toLowerCase).toArray();
        System.out.println(Arrays.toString(objArr));
    }
}
