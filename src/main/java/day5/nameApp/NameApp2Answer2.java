package day5.nameApp;

import java.util.ArrayList;
import java.util.Scanner;

public class NameApp2Answer2 {
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

        ArrayList<Person> people = new ArrayList<>();

        // 이름 짓는 고민 -> 대충 짓고 넘어가면 -> 큰일난다.
        // 이름 짓는 고민 -> 많이 해도 괜찮음
        // 변수 -> 명사(저장하려는 값과 관계 있어야 함), 메서드(동작) -> 동사

        while(true) {
            System.out.print("명령어 입력 : ");
            String command = sc.nextLine();

            if (command.equals("help")) {
                System.out.println("add : 이름 입력");
                System.out.println("list : 이름 목록");
                System.out.println("exit : 종료");
            } else if (command.equals("add")) {
                System.out.print("이름을 입력해주세요 : ");
                String name = sc.nextLine();

                System.out.print("나이를 입력해주세요 : ");
                int age = Integer.parseInt(sc.nextLine());

                Person p = new Person();
                p.name = name;
                p.age = age;

                people.add(p);

                System.out.println(name + "이 명부에 저장되었습니다.");
            } else if (command.equals("list")) {
                System.out.println("===== 이름 목록 =====");
                for (int i = 0; i < people.size(); i++) {
                    System.out.println((i + 1) + ". " + people.get(i).name + ", " + people.get(i).age);
                }
                System.out.println("=====================");
            } else if (command.equals("exit")) {
                System.out.println("이름 프로그램이 종료됩니다.");
                break;
            }
        }
    }
}