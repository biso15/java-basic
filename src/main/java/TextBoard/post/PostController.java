package TextBoard;

import TextBoard.like.Like;
import TextBoard.post.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class PostController {

    private Scanner sc = new Scanner(System.in);

    private PostRepository postRepository = new PostRepository();
    private PostView postView = new PostView();

    private int lastPost = 0;  // 가장 최신의 number값. number값의 고유성을 유지하기 위해 1씩 증가시킬 계획임.

    private ArrayList<Member> members = new ArrayList<>();

    private ArrayList<Like> likes = new ArrayList<>();

    private Member member = new Member("","","");
    private String memberInfo = "";

    private int nowPage = 1;

    // 값의 초기화는 대부분 생성자에서 해주는 것을 권장합니다. 다양한 로직 수행 가능합니다.
    public PostController () {

        for (int i = 0; i < 100; i++) {
            int iValue = (int)(Math.random() * 100);
            Post p1 = new Post(i + 1, "안녕하세요 반갑습니다. java 공부중이에요." + i,"java 너무 재밌어요!!" + i, getnowDate(), iValue, "kildong" + i);

            postRepository.save(p1);
        }

        Member m1 = new Member("kd", "kd", "kildong");
        Member m2 = new Member("ks", "ks", "kilsoon");

        members.add(m1);
        members.add(m2);

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

    // command : page
    public void page() {
        ArrayList<Post> posts = postRepository.getPosts();
        postView.printPostList(posts, nowPage);

        while(true) {

            System.out.print("페이징 명령어를 입력해주세요 (1. 이전, 2. 다음, 3. 선택, 4. 뒤로가기) : ");
            int pageCom = Integer.parseInt(sc.nextLine());

            if (pageCom == 1) {
                if (nowPage == 1) {
                    System.out.println("이전 페이지가 없습니다.");
                    continue;
                }
                nowPage--;

                posts = postRepository.getPosts();
                postView.printPostList(posts, nowPage);

            } else if (pageCom == 2) {
                if (nowPage == 5) {
                    System.out.println("다음 페이지가 없습니다.");
                    continue;
                }

                nowPage++;

                posts = postRepository.getPosts();
                postView.printPostList(posts, nowPage);

            }

        }
    }

    // command : list
    public void list() {
        // 가장 상단에 정의할 수도 있지만, 그럴 경우 ArrayList에 변경사항이 있는 경우 새로고침이 되지 않으므로 사용할 때 불러와서 사용하는 것이 좋다.
        ArrayList<Post> posts = postRepository.getPosts();
        postView.printPostList(posts, nowPage);
    }

    // command : sort
    public void sort() {
        System.out.print("정렬 대상을 선택해주세요. (1. 번호, 2. 조회수) : ");
        int object = Integer.parseInt(sc.nextLine());
        System.out.print("정렬 방법을 선택해주세요. (1. 오름차순, 2. 내림차순) : ");
        int way = Integer.parseInt(sc.nextLine());

        ArrayList<Post> posts = postRepository.getPosts();

        if (object == 1) {
            if (way == 1) {
                Collections.sort(posts, new PostComparatorByNumber());
                postView.printPostList(posts, nowPage);

            } else if (way == 2) {
                Collections.sort(posts, new PostComparatorByNumber().reversed());
                postView.printPostList(posts, nowPage);
            }

        } else if (object == 2) {
            if (way == 1) {
                Collections.sort(posts, new PostComparatorByView());
                postView.printPostList(posts, nowPage);

            } else if (way == 2) {
                Collections.sort(posts, new PostComparatorByView().reversed());
                postView.printPostList(posts, nowPage);
            }
        }
    }

    // command : logout
    public void logout() {

        boolean checkLogin = checkLogin();

        if (!checkLogin) {
            System.out.println("로그인을 해주세요");
            return;
        }

        System.out.print("로그아웃을 하시겠습니까? (y/n) : ");
        String logout = sc.nextLine();

        if (logout.equals("y")) {

            member.setId("");
            member.setPw("");
            member.setName("");
            memberInfo = "";

            System.out.println("로그아웃이 완료되었습니다.");
        }
    }

    // command : login
    public void login() {
        boolean checkLogin = checkLogin();

        if (checkLogin) {
            System.out.println("로그아웃을 해주세요");
            return;
        }

        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String pw = sc.nextLine();

        member = findMember(id, pw);

        if (member == null) {
            System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
            return;
        }

        memberInfo = getMemberInfo(member.id, member.name);

        System.out.println(member.name + "님 환영합니다!");
    }

    // command : signup
    public void signup() {
        System.out.println("==== 회원 가입을 진행합니다 ====");
        System.out.print("아이디를 입력해주세요 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력해주세요 : ");
        String pw = sc.nextLine();
        System.out.print("닉네임을 입력해주세요 : ");
        String name = sc.nextLine();

        Member u = new Member(id, pw, name);
        members.add(u);

        System.out.println("==== 회원 가입이 완료되었습니다. ====");
    }

    // command : search
    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = sc.nextLine();

        ArrayList<Post> FilterPosts = postRepository.getFilterPosts(keyword);

        if (FilterPosts.size() > 0) {
            postView.printPostList(FilterPosts, nowPage);
            return;
        }

        System.out.println("==================");
        System.out.println("검색 결과가 없습니다.");
        System.out.println("==================");
    }

    // command : detail
    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int num = Integer.parseInt(sc.nextLine());

        Post post = postRepository.findPostByNumber(num);  // 창고에서 꺼내서

        boolean checkPost = checkPost(post);

        // ==== 요리를 한다음
        if (!checkPost) {
            return;
        }

//        post.setView(post.getView() + 1);
        post.increaseView();
        // ======

        postView.printPost(post);  // 서빙한테 넘겨줌

        while (true) {
            System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
            int detailNum = Integer.parseInt(sc.nextLine());

            if (detailNum == 1) {
                System.out.print("댓글 내용 : ");
                String comment = sc.nextLine();

                Comment c = new Comment(comment);
                post.setComments(c);

                System.out.println("댓글이 성공적으로 등록되었습니다");

                postView.printPost(post);

            } else if (detailNum == 2) {

                boolean checkLogin = checkLogin();

                if (!checkLogin) {
                    System.out.println("로그인을 해주세요");
                    continue;
                }

                // post 객체 안에 likes가 들어있는 경우
                // Like like = findLikeById(post);
                Like like = findLikeById(post, likes);

                if (like == null) {

                    Like l = new Like(post.getNumber(), member.getId(), getnowDate());
                    // post 객체 안에 likes가 들어있는 경우
                    // post.setLike(l);
                    likes.add(l);

                    System.out.println("해당 게시물을 좋아합니다.");
                    postView.printPost(post);

                    continue;
                }

                // post 객체 안에 likes가 들어있는 경우
                // post.getLike().remove(like);
                likes.remove(like);

                System.out.println("해당 게시물의 좋아요를 해제합니다.");
                postView.printPost(post);

            } else if (detailNum == 3) {

                if (member.getId().equals(post.getWriter())) {

                    System.out.print("제목 : ");
                    String title = sc.nextLine();
                    System.out.print("내용 : ");
                    String contents = sc.nextLine();

                    post.setTitle(title);
                    post.setContents(contents);

                    postView.printPost(post);

                    continue;
                }

                System.out.println("자신의 게시물만 수정/삭제 할 수 있습니다.");

            } else if (detailNum == 4) {
                if (member.getId().equals(post.getWriter())) {
                    System.out.print("정말 게시물을 삭제하시겠습니까? (y/n) : ");
                    String delete = sc.nextLine();

                    if (delete.equals("y")) {
                        ArrayList<Post> posts = postRepository.getPosts();
                        postRepository.delete(post);
                        System.out.println(member.getName() + "님의 " + post.getNumber() + "번 게시물을 삭제했습니다.");

                        postView.printPostList(posts, nowPage);
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

    // command : delete
    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int num = Integer.parseInt(sc.nextLine());

        Post post = postRepository.findPostByNumber(num);

        boolean checkPost = checkPost(post);

        if (!checkPost) {
            return;
        }

        postRepository.delete(post);  // index가 아닌 값을 직접 넣어서 해당 값을 삭제할 수도 있다.
        System.out.printf("%d번 게시물이 삭제되었습니다.\n", num);

    }

    // command : update
    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int num = Integer.parseInt(sc.nextLine());

        Post post = postRepository.findPostByNumber(num);

        boolean checkPost = checkPost(post);

        if (!checkPost) {
            return;
        }

        System.out.print("제목 : ");
        String title = sc.nextLine();
        System.out.print("내용 : ");
        String contents = sc.nextLine();

        post.setTitle(title);  // new로 새로 만들어도 되지만 수정하는 방법도 있다.
        post.setContents(contents);

        System.out.printf("%d번 게시물이 수정되었습니다.\n", num);

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

    // command : add
    public void add() {

        boolean checkLogin = checkLogin();

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
        lastPost = 101;
        // lastPost++;
        Post p = new Post(lastPost, title, contents, getnowDate(), 0, member.getName());

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

        System.out.println("게시물이 등록되었습니다.");

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

}
