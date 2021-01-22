package Linklist;

public abstract class absLink<E> implements link<E>{
    protected int size;

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
//    public void add(E element){
//        add(size,element);
//    }


}
