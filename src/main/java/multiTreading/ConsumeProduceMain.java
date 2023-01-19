package multiTreading;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumeProduceMain {
    private static Buffer buffer = new Buffer();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProduceTask());
        executor.execute(new ReadTask());

        executor.shutdown();
    }

    private static class ProduceTask implements Runnable{

        @Override
        public void run() {
            try {
                while(true){
                    int unit = (int) (Math.random()*100);
                    System.out.println("Producer produce " + unit);
                    buffer.writeData(unit);
                    Thread.sleep((int) (Math.random()*1000));
                }
            }catch (InterruptedException e) {
            }

        }
    }

    public static class ReadTask implements Runnable{

        @Override
        public void run() {

            try{
                while(true){
                    System.out.println("\t\t\t\t\t\tConsumer reads " + buffer.read());
                    Thread.sleep((int) (Math.random()*1000));
                }
            }catch (InterruptedException e){

            }
        }
    }
    public static class Buffer{
        private static int Capacity = 1;
        private java.util.LinkedList<Integer> queue =
                new LinkedList<Integer>();
        //建立new lock
        private static Lock lock = new ReentrantLock();

        //建立兩個condition
        private static Condition write = lock.newCondition();//生產條件
        private static Condition read = lock.newCondition();//讀取條件

        public void writeData(int value){
            lock.lock();

            //當生產空間已滿,write的線程等待
            try{
                while(queue.size() == Capacity){
                    System.out.println("生產空間已滿,等待讀取");
                    write.await();
                }
                queue.offer(value);
                //讓讀取線程開始讀取
                read.signalAll();
            }catch(InterruptedException e){

            }finally{
                lock.unlock();
            }
        }

        public int read(){
            int value = 0;
            lock.lock();
            //當所有生產的已被讀取完畢,讀取線程停止
            try{
                while(queue.isEmpty()){
                    System.out.println("\t\t\t\t\t\t讀取完畢,等待生產");
                    read.await();
                }
                value = queue.remove();
                //讓生產線程開始生產
                write.signalAll();

            }catch (InterruptedException e){

            }finally {
                lock.unlock();
            }
            return value;
        }
    }
}
