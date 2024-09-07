package TextBoard.like;

import java.util.ArrayList;

public class LikeController {

    // post 객체 안에 likes가 들어있는 경우
    // private ArrayList<Like> likes = new ArrayList<>();
    private LikeRepository likeRepository = new LikeRepository();

    public LikeController() {

        LikeRepository likeRepository = new LikeRepository();

        Like l1 = new Like(1, "kd", getnowDate());
        Like l2 = new Like(1, "ks", getnowDate());
        Like l3 = new Like(3, "kd", getnowDate());
        Like l4 = new Like(1, "mj", getnowDate());
        Like l5 = new Like(2, "kd", getnowDate());
        Like l6 = new Like(2, "ks", getnowDate());
        Like l7 = new Like(1, "jw", getnowDate());
        Like l8 = new Like(3, "ks", getnowDate());
        Like l9 = new Like(3, "mj", getnowDate());
        Like l10 = new Like(1, "km", getnowDate());

        likes.add(l1);
        likes.add(l2);
        likes.add(l3);
        likes.add(l4);
        likes.add(l5);
        likes.add(l6);
        likes.add(l7);
        likes.add(l8);
        likes.add(l9);
        likes.add(l10);
    }

}
