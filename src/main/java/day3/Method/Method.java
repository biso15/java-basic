package day3.Method;

public class Method {
    public static void main(String[] args) {

        // 변수 -> 정보를 저장
        // 메서드 -> 동작을 수행
        Person p1 = new Person();
        p1.age = 20;
        p1.name = "홍길동";

        Person p2 = new Person();
        p2.age = 30;
        p2.name = "이순신";

        p1.introduce( 20, "홍길동");
        p2.introduce(30, "이순신");
        p1.introduce2();
        p2.introduce2();

    }
}
