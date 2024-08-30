package day2;

import java.util.Scanner;

public class Exam6 {
    public static void main(String[] args) {

        // Scanner를 이용해 입력값을 받아
        // 구구단을 원하는 단이 나오게 해주세요.

        //예시) 원하는 단을 입력해주세요 : 4 (입력후 엔터)

        // 4단 출력.

        Scanner sc = new Scanner(System.in);

        System.out.print("원하는 단을 입력해주세요 : ");
        int num1 = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(num1 + " x " + i + " = " + (num1 * i));
        }
    }
}
