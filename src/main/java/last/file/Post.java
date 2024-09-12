package last.file;

public class Post {
    private int id;
    private String title;
    private String body;
    private String createDate;
    private int hit;

    // 생성자 여러개 만들 수 있다. 단, 매개변수 모양이 달라야 함. => 생성자 오버로딩
    public Post() {}

    public Post(int id, String title, String body, String createDate, int hit) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createDate = createDate;
        this.hit = hit;
    }

    public void increaseHit() {
        this.hit++;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
