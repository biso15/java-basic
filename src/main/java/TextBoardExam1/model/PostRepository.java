package TextBoardExam1.model;

import TextBoardExam1.util.Util;

import java.util.ArrayList;

public class PostRepository {

    private ArrayList<Post> posts = new ArrayList<>();

    public PostRepository() {
        Post p1 = new Post(1, "안녕하세요 반갑습니다. java 공부중이에요.", "냉무", Util.getCurrentDate(), 0);
        Post p2 = new Post(2, "java 질문좀 할게요~", "냉무", Util.getCurrentDate(), 0);
        Post p3 = new Post(3, "정처기 따야되나요?", "냉무", Util.getCurrentDate(), 0);

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }

    public void save (Post post) {
        posts.add(post);
    }

    public void delete (Post post) {
        posts.remove(post);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public Post findPostbyId (int postId) {
        Post targetPost = null;

        ArrayList<Post> posts = getPosts();

        for (Post post : posts) {
            if (post.getId() == postId) {
                targetPost = post;
                return targetPost;
            }
        }
        return targetPost;
    }
}
