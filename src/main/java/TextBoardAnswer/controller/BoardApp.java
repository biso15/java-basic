package TextBoardAnswer.controller;


import TextBoardAnswer.model.Member;

import java.util.Scanner;

public class BoardApp {
    Scanner scan = new Scanner(System.in);
    ArticleController articleController = new ArticleController();
    MemberController memberController = new MemberController();

    public void start() {

        // 이름 짓는 규칙
        // 변수, 클래스 -> 명사
        // 함수 -> 동사
        // 단어 조합시 단어 의미가 바뀔 때마다 대문자 표현
        //    -> 카멜 표기법
        // 클래스 이름 지을 때는 첫글자 무조건 대문자.
        // 누가 봐도. 추측 가능한. 단어 조합으로 지으세요.
        // 파파고나 구글 번역기, 챗gpt 켜서
        // 이름 짓는 건 너무너무너무너무너무너무너무 중요함

        // 코드 정렬 (심심할 때마다 눌러주세요_
        // Alt + Ctrl + L

        //        // 숫자 비교
        //        int a = 10;
        //        System.out.println(a == 10);
        //
        //        // 문자열 비교
        //        String str = "hello";
        //        System.out.println(str.equals("hello"));

        while (true) {
            Member loginedMember = memberController.getLoginedMember();
            articleController.setLoginedMember(loginedMember);

            if (loginedMember == null) {
                System.out.print("명령어: ");
            } else {
                System.out.printf("명령어[%s(%s)]: ", loginedMember.getLoginId(), loginedMember.getNickname());
            }

            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                articleController.add();

            } else if (command.equals("list")) {
                articleController.list();

            } else if (command.equals("update")) {
                articleController.update();

            } else if (command.equals("delete")) {
                articleController.delete();

            } else if (command.equals("detail")) {
                articleController.detail();
            } else if (command.equals("search")) {
                articleController.search();
            } else if(command.equals("sort")) {
                articleController.sort();
            } else if (command.equals("signup")) {
                memberController.signup();
            } else if (command.equals("login")) {
                memberController.login();
            } else if(command.equals("page")) {
                articleController.page();
            }
        }
    }
}
