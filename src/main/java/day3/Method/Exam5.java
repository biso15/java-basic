package day3.Method;

public class Exam5 {
    public static void main(String[] args) {
        Person3 p1 = new Person3();

        p1.introduce(3);

        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!

        p1.introduce(5);
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!

        p1.introduce(10);
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
        // 안녕하세요. 20살 홍길동입니다.!
    }
}

class Person3 {
    public void introduce(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("안녕하세요. 20살 홍길동입니다.!");
        }
    }
}