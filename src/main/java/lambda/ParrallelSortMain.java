package lambda;

import java.util.Arrays;

public class ParrallelSortMain {
    public static void main(String[] args) {
        int[] arr = {5,9,3,4,85,13,62};
        Arrays.stream(arr).forEach(p-> System.out.print(p + ","));

        System.out.println("");
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(p -> System.out.print(p + ","));
    }
}
