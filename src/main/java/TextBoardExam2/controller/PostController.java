package TextBoardExam2.controller;

import TextBoardExam2.model.Comment;
import TextBoardExam2.model.CommentRepository;
import TextBoardExam2.model.Post;
import TextBoardExam2.model.PostRepository;
import TextBoardExam2.util.Util;
import TextBoardExam2.view.PostView;

import java.util.ArrayList;
import java.util.Scanner;

public class PostController {

    private Scanner sc = new Scanner(System.in);

    private PostRepository postRepository = new PostRepository();
    private PostView postView = new PostView();
    private CommentRepository commentRepository = new CommentRepository();

    private int lastPostId = 3;

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();

        lastPostId++;
        Post post = new Post(lastPostId, title, content, Util.CurrentDate(), 0);
        postRepository.save(post);

        System.out.println("게시물이 등록되었습니다.");
    }

    public void list() {
        ArrayList<Post> posts = postRepository.getPosts();
        postView.printList(posts);
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int targetId = checkNum(sc.nextLine(), -1);
        if (targetId == -1) {
            return;
        }

        ArrayList<Post> posts = postRepository.getPosts();
        Post targetPost = postRepository.findPostById(targetId, posts);

        if (checkPost(targetPost)) {
            return;
        }

        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();

        targetPost.setTitle(title);
        targetPost.setContent(content);

        System.out.printf("%d번 게시물이 수정되었습니다.\n", targetPost.getId());
    }

    public void delete () {

        System.out.print("삭제할 게시물 번호 : ");
        int targetId = checkNum(sc.nextLine(), -1);
        if (targetId == -1) {
            return;
        }

        ArrayList<Post> posts = postRepository.getPosts();
        Post targetPost = postRepository.findPostById(targetId, posts);

        if (checkPost(targetPost)) {
            return;
        }

        postRepository.delete(targetPost);
        System.out.printf("%d번 게시물이 삭제되었습니다.\n", targetPost.getId());

    }

    public void detail () {

        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int targetId = checkNum(sc.nextLine(), -1);
        if (targetId == -1) {
            return;
        }

        ArrayList<Post> posts = postRepository.getPosts();
        Post targetPost = postRepository.findPostById(targetId, posts);

        if (checkPost(targetPost)) {
            return;
        }
        
        targetPost.setHit(targetPost.getHit() + 1);
        ArrayList<Comment> Comments = commentRepository.findCommentByPostId(targetPost);
        postView.printDetail(targetPost, Comments);
        innerDetail(targetPost);
    }

    public void innerDetail(Post post) {
        while(true) {
            System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");

            int cmd = checkNum(sc.nextLine(), -1);

            if (cmd == 1) {
                System.out.print("댓글 내용 : ");
                String content = sc.nextLine();

                Comment comment = new Comment(post.getId(), content, Util.CurrentDate());
                commentRepository.save(comment);

                System.out.println("댓글이 성공적으로 등록되었습니다.");

                ArrayList<Comment> Comments = commentRepository.findCommentByPostId(post);
                postView.printDetail(post, Comments);

            } else if (cmd == 2) {
                System.out.println("[추천 기능]");

            } else if (cmd == 3){
                System.out.println("[수정 기능]");

            } else if (cmd == 4){
                System.out.println("[삭제 기능]");

            } else if (cmd == 5){
                break;
            }
        }
    }

    public void search () {

        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = sc.nextLine();

        ArrayList<Post> posts = postRepository.getPosts();

        ArrayList<Post> searchedPosts = new ArrayList<Post>();

        for (Post post : posts) {
            if (post.getTitle().contains(keyword)) {
                searchedPosts.add(post);
            }
        }

        if (searchedPosts.size() == 0) {
            postView.printNoResult();
        } else {
            postView.printList(searchedPosts);
        }
    }

    public int checkNum(String targetId, int defaultNum) {
        try {
            int num = Integer.parseInt(targetId);
            return num;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        }
        return defaultNum;
    }
    
    public boolean checkPost (Post targetPost) {
        if (targetPost == null) {
            System.out.println("없는 게시물 번호입니다.");
            return true;
        }
        return false;
    }

}
