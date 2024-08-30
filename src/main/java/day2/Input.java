package day2;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();  // 숫자를 입력받는 명령어
        System.out.println("당신이 입력한 첫번째 값은 : " + num1);

        int num2 = sc.nextInt();
        System.out.println("당신이 입력한 두번째 값은 : " + num2);

        System.out.println(num1 + num2);
    }
}
