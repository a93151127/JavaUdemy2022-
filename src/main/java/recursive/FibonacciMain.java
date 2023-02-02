package recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciMain {
    public static void main(String[] args) {
        System.out.println("enter index of fib");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();

        System.out.println("fib index is : " + index + ", " +
                "fib amount is : " + fib(index));
    }

    //使用map優化速度(把每次結果存入map,避免重複的計算)
    private static Map map = new HashMap<>();

    private static long fib(int index){
        long amount = 0;
        if(map.containsKey(index)){
            amount = (long) map.get(index);
            return amount;
        }

        if(index == 0){
            amount = 0;
        }else if(index == 1){
            amount = 1;
        }else{
            amount = fib(index - 2) + fib(index - 1);
            map.put(index, amount);
        }
        return amount;
    }
}
