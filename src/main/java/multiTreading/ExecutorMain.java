package multiTreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));
        //線程是否關閉
        System.out.println(executor.isShutdown());
        //任務是否終止
        System.out.println(executor.isTerminated());

        executor.shutdown();

        System.out.println(executor.isShutdown());
        System.out.println(executor.isTerminated());

        //等待任務全部跑完
        while(!executor.isTerminated()){

        }
        System.out.println(executor.isTerminated());
    }
}
