package day3.Method;

// 객체(사물 표현) -> 상태/동작 -> 변수와 메서드의 집합이다.
public class Person {
    // 변수는 상태를 표현한다.
    int age;
    String name;

    // 메서드는 동작(연산)을 표현한다.
    // 접근제어자 리턴타입 메서드명(매개변수) { 내용 }
    // 동작은 일단 쉽게 출력으로 대체할 것임
    public void walk() {
        System.out.println("사람이 걷습니다.");
    }

    public void introduce(int age2, String name2) {
        System.out.println("안녕하세요 " + age2 + "살 " + name2 + "입니다.");
    }

    public void introduce2() {
        System.out.println("안녕하세요 " + age + "살 " + name + "입니다.");
    }
}
