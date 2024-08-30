package day2;

import java.util.Scanner;

public class InputString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열 입력 받기
        System.out.print("첫번째 값을 입력해주세요 : ");
        String str1 = sc.nextLine();
        System.out.println("당신이 입력한 첫번째 값은 : " + str1);

        System.out.print("두번째 값을 입력해주세요 : ");
        String str2 = sc.nextLine();
        System.out.println("당신이 입력한 두번째 값은 : " + str2);
    }
}
