package queue;


public class CircleQueue<E> {
    private int front;
    private int size;
    private E[] elements;

    public CircleQueue() {
        elements = (E[]) new Object[10];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(E elment) {
        ensureCapacity(size + 1);
        elements[index(size)] = elment;
        size++;
    }

    public E Dequeue() {
        E frontelement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontelement;
    }

    public E front() {
        return elements[front];
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //扩容1.5倍;
        int newcapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newcapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
        System.out.println(oldCapacity + "扩容为" + newcapacity);

    }

    private int index(int index) {
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }

    public void clear() {
        size = 0;
        front = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size==").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i != size - 1)
                string.append(",");
        }
        string.append("]");
        return string.toString();
    }
}
