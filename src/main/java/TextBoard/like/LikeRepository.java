package TextBoard.like;

import TextBoard.member.Member;
import TextBoard.post.Post;

import java.util.ArrayList;

public class LikeRepository {

    private ArrayList<Like> likes = new ArrayList<>();

//    post 객체 안에 likes가 들어있는 경우
//    public Like findLikeById(Post post) {
//        for (Like like : post.getLike()) {
//            if (like.getMemberId().equals(member.getId())) {
//                return like;
//            }
//        }
//        return null;
//    }

    public Like findLikeById(Post post, ArrayList<Like> likes) {
        for (Like like : likes) {
            if (like.getMemberId().equals(member.getId()) && like.getPostNumber() == post.getNumber()) {
                return like;
            }
        }
        return null;
    }

    public int getLikeByPostNumber (Post post, ArrayList<Like> likes) {
        int likeLength = 0;
        for (Like like : likes) {
            if (like.getPostNumber() == (post.getNumber())) {
                likeLength++;
            }
        }
        return likeLength;
    }

    public Member findMember(String id, String pw) {
//        for(Member member : members) {
//
//            // 논리연산자
//            // 조건1 || 조건2 -> 조건1 조건2 둘 중 하나만 만족해도 실행
//            // 조건1 && 조건2 -> 조건1 조건2가 동시에 만족(모두 만족)해야만 실행
//            if (id.equals(member.getId()) && pw.equals(member.getPw())) {
//                return member;
//            }
//        }
        return null;
    }
}
