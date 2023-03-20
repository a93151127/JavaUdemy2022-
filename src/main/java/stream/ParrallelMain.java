package stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ParrallelMain {
    public static void main(String[] args) {
        Random random = new Random();
        int[] intArr = random.ints(200_000_000).toArray();

        System.out.println("Number of processors: " +
                Runtime.getRuntime().availableProcessors());
        long start = System.currentTimeMillis();
        int[] arr1 = IntStream.of(intArr).filter(p -> p > 0).sorted().limit(5).toArray();
        System.out.println(Arrays.toString(arr1));
        long end = System.currentTimeMillis();
        System.out.println("Spend Time : " + (end - start) + " milli seconds");

        start = System.currentTimeMillis();
        int[] arr2 = IntStream.of(intArr).parallel().filter(p -> p > 0).sorted().limit(5).toArray();
        System.out.println(Arrays.toString(arr2));
        end = System.currentTimeMillis();
        System.out.println("Spend Time : " + (end - start) + " milli seconds");
    }
}
