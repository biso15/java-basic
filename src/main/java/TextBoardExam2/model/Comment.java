package TextBoardExam2.model;

public class Comment {
    int postId;
    String content;
    String date;

    public Comment (int postId, String content, String date) {
        this.postId = postId;
        this.content = content;
        this.date = date;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
