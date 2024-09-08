package TextBoard.like;

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


    public void save(Like like) {
        likes.add(like);
    }

    public void delete(Like like) {
        likes.remove(like);
    }

    public Like findLikeById(Post post, String userId) {
        for (Like like : likes) {
            if (like.getMemberId().equals(userId) && like.getPostNumber() == post.getNumber()) {
                return like;
            }
        }
        return null;
    }

    public int getLikeByPostNumber (Post post) {
        int likeLength = 0;
        for (Like like : likes) {
            if (like.getPostNumber() == (post.getNumber())) {
                likeLength++;
            }
        }
        return likeLength;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }
}
