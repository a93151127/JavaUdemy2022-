package stream;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupByMain {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen",
                "George", "Alan", "Stacy", "Steve", "john"};
        Map<String, Long> map = Stream.of(names).map(p -> p.toUpperCase())
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println(map);

        //TreeMap會自動排序
        Map<Character, Long> map1 = Stream.of(names)
                .collect(Collectors.groupingBy(p -> p.charAt(0), TreeMap::new,
                        Collectors.counting()));

        System.out.println(map1);

        int[] values = {2, 3, 4, 1, 2, 3, 2, 3, 4, 5, 1, 421};
        IntStream.of(values).mapToObj(p -> p)
                .collect(Collectors.groupingBy(p -> p, TreeMap::new, Collectors.counting()))
                .forEach((k,v)-> System.out.println("key is " + k + "\tvalue is " + v));

        MyStudent[] students = {new MyStudent("John", "Lu", "CS", 32, 78),
                new MyStudent("Susan", "Yao", "Math", 31, 85.4),
                new MyStudent("Kim", "Johnson", "CS", 30, 78.1)};

        //以科目當key,然後算出個別的平均
        Map<String, Double> map2 = Stream.of(students)
                .collect(Collectors.groupingBy(MyStudent::getMajor, //以甚麼當key
                                                TreeMap::new, //哪種map型態
                                                Collectors.averagingDouble(MyStudent::getScore)));//以甚麼當value
        System.out.println(map2);
    }
}

class MyStudent {

    private String firstName;
    private String lastName;
    private String major;
    private int age;
    private double score;


    public MyStudent(String firstName, String lastName, String major, int age, double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.age = age;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
