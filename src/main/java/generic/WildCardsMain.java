package generic;

public class WildCardsMain {
    public static void main(String[] args) {
        //受限通配
        GenericTest<Integer> genIen = new GenericTest<Integer>();
        genIen.push(2);
        genIen.push(0);
        genIen.push(-1);
        genIen.push(5);

        System.out.println(getMax(genIen));
    }

    private static double getMax(GenericTest<? extends Number> stack){
        double max = stack.pop().doubleValue();
        if(stack.getSize() != 0){
            double value = stack.pop().doubleValue();
            if(value > max){
                max = value;
            }
        }
        return max;
    }
}
