package last.file;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    public String toJsonString(Post post) {

        // Jackson ObjectMapper 인스턴스 생성
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 1. 객체를 JSON 문자열로 변환 (직렬화)
            String jsonString = objectMapper.writeValueAsString(post);
            return jsonString;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String toJsonString(Member member) {

        // 메서드 오버로딩 => 매개변수 모양만 다르면 동일한 이름의 메서드 여러개 만들기 가능
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writeValueAsString(member);
            return jsonString;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Post toPost(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일을 Java 객체로 변환
            Post post = objectMapper.readValue(jsonString, Post.class);
            return post;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Member toMember(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Member member = objectMapper.readValue(jsonString, Member.class);
            return member;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
