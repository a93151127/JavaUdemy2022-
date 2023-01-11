package multiTreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {

    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 1; i <= 10000; i++){
            executor.execute(new addCash());
        }
        executor.shutdown();
        while(!executor.isTerminated()){

        }
        System.out.println(account.getBalance());

    }

    private static class addCash implements Runnable{

        @Override
        public void run() {
            synchronized (account){
                account.deposit(1);
            }
        }
    }

    // An inner class for account
    private static class Account {

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            int newBalance = balance + amount;

            // This delay is deliberately added to magnify the
            // data-corruption problem and make it easy to see.
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }

            balance = newBalance;
        }
    }
}
