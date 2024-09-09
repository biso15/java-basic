package TextBoard.member;

import java.io.Serializable;

public class Member implements Serializable {
    private String id;
    private String pw;
    private String name;

    public Member(String id, String pw, String name) {
        setId(id);
        setPw(pw);
        setName(name);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }
}

