package TextBoard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    public void main(String[] args) {
        // 현재 날짜와 시간 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 원하는 포맷 지정하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

        // 포맷 적용하여 출력하기
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("포맷된 날짜와 시간: " + formattedDateTime);
    }
}