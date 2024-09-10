package day11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReadObjectFromFile {
    public static void main(String[] args) {
        // Jackson ObjectMapper 생성
        ObjectMapper mapper = new ObjectMapper();

        try {
            // JSON 파일을 ArrayList로 변환
            ArrayList<MyObject> list = mapper.readValue(new File("objects.json"), new TypeReference<ArrayList<MyObject>>() {});
            System.out.println("JSON 파일을 ArrayList로 읽어왔습니다.");

            // 리스트 내용 출력
            for (MyObject obj : list) {
                System.out.println("이름: " + obj.getName() + ", 값: " + obj.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        // Jackson ObjectMapper 생성
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            // JSON 파일을 Java 객체로 변환
//            MyObject obj = mapper.readValue(new File("object.json"), MyObject.class);
//            System.out.println("객체를 JSON 파일에서 읽어왔습니다.");
//            System.out.println("이름: " + obj.getName());
//            System.out.println("값: " + obj.getValue());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
