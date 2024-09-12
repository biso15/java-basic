package TextBoardExam2.model;

public class Post {
    private int id;
    private String title;
    private String content;
    private String date;
    private int hit;

    public Post(int id, String title, String content, String date, int hit) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.hit = hit;
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

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
}
