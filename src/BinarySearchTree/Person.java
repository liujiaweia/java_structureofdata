package BinarySearchTree;

public class Person implements Comparable<Person> {
    private int age;
    private String name;
    public Person(int age,String name){
        this.age = age;
        this.name  = name;
    }
    public Person(int age){
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public int compareTo(Person e){
        return age-e.age;
    }
    public String toString(){
        return  "Person_age="+age+ "";
    }
}
