package lambda;

public class LambdaDemo2 {
    public static void main(String[] args) {
        int width = 10;
        //傳統方法
        Drawable d1 = new Drawable() {
            @Override
            public void draw() {
                System.out.println("inside traditional draw : " + width);
            }
        };
        d1.draw();

        /*
        使用lambda
        step 1 : 幫interface加上@FunctionalInterface的標籤(可加可不加)
         */
        Drawable d2 = () -> {
            System.out.println("inside lambde draw : " + width);
        };
        d2.draw();

        //傳統回傳參數範例
        Sayable s1 = new Sayable() {
            @Override
            public String say(String name) {
                return name + " have nothing to say";
            }
        };
        System.out.println(s1.say("martin"));

        //lambda寫法
        Sayable s2 = (p1) -> {
            return p1 + " have nothing to say";
        };
        System.out.println(s2.say("abi"));
    }
}

@FunctionalInterface
interface Drawable{
    public void draw();
 }

 interface Sayable{
    public String say(String name);
 }