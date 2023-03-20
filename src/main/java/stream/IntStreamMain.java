package stream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamMain {
    public static void main(String[] args) {
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};

        //去掉重複的然後數值>3且可以被2整除,取得平均之後轉換成double類型
        System.out.println(IntStream.of(values).distinct().
                filter(p -> p > 3 && p % 2 == 0).average().getAsDouble());

        //取得前四個元素的總和
        System.out.println(IntStream.of(values).limit(4).sum());

        //取得統計值之後列印出所需的數值
        IntSummaryStatistics iss = IntStream.of(values).summaryStatistics();
        System.out.println(iss.getMax());
        System.out.println(iss.getSum());
        System.out.println(iss.getMin());
        System.out.println(iss.getAverage());
        System.out.println(iss.getCount());

        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle",
                "john"};
        //取得每個字串的長度並加總
        System.out.println(Stream.of(names).mapToInt(p -> p.length()).sum());

        /*
        計算數組有幾個字節
        map(p->p+"")=>這邊是把int轉成字串
         */
        System.out.println(Stream.of(values).map(p -> p + "").mapToInt(p -> p.length()).sum());
    }
}
