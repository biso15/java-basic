package TextBoardAnswer.model;

import java.util.ArrayList;

import TextBoardAnswer.util.Util;

// Dao
// Repository
public class ArticleRepository {

    ArrayList<Article> articles = new ArrayList<>();

    int lastArticleId = 1;

    public ArticleRepository() {

        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "냉무", 1, Util.getCurrentDate());
        a1.setHit(10);
        Article a2 = new Article(2, "자바 질문좀 할게요~.", "냉무", 2, Util.getCurrentDate());
        a2.setHit(102);
        Article a3 = new Article(3, "정처기 따야되나요?", "냉무", 1, Util.getCurrentDate());
        a3.setHit(55);

        articles.add(a2);
        articles.add(a3);
        articles.add(a1);

        lastArticleId = 4;
    }

    public Article findById(int id) {

        Article target = null;

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }

        return target;

    }

    public ArrayList<Article> findByTitle (String keyword) {

        ArrayList<Article> searchedArticles = new ArrayList<>();

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            String title = article.getTitle();

            if (title.contains(keyword)) {
                searchedArticles.add(article);
            }
        }
        return searchedArticles;
    }

    public void insert(String title, String content, int memberId) {
        Article article = new Article(lastArticleId, title, content, memberId, Util.getCurrentDate());
    }

    public void update(int articleId, String title, String content) {
        Article article = findById(articleId);
        article.setTitle(title);
        article.setContent(content);
    };

    public void delete(Article article) {
        //articles.remove(i); // 위치 기반으로 삭제
        articles.remove(article);  // 값 기반 삭제
    }

    public ArrayList<Article> findAllArticles() {
        return articles;
    }
}
