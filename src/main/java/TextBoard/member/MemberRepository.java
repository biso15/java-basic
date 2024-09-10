package TextBoard.member;

import java.util.ArrayList;

public class MemberRepository {

    private ArrayList<Member> members = new ArrayList<>();

    public void save (Member member) {
        members.add(member);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public Member findMember(String id, String pw) {
        for(Member member : members) {

//            // 논리연산자
//            // 조건1 || 조건2 -> 조건1 조건2 둘 중 하나만 만족해도 실행
//            // 조건1 && 조건2 -> 조건1 조건2가 동시에 만족(모두 만족)해야만 실행
            if (id.equals(member.getId()) && pw.equals(member.getPw())) {
                return member;
            }
        }
        return null;
    }
}
