package ArrayList;


public class Main {
    public static void main(String[] args) {
//        ArrayListofmine list = new ArrayListofmine();
//        list.add(969);
//        list.add(929);
//        list.add(939);
//        list.add(949);
//        list.add(959);
//
//        list.set(3,80);
//        System.out.println(list);
        ArrayListofmine<Person> person = new ArrayListofmine<>();
        person.add(new Person(10,"Asda"));
        person.add(new Person(11,"Bsda"));
        person.add(new Person(12,"Csda"));
        System.out.println(person);
        //System.out.println(list.indeOf(969));


    }
}
