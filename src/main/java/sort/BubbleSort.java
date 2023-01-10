package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = new int[5];
        list[0] = 3;
        list[1] = 39;
        list[2] = -13;
        list[3] = 24;
        list[4] = 1;

        bubbleSort(list);
    }

    public static void bubbleSort(int[] list) {
        boolean nextRound = true;

        //總共需要執行n-1 round
        for (int k = 1; k < list.length && nextRound; k++) {
            nextRound = false;

            /*
            每一round會決定一個最大的數值擺在最後面,所以這邊list.length-k可以讓迴圈
            不用去執行k個已經排序好的最大值
             */
            for (int i = 0; i < list.length - k; i++) {
                if(list[i] > list[i+1]){
                    int tmp = list[i+1];
                    list[i+1] = list[i];
                    list[i] = tmp;
               }
                /*
                這個主要是優化算法,例如今天有一個數組是1,2,3,4,5,6(已經排序好的),
                這樣我們就不需要再去跑算法,可以節省時間
                 */
                nextRound = true;
            }
        }

        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }

    }
}
