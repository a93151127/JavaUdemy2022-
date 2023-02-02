package recursive;

public class BinaryMain {
    public static void main(String[] args) {
        int[] list ={1,2,3,4,5,6};
        System.out.println(binaryQry(list,3));
    }

    private static int binaryQry(int[] list, int key){
        return binaryQry(list, key, 0, list.length - 1);
    }

    private static int binaryQry(int[] list, int key, int low, int high){
        if(low > high){
            return -low - 1;
        }
        int mid = (low + high)/2;
        if(key < list[mid]){
            return binaryQry(list, key, low, mid-1);
        }else if(key == list[mid]){
            return mid;
        }else {
            return binaryQry(list, key, mid + 1, high);
        }
    }
}
