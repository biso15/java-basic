package TextBoard.member;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {

    private ArrayList<Member> members = new ArrayList<>();

    public MemberRepository () {
        // 파일에서 ArrayList를 읽어오기
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("members.txt"));
            setMembers((ArrayList<Member>)ois.readObject());  // 파일에서 ArrayList읽기
            ois.close();
            System.out.println("Member 정보가 파일에서 읽어졌습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Member upload fail");
        }
    }

    public void save (Member member) {
        members.add(member);

        // ArrayList를 파일로 저장
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("members.txt"));
            oos.writeObject(getMembers());  // 파일에 ArrayList 저장
            oos.close();
            System.out.println("Member 정보가 파일에 저장되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Member save fail");
        }
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
