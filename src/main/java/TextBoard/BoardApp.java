package TextBoard;

import TextBoard.post.PostController;
import TextBoard.member.MemberController;

import java.util.Scanner;

public class BoardApp {

    private static CommonRepository commonRepository = new CommonRepository();
    private static PostController postController = new PostController();
    private static MemberController memberController = new MemberController();

    private Scanner sc = new Scanner(System.in);

    public void run() {

        while(true) {
            System.out.print("명령어를 입력해주세요" + commonRepository.getMemberInfo() + " : ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (command.equals("add")) {
                postController.add();

            } else if (command.equals("list")) {
                postController.list();

            } else if (command.equals("update")) {
                postController.update();

            } else if (command.equals("delete")) {
                postController.delete();

            } else if (command.equals("detail")) {
                postController.detail();

            } else if (command.equals("search")) {
                postController.search();

            } else if (command.equals("signup")) {
                memberController.signup();

            } else if (command.equals("login")) {
                memberController.login();

            } else if (command.equals("logout")) {
                memberController.logout();

            } else if (command.equals("sort")) {
                postController.sort();

            } else if (command.equals("page")) {
                postController.page();

            }
        }
    }

    public static CommonRepository getCommonRepository() {
        return commonRepository;
    }

    public static PostController getPostController() {
        return postController;
    }
}