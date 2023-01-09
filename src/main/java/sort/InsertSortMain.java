package sort;

public class InsertSortMain {
    public static void main(String[] args) {
        int[] arr = new int[2];
        arr[0] = 38;
        arr[1] = 3;
//        arr[2] = 24;
//        arr[3] = 56;
//        arr[4] = 1;
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        int j = 0;
        int t = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                t = arr[i];
                for (j = i - 1; j >= 0 && arr[j] >t ; j--) {
                    arr[j+1] = arr[j];
                    System.out.println("j in for======== "+ j);
                }
                System.out.println("j after==========" + j);
                //因為上面for迴圈的j--會讓j變成-1,所以這邊實際的index要加回來
                arr[j + 1] = t;

            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
