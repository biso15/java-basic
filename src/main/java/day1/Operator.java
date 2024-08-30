package day1;

public class Operator {
    public static void main(String[] args) {
        // 산술 연산자
        // +, -, *, /, %
        System.out.println(10 + 3);  // 13
        System.out.println(10 - 3);  // 7
        System.out.println(10 * 3);  // 30
        System.out.println(10 / 3);  // 3
        System.out.println(10 % 3);  // 1

        System.out.println(10 / 3);  // 3(정수)
        System.out.println(10.0 / 3.0);  // 3.33333(실수) -> 오차 있음

        // 비교 연산자 -> 논리값으로 결과가 나옴
        // <, >, <=, >=, ==, !=
        System.out.println(10 > 5);  // true
        System.out.println(10 < 5);  // false
        System.out.println(10 > 10);  // false
        System.out.println(10 >= 10);  // true
        System.out.println(10 == 10);  // true
        System.out.println(10 != 10);  // false
        System.out.println(!true);  // false
        System.out.println(!false);  // true

        // 자료형(타입)
        // 문자 : String, 숫자(정수) : int, 숫자(실수) : double, 논리값(참/거짓) : boolean
    }
}
