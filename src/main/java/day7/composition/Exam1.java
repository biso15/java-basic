package day7.composition;

// 출력 : 아래와 같이 출력되게 해주세요.

public class Exam1 {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.age = 20;
        p1.arm = new Arm();  // Arm 타입

        System.out.println(p1.arm.length + "cm");
        // 출력 : 100cm

        // 객체가 가지고 있는 변수, 메서드는 ()로 구분
    }
}

class Person {
    int age;
    Arm arm;
}

class Arm {
    int length = 100;
}