package TextBoard.post;

import TextBoard.BoardApp;
import TextBoard.CommonContainer;
import TextBoard.like.Like;
import TextBoard.like.LikeController;
import TextBoard.like.LikeRepository;
import TextBoard.member.Member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class PostController {

    private Scanner sc = new Scanner(System.in);

    private CommonContainer commonContainer = BoardApp.getCommonRepository();

    private static PostRepository postRepository = new PostRepository();
    private static PostView postView = new PostView();

    private LikeRepository likeRepository = LikeController.getLikeRepository();

    private CommentRepository commentRepository = new CommentRepository();

    private int lastPost = 0;  // 가장 최신의 number값. number값의 고유성을 유지하기 위해 1씩 증가시킬 계획임.

    // 값의 초기화는 대부분 생성자에서 해주는 것을 권장합니다. 다양한 로직 수행 가능합니다.
    public PostController() {

//        // Json 파일에서 ArrayList를 읽어오기
//        // Jackson ObjectMapper 생성
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            // JSON 파일을 ArrayList로 변환
//            ArrayList<Post> posts = mapper.readValue(new File("src/main/java/TextBoard/json/posts.json"), new TypeReference<ArrayList<Post>>() {
//            });
//
//            // 레포지토리에 저장
//            for (Post post : posts) {
//                postRepository.save(post);
//            }
//
//            System.out.println("post JSON 파일을 ArrayList로 읽어왔습니다.");
//
//        } catch (FileNotFoundException e) {
//            for (int i = 0; i < 100; i++) {
//                int iValue = (int) (Math.random() * 100);
//                int iValue2 = (int) (Math.random() * 100);
//                Post p = new Post(i + 1, "안녕하세요 반갑습니다. java 공부중이에요." + i, "java 너무 재밌어요!!" + i, getnowDate(), iValue, "kd", "kildong", iValue2);
//
//                postRepository.save(p);
//            }
//            lastPost = 100;
//
//            commonContainer.saveToJson("src/main/java/TextBoard/json/posts.json", postRepository.getPosts());
//
//            System.out.println("Post 임시 데이터를 만들었습니다.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            // JSON 파일을 ArrayList로 변환
//            ArrayList<Comment> comments = mapper.readValue(new File("src/main/java/TextBoard/json/comments.json"), new TypeReference<ArrayList<Comment>>() {
//            });
//
//            // 레포지토리에 저장
//            for (Comment comment : comments) {
//                commentRepository.save(comment);
//            }
//
//            System.out.println("comment JSON 파일을 ArrayList로 읽어왔습니다.");
//
//        } catch (FileNotFoundException e) {
//
//            for (int i = 0; i < 10; i++) {
//                int iValue = (int) (Math.random() * 3) + 1;
//                Comment c = new Comment("안녕하세요 반갑습니다. 댓글이예요" + i, getnowDate(), "kd", iValue);
//
//                commentRepository.save(c);
//            }
//
//            commonContainer.saveToJson("src/main/java/TextBoard/json/comments.json", commentRepository.getComments());
//
//            System.out.println("Comment 임시 데이터를 만들었습니다.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        // txt 파일에서 ArrayList를 읽어오기
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("posts.txt"));
//            postRepository.setPosts((ArrayList<Post>)ois.readObject());  // 파일에서 ArrayList읽기
//            ois.close();
//            System.out.println("Post 정보를 파일에서 읽었습니다.");
//        } catch (FileNotFoundException e) {
//            for (int i = 0; i < 100; i++) {
//                int iValue = (int)(Math.random() * 100);
//                int iValue2 = (int)(Math.random() * 100);
//                Post p1 = new Post(i + 1, "안녕하세요 반갑습니다. java 공부중이에요." + i,"java 너무 재밌어요!!" + i, getnowDate(), iValue, "kd", "kildong", iValue2);
//
//                postRepository.save(p1);
//            }
//            lastPost = 100;
//            System.out.println("Post 임시 데이터 읽었습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Post load fail");
//        }
    }

    // command : add
    public void add() {

        boolean checkLogin = commonContainer.getCheckLogin();

        if (!checkLogin) {
            System.out.println("로그인을 해주세요");
            //  continue;  반복문 안에서 사용하던 continue는 메서드로 변경하면 return으로 변경
            return;
        }

        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String contents = sc.nextLine();

        // 1부터 1씩 증가 -> 고유값 유지하는데 편리
        lastPost++;
        Member user = commonContainer.getUser();
        Post p = new Post(lastPost, title, contents, getnowDate(), 0, user.getId(), user.getName(), 0);

//        Post p = new Post();
//
//         // 마지막 객체 구하기
//        int number;
//        if (posts.size() == 0) {
//            number = 1;
//        } else {
//            number = posts.get(posts.size() - 1).getNumber() + 1;
//        }
//
//        p.setNumber(lastPost);
//        p.setTitle(title);
//        p.setContents(contents);

        postRepository.save(p);
        commonContainer.saveToJson("src/main/java/TextBoard/json/posts.json", postRepository.getPosts());
        System.out.println("게시물이 등록되었습니다.");

    }

    // command : list
    public void list() {
        // 가장 상단에 정의할 수도 있지만, 그럴 경우 ArrayList에 변경사항이 있는 경우 새로고침이 되지 않으므로 사용할 때 불러와서 사용하는 것이 좋다.
        ArrayList<Post> posts = postRepository.getPosts();
        int realMaxPaging = getMaxPage(posts.size());
        postView.printPostList(posts, commonContainer.getNowPage(), realMaxPaging);
    }

    // command : update
    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int num = checkNum(sc.nextLine());

