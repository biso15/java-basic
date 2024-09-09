package TextBoard.like;

public class Like {
    private int postNumber;
    private String memberId;
    private String date;

    public Like (int postNumber, String memberId, String date) {
        setPostNumber(postNumber);
        setMemberId(memberId);
        setDate(date);
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public String getMemberId() {
        return memberId;
    }
}