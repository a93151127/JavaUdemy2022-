package lambda;

public class LambdaDefaultDemo implements SaySayable{
    public static void main(String[] args) {
        SaySayable s = new LambdaDefaultDemo();
        s.say();
        s.sayMore("hello! sayMore!");
        SaySayable.sayLaoder("static say");
        }

    //這個方法可override也可不用,因為interface裡面就已經有實作了
    @Override
    public void say() {
        System.out.println("override say method");
    }



    @Override
    public void sayMore(String msg) {
        System.out.println(msg);
    }
}

/*
可以使用 default或者static在interface裡面實作
 */
interface SaySayable{
    //default實作
    default void say(){
        System.out.println("this is inside say method");
    }

    //static方法實作
    static void sayLaoder(String msg){
        System.out.println("sayLaoder : " + msg);
    }

    //abstract method
    void sayMore(String msg);
}
