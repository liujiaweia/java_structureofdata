package stack;

public class Main {
    public static void main(String[] args) {
        Stackofmine<Integer> stack = new Stackofmine<>();
        stack.add(11);
        stack.add(12);
        stack.add(13);
        stack.add(14);
        while(!stack.isempty()){
            System.out.println(stack.pop());
        }
    }
}
