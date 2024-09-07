package TextBoard.member;

public class MemberController {

    private MemberRepository memberRepository = new MemberRepository();

    public MemberController() {

        Member m1 = new Member("kd", "kd", "kildong");
        Member m2 = new Member("ks", "ks", "kilsoon");

        memberRepository.save(m1);
        memberRepository.save(m2);
    }

}
