package exception;

public class ExceptionMain {
    public static void main(String[] args) {
        Test t = new Test();

        try{
            t.rrr();
        }catch(Exception1 e1){
            System.out.println("e1");
        }
        System.out.println("main");

    }
}

class Test{
    public void ttt(){
        System.out.println("e3");
        throw new Exception2();
    }

    public void rrr(){
        try{
            ttt();
        }catch(Exception2 e2){
            System.out.println("e2");
        }
        System.out.println("rrr");
    }
}

class Exception1 extends RuntimeException{

}

class Exception2 extends RuntimeException{

}

class Exception3 extends RuntimeException{

}