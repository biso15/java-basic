package TextBoardExam2.view;

import TextBoardExam2.model.Comment;
import TextBoardExam2.model.Post;

import java.util.ArrayList;

public class PostView {

    public void printDetail(Post targetPost, ArrayList<Comment> comments) {
        System.out.println("==================");
        System.out.printf("번호 : %d\n", targetPost.getId());
        System.out.printf("제목 : %s\n", targetPost.getTitle());
        System.out.printf("내용 : %s\n", targetPost.getContent());
        System.out.printf("등록날짜 : %s\n", targetPost.getDate());
        System.out.printf("조회수 : %s\n", targetPost.getHit());
        System.out.println("==================");
        if (comments.size() != 0) {
            printComment(comments);
        }
    }

    public void printComment(ArrayList<Comment> comments) {
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

    public void printNoResult() {
        System.out.println("==================");
        System.out.println("검색 결과가 없습니다.");
        System.out.println("==================");
    }
}
