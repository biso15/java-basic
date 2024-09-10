package TextBoardAnswer.model;

public class Article {

    // 게시물 번호
    private int id;
    // 제목
    private String title;
    // 내용
    private String content;
    // 날짜
    private String regDate;
    // 조회수
    private int hit;
    // member 고유 id
    private int memberId;

    public Article(int id, String title, String content, int memberId, String regDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.regDate = regDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
//    public void increaseHit() {
//        hit++;
//    }

}