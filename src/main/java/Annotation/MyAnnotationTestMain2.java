package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MyAnnotationTestMain2 {

    @MyAnnotion2(name="abc", age = "18")//這裡的age若沒有寫,則在annotation裡面會把值默認為10
    public void testAnno(){

    }
}
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotion2{
    //給這個標籤一個name的參數,代表在使用這個標籤時一定要有這個參數
    String name();
    //有加"default"代表使用這個標籤時可以不給這個參數,然後在標籤裡會把這個參數默認為10
    String age() default "10";
    String[] school() default {"東吳,清華"};
}