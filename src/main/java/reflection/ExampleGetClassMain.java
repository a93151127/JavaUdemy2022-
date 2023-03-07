package reflection;

public class ExampleGetClassMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("這是Person的實例");

        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        Class c2 = Class.forName("reflection.Student");
        System.out.println(c2.hashCode());

        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        Class c4 = Integer.TYPE;
        System.out.println(c4);

        System.out.println(c3.getSuperclass());

    }
}

class Person {

    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Teacher extends Person {

    public Teacher() {
        this.name = "老师";
    }
}


class Student extends Person {

    public Student() {
        this.name = "学生";
    }
}
