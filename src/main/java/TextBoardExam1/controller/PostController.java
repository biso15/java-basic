package TextBoardExam1.controller;

import TextBoardExam1.model.CommentRepository;
import TextBoardExam1.model.Comment;
import TextBoardExam1.model.Post;
import TextBoardExam1.model.PostRepository;
import TextBoardExam1.view.PostView;
import TextBoardExam1.util.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class PostController {

    private Scanner sc = new Scanner(System.in);
    private int lastPostId = 4;

    private PostRepository postRepository = new PostRepository();
    private PostView postView = new PostView();
    private CommentRepository commentRepository = new CommentRepository();

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();

        Post post = new Post(lastPostId, title, content, Util.getCurrentDate(), 0);
        postRepository.save(post);
        lastPostId++;

        System.out.println("게시물이 등록되었습니다.");
    }

    public void list() {
        ArrayList<Post> posts = postRepository.getPosts();
        postView.printList(posts);
    }

    public void update () {
        System.out.print("수정할 게시물 번호 : ");
        int postId = checkNum(sc.nextLine(), -1);
        if (postId == -1) {
            return;
        }

        Post targetPost = null;

        ArrayList<Post> posts = postRepository.getPosts();

        for (Post post : posts) {
            if (post.getId() == postId) {
                targetPost = post;

                System.out.print("제목 : ");
                String title = sc.nextLine();
                System.out.print("내용 : ");
                String content = sc.nextLine();

                targetPost.setTitle(title);
                targetPost.setContent(content);

                System.out.printf("%d번 게시물이 수정되었습니다.\n", targetPost.getId());

                break;
            }
        }

        checkNull(targetPost);
    }

    public void delete () {
        System.out.print("삭제할 게시물 번호 : ");
        int postId = checkNum(sc.nextLine(), -1);
        if (postId == -1) {
            return;
        }

        Post targetPost = postRepository.findPostbyId(postId);

        if (targetPost != null) {
            postRepository.delete(targetPost);
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", targetPost.getId());

            return;
        }

        checkNull(targetPost);

    }

    public void detail () {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int postId = checkNum(sc.nextLine(), -1);
        if (postId == -1) {
            return;
        }

        Post targetPost = postRepository.findPostbyId(postId);

        if (targetPost != null) {
            targetPost.setHit(targetPost.getHit() + 1);
            ArrayList<Comment> comments = commentRepository.getComments();
            postView.printDetail(targetPost, comments);
            detailMenu(targetPost);
        }

        checkNull(targetPost);

    }

    public void detailMenu(Post targetPost) {
        while(true) {
            System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
            int com = checkNum(sc.nextLine(), -1);
            if (com == -1) {
                return;
            }

            if (com == 1) {
                System.out.print("댓글 내용 : ");
                String content = sc.nextLine();

                Comment comment = new Comment(content, targetPost.getId(), Util.getCurrentDate());
                commentRepository.save(comment);

                System.out.println("댓글이 성공적으로 등록되었습니다.");

                ArrayList<Post> posts = postRepository.getPosts();
                postView.printList(posts);

            } else if (com == 2) {
                System.out.println("[추천 기능]");
            } else if (com == 3) {
                System.out.println("[수정 기능]");
            } else if (com == 4) {
                System.out.println("[삭제 기능]");
            } else if (com == 5) {
                break;
            }

        }
    }

    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = sc.nextLine();

        ArrayList<Post> searchedPost = new ArrayList<>();

        ArrayList<Post> posts = postRepository.getPosts();
        for (Post post : posts) {
            String postTitle = post.getTitle();
            if (postTitle.contains(keyword)) {
                searchedPost.add(post);
            }
        }

        if (searchedPost.size() > 0) {
            postView.printList(searchedPost);

            return;
        }

        System.out.println("==================");
        System.out.println("검색 결과가 없습니다.");
        System.out.println("==================");

    }

    public void checkNull (Post targetPost) {
        if (targetPost == null) {
            System.out.println("없는 게시물 번호입니다.");
        }
    }

    public int checkNum (String str, int defaultNum) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            num = defaultNum;
        }
        return num;
    }
}
