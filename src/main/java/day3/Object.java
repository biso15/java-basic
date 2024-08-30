package day3;

public class Object {
    public static void main(String[] args) {

        // 폴더 -> 배열
        // String[] hong = {20, "홍길동", "서울"};  // 배열로는 안됨.

        // 폴더 -> 숫자, 문자 가리지 않고 다 저장 가능한 개념 ==> 객체

        // 자바는 변수 저장할 때 자료형을 요구
        // 객체는 먼저 어떻게 생겼는지 정의되어야 자바가 만들어줄 수 있다. -> 설계도(class)를 먼저 만든다.

        Person hong;  // 폴더가 만들어졌는가 ? X
        hong = new Person();  // Person 설계도에 따라서 객체를 하나 만들어줘. 그리고 hong 변수에 담아줘
        Person lee = new Person();  // new로 class를 이용한 객체(인스턴스)를 만들고, 값을 넣어서 사용

        // 객체, 클래스
        hong.age = 20;
        hong.name = "홍길동";
        hong.home = "서울";

        lee.age = 30;
        lee.name = "이순신";
        lee.home = "대전";

        System.out.println(hong.age + "살, " + hong.home + " 사는 " + hong.name + "입니다.");
        System.out.println(lee.age + "살, " + lee.home + " 사는 " + lee.name + "입니다.");
    }
}
