package newpackage;
/*
 * public
 * protected
 * default (cannot be used outside this package)
 * private (only available inside this class)
 *
 * fully qualified: name of package, subpackage, classname
 * Object is parent of class
 */

import java.util.Scanner;

//pojo -> plain old java object
class User extends Object {
    private int userId;
    private String userName;

    User() {
        super();
        //This is not the default constructor
    }

    User(int id, String userName) {
        this.userId = id;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String toString() {
        return this.userName + " " + this.userId;
    }

    public boolean equals(Object obj) {
        User user = (User) obj;
        return (this.userName.equals(user.getUserName()) && this.userId == user.getUserId());
    }
}

class Animal {
    public void eat() {
        System.out.println("eating ..");
    }
}

class Dog extends Animal {
    public void display() {
        System.out.println(" dog ..");
    }
}

class Student {
    private static Student ref;
    private Student() {
    }
    public static Student getStudent() {
        if (ref == null) {
            ref=new Student();
            return ref;
        } else {
            return ref;
        }
        //cannot use non static variables inside a static class
    }
}
abstract class Burger{
    abstract public void prepare();

    public void ingredient(){
        System.out.println("ingredients are burger and beans");
    }
    public void cook(){
        System.out.println("Cooking!");
    }
}
class CheeseBurger extends Burger{
    public void prepare() {
        System.out.println("cheese burger...");
    }

}
class ChickenBurger extends Burger{
    public void prepare() {
        System.out.println("chicken burger...");
    }
}
class VegBurger extends Burger{
    public void prepare() {
        System.out.println("veg burger...");
    }
}
class BurgerFactory{
    public static Burger getBurger(String type){
        if(type.equals("veg"))
            return new VegBurger();
        else if(type.equals("chicken"))
            return new ChickenBurger();
        else if(type.equals("cheese"))
            return new CheeseBurger();
        else
            throw new IllegalArgumentException("Unknown type: " + type);
    }
}
public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        User user = new User(101, "Alexander");
        System.out.println(user);

        String a = "hello";
        String b = "hello"; //Created in string pool not in heap
        //Returning the address of the corresponding variables
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b)); //Pointing to the same location

        int a1 = 2;
        int b1 = 2; //Created in string pool not in heap
        //Returning the address of the corresponding variables
        System.out.println(System.identityHashCode(a1));
        System.out.println(System.identityHashCode(b1)); //Pointing to the same location

        String c = "hello";
        String d = "hello"; //Created in heap

        //Returning the address of the corresponding variables
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d)); //NOT Pointing to the same location

        //double equals for address and .equals for values of the corresponding variables
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(c.equals(d));

        System.out.println(a.equals("HELLO"));

        //Parents reference can be stored in the child class
        Animal animal = new Dog();
        Dog dog = (Dog) animal;
        animal.eat();
        dog.eat();
//        animal.display();
        dog.display();

        Student st1 = Student.getStudent();
        Student st2 = Student.getStudent();

        System.out.println(System.identityHashCode(st1));
        System.out.println(System.identityHashCode(st2)); //Pointing to the same location

        System.out.println(st1.equals(st2));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a type: ");
        String type=scanner.nextLine();

        Burger burger= BurgerFactory.getBurger(type);
        burger.ingredient();
        burger.prepare();
    }
}
