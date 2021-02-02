package queue;


public class CircleDeque<E> {
    private int front;
    private int size;
    private E[] elements;

    public CircleDeque() {
        elements = (E[]) new Object[10];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;

    }

    public E deQueueFront() {
        E frontDeque = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontDeque;
    }

    public void enQueuefront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;

    }

    public E deQueueRear() {
        int rearindex = index(size - 1);
        E rear = elements[rearindex];
        elements[rearindex] = null;
        size--;
        return rear;
    }

    public E front() {
        return elements[front];
    }

    public E rear() {
        return elements[index(size - 1)];
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
        if (index < 0) {
            return index + elements.length;
        }
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
