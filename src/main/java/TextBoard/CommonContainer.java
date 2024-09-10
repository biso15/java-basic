package TextBoard;

import TextBoard.member.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CommonContainer {

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

    public <T> void saveToJson(String src, T arryList) {  // 여러 종류의 객체를 매개변수로 받는 법.(제네릭)

        // ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일로 저장
            // writerWithDefaultPrettyPrinter()를 사용하면 JSON이 읽기 쉬운 형식으로 저장됩니다.
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(src), arryList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
