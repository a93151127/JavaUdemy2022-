package reflection;

import io.FileMain;

import java.lang.reflect.Field;

public class TestORMMain {
    public static void main(String[] args) throws NoSuchFieldException {
        Class c1 = MyStudent.class;
        TableStudent tableStudent = (TableStudent) c1.getAnnotation(TableStudent.class);
        System.out.println(tableStudent.value());

        Field field = c1.getDeclaredField("id");
        FieldStudent fieldStudent = (FieldStudent) field.getAnnotation(FieldStudent.class);
        System.out.println(fieldStudent.columnName());
        System.out.println(fieldStudent.type());
        System.out.println(fieldStudent.length());
    }
}
