package TextBoard.like;

import TextBoard.BoardApp;
import TextBoard.post.PostController;


public class LikeController {

    // post 객체 안에 likes가 들어있는 경우
    // private ArrayList<Like> likes = new ArrayList<>();
    private static LikeRepository likeRepository = new LikeRepository();

    private PostController postController = BoardApp.getPostController();

    public LikeController() {

        Like l1 = new Like(1, "kd", postController.getnowDate());
        Like l2 = new Like(1, "ks", postController.getnowDate());
        Like l3 = new Like(3, "kd", postController.getnowDate());
        Like l4 = new Like(1, "mj", postController.getnowDate());
        Like l5 = new Like(2, "kd", postController.getnowDate());
        Like l6 = new Like(2, "ks", postController.getnowDate());
        Like l7 = new Like(1, "jw", postController.getnowDate());
        Like l8 = new Like(3, "ks", postController.getnowDate());
        Like l9 = new Like(3, "mj", postController.getnowDate());
        Like l10 = new Like(1, "km", postController.getnowDate());

        likeRepository.save(l1);
        likeRepository.save(l2);
        likeRepository.save(l3);
        likeRepository.save(l4);
        likeRepository.save(l5);
        likeRepository.save(l6);
        likeRepository.save(l7);
        likeRepository.save(l8);
        likeRepository.save(l9);
        likeRepository.save(l10);
    }

    public static LikeRepository getLikeRepository() {
        return likeRepository;
    }
}
