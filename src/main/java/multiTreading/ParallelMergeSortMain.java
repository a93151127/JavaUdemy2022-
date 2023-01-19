package multiTreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSortMain {
    public static void main(String[] args) {
        final int size = 7000000;
        int[] list1 = new int[size];
        int[] list2 = new int[size];

        for(int i = 0; i<list1.length; i++){
            list1[i] = list2[i] =(int)(Math.random()*1000);
        }

        long startTime = System.currentTimeMillis();
        parallelMergeSort(list1);
        long endTime = System.currentTimeMillis();

        System.out.println("\nParallel time with "
                + Runtime.getRuntime().availableProcessors() +
                " processors is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        MergeSort.mergeSort(list2);
        endTime = System.currentTimeMillis();

        System.out.println("\nSequential time is " +
                (endTime - startTime) + " milliseconds");
    }

    public static void parallelMergeSort(int[] list){
        RecursiveAction mainTask = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    public static class SortTask extends RecursiveAction{

        private final int THRESHOLD = 500;
        private int[] list;

        public SortTask(int[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if(list.length < THRESHOLD){
                java.util.Arrays.sort(list);
            }else{
                /*
                Public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
                參數(Parameter)
                • src – 來源陣列 (source array)
                • srcPos − 源頭陣列的開始位置
                • dest – 目的地陣列(destination array)
                • destPos −目的地陣列的開始位置
                • length – 被複製的元素的長度
                 */
                //obtain firstHalf
                int[] firstHalf = new int[list.length/2];
                System.arraycopy(list, 0 , firstHalf,
                        0, list.length/2);

                //obtain secondHalf
                int seconHalfLength = list.length - list.length/2;
                int[] secondHalf = new int[seconHalfLength];
                System.arraycopy(list, list.length/2, secondHalf,
                        0, seconHalfLength);
                //將兩個task並行
                invokeAll(new SortTask(firstHalf),
                        new SortTask(secondHalf));

                //將兩個list合併
                MergeSort.merge(firstHalf, secondHalf, list);

            }
        }
    }
}

class MergeSort {

    /**
     * The method for sorting the numbers
     */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);


        }
    }

    /**
     * Merge two sorted lists
     */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    /**
     * A test method
     */
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}