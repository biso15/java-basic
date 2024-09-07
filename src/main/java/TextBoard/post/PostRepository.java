package TextBoard.post;

import java.util.ArrayList;

// 창고 관리(Model)
public class PostRepository {
    private ArrayList<Post> posts = new ArrayList<>();

    // 누군가에게 Post를 넘겨받아서 창고(ArrayList)에 저장해주는 기능
    public void save(Post post) {
        posts.add(post);
    }

    // 자신이 가지고 있는 창고(ArrayList)의 내용물을 다른 누군가에게 전달
    public ArrayList<Post> getPosts() {
        return posts;
    }

    // 창고에서 특정 물건을 제거함
    public void delete(Post post) {
        posts.remove(post);
    }

    public Post findPostByNumber(int num) {
        // 만약 내가 찾고자 하는 게시물이 없다면?
        for(Post post : posts) {
            if (num == post.getNumber()) {
                return post;  // return을 만나면 메서드는 그 즉시 종료.
            }
        }
        return null;  // null은 "없다" 라는 의미
    }

    // keyword가 포함된 Post만 선별해서 ArrayList로 담아 필요한 누군가에게 제공
    public ArrayList<Post> getFilterPosts(String keyword) {
        ArrayList<Post> FilterPosts = new ArrayList<>();

        for (Post post : posts) {
            if (post.getTitle().contains(keyword)) {
                FilterPosts.add(post);
            }
        }
        return FilterPosts;
    }

}
