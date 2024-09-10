package TextBoard.like;

import TextBoard.post.Post;

import java.io.*;
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

        // ArrayList를 파일로 저장
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("likes.txt"));
            oos.writeObject(getLikes());  // 파일에 ArrayList 저장
            oos.close();
            System.out.println("like 정보가 파일에 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Like save fail");
        }
    }

    public void delete(Like like) {
        likes.remove(like);

        // ArrayList를 파일로 저장
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("likes.txt"));
            oos.writeObject(getLikes());  // 파일에 ArrayList 저장
            oos.close();
            System.out.println("like 정보가 파일에 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Like save fail");
        }
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public Like findLikeById(Post post, String userId) {
        for (Like like : likes) {
            if (like.getMemberId().equals(userId) && like.getPostNumber() == post.getNumber()) {
                return like;
            }
        }
        return null;
    }
}
