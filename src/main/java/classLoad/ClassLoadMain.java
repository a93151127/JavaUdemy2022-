package classLoad;

public class ClassLoadMain {
    public static void main(String[] args) {
        System.out.println(A.m);
        System.out.println(new A());
    }
}

class A{
    //以下的加載是靠順序,若m在這邊設定則上面的A.m是300
//    static int m = 100;
    static{
        System.out.println("靜態初始化開始");
        m = 300;
    }
    //若m在這邊設定則上面的A.m是100
    static int m = 100;

    public A(){
        System.out.println("constructor初始化開始");
    }
}