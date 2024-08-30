package day3.Method;

public class Exam2 {
    public static void main(String[] args) {

        Test t1 = new Test();

        t1.hi();
        // 안녕하세요. 저는 홍길동입니다. 잘부탁드립니다.

        t1.bye();
        // 안녕히 가세요. 다음에 또 봐요!

    }
}

class Test {
    public void hi() {
        System.out.println("안녕하세요. 저는 홍길동입니다. 잘부탁드립니다.");
    }

    public void bye() {
        System.out.println("안녕히 가세요. 다음에 또 봐요!");
    }
}