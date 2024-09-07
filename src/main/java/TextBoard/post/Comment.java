package TextBoard.post;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Comment {
    private String contents;
    private String date;

    public Comment(String contents) {
        setContents(contents);
        setDate();
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        date = sdf.format(ts.getTime());
    }

    public String getContents() {
        return contents;
    }

    public String getDate() {
        return date;
    }
}
