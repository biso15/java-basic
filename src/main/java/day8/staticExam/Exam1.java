package day8.staticExam;

// 문제 : 아래 코드의 잘 못된 점을 고쳐보세요.

public class Exam1 {
    public static void main(String[] args) {
        Person2 a1 = new Person2();
        a1.name = "홍길동";
        a1.age = 22;

        a1.introduce();
        // 출력 : 저는 22살 홍길동 입니다.

        Person2 a2 = new Person2();
        a2.name = "홍길순";
        a2.age = 25;

        a2.introduce();
        // 출력 : 저는 25살 홍길순 입니다.

        a1.introduce();
        // 출력 : 저는 22살 홍길동 입니다.
    }
}

class Person2 {

    int age;
    String name;

    public void introduce() {
        System.out.println("저는 " + age + "살 " + name + " 입니다.");
    }
}