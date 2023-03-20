package lambda;

public class FunctionalInterfaceDemo implements Sleepable{
    @Override
    public void sleep() {
        System.out.println("inside sleep");
    }

    public static void main(String[] args) {
        Sleepable s = new FunctionalInterfaceDemo();
        System.out.println(s.hashCode());
        System.out.println(s.toString());
        s.sleep();
        Sleepable.sleepStatic("inside sleepStatic");

    }
}

@FunctionalInterface
interface Sleepable{
    void sleep(); //abstract method


    //it can contain number of Object Class methods or static method
    //需要跟Object類型的命名完全依樣,不能修改名稱
    int hashCode();

    String toString();

    static void sleepStatic(String msg){
        System.out.println(msg);
    }

}
