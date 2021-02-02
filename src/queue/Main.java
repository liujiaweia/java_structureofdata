package queue;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;
import stack.Stackofmine;

public class Main {
    static void test() {
        CircleQueue<Integer> queue = new CircleQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < 5; i++) {
            queue.Dequeue();
        }
        for (int i = 15; i < 23; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.Dequeue());
        }
    }

    static void test2() {
        CircleDeque<Integer> queue = new CircleDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.enQueuefront(i + 1);
            queue.enQueueRear(i + 100);
        }
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }
        queue.enQueuefront(11);
        queue.enQueuefront(12);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueFront());
        }
    }

    public static void main(String[] args) {
//        queueofmine<Integer> queue = new queueofmine<>();
//        queue.enQueue(11);
//        queue.enQueue(12);
//        queue.enQueue(13);
//        queue.enQueue(14);
//        while(!queue.isEmpty()){
//            System.out.println(queue.Dequeue());
//        }
        test2();
    }
}
