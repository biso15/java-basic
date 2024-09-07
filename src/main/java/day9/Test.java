package day9;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Person p1 = new Person();

        setPerson(p1);

        p1.intro();

        Person p2 = getPerson();

        p2.intro();

        ArrayList<String> arr = new ArrayList<>();

        myTest(arr);

        System.out.println(arr.get(0));
    }

    // main에서 arr를 넘겨받아 "apple", "banana", "orange"저장
    public static void myTest(ArrayList<String> arr) {
        arr.add("apple");
        arr.add("banana");
        arr.add("orange");
    }

    public static Person getPerson() {
        Person p = new Person();
        p.age = 30;
        p.name = "이순신";

        return p;
    }

    public static void setPerson(Person a) {
        a.age = 20;
        a.name = "홍길동";
    }
}

class Person {
    int age;
    String name;

    public void intro() {
        System.out.printf("%d살 %s입니다.\n", age, name);
    }
}