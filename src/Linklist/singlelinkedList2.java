package Linklist;

public class singlelinkedList2<E> {
    private int size;
    private singlelinkedList2.Node<E> first;
    private static final int ELEMENT_NO_FOUNT = -1;

    //边界检测
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ",Size" + size);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index:" + index + ",Size" + size);
    }

    private void rangeCheckAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index:" + index + ",Size" + size);
    }
    public singlelinkedList2(){
        first = new Node<>(null,null);
    }
    private static class Node<E> {
        E element;
        singlelinkedList2.Node<E> next;

        public Node(E element, singlelinkedList2.Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void clear() {
        size = 0;
        first = null;

    }

//
//    public int size(){
//        return size;
//    }
//    public boolean isEmpty(){
//        return size == 0;
//    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NO_FOUNT;
    }

    public void add(E element) {
        add(size, element);
    }

    public E get(int index) {
        return node(index).element;
    }

    public E set(int index, E element) {
        Node<E> node  = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    public void add(int index, E element) {
        rangeCheckAdd(index);
        //插入在0位置;
        Node<E> prenode =index==0?first:node(index - 1);
        prenode.next = new singlelinkedList2.Node<>(element, prenode.next);
        size++;

    }
    public E remove(int index){
        rangeCheck(index);
        Node<E> pre =index==0?first:node(index - 1);
        Node<E>  node = pre.next;
        pre.next = node.next;
        size--;
        return node.element;
    }

    public int indexOf(E element) {
        if(element ==null){
            Node<E> node = first;
            for(int i=0;i<size;i++){
                if(node.element ==  null)
                    return i;
                node = node.next;
            }
        }else {
            Node<E> node = first;
            for(int i=0;i<size;i++){
                if(element.equals(node.element))
                    return i;
                node = node.next;
            }
        }
        return ELEMENT_NO_FOUNT;
    }


    private singlelinkedList2.Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string =  new StringBuilder();
        string.append("size==").append(size).append(",[");
        Node<E> node = first.next;
        for(int i=0;i<size;i++){
            string.append(node.element);
            if(i!=size-1)
                string.append(",");
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
