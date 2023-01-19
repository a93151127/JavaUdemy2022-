package io;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProduceWithBlockQueueMain {

    private static ArrayBlockingQueue<Integer> buffer =
            new ArrayBlockingQueue<Integer>(2);

    public static void main(String[] args) {
        ExecutorService excutor = Executors.newFixedThreadPool(2);
        excutor.execute(new WriteTask());
        excutor.execute(new ReadTask());
        excutor.shutdown();
    }

    private static class WriteTask implements Runnable{

        @Override
        public void run() {

            try {
                while(true){
                    int unit = (int)(Math.random()*100);
                    System.out.println("生產 " + unit + "單位");
                    buffer.put(unit);

                    Thread.sleep((int)(Math.random()*1000));
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private static class ReadTask implements Runnable{

        @Override
        public void run() {
            try{
                while(true){
                    System.out.println("\t\t\t\t\t讀取" + buffer.take() + "單位");
                    Thread.sleep((int)(Math.random()*1000));
                }
            }catch (InterruptedException e){

            }
        }
    }
}
