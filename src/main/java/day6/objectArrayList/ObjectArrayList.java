package day6.objectArrayList;

import java.util.ArrayList;

public class ObjectArrayList {
    public static void main(String[] args) {

        String name1 = "홍길동";
        int age1 = 20;

        ArrayList<String> names = new ArrayList<>();
        names.add(name1);

        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(age1);

        Person p1 = new Person();
        p1.name = name1;
        p1.age = age1;

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(p1);

        // 객체 -> 리모콘(참조값)
        System.out.println(p1);  // 리모콘 값이 출력됨 => @2f4d3709

        // 객체 -> 변수(상태) + 메서드(동작)
        System.out.println(p1.name);
    }
}