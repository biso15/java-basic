package TextBoard.member;

import TextBoard.BoardApp;
import TextBoard.CommonContainer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {

    private CommonContainer commonContainer = BoardApp.getCommonRepository();

    private static MemberRepository memberRepository = new MemberRepository();

    private Scanner sc = new Scanner(System.in);

    public MemberController() {

        // Json 파일에서 ArrayList를 읽어오기
        // Jackson ObjectMapper 생성
        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON 파일을 ArrayList로 변환
            ArrayList<Member> members = mapper.readValue(new File("src/main/java/TextBoard/json/members.json"), new TypeReference<ArrayList<Member>>() {});

            // 레포지토리에 저장
            for (Member member : members) {
                memberRepository.save(member);
            }

            System.out.println("member JSON 파일을 ArrayList로 읽어왔습니다.");

        } catch (FileNotFoundException e) {
            Member m1 = new Member("kd", "kd", "kildong");
            Member m2 = new Member("ks", "ks", "kilsoon");

            memberRepository.save(m1);
            memberRepository.save(m2);

            commonContainer.saveToJson("src/main/java/TextBoard/json/members.json", memberRepository.getMembers());

            System.out.println("Member 임시 데이터를 만들었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // command : signup
    public void signup() {
        boolean checkLogin = commonContainer.getCheckLogin();

        if (checkLogin) {
            System.out.println("로그아웃을 해주세요");
            return;
        }

        System.out.println("==== 회원 가입을 진행합니다 ====");
        System.out.print("아이디를 입력해주세요 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력해주세요 : ");
        String pw = sc.nextLine();
        System.out.print("닉네임을 입력해주세요 : ");
        String name = sc.nextLine();

        Member u = new Member(id, pw, name);
        memberRepository.save(u);
        commonContainer.saveToJson("src/main/java/TextBoard/json/members.json", memberRepository.getMembers());

        System.out.println("==== 회원 가입이 완료되었습니다. ====");
    }

    // command : login
    public void login() {
        boolean checkLogin = commonContainer.getCheckLogin();

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

        commonContainer.setMemberInfo(member);
        commonContainer.setUser(member);
        commonContainer.setCheckLogin(true);

        System.out.println(member.getName() + "님 환영합니다!");
    }

    // command : logout
    public void logout() {

        boolean checkLogin = commonContainer.getCheckLogin();

        if (!checkLogin) {
            System.out.println("로그인을 해주세요");
            return;
        }

        System.out.print("로그아웃을 하시겠습니까? (y/n) : ");
        String logout = sc.nextLine();

        if (logout.equals("y")) {

            commonContainer.setMemberInfo(null);
            commonContainer.setUser(new Member("", "", ""));
            commonContainer.setCheckLogin(false);

            System.out.println("로그아웃이 완료되었습니다.");
        }
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
