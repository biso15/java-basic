package TextBoardAnswer.view;

import TextBoardAnswer.model.Article;
import TextBoardAnswer.model.Like;
import TextBoardAnswer.model.Member;
import TextBoardAnswer.model.Reply;

import java.util.ArrayList;

public class ArticleView {

    public void printArticles(ArrayList<Article> articles) {
        System.out.println("==================");
        for (int i = 0; i < articles.size(); i++) {

            Article article = articles.get(i);

            System.out.printf("번호 : %d\n", article.getId());
            System.out.printf("제목 : %s\n", article.getTitle());
            System.out.printf("등록일 : %s\n", article.getRegDate());
            System.out.println("==================");
        }
    }

    public void printArticleDetail(Article article, Member member, ArrayList<Reply> replies, int likeCount, Like like) {
        System.out.println("===================");
        System.out.printf("번호 : %d\n", article.getId());
        System.out.printf("제목 : %s\n", article.getTitle());
        System.out.printf("내용 : %s\n", article.getContent());
        System.out.printf("작성자 : %s\n", member.getNickname());
        if(like == null) {
            System.out.printf("좋아요 : ♡ %d\n", likeCount);
        } else {
            System.out.printf("좋아요 : ♥ %d\n", likeCount);
        }
        System.out.printf("조회수 : %d\n", article.getHit());
        System.out.printf("등록일 : %s\n", article.getRegDate());
        System.out.println("===================");
        if (replies.size() > 0) {
            printReplies(replies);
        }
    }

    public void printReplies(ArrayList<Reply> replies) {
        System.out.println("======= 댓글 ======");
        for(Reply reply : replies) {
            System.out.printf("댓글 내용 : %s\n", reply.getBody());
            System.out.printf("댓글 작성일 : %s\n", reply.getRegDate());
            System.out.println("================");
        }
    }
}