//            int num;
//            try {
//                System.out.print("수정할 게시물 번호 : ");
//                num = Integer.parseInt(sc.nextLine());
//
//            } catch (NumberFormatException e) {
//                System.out.println("숫자를 입력해주세요.");
//                continue;
//            }

        Post post = postRepository.findPostByNumber(num);

        boolean checkPost = checkPost(post);

        if (!checkPost) {
            return;
        }

        String userId = commonContainer.getUser().getId();
        if (userId.equals(post.getUserId())) {
            System.out.print("제목 : ");
            String title = sc.nextLine();
            System.out.print("내용 : ");
            String contents = sc.nextLine();

            post.setTitle(title);  // new로 새로 만들어도 되지만 수정하는 방법도 있다.
            post.setContents(contents);
            commonContainer.saveToJson("src/main/java/TextBoard/json/posts.json", postRepository.getPosts());

            System.out.printf("%d번 게시물이 수정되었습니다.\n", num);

            return;
        }

        System.out.println("자신의 게시물만 수정/삭제 할 수 있습니다.");

//        메서드로 해당 객체를 리턴 받아서 작업
//        Post post = findPostByNumber(num);
//
//        if (post != null) {
//            System.out.print("제목 : ");
//            String title = sc.nextLine();
//            System.out.print("내용 : ");
//            String contents = sc.nextLine();
//
//            post.setTitle(title);  // new로 새로 만들어도 되지만 수정하는 방법도 있다.
//            post.setContents(contents);
//
//            System.out.printf("%d번 게시물이 수정되었습니다.\n", num);
//
//            break;
//
//        } else {
//            System.out.println("없는 게시물 번호입니다.");
//        }
//
//
//        해당 객체의 인덱스를 구한 후 작업
//        int index = 0;
//
//        for (int i = 0; i < posts.size(); i++) {
//            if (num == posts.get(i).getNumber()) {
//                exist = true;
//                index = i;
//                break;
//            }
//        }
//
//        if (!exist) {
//            System.out.println("없는 게시물 번호입니다.");
//        } else {
//            System.out.print("제목 : ");
//            String title = sc.nextLine();
//            System.out.print("내용 : ");
//            String contents = sc.nextLine();
//
//            Post p = posts.get(index);  // new로 새로 만들어도 되지만 수정하는 방법도 있다.
//            p.setTitle(title);
//            p.setContents(contents);
//
//            System.out.printf("%d번 게시물이 수정되었습니다.\n", num);
//        }
    }

    // command : delete
    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int num = checkNum(sc.nextLine());

        Post post = postRepository.findPostByNumber(num);

        boolean checkPost = checkPost(post);

        if (!checkPost) {
            return;
        }

        String userId = commonContainer.getUser().getId();
        if (userId.equals(post.getUserId())) {
            postRepository.delete(post);  // index가 아닌 값을 직접 넣어서 해당 값을 삭제할 수도 있다.
            commonContainer.saveToJson("src/main/java/TextBoard/json/posts.json", postRepository.getPosts());
            System.out.printf("%d번 게시물이 삭제되었습니다.\n", num);

            return;
        }

        System.out.println("자신의 게시물만 수정/삭제 할 수 있습니다.");
    }

    // command : detail
    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int num = checkNum(sc.nextLine());

        Post post = postRepository.findPostByNumber(num);  // 창고에서 꺼내서

        boolean checkPost = checkPost(post);

        // ==== 요리를 한다음
        if (!checkPost) {
            return;
        }

