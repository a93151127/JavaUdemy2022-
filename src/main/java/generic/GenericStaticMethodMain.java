package generic;

public class GenericStaticMethodMain {
    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5};
        String[] strings = {"aaa", "bbb", "ccc"};
        GenericMethod.<Integer>print(integers);
        GenericMethod.print(strings);
    }
}
class GenericMethod{

    public static <E> void print(E[] list){
        for(E e:list){
            System.out.println(e);
        }
    }
}
