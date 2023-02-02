package recursive;

import static java.util.Arrays.sort;

public class SelectionMain {
    public static void main(String[] args) {
        double[] doubleList = {2,1,-3,-20,5,100,0,-9,69};

        sort(doubleList);
        for(int i = 0 ; i < doubleList.length; i ++){
            System.out.println(doubleList[i]);
        }

    }
    private static void sort(double[] list){
        sort(list, 0 ,list.length);
    }
    private static void sort(double[] list, int low, int high){
        if(low < high){
            int indexOfMin = low;
            double min = list[low];

            for(int i = low + 1; i < high; i ++){
                if(list[i] < min){//這邊不可以寫list[i]<list[low],因為min是變動的,但list[low]固定
                    indexOfMin = i;
                    min = list[i];
                }
            }
            list[indexOfMin] = list[low];
            list[low] = min;
            sort(list, low + 1, high);
        }

    }
}