//        post.setView(post.getView() + 1);
        post.increaseView();
        // ======

        String userId = commonContainer.getUser().getId();
        Like finedLike = likeRepository.findLikeById(post, userId);
        ArrayList<Comment> comments = commentRepository.getCommentsbyPostNumber(post.getNumber());
        postView.printPost(post, finedLike, comments);  // 서빙한테 넘겨줌

        while (true) {
            System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
            int detailNum = checkNum(sc.nextLine());

            if (detailNum == 1) {
                System.out.print("댓글 내용 : ");
                String comment = sc.nextLine();

                Comment c = new Comment(comment, getnowDate(), userId, post.getNumber());
                commentRepository = getCommentRepository();
                commentRepository.save(c);
                commonContainer.saveToJson("src/main/java/TextBoard/json/comments.json", commentRepository.getComments());

                System.out.println("댓글이 성공적으로 등록되었습니다");

                //finedLike = likeRepository.findLikeById(post, userId);
                comments = commentRepository.getCommentsbyPostNumber(post.getNumber());
                postView.printPost(post, finedLike, comments);

            } else if (detailNum == 2) {

                boolean checkLogin = commonContainer.getCheckLogin();

                if (!checkLogin) {
                    System.out.println("로그인을 해주세요");
                    continue;
                }

                // post 객체 안에 likes가 들어있는 경우
                // Like like = findLikeById(post);
                //finedLike = likeRepository.findLikeById(post, userId);

                if (finedLike == null) {

                    Like l = new Like(post.getNumber(), userId, getnowDate());
                    // post 객체 안에 likes가 들어있는 경우
                    // post.setLike(l);
                    likeRepository.save(l);
                    commonContainer.saveToJson("src/main/java/TextBoard/json/likes.json", likeRepository.getLikes());

                    post.setLikeLength(post.getLikeLength() + 1);
                    commonContainer.saveToJson("src/main/java/TextBoard/json/posts.json", postRepository.getPosts());

                    System.out.println("해당 게시물을 좋아합니다.");

                    comments = commentRepository.getCommentsbyPostNumber(post.getNumber());
                    postView.printPost(post, l, comments);

                    continue;
                }

                // post 객체 안에 likes가 들어있는 경우
                // post.getLike().remove(like);
                likeRepository.delete(finedLike);
                commonContainer.saveToJson("src/main/java/TextBoard/json/likes.json", likeRepository.getLikes());

                post.setLikeLength(post.getLikeLength() - 1);
                commonContainer.saveToJson("src/main/java/TextBoard/json/posts.json", postRepository.getPosts());

                System.out.println("해당 게시물의 좋아요를 해제합니다.");

                comments = commentRepository.getCommentsbyPostNumber(post.getNumber());
                postView.printPost(post, null, comments);

            } else if (detailNum == 3) {

                // finedLike = likeRepository.findLikeById(post, userId);
                if (userId.equals(post.getUserId())) {

                    System.out.print("제목 : ");
                    String title = sc.nextLine();
                    System.out.print("내용 : ");
                    String contents = sc.nextLine();

                    post.setTitle(title);
                    post.setContents(contents);
                    commonContainer.saveToJson("src/main/java/TextBoard/json/posts.json", postRepository.getPosts());

                    comments = commentRepository.getCommentsbyPostNumber(post.getNumber());
                    postView.printPost(post, finedLike, comments);

                    continue;
                }

                System.out.println("자신의 게시물만 수정/삭제 할 수 있습니다.");

            } else if (detailNum == 4) {

                String userName = commonContainer.getUser().getName();

                if (userId.equals(post.getUserId())) {
                    System.out.print("정말 게시물을 삭제하시겠습니까? (y/n) : ");
                    String delete = sc.nextLine();

                    if (delete.equals("y")) {
                        ArrayList<Post> posts = postRepository.getPosts();
                        postRepository.delete(post);
                        commonContainer.saveToJson("src/main/java/TextBoard/json/posts.json", postRepository.getPosts());
                        System.out.println(userName + "님의 " + post.getNumber() + "번 게시물을 삭제했습니다.");

                        postView.printPostList(posts, commonContainer.getNowPage(), getMaxPage(posts.size()));
                    }
                    break;
                }

                System.out.println("자신의 게시물만 수정/삭제 할 수 있습니다.");

            } else if (detailNum == 5) {
                System.out.println("상세보기 화면을 빠져나갑니다.");
                break;
            }

        }
    }

    // command : search
    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = sc.nextLine();

        ArrayList<Post> FilterPosts = postRepository.getFilterPosts(keyword);

        if (FilterPosts.size() > 0) {
            commonContainer.setNowPage(1);
            postView.printPostList(FilterPosts, commonContainer.getNowPage(), getMaxPage(FilterPosts.size()));
            return;
        }

        System.out.println("==================");
        System.out.println("검색 결과가 없습니다.");
        System.out.println("==================");
    }

    // command : sort
    public void sort() {
        System.out.print("정렬 대상을 선택해주세요. (1. 번호, 2. 조회수) : ");
        int object = checkNum(sc.nextLine());

        while (true) {
            System.out.print("정렬 방법을 선택해주세요. (1. 오름차순, 2. 내림차순) : ");
            int way = checkNum(sc.nextLine());

            ArrayList<Post> posts = postRepository.getPosts();
            commonContainer.setNowPage(1);

            if (object == 1) {
                if (way == 1) {
                    Collections.sort(posts, new PostComparatorByNumber());
                    postView.printPostList(posts, commonContainer.getNowPage(), getMaxPage(posts.size()));
                    break;

                } else if (way == 2) {
                    Collections.sort(posts, new PostComparatorByNumber().reversed());
                    postView.printPostList(posts, commonContainer.getNowPage(), getMaxPage(posts.size()));
                    break;
                }

            } else if (object == 2) {
                if (way == 1) {
                    Collections.sort(posts, new PostComparatorByView());
                    postView.printPostList(posts, commonContainer.getNowPage(), getMaxPage(posts.size()));
                    break;

                } else if (way == 2) {
                    Collections.sort(posts, new PostComparatorByView().reversed());
                    postView.printPostList(posts, commonContainer.getNowPage(), getMaxPage(posts.size()));
                    break;
                }
            }
        }
    }

    // command : page
    public void page() {
        list();

        while (true) {
            System.out.print("페이징 명령어를 입력해주세요 (1. 이전, 2. 다음, 3. 선택, 4. 뒤로가기) : ");
            int pageCom = checkNum(sc.nextLine());

            if (pageCom == 1) {
                if (commonContainer.getNowPage() == 1) {
                    System.out.println("이전 페이지가 없습니다.");
                    continue;
                }
                commonContainer.setNowPage(commonContainer.getNowPage() - 1);
                list();

            } else if (pageCom == 2) {
                int postSize = postRepository.getPosts().size();

                if (commonContainer.getNowPage() == getMaxPage(postSize)) {
                    System.out.println("다음 페이지가 없습니다.");
                    continue;
                }

                commonContainer.setNowPage(commonContainer.getNowPage() + 1);
                list();
            } else if (pageCom == 3) {
                System.out.print("이동하실 페이지 번호를 입력해주세요 : ");
                int movePage = checkNum(sc.nextLine());

                int postSize = postRepository.getPosts().size();

                if (movePage > getMaxPage(postSize)) {
                    System.out.println("선택한 페이지가 없습니다.");
                    continue;
                }
                commonContainer.setNowPage(movePage);
                list();

            } else if (pageCom == 4) {
                break;
            }
        }
    }

    public boolean checkPost(Post post) {
        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
            return false;
        }
        return true;
    }

    public String getnowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return sdf.format(ts.getTime());
    }

    public int getMaxPage(int postSize) {
        int maxPage;
        if (postSize % 3 == 0) {
            maxPage = postSize / 3;
        } else {
            maxPage = postSize / 3 + 1;
        }
        return maxPage;
    }

    public PostRepository getPostRepository() {
        return postRepository;
    }

    public int checkNum(String target) {
        int defaultValue = -1;  // index는 -1이 없으므로 없는 값을 지정할 때 -1로 사용을 많이 함
        // try - catch를 최대한 사용 안하는게 좋다. 순서대로 실행되는것이 아니라 되돌아가서 실행되기 때문에 가독성이 좋지 않음
        // 몇가지 상황을 제외하고는 try - catch 사용 안하고 if로 처리 다 가능함.
        try {
            int parseInt = Integer.parseInt(target);
            return parseInt;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        }
        return defaultValue;

//        int num;
//        while(true) {
//            try {
//                System.out.print(request);
//                num = Integer.parseInt(sc.nextLine());
//                return num;
//            } catch (NumberFormatException e) {
//                System.out.println("숫자를 입력해주세요.");
//            }
//        }
    }

    public void setComments(Comment comment) {
        commentRepository.save(comment);
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
