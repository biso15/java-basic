package day3.Method;

public class Exam1 {
    public static void main(String[] args) {
        // 메서드를 올바르게 호출해서 아래처럼 출력되게 해주세요.

        Print p1 = new Print();
        p1.print();
        // 안녕하세요!!
        // 저는 차태진입니다.
        // 자바를 통해
        // 프로그램을 만들어보아요.

    }
}

class Print {
    public void print() {
        System.out.println("안녕하세요!!");
        System.out.println("저는 차태진입니다.");
        System.out.println("자바를 통해");
        System.out.println("프로그램을 만들어보아요.");
    }
}
