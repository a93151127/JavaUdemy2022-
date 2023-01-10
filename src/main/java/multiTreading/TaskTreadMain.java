package multiTreading;

public class TaskTreadMain {
    public static void main(String[] args) {
        Runnable r1 = new PrintChar('A', 100);
        Runnable r2 = new PrintChar('B', 100);
        Runnable r3 = new PrintNum(100);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        //幫t3設置優先級
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintChar implements Runnable {

    private char ch;
    private int time;

    public PrintChar(char ch, int time) {
        this.ch = ch;
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 1; i <= time; i++) {
            System.out.print(ch);
        }
    }
}

class PrintNum implements Runnable {
    private int time;

    public PrintNum(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        try{
            for (int i = 1; i <= time; i++) {
                System.out.print(i);
            }
        }catch(Exception e){

        }

    }
}
