package TextBoard;

import TextBoard.like.LikeController;
import TextBoard.member.Member;
import TextBoard.post.PostController;
import TextBoard.member.MemberController;

import java.util.Scanner;

public class BoardApp {

    private PostController postController = new PostController();
    private MemberController memberController = new MemberController();
    private LikeController likeController = new LikeController();
    private Scanner sc = new Scanner(System.in);

    private String memberInfo = "";
    private Member member = new Member("","","");

    public void setMember(Member member) {
        this.member = member;
    }

    public void run() {

        while(true) {
            System.out.print("명령어를 입력해주세요" + memberInfo + " : ");
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
                postController.signup();

            } else if (command.equals("login")) {
                //postController.login();

            } else if (command.equals("logout")) {
                //postController.logout();

            } else if (command.equals("sort")) {
                postController.sort();

            } else if (command.equals("page")) {
                postController.page();

            }
        }
    }

    public void setMemberInfo (String memberInfo) {
        this.memberInfo = memberInfo;
    }
}