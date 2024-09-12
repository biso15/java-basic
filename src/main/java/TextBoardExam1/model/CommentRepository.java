package TextBoardExam1.model;

import TextBoardExam1.util.Util;

import java.util.ArrayList;

public class CommentRepository {

    private ArrayList<Comment> comments = new ArrayList<>();

    public CommentRepository () {
        Comment c1 = new Comment("댓글입니당1", 1, Util.getCurrentDate());
        Comment c2 = new Comment("댓글입니당2", 4, Util.getCurrentDate());
        Comment c3 = new Comment("댓글입니당3", 3, Util.getCurrentDate());
        Comment c4 = new Comment("댓글입니당4", 1, Util.getCurrentDate());
        Comment c5 = new Comment("댓글입니당5", 4, Util.getCurrentDate());
        Comment c6 = new Comment("댓글입니당6", 5, Util.getCurrentDate());

        comments.add(c1);
        comments.add(c2);
        comments.add(c3);
        comments.add(c4);
        comments.add(c5);
        comments.add(c6);
    }

    public void save (Comment comment) {
        comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
