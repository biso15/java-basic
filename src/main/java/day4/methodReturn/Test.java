package day4.methodReturn;

public class Test {

    public int plus(int num1, int num2) {
        System.out.println(num1 + num2);
        return num1 + num2;  // 메서드가 리턴할(돌아갈) 때 10이라는 값을 가지고 돌아감.
        // void 함수는 return시 아무 값도 넘기지 않음. 값을 넘기려면 void 대진 자료형을 써줘야 함
    }

    // 실수와 정수를 계산하면 결과는 무조건 실수입니다.
    public double circleArea(int r) {
        return r * r * 3.14;
    }
}