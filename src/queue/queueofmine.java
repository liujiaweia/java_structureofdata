package queue;

import Linklist.Linklist;

public class queueofmine<E> {
    private Linklist<E> list = new Linklist<E>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(E elment) {
        list.add(elment);
    }

    public E Dequeue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }

}
