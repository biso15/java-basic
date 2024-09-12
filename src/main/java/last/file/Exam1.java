package last.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Exam1 {
    public static void main(String[] args) {

        // 파일 저장하기
        String content = "hello world";
        Path filePath = Paths.get("text.txt");

        try {
            // 파일에 문자열 쓰기
            Files.write(filePath, content.getBytes());
            System.out.println("파일 작성 완료 : " + filePath.toAbsolutePath());
        } catch(IOException e) {
            e.printStackTrace();
        }

        // 파일 읽기
        String filePath2 = "text.txt"; // 파일 경로를 설정하세요
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath2));  // 메서드 하나하나 이해하려 하지 않아도 됨
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
