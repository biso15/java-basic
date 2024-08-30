package day3;

import java.util.Scanner;

public class NameAppAnswer {
    public static void main(String[] args) {
        // [예제]
        // 명령어 입력 : help
        // add : 이름 입력
        // list : 이름 목록
        // exit : 종료
        // 명령어 입력 : add
        // 이름을 입력해 주세요 : john
        // 나이를 입력해주세요 : 24
        // john이 명부에 저장되었습니다.
        // 명령어 입력 : list
        // ===== 이름 목록 =====
        // 1. john, 24
        // =====================
        // 명령어 입력 : add
        // 이름을 입력해주세요 : tomas
        // 나이를 입력해주세요 : 31
        // tomas이 명부에 저장되었습니다.
        // 명령어 입력 : add
        // 이름을 입력해주세요 : chris
        // 나이를 입력해 주세요 : 18
        // chris이 명부에 저장되었습니다.
        // 명령어 입력 : list
        // ===== 이름 목록 =====
        // 1. john, 24
        // 2. tomas, 31
        // 3. chris, 18
        // =====================
        // 명령어 입력 : exit
        // 이름 프로그램이 종료됩니다.

        // 배열이 어려우면 일단 한명의 이름을 저장하고 출력해본다.
        Scanner sc = new Scanner(System.in);

        String[] names = new String[5];  // 문자열 초기값 null
        int[] ages = new int[5];  // 문자열 초기값 null
        int index = 0;

        while(true) {
            System.out.print("명령어 입력 : ");
            String command = sc.nextLine();

            if (command.equals("help")) {
                System.out.println("add : 이름 입력");
                System.out.println("list : 이름 목록");
                System.out.println("exit : 종료");
            } else if (command.equals("add")) {
                    System.out.print("이름을 입력해주세요 : ");
                    names[index] = sc.nextLine();

                    System.out.print("나이를 입력해주세요 : ");
                    ages[index] = Integer.parseInt(sc.nextLine());

                    System.out.println(names[index] + "이 명부에 저장되었습니다.");
                    index++;
            } else if (command.equals("list")) {
                System.out.println("===== 이름 목록 =====");
                for (int i = 0; i < index; i++) {
                    System.out.println((i + 1) + ". " + names[i] + ", " + ages[i]);
                }
                System.out.println("=====================");
            } else if (command.equals("exit")) {
                System.out.println("이름 프로그램이 종료됩니다.");
                break;
            }
        }
    }
}
