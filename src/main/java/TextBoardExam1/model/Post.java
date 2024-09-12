package TextBoardExam1.model;

public class Post {
    private int id;
    private String title;
    private String content;
    private String currentDate;
    private int hit;

    public Post (int id, String title, String content, String currentDate, int hit) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.currentDate = currentDate;
        this.hit = hit;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
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
}
