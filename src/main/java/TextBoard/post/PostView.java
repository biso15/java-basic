package TextBoard.post;

import TextBoard.like.Like;

import java.util.ArrayList;

public class PostView {

    public void printPostList(ArrayList<Post> posts, int nowPage, int realMaxPaging) {
//        for (int i = 0; i < posts.size(); i++) {
//            System.out.println("==================");
//            System.out.println("번호 : " + posts.get(i).getNumber());
//            System.out.println("제목 : " + posts.get(i).getTitle());
//            // System.out.println("내용 : " + posts.get(i).getContents());
//        }

        int startPostIndex = 3 * (nowPage - 1);
        ArrayList<Post> PagePosts = new ArrayList<>();

        if (posts.size() < startPostIndex + 3) {
            for (int i = startPostIndex; i < posts.size(); i++) {
                PagePosts.add(posts.get(i));
            }
        } else {
            for (int i = startPostIndex; i < startPostIndex + 3; i++) {
                PagePosts.add(posts.get(i));
            }
        }

        // for문 변형
        for(Post post : PagePosts) {
            System.out.println("==================");
            System.out.println("번호 : " + post.getNumber());
            System.out.println("제목 : " + post.getTitle());
            System.out.println("작성자 : " + post.getWriter());
            System.out.println("조회수 : " + post.getView());
            System.out.println("좋아요 : " + post.getLikeLength());
        }
        System.out.println("==================");

        String paging = "";
        String nextPaging = ">>";
        String prevPaging = "<< ";

        int maxPaging = ((nowPage - 1) / 5 + 1) * 5;  // 페이지에 표시되는 마지막 페이징 (5의 배수)

        int minPaging = maxPaging - 4;  // 첫번째 페이징
        if (maxPaging < 5) {
            minPaging = 1;  // 마지막 페이징아 5 이하일 경우 첫번째 페이징은 1로 지정 -> -가 되므로 지정해야함
        }

        if (realMaxPaging < maxPaging) {
            maxPaging = realMaxPaging;  // 빈 페이징이 생길 경우 실제 페이징 수로 수정
        }

        for (int i = minPaging; i <= maxPaging; i++) {
            if (nowPage == i) {
                paging = paging + "[" + i + "]" + " ";
                continue;
            }
            paging = paging + i + " ";
        }


        if (nowPage > (realMaxPaging - ((realMaxPaging - 1) % 5) - 1)) {
            nextPaging = "";
        }

        if (nowPage <= 5) {
            prevPaging = "";
        }

        System.out.print(prevPaging);
        System.out.print(paging);
        System.out.println(nextPaging);
    }

    public void printPost(Post post, Like findLikeById) {

        String likeImage = "♡";

//        post 객체 안에 likes가 들어있는 경우
//        for (Like like : post.getLike()) {
//            if (like.getMemberId().equals(member.getId())) {
//                likeImage = "♥";
//            }
//        }

        if (findLikeById != null) {
            likeImage = "♥";
        }

        System.out.printf("===== %d번 게시물 =====\n", post.getNumber());
        System.out.println("번호 : " + post.getNumber());
        System.out.println("제목 : " + post.getTitle());
        System.out.println("내용 : " + post.getContents());
        System.out.println("작성일 : " + post.getDate());
        System.out.println("작성자 : " + post.getWriter());
        System.out.println("조회수 : " + post.getView());
        System.out.println("좋아요 : " + likeImage + " " + post.getLikeLength());
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
