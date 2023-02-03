package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest<E> {
    private ArrayList<E> list = new ArrayList<E>();
    public int getSize(){
        return list.size();
    }
    public E peek(){
        return list.get(getSize()-1);
    }
    public void push(E e){
        list.add(e);
    }
    //取得最後一個值返回並刪除
    public E pop(){
        E e = list.get(getSize()-1);
        list.remove(getSize()-1);
        return e;
    }

}
