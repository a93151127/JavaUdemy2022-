package dataStructure.map;

import java.util.*;

public class TreeMapMain {
    public static void main(String[] args) {
        Map<Student, Integer> studentMap = new TreeMap(new SortDropPower());
        studentMap.put(new Student(5, "Martin", 98), 12000);
        studentMap.put(new Student(3, "Abi", 30), 3000);
        studentMap.put(new Student(1, "John", 50), 5000);
        studentMap.put(new Student(2, "Vincent", 100), 10000);

        studentMap.forEach((k, v) -> {
            System.out.println(k.toString() + ":" + v);
        });
    }
}

class Student{
    private int id;
    private String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

class SortDropPower implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getScore() - o1.getScore();
    }
}