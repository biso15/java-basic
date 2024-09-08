package TextBoard.member;

import TextBoard.BoardApp;
import TextBoard.CommonRepository;

import java.util.Scanner;

public class MemberController {

    private CommonRepository commonRepository = BoardApp.getCommonRepository();

    private static MemberRepository memberRepository = new MemberRepository();

    private Scanner sc = new Scanner(System.in);

    public MemberController() {

        Member m1 = new Member("kd", "kd", "kildong");
        Member m2 = new Member("ks", "ks", "kilsoon");

        memberRepository.save(m1);
        memberRepository.save(m2);
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
        memberRepository.save(u);

        System.out.println("==== 회원 가입이 완료되었습니다. ====");
    }

    // command : login
    public void login() {
        boolean checkLogin = commonRepository.getCheckLogin();

        if (checkLogin) {
            System.out.println("로그아웃을 해주세요");
            return;
        }

        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String pw = sc.nextLine();

        Member member = memberRepository.findMember(id, pw);

        if (member == null) {
            System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
            return;
        }

        commonRepository.setMemberInfo(member);
        commonRepository.setUser(member);
        commonRepository.setCheckLogin(true);

        System.out.println(member.getName() + "님 환영합니다!");
    }

    // command : logout
    public void logout() {

        boolean checkLogin = commonRepository.getCheckLogin();

        if (!checkLogin) {
            System.out.println("로그인을 해주세요");
            return;
        }

        System.out.print("로그아웃을 하시겠습니까? (y/n) : ");
        String logout = sc.nextLine();

        if (logout.equals("y")) {

            commonRepository.setMemberInfo(null);
            commonRepository.setUser(new Member("", "", ""));
            commonRepository.setCheckLogin(false);

            System.out.println("로그아웃이 완료되었습니다.");
        }
    }

}
