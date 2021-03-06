package Linklist;

//public class linkedList<E> extends absLink<E> {
public class singlecirlelinkedList<E>  {
    private int size;
    private Node<E> first;
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

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
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
        if(index == 0){
            //创建新节点 避免找最后节点错误。
            Node<E> newfirst = new Node<>(element,first);
            //拿到最后一个节点
            Node<E> last =(size==0)?newfirst:node(size-1);
            last.next = newfirst;
            first = newfirst;
        }else {
            Node<E> prenode = node(index - 1);
            prenode.next = new Node<>(element, prenode.next);
        }
        size++;

    }
    public E remove(int index){
        rangeCheck(index);
        Node<E> node = first;
        if(index==0) {
            //先拿 避免只存在一个点的时候  拿不到
            if(size==1) {
                first = null;
            }
            else {
                Node<E> last = node(size - 1);
                first = first.next;
                last.next = first;
            }
        }else {
            Node<E> pre = node(index - 1);
            node = pre.next;
            pre.next = node.next;
        }
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


    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string =  new StringBuilder();
        string.append("size==").append(size).append(",[");
        Node<E> node = first;
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
