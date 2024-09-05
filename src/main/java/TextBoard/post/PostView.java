package TextBoard;

import java.util.ArrayList;

public class PostView {

    public void printPostList(ArrayList<Post> posts, int nowPage) {
//        for (int i = 0; i < posts.size(); i++) {
//            System.out.println("==================");
//            System.out.println("번호 : " + posts.get(i).getNumber());
//            System.out.println("제목 : " + posts.get(i).getTitle());
//            // System.out.println("내용 : " + posts.get(i).getContents());
//        }

        int startPostIndex = 3 * (nowPage - 1);
        ArrayList<Post> PagePosts = new ArrayList<>();

        for (int i = startPostIndex; i < 3; i++) {
            PagePosts.add(posts.get(startPostIndex));
            startPostIndex++;
        }

        // for문 변형
        for(Post post : PagePosts) {

            int likeLength = getLikeByPostNumber(post, likes);

            System.out.println("==================");
            System.out.println("번호 : " + post.getNumber());
            System.out.println("제목 : " + post.getTitle());
            System.out.println("작성자 : " + post.getWriter());
            System.out.println("조회수 : " + post.getView());
            System.out.println("좋아요 : " + likeLength);

        }
        System.out.println("==================");

        String paging = "";
        for (int i = 1; i <= 5; i++) {
            if (nowPage == i) {
                paging = paging + "[" + i + "]" + " ";
                continue;
            }
            paging = paging + i + " ";
        }
        paging = paging + ">>";
        System.out.println(paging);
    }

    public void printPost(Post post) {

        String likeImage = "♡";

//        post 객체 안에 likes가 들어있는 경우
//        for (Like like : post.getLike()) {
//            if (like.getMemberId().equals(member.getId())) {
//                likeImage = "♥";
//            }
//        }

        int likeLength = getLikeByPostNumber(post, likes);

        if (findLikeById(post, likes) != null) {
            likeImage = "♥";
        }

        System.out.printf("===== %d번 게시물 =====\n", post.getNumber());
        System.out.println("번호 : " + post.getNumber());
        System.out.println("제목 : " + post.getTitle());
        System.out.println("내용 : " + post.getContents());
        System.out.println("작성일 : " + post.getDate());
        System.out.println("작성자 : " + post.getWriter());
        System.out.println("조회수 : " + post.getView());;
        System.out.println("좋아요 : " + likeImage + " " + likeLength);
        System.out.println("==================");

        if (post.getComments().size() > 0) {
            System.out.println("======= 댓글 =======");
            for (Comment comment : post.getComments()) {
                System.out.println("댓글 내용 : " + comment.getContents());
                System.out.println("댓글 작성일 : " + comment.getDate());
                System.out.println("==================");
            }
        }
    }
}
