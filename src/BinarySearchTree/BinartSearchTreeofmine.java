package BinarySearchTree;

import BinarySearchTree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinartSearchTreeofmine<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinartSearchTreeofmine(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinartSearchTreeofmine() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isempty() {
        return size == 0;
    }

    public void add(E element) {
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        Node<E> node = root;
        Node<E> parent = null;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            //记录父节点
            parent = node;
            if (cmp > 0) {
                node = node.rightNode;
            } else if (cmp < 0) {
                node = node.leftNode;
            } else {
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.rightNode = newNode;
        } else {
            parent.leftNode = newNode;
        }
        size++;

    }
    public boolean iscomplete2(){
        Queue<Node<E>> q = new LinkedList<>();
        q.offer(root);
        boolean leaf = false;
        while(!q.isEmpty()){
            Node<E> node = q.poll();
            if(leaf&&!node.isleaf())
                return false;
            if(node.leftNode!=null){
                q.offer(node.leftNode);
            }else if(node.rightNode!=null){
                return false;
            }
            if(node.rightNode!=null){
                q.offer(node.rightNode);
            }else{
                leaf = true;
            }

        }
        return  true;
    }
    public boolean isComplete() {
        Queue<Node<E>> q = new LinkedList<>();
        q.offer(root);
        boolean leaf = false;
        while (!q.isEmpty()) {
            Node<E> node = q.poll();
            if (leaf && !node.isleaf())
                return false;
            if (node.hastwochild()) {
                q.offer(node.leftNode);
                q.offer(node.rightNode);
            } else if (node.leftNode == null && node.rightNode != null) {
                return false;
            } else {
                leaf = true;
                if(node.leftNode!=null){
                    q.offer(node.leftNode);
                }
            }
        }
        return true;
    }

    //高度
    public int height2() {
        int height = 0;
        int levelsize = 1;
        if (root == null)
            return 0;
        Queue<Node<E>> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node<E> node = q.poll();
            levelsize--;
            if (node.leftNode != null)
                q.offer(node.leftNode);
            if (node.rightNode != null) {
                q.offer(node.rightNode);
            }
            if (levelsize == 0) {
                levelsize = q.size();
                height++;
            }
        }
        return height;

    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> root) {
        if (root == null)
            return 0;
        return Math.max(height(root.leftNode), height(root.rightNode)) + 1;
    }

    //0 相等  1 1大于2
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    //前
    public void perorder(Visitora<E> visitor) {
        perorder(root, visitor);
    }

    private void perorder(Node<E> node, Visitora<E> visitor) {
        if (node == null || visitor == null || visitor.stop) return;
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        perorder(node.leftNode, visitor);
        perorder(node.rightNode, visitor);
    }

    //中
    public void inorder(Visitora<E> visitor) {
        inorder(root, visitor);
    }

    private void inorder(Node<E> node, Visitora<E> visitor) {
        if (node == null || visitor == null) return;
        perorder(node.leftNode, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        perorder(node.rightNode, visitor);
    }

    //后
    public void postorder(Visitora<E> visitor) {
        postorder(root, visitor);
    }

    private void postorder(Node<E> node, Visitora<E> visitor) {
        if (node == null || visitor == null || visitor.stop) return;
        perorder(node.leftNode, visitor);
        perorder(node.rightNode, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    public void levelOrderTranversal(Visitora<E> visitor) {
        if (root == null || visitor == null)
            return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            //System.out.println(node.element);
            if (visitor.visit(node.element)) return;
            if (node.leftNode != null) {
                queue.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.offer(node.rightNode);
            }
        }

    }

    public static abstract class Visitora<E> {
        boolean stop;

        abstract boolean visit(E element);
    }


    private void elementNotNullCheck(E element) throws IllegalAccessException {
        if (element == null)
            throw new IllegalAccessException("element must bot be null");
    }

    private static class Node<E> {
        E element;
        Node<E> leftNode;
        Node<E> rightNode;
        Node<E> parentNode;

        public Node(E element, Node<E> parentNode) {
            this.element = element;
            this.parentNode = parentNode;
        }

        public boolean isleaf() {
            return leftNode == null && rightNode == null;
        }

        public boolean hastwochild() {
            return leftNode != null && rightNode != null;
        }

    }

    public Object root() {
        return root;
    }

    public Object left(Object node) {
        return ((Node<E>) node).leftNode;
    }

    public Object right(Object node) {
        return ((Node<E>) node).rightNode;
    }

    public Object string(Object node) {
        return ((Node<E>) node).element;
    }
}
