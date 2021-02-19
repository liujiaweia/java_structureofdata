package BinarySearchTree;

import BinarySearchTree.printer.BinaryTreeInfo;

import java.util.Comparator;

public class BinartSearchTreeofmine<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;
    public BinartSearchTreeofmine(Comparator<E> comparator){
        this.comparator = comparator;
    }

    public BinartSearchTreeofmine(){
        this(null);
    }
    public int size(){
        return size;
    }
    public boolean isempty(){
        return size==0;
    }
    public void add(E element){
        if(root==null){
            root = new Node<>(element,null);
            size++;
            return;
        }
        Node<E> node = root;
        Node<E> parent = null;
        int cmp = 0;
        while(node!=null) {
            cmp = compare(element,node.element);
            //记录父节点
            parent = node;
            if (cmp > 0) {
                node = node.rightNode;
            } else if (cmp < 0) {
                node = node.leftNode;
            } else {
                return ;
            }
        }
        Node<E> newNode = new Node<>(element,parent);
        if(cmp>0){
            parent.rightNode = newNode;
        }else{
            parent.leftNode = newNode;
        }
        size++;

    }
    //0 相等  1 1大于2
    private int compare(E e1,E e2){
       if(comparator!=null){
           return comparator.compare(e1,e2);
       }
       return ((Comparable<E>)e1).compareTo(e2);
    }
    private void elementNotNullCheck(E element) throws IllegalAccessException {
        if(element==null)
            throw new IllegalAccessException("element must bot be null");
    }
    private static class Node<E>{
        E element;
        Node<E> leftNode;
        Node<E> rightNode;
        Node<E> parentNode;
        public Node(E element,Node<E> parentNode){
            this.element = element;
            this.parentNode = parentNode;
        }

    }
    public Object root() {
        return root;
    }
    public Object left(Object node) {
        return ((Node<E>)node).leftNode;
    }
    public Object right(Object node) {
        return ((Node<E>)node).rightNode;
    }
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }
}
