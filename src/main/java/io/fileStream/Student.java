package io.fileStream;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    int age;
    //以下兩個是不能或沒有序列化的例子
    static transient int score;
    transient A a = new A();

}

//注意這邊的A沒有序列化
class A{

}