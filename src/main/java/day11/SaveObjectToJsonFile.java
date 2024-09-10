package day11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaveObjectToJsonFile {
    public static void main(String[] args) {

        // 객체 생성
        MyObject myObject1 = new MyObject("Mint1", 90);
        MyObject myObject2 = new MyObject("Elin2", 40);
        MyObject myObject3 = new MyObject("John Doe3", 30);
        MyObject myObject4 = new MyObject("Jane Smith4", 25);

        ArrayList<MyObject> people = new ArrayList<>() {{
            add(myObject1);
            add(myObject2);
            add(myObject3);
            add(myObject4);
        }};

        // ObjectMapper 생성
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일로 저장
            // writerWithDefaultPrettyPrinter()를 사용하면 JSON이 읽기 쉬운 형식으로 저장됩니다.
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("objects.json"), people);
            System.out.println("JSON 파일로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }


//        // 예제 객체 생성
//        MyObject obj = new MyObject("example", 123);
//
//        // Jackson ObjectMapper 생성
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            // 객체를 JSON 파일로 저장
//            mapper.writeValue(new File("json/object.json"), obj);
//            System.out.println("객체를 JSON 파일로 저장했습니다.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}