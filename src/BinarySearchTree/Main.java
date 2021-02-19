package BinarySearchTree;

import BinarySearchTree.printer.BinaryTrees;
import BinarySearchTree.Person;

import java.util.Comparator;

public class Main {
    static void test() {
        Integer date[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        BinartSearchTreeofmine<Integer> bst = new BinartSearchTreeofmine<>();
        for (int i = 0; i < date.length; i++) {
            bst.add(date[i]);
        }
        BinaryTrees.println(bst);

    }
    static void test2(){
        Integer date[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        BinartSearchTreeofmine<Person> bst = new BinartSearchTreeofmine<>();
        for (int i = 0; i < date.length; i++) {
            bst.add(new Person(date[i]));
        }
        BinaryTrees.println(bst);
    }

    static void test3(){
        Integer date[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        BinartSearchTreeofmine<Person> bst = new BinartSearchTreeofmine<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        for(int i=0;i<date.length;i++){
            bst.add(new Person(date[i]));
        }
        BinaryTrees.println(bst);
    }
    public static void main(String[] args) {
        test3();
    }
}
