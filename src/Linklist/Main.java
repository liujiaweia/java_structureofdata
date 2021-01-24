package Linklist;


public class Main {
    public static void main(String[] args) {
        //singlelinkedList2<Integer> list = new singlelinkedList2<Integer>();
//        list.remove(0);
//        list.add(20);
//        list.add(0,10);
//        list.add(30);
//        list.add(list.size(),40);
//        list.remove(1);
//        System.out.println(list);
        Linklist<Integer> list = new Linklist<Integer>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0,55);
        list.add(2,66);
        list.add(list.size(),77);

        list.remove(0);
        list.remove(2);
        list.remove(list.size()-1);

        System.out.println(list);
    }
}
