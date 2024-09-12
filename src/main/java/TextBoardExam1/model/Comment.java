package TextBoardExam1.model;

public class Comment {
    private String content;
    private int postNumber;
    private String date;

    public Comment(String content, int postNumber, String date) {
        this.content = content;
        this.postNumber = postNumber;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }
}
