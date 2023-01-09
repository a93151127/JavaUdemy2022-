package dataStructure.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListMain {
    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        //將元素插入在index = 0的位置
        arrayList.add(0, "martin");

        System.out.println(arrayList);
        //移除元素
        arrayList.remove(0);
        System.out.println(arrayList);
        arrayList.remove("c");
        System.out.println(arrayList);

        //將所有元素清空
        arrayList.clear();
        System.out.println(arrayList);

        greaterThan100();
    }

    public static void greaterThan100(){

//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(101);
//        integerList.add(55);
//        integerList.add(2000);
//        integerList.add(1);
//        integerList.add(300);

        //使用這種方法的list,在add,remove的方法下會有UnsupportedOperationException
        List<Integer> integerList = Arrays.asList(
                101,55,2000,1,300
        );


        for(int i = 0; i < integerList.size(); i++){
            if(integerList.get(i) >= 100){
                integerList.remove(i);
            }
        }
        System.out.println(integerList);
    }
}
