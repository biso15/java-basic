package day3;

import java.util.Scanner;

public class InputGarbage {
    public static void main(String[] args) {
        // 나이 입력 : 24
        // 이름 입력 : 홍길동

        // 안녕하세요 24살 홍길동입니다.
        Scanner sc = new Scanner(System.in);

        System.out.print("나이 : ");
        int age = sc.nextInt();

        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.println("안녕하세요 " + age + "살 " + name + "입니다.");

        // 숫자 입력시 문자 입력으로 넘어가지 않고 마지막 출력 코드가 바로 출력됨
        // 숫자를 입력받을 때 문자로 받아서 숫자로 변환 (사칙연산을 사용할 수 있으므로 String이 아닌 int로 사용)
        System.out.print("나이 : ");
        int age2 = Integer.parseInt(sc.nextLine());

        System.out.print("이름 : ");
        String name2 = sc.nextLine();

        System.out.println("안녕하세요 " + age2 + "살 " + name2 + "입니다.");
    }
}
