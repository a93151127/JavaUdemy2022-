package generic;

public class AnyWildCardsMain {
    public static void main(String[] args) {
        GenericTest<Integer> genIen = new GenericTest<Integer>();
        genIen.push(2);
        genIen.push(0);
        genIen.push(-1);
        genIen.push(5);
        GenericTest<String> genStr = new GenericTest<String>();
        genStr.push("a");
        genStr.push("b");
        genStr.push("c");
        System.out.println(getLastNum(genIen));
        System.out.println(getLastNum(genStr));
    }

    private static Object getLastNum(GenericTest<?> stack){
        return stack.peek();
    }
}
