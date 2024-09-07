package TextBoard.member;

import java.util.ArrayList;

public class MemberRepository {

    private ArrayList<Member> members = new ArrayList<>();

    public void save (Member member) {
        members.add(member);
    }


    public boolean checkLogin(Member member) {

        if (member.getId().equals("")) {
            return false;
        }
        return true;
    }
}
