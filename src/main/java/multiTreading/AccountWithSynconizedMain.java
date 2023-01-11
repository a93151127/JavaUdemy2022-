package multiTreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSynconizedMain {
    //設置一個鎖
    private static Lock lock = new ReentrantLock();
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 1; i <= 1000; i++){
            executor.execute(new AddCash());
        }
        executor.shutdown();
        while(!executor.isTerminated()){

        }
        System.out.println(account.getBalance());
    }

    private static class AddCash implements Runnable{

        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account{

        private static int balance = 0;

        public int getBalance() {
            return balance;
        }

        public static void deposit(int amount){
            //上鎖
            lock.lock();

            try{

                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            }catch (InterruptedException e ){
            }finally {
                //解鎖
                lock.unlock();
            }

        }
    }
}
