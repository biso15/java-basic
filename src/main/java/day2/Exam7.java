package day2;

// 이름과 나이를 입력값으로 받아 자기소개를 해주세요.
// 조건 : 성과 이름은 띄어쓰기로 구분해주세요.
import java.util.Scanner;

public class Exam7 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // v1
        System.out.print("이름을 입력해주세요 : ");
        String name1 = scan.nextLine();
        System.out.print("나이를 입력해주세요 : ");
        int age1 = Integer.parseInt(scan.nextLine());
        System.out.println("안녕하세요 " + age1 + "세 " + name1 + "입니다.");

        // v2
        System.out.print("나이를 입력해주세요 : ");
        int age2 = Integer.parseInt(scan.nextLine());
        System.out.print("이름을 입력해주세요 : ");
        String name2 = scan.nextLine();
        System.out.println("안녕하세요 " + age2 + "세 " + name2 + "입니다.");

        // v1
        // 이름을 입력해주세요 : 홍 길동
        // 나이를 입력해주세요 : 29
        // 출력 : 안녕하세요 29세 홍 길동입니다.


        // v2
        // 나이를 입력해주세요 : 29
        // 이름을 입력해주세요 : 홍 길동
        // 출력 : 안녕하세요 29세 홍 길동입니다.


    }
}
