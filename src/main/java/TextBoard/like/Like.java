package TextBoard.like;

import java.io.Serializable;

public class Like implements Serializable {
    private int postNumber;
    private String memberId;
    private String date;

    // 기본 생성자
    public Like () {}

    public Like (int postNumber, String memberId, String date) {
        setPostNumber(postNumber);
        setMemberId(memberId);
        setDate(date);
    }

    public String getDate() {
        return date;
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