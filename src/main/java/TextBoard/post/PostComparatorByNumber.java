package TextBoard;

import TextBoard.post.Post;

import java.util.Comparator;

public class PostComparatorByNumber implements Comparator<Post> {
    public int compare(Post p1, Post p2) {
        if (p1.getNumber() > p2.getNumber()) {
            return 1;
        } else if (p1.getNumber() < p2.getNumber()) {
            return -1;
        }
        return 0;
    }
}
