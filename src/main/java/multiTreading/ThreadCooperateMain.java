package multiTreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperateMain {
    private static Account account = new Account();
    private static boolean doOrNot = true;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new AddCash());
        executor.execute(new WithDraw());
        executor.shutdown();
        while(!executor.isTerminated()){

        }
        System.out.println("executor has been closed");
    }

    private static class AddCash implements Runnable{

        @Override
        public void run() {
            try {
                while (doOrNot) {
                    account.addCash((int) (Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class WithDraw implements Runnable{

        @Override
        public void run() {
            while (doOrNot) {
                account.withDraw((int) (Math.random() * 10) + 1);
                doOrNot = false;
            }
        }
    }

    private static class Account{
        private static Lock lock = new ReentrantLock();
        //創建一個condition的 lock
        private static Condition newWithDraw = lock.newCondition();
        private static int balance = 0;

        public static int getBalance() {
            return balance;
        }

        public static void withDraw(int amount){
            try{
                lock.lock();
                while(amount > balance){
                    //線程等待
                    newWithDraw.await();
                }
                balance -= amount;
                System.out.println("inside withDraw, amount " + amount);
                System.out.println("inside withDraw, balance " + balance);
            }catch (InterruptedException e){

            }finally {
                lock.unlock();
            }
        }

        public static void addCash(int amount){
            int newBalance = balance + amount;

            try{
                lock.lock();
                balance += amount;
                System.out.println("inside addCash , amount : " + amount);
                System.out.println("inside addCash , balance : " + getBalance());

                newWithDraw.signalAll();

            }finally{
                lock.unlock();
            }
        }
    }
}
