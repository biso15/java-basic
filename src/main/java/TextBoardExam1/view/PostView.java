package TextBoardExam1.view;

import TextBoardExam1.model.Post;
import TextBoardExam1.model.Comment;

import java.util.ArrayList;

public class PostView {

    public void printDetail(Post post, ArrayList<Comment> comments) {
        System.out.println("==================");
        System.out.printf("번호 : %s\n", post.getId());
        System.out.printf("제목 : %s\n", post.getTitle());
        System.out.printf("내용 : %s\n", post.getContent());
        System.out.printf("등록날짜 : %s\n", post.getCurrentDate());
        System.out.printf("조회수 : %s\n", post.getHit());
        System.out.println("==================");



        System.out.println("======= 댓글 =======");

        for (Comment comment : comments) {
            System.out.printf("댓글 내용 : %s\n", comment.getContent());
            System.out.printf("댓글 작성일 : %s\n", comment.getDate());
            System.out.println("==================");

        }

    }

    public void printList(ArrayList<Post> posts) {
        System.out.println("==================");
        for (Post post : posts) {
            System.out.printf("번호 : %s\n", post.getId());
            System.out.printf("제목 : %s\n", post.getTitle());
            System.out.println("==================");
        }
    }
}
