package generic;

public class LowerWildcardsMain {
    public static void main(String[] args) {
        GenericTest<String> getStr = new GenericTest<String>();
        GenericTest<Object> getObj = new GenericTest<Object>();
        GenericTest<Integer> getIen = new GenericTest<Integer>();

        getStr.push("a");
        getStr.push("b");
        getObj.push(1);
        getObj.push("aa");
        getIen.push(100);
        getIen.push(200);

       //add(getStr,getIen);//因為Integer不是String的父類,所以這裡會報錯
        add(getStr,getObj);
        System.out.println(getObj.pop());
    }

    private static <T> void add(
            GenericTest<T> stack1, GenericTest<? super T> stack2){
        if(stack1.getSize()!=0){
            stack2.push(stack1.pop());
        }
    }
}
