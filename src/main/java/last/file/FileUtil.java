package last.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public void save(String content, String fileName) {
        Path filePath = Paths.get(fileName);

        try {
            // 파일에 문자열 쓰기
            Files.write(filePath, content.getBytes());
            // System.out.println("파일 작성 완료 : " + filePath.toAbsolutePath());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String load(String fileName) {
        Path filePath = Paths.get(fileName); // 파일 경로를 설정하세요

        try {
            String content = Files.readString(filePath);  // 메서드 하나하나 이해하려 하지 않아도 됨
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
