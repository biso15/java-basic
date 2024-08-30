package day3;

// 명명 규칙
// 클래스명은 대문자 시작
// 의미가 바뀔 때 대문자로 구분. 두 단어 이상의 조합으로 이름 지을 때 단어 의미가 바뀌면 바뀌는 단어의 앞문자를 대문자로(띄어쓰기 대체)
// 카멜 표기법
// 함수나 변수는 소문자로 시작
// 상수는 모두 대문자. 띄어쓰기는 _ 사용

import java.util.Scanner;

public class NameApp {
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

        Scanner sc = new Scanner(System.in);

        String[] nameList = {"0", "0", "0", "0", "0"};
        int[] ageList = new int[5];

        while(true) {
            System.out.print("명령어 입력 : ");
            String command = sc.nextLine();

            // "문자1" == "문자2" : 틀린 비교
            // "문자1".equals("문자2") : 올바른 비교
            if (command.equals("help")) {
                System.out.println("add : 이름 입력");
                System.out.println("list : 이름 목록");
                System.out.println("exit : 종료");
            } else if (command.equals("add")) {
                if (nameList[nameList.length - 1].equals("0")) {
                    System.out.print("이름을 입력해주세요 : ");
                    String name = sc.nextLine();
                    System.out.print("나이를 입력해주세요 : ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.println(name + "이 명부에 저장되었습니다.");
                    for (int i = 0; i < nameList.length; i++) {
                        if (nameList[i].equals("0")) {
                            nameList[i] = name;
                            ageList[i] = age;
                            break;
                        }
                    }
                } else {
                    System.out.println("이름이 가득찼습니다.");
                }
            } else if (command.equals("list")) {
                System.out.println("===== 이름 목록 =====");
                for (int i = 0; i < nameList.length; i++) {
                    if (nameList[i].equals("0")) {
                        break;
                    }
                    System.out.println((i + 1) + ". " + nameList[i] + ", " + ageList[i]);
                }
                System.out.println("=====================");
            } else if (command.equals("exit")) {
                System.out.println("이름 프로그램이 종료됩니다.");
                break;
            }
        }
    }
}
