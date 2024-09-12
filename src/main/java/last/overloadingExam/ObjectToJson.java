package last.overloadingExam;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ObjectToJson {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {

        Post p = new Post("title1", "content1");

        // json 파일로 저장
        objectToJson(p, "post.json");

        // json 파일에서 불러오기
        Post post = jsonToObject("post.json", Post.class);

        // 출력
        System.out.println("제목 : " + post.getTitle());
        System.out.println("내용 : " + post.getBody());


        Member m = new Member("hkd1234", "kd1234", "홍길동");

        objectToJson(m, "member.json");
        Member member = jsonToObject("member.json", Member.class);

        System.out.println("닉네임 : " + member.getNickname());
    }

    public static void objectToJson (Object object, String fileName) {

        String jsonString;
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            jsonString = null;
        }

        Path filePath = Paths.get(fileName);
        try {
            Files.write(filePath, jsonString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T jsonToObject (String fileName, Class<T> valueType) {

        Path filePath = Paths.get(fileName);

        String jsonString;
        try {
            jsonString = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            jsonString = null;
        }

        try {
            T object = objectMapper.readValue(jsonString, valueType);
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}