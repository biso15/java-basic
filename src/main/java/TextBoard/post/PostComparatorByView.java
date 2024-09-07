package TextBoard.post;

import java.util.Comparator;

public class PostComparatorByView implements Comparator<Post> {
    public int compare(Post p1, Post p2) {
        if (p1.getView() > p2.getView()) {
            return 1;
        } else if (p1.getView() < p2.getView()) {
            return -1;
        }
        return 0;
    }
}