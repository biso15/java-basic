package TextBoard.post;

public class Comment {
    private String contents;
    private String date;
    private String memberId;
    private int postNumber;

    // 기본 생성자
    public Comment() {}

    public Comment(String contents, String date, String memberId, int postNumber) {
        setContents(contents);
        setDate(date);
        setMemberId(memberId);
        setPostNumber(postNumber);
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return date;
    }
}
