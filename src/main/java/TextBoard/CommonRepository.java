package TextBoard;

import TextBoard.member.Member;

public class CommonRepository {

    private String memberInfo = "";
    private Member user = new Member("","","");
    private boolean checkLogin = false;

    private int nowPage = 1;

    public String getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(Member member) {
        if (member != null) {
            memberInfo = "[" + member.getId() + "(" + member.getName() + ")" + "]";
        } else {
            memberInfo = "";
        }
    }

    public Member getUser() {
        return user;
    }

    public void setUser(Member user) {
        this.user = user;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public boolean getCheckLogin() {
        return checkLogin;
    }

    public void setCheckLogin(boolean checkLogin) {
        this.checkLogin = checkLogin;
    }
}
