package day8.staticExam;

// 문제 : 아래 코드의 잘 못된 점을 고쳐보세요. 그리고 printValue 함수를 완성시켜주세요.

public class Exam2 {

    static int num = 10;

    public static void printValue(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {

        // static이 붙은 메서드는 static이 붙지 않은 변수나 메서드는 사용 불가
        System.out.println(num); // 출력 : 10

        printValue("안녕");
        // 출력 : 안녕
    }

}