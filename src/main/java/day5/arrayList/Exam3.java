package day5.arrayList;

import java.util.ArrayList;

public class Exam3 {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.age = 24;
        p1.name = "홍길동";

        Person p2 = new Person();
        p2.age = 30;
        p2.name = "이순신";

        Person p3 = new Person();
        p3.age = 41;
        p3.name = "을지문덕";

        Person p4 = new Person();
        p4.age = 32;
        p4.name = "황진이";

        // 1. 네 사람을 ArrayList에 저장
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        // 2. 네 사람에게 자기소개 시키기 (자기소개 문구 : 안녕하세요 ~~살 ~~~입니다.)
        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).introduce();
        }

        // 3. 30대인 사람에게만 자기소개 시키기
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).age >=30) {
                if (personList.get(i).age < 40) {
                    personList.get(i).introduce();
                }
            }
        }
    }
}

class Person {
    int age;
    String name;

    public void introduce() {
        System.out.println("안녕하세요 " + age + "살 " + name + "입니다.");
    }
}

// 2개 이상의 데이터로 표현되는 개념/사물은 무조건 객체로 만들어라.