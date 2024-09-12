package TextBoardExam2.model;

import java.util.ArrayList;

public class CommentRepository {
    ArrayList<Comment> comments = new ArrayList<Comment>();

    public void save(Comment comment) {
        comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Comment> findCommentByPostId (Post post) {
        ArrayList<Comment> comments = getComments();

        ArrayList<Comment> findComments = new ArrayList<Comment>();
        for (Comment comment : comments) {
            if (comment.getPostId() == post.getId()) {
                findComments.add(comment);
            }
        }
        return findComments;
    }
}
