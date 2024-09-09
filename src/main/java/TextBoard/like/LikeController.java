package TextBoard.like;

import TextBoard.BoardApp;
import TextBoard.post.Post;
import TextBoard.post.PostController;
import TextBoard.post.PostRepository;

public class LikeController {

    // post 객체 안에 likes가 들어있는 경우
    // private ArrayList<Like> likes = new ArrayList<>();
    private static LikeRepository likeRepository = new LikeRepository();

    private PostController postController = BoardApp.getPostController();
    private PostRepository postRepository = postController.getPostRepository();

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

        save(l1);
        save(l2);
        save(l3);
        save(l4);
        save(l5);
        save(l6);
        save(l7);
        save(l8);
        save(l9);
        save(l10);
    }

    public void save (Like l) {
        likeRepository.save(l);
        for (Post post : postRepository.getPosts()) {
            if (post.getNumber() == l.getPostNumber()) {
                post.setLikeLength(post.getLikeLength() + 1);
            }
        }
    }

    public static LikeRepository getLikeRepository() {
        return likeRepository;
    }
}
