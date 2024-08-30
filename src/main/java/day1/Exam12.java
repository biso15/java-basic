package day1;

public class Exam12 {
    // 문제 : 구구단 작성
    // 조건 : 짝수번째만 곱하기
    /* 출력예시 :

      2 * 2 = 4
      2 * 4 = 8
      2 * 6 = 12
      2 * 8 = 16

      ...

      9단까지 이런식으로 나오면 됩니다.

    */

    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++) {
            for (int x = 2; x <= 9; x++) {
                if (x % 2 == 0) {
                    System.out.println(i + " * " + x + " = " + i * x);
                }
            }
        }
    }
}
