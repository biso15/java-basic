package TextBoard.post;

import java.io.Serializable;

public class Post implements Serializable {
    private int number;
    private String title;
    private String contents;
    private String date;
    private int view;
    private String writer;
    private String userId;
    private int likeLength;

    // jackson 에서 Json 파일을 불러오기 위해 필요한 기본 생성자
    public Post () {}

    public Post (int number, String title, String contents, String date, int view, String userId, String writer, int likelength) {
        setNumber(number);
        setTitle(title);
        setContents(contents);
        setDate(date);
        setView(view);
        setUserId(userId);
        setWriter(writer);
        setLikeLength(likelength);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setView(int view) {
        this.view = view;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

//    post 객체 안에 likes가 들어있는 경우
//    public void setLike(Like like) {
//        likes.add(like);
//    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return date;
    }

    public int getView() {
        return view;
    }


    public String getWriter() {
        return writer;
    }

//    post 객체 안에 likes가 들어있는 경우
//    public ArrayList<Like> getLike() {
//        return likes;
//    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void increaseView() {
        this.view++;
    }

    public int getLikeLength() {
        return likeLength;
    }

    public void setLikeLength(int likeLength) {
        this.likeLength = likeLength;
    }
}
