package day4.methodReturn;

public class Exam3 {
    public static void main(String[] args) {

        Test3 t1 = new Test3();

        // 0은 양수로 보겠습니다.
        int no = -1;

        if (t1.isNegative(no)) {

            System.out.println("음수입니다.");

        } else {

            System.out.println("양수입니다.");

        }
        // no 값을 바꿔가면서 테스트해보세요.
    }
}

class Test3 {
    public boolean isNegative(int no) {
        if (no < 0) {
            return true;
        } else {
            return false;
        }
    }
}