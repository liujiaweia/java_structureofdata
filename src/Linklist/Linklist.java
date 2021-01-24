package Linklist;

//public class linkedList<E> extends absLink<E> {
public class Linklist<E>  {
    private int size;
    private Node<E> first;
    private  Node<E> last;
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
        Node<E> prev;
        public Node(Node<E>prev,E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if(prev!=null){
                sb.append(prev.element);
            }
            sb.append("<-").append(element).append("->");
            if(next!=null){
                sb.append(next.element);
            }
            return sb.toString();
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
        last = null;

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
    //添加
    public void add(int index, E element) {
        rangeCheckAdd(index);
        if(index==size){//最后添加
            Node<E> oldLast = last;
            last = new Node<>(oldLast,element,null);
            if(oldLast==null){
                first = last;
            }else{
                oldLast.next = last;
            }
        }else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;

            Node<E> node = new Node<>(prev, element, next);

            next.prev = node;
            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
            }
        }


        size++;

    }
    //删除
    public E remove(int index){
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if(prev==null){
            first = next;
        }else {
            prev.next = next;
        }
        if(next==null){
            last = prev;
        }else {
            next.prev = prev;
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

    //查找节点
    private Node<E> node(int index) {
        rangeCheck(index);

        if(index<size>>1){
            Node<E> node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        }else{
            Node<E> node = last;
            for (int i = size-1; i > index; i--)
                node = node.prev;
            return node;
        }

    }

    @Override
    public String toString() {
        StringBuilder string =  new StringBuilder();
        string.append("size==").append(size).append(",[");
        Node<E> node = first;
        for(int i=0;i<size;i++){
            string.append(node);
            if(i!=size-1)
                string.append(",");
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
