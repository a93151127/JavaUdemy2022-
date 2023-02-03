package generic;

public class GenericTestMain {
    public static void main(String[] args) {
        GenericTest<String> g = new GenericTest<String>();

        g.push("a");
        g.push("b");
        System.out.println(g.getSize());
        System.out.println(g.peek());
        g.pop();
        System.out.println(g.peek());
    }
}
