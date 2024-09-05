package proj1;

import java.util.ArrayList;
import java.util.Scanner;

public class TextBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lastPost = 0;  // 가장 최신의 number값. number값의 고유성을 유지하기 위해 1씩 증가시킬 계획임.

        lastPost++;
        Post p1 = new Post(lastPost, "안녕하세요 반갑습니다. java 공부중이에요.", "java 너무 재밌어요!!");
        lastPost++;
        Post p2 = new Post(lastPost, "java 질문좀 할게요~", "");
        lastPost++;
        Post p3 = new Post(lastPost, "license 따야되나요?", "");

        ArrayList<Post> posts = new ArrayList<>() {{
            add(p1);
            add(p2);
            add(p3);
        }};

        ArrayList<Member> members = new ArrayList<>();

        while(true) {
            String user = "";
            System.out.print("명령어를 입력해주세요" + user + " : ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String contents = sc.nextLine();

                // 1부터 1씩 증가 -> 고유값 유지하는데 편리
                lastPost++;
                Post p = new Post(lastPost, title, contents);

//                Post p = new Post();

//                 // 마지막 객체 구하기
//                int number;
//                if (posts.size() == 0) {
//                    number = 1;
//                } else {
//                    number = posts.get(posts.size() - 1).getNumber() + 1;
//                }

//                p.setNumber(lastPost);
//                p.setTitle(title);
//                p.setContents(contents);

                posts.add(p);

                System.out.println("게시물이 등록되었습니다.");

            } else if (command.equals("list")) {

//                for (int i = 0; i < posts.size(); i++) {
//                    System.out.println("==================");
//                    System.out.println("번호 : " + posts.get(i).getNumber());
//                    System.out.println("제목 : " + posts.get(i).getTitle());
//                    // System.out.println("내용 : " + posts.get(i).getContents());
//                }

                // for문 변형
                for(Post post : posts) {
                    System.out.println("==================");
                    System.out.println("번호 : " + post.getNumber());
                    System.out.println("제목 : " + post.getTitle());
                }

                System.out.println("==================");

            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int num = Integer.parseInt(sc.nextLine());

                boolean exist = false;

                for(Post post : posts) {
                    if (num == post.getNumber()) {
                        System.out.print("제목 : ");
                        String title = sc.nextLine();
                        System.out.print("내용 : ");
                        String contents = sc.nextLine();

                        post.setTitle(title);  // new로 새로 만들어도 되지만 수정하는 방법도 있다.
                        post.setContents(contents);

                        System.out.printf("%d번 게시물이 수정되었습니다.\n", num);

                        exist = true;

                        break;
                    }
                }

                if (!exist) {
                    System.out.println("없는 게시물 번호입니다.");
                }

//                int index = 0;

//                for (int i = 0; i < posts.size(); i++) {
//                    if (num == posts.get(i).getNumber()) {
//                        exist = true;
//                        index = i;
//                        break;
//                    }
//                }
//
//                if (!exist) {
//                    System.out.println("없는 게시물 번호입니다.");
//                } else {
//                    System.out.print("제목 : ");
//                    String title = sc.nextLine();
//                    System.out.print("내용 : ");
//                    String contents = sc.nextLine();
//
//                    Post p = posts.get(index);  // new로 새로 만들어도 되지만 수정하는 방법도 있다.
//                    p.setTitle(title);
//                    p.setContents(contents);
//
//                    System.out.printf("%d번 게시물이 수정되었습니다.\n", num);
//                }

            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int num = Integer.parseInt(sc.nextLine());

                boolean exist = false;

                for (Post post : posts) {
                    if (num == post.getNumber()) {
                        posts.remove(post);  // // index가 아닌 값을 직접 넣어서 해당 값을 삭제할 수도 있다.
                        System.out.printf("%d번 게시물이 삭제되었습니다.\n", num);

                        exist = true;

                        break;
                    }
                }

                if (!exist) {
                    System.out.println("없는 게시물 번호입니다.");
                }

            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int num = Integer.parseInt(sc.nextLine());

                boolean exist = false;

                for (Post post : posts) {
                    if (num == post.getNumber()) {

                        post.setView(post.getView() + 1);

                        System.out.printf("===== %d번 게시물 =====\n", post.getNumber());
                        System.out.println("번호 : " + post.getNumber());
                        System.out.println("제목 : " + post.getTitle());
                        System.out.println("내용 : " + post.getContents());
                        System.out.println("등록날짜 : " + post.getDate());
                        System.out.println("조회수 : " + post.getView());
                        System.out.println("==================");

                        if (post.getComments().size() > 0) {
                            System.out.println("======= 댓글 =======");
                            for (Comment comment : post.getComments()) {
                                System.out.println("댓글 내용 : " + comment.getContents());
                                System.out.println("댓글 작성일 : " + comment.getDate());
                                System.out.println("==================");
                            }
                        }

                        while (true) {
                            System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
                            int detailNum = Integer.parseInt(sc.nextLine());
                            if (detailNum == 1) {
                                System.out.print("댓글 내용 : ");
                                String comment = sc.nextLine();

                                Comment c = new Comment(comment);
                                post.setComments(c);

                                System.out.println("댓글이 성공적으로 등록되었습니다");

                                System.out.printf("===== %d번 게시물 =====\n", post.getNumber());
                                System.out.println("번호 : " + post.getNumber());
                                System.out.println("제목 : " + post.getTitle());
                                System.out.println("내용 : " + post.getContents());
                                System.out.println("등록날짜 : " + post.getDate());
                                System.out.println("조회수 : " + post.getView());
                                System.out.println("==================");

                                System.out.println("======= 댓글 =======");
                                for (int i = 0; i < post.getComments().size(); i++) {
                                    System.out.println("댓글 내용 : " + post.getComments().get(i).getContents());
                                    System.out.println("댓글 작성일 : " + post.getComments().get(i).getDate());
                                    System.out.println("==================");
                                }
                            } else if (detailNum == 2) {
                                System.out.println("[추천 기능]");
                            } else if (detailNum == 3) {
                                System.out.println("[수정 기능]");
                            } else if (detailNum == 4) {
                                System.out.println("[삭제 기능]");
                            } else if (detailNum == 5) {
                                System.out.println("상세보기 화면을 빠져나갑니다.");
                                break;
                            }
                        }

                        exist = true;

                        break;
                    }
                }

                if (!exist) {
                    System.out.println("존재하지 않는 게시물 번호입니다.");
                }

            } else if (command.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String str = sc.nextLine();

                boolean exist = false;

                for (Post post : posts) {
                    if (post.getTitle().contains(str)) {
                        System.out.println("==================");
                        System.out.println("번호 : " + post.getNumber());
                        System.out.println("제목 : " + post.getTitle());

                        exist = true;
                    }
                }

                if (!exist) {
                    System.out.println("==================");
                    System.out.println("검색 결과가 없습니다.");
                }

                System.out.println("==================");

            } else if (command.equals("signup")) {
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

                continue;

            } else if (command.equals("login")) {
                System.out.print("아이디 : ");
                String id = sc.nextLine();
                System.out.print("비밀번호 : ");
                String pw = sc.nextLine();

                boolean exist = false;

                for (Member member : members) {
                    if (id.equals(member.id) && (pw.equals(member.pw))) {
                        System.out.println(member.name + "님 환영합니다!");
                        user = "[" + member.id + "(" + member.name + ")" + "]";

                        exist = true;
                        break;
                    }
                }

                if (!exist) {
                    System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
                }
            }
        }
    }
}

// 논리연산자
// 조건1 || 조건2 -> 조건1 조건2 둘 중 하나만 만족해도 실행
// 조건1 && 조건2 -> 조건1 조건2가 동시에 만족(모두 만족)해야만 실행