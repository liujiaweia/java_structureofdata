package stack;

public class Main {
    public static void main(String[] args) {
        Stackofmine<Integer> stack = new Stackofmine<>();
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
