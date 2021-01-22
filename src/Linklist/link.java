package Linklist;

public interface link<T> {

    public static final int ELEMENT_NO_FOUNT = -1;
    void clear();

    int size();

    boolean isEmpty();
    public void add(T element);

    public T get(int index);

    public T set(int index,T element);

    public void add(int index,T element);

    public T remove(int index);
}
