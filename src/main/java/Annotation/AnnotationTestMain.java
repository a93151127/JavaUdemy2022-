package Annotation;

public class AnnotationTestMain {
    public static void main(String[] args) {
        testDep();
    }
    @Deprecated
    private static void testDep(){

    }

    @SuppressWarnings("all")
    private static void unusedMethod(){

    }
}
