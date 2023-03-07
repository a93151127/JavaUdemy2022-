package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MyAnnotationMain {
    public static void main(String[] args) {
    }
}
@MyFirstAnnotation
class A{

    @MyFirstAnnotation
    public static void testMyFirstAnnotation(){

    }
}

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyFirstAnnotation{

}
