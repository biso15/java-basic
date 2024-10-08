package TextBoard;

import TextBoard.like.LikeController;
import TextBoard.post.PostController;
import TextBoard.member.MemberController;

import java.util.Scanner;

public class BoardApp {

    private static CommonContainer commonContainer = new CommonContainer();
    private static MemberController memberController = new MemberController();
    private static PostController postController = new PostController();
    private static LikeController likeController = new LikeController();

    private Scanner sc = new Scanner(System.in);

    public void run() {
        while(true) {
            System.out.print("명령어를 입력해주세요" + commonContainer.getMemberInfo() + " : ");
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

    public static CommonContainer getCommonRepository() {
        return commonContainer;
    }

    public static PostController getPostController() {
        return postController;
    }

    public static CommonContainer getCommonContainer() {
        return commonContainer;
    }

    public static void setCommonContainer(CommonContainer _commonContainer) {
        commonContainer = _commonContainer;
    }

    public static MemberController getMemberController() {
        return memberController;
    }

    public static void setMemberController(MemberController _memberController) {
        memberController = _memberController;
    }

    public static void setPostController(PostController _postController) {
        postController = _postController;
    }

    public LikeController getLikeController() {
        return likeController;
    }

    public void setLikeController(LikeController _likeController) {
        likeController = _likeController;
    }
}