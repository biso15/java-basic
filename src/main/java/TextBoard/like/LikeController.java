package TextBoard.like;

import TextBoard.BoardApp;
import TextBoard.CommonContainer;
import TextBoard.post.Post;
import TextBoard.post.PostController;
import TextBoard.post.PostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LikeController {

    // post 객체 안에 likes가 들어있는 경우
    // private ArrayList<Like> likes = new ArrayList<>();
    private static LikeRepository likeRepository = new LikeRepository();

    private PostController postController = BoardApp.getPostController();
    private PostRepository postRepository = postController.getPostRepository();
    private static CommonContainer commonContainer = BoardApp.getCommonRepository();

    public LikeController() {

        // Json 파일에서 ArrayList를 읽어오기
        // Jackson ObjectMapper 생성
        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON 파일을 ArrayList로 변환
            ArrayList<Like> likes = mapper.readValue(new File("src/main/java/TextBoard/json/likes.json"), new TypeReference<ArrayList<Like>>() {});

            // 레포지토리에 저장
            for (Like like : likes) {
                likeRepository.save(like);
            }

            System.out.println("like JSON 파일을 ArrayList로 읽어왔습니다.");

        } catch (FileNotFoundException e) {
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

            commonContainer.saveToJson("src/main/java/TextBoard/json/likes.json", likeRepository.getLikes());

            System.out.println("Like 임시 데이터를 만들었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
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
