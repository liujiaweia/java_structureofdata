package stack;

import ArrayList.ArrayListofmine;

// 撤销和恢复功能主要利用两个站来操作
public class Stackofmine<E> {
    private ArrayListofmine<E> list = new ArrayListofmine<>();
    public void push(E elment){
        list.add(elment);
    }
    public E pop(){
        return list.remove(list.size()-1);
    }
    public E top(){
        return list.get(list.size()-1);
    }



}
