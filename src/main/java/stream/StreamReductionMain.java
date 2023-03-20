package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReductionMain {
    public static void main(String[] args) {
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};

        System.out.print("The values are ");
        IntStream.of(values).forEach(e -> System.out.print(e + " "));

        //把每個元素相乘然後再乘與4
        System.out.println("\nThe result of multiplying all values is " +
                IntStream.of(values).reduce(4,(p1, p2) -> p1 * p2)
                );

        //把每個元素加?呈現
        System.out.println(IntStream.of(values).mapToObj(p -> p + "")
                .reduce((p1, p2) -> (p1 + "?" + p2)).get());

        String[] names = {"John", "Peter", "Susan", "Kim", "Jen",
                "George", "Alan", "Stacy", "Michelle", "john"};
        //把每個元素中間加!呈現
        System.out.println(Stream.of(names).reduce((p1, p2) -> p1 + "!" + p2).get());

        //把每個元素相加當成一個字串
        System.out.println(Stream.of(names).reduce((p1, p2) -> p1.concat(p2)).get());

        //取得上面那串字串的長度
        System.out.println(Stream.of(names).reduce((p1, p2) -> p1 + p2).get().length());


    }
}
