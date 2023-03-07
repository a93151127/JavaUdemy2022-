package classLoad;


public class LoaderMain {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extentionLoader = systemClassLoader.getParent();
        System.out.println(extentionLoader);

        ClassLoader bootStapLoader = extentionLoader.getParent();
        System.out.println(bootStapLoader);

        System.out.println("=============");

        //目前的類是由哪種加載器加載
        ClassLoader c1 = Class.forName("classLoad.LoaderMain").getClassLoader();
        System.out.println(c1);
        //Object是由哪個加載器加載的
        ClassLoader c2 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(c2);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

    }
}
