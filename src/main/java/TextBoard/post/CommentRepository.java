package TextBoard.post;

import java.util.ArrayList;

public class CommentRepository {

    private ArrayList<Comment> comments = new ArrayList<>();

    public CommentRepository () {

    }
    public void save(Comment comment) {
        comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Comment> getCommentsbyPostNumber(int postNumber) {
        ArrayList<Comment> FilterComment = new ArrayList<>();

        for (Comment comment : comments) {
            if (comment.getPostNumber() == postNumber) {
                FilterComment.add(comment);
            }
        }
        return FilterComment;
    }

}
