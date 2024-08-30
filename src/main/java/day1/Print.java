package day1;

public class Print {
    public static void main(String args[]) {  // 실행되는 부분
        // 출력 -> System.out.print() : 괄호 안의 값을 콘솔에 출력
        System.out.print(100);
        System.out.print(777);

        // 출력 -> System.out.println() : 출력 후 줄바꿈해주는 명령어
        System.out.println(100);
        System.out.println(777);

        // 문자의 경우는 ""를 이용해 구별해야 한다.
        System.out.println("안녕하세요");

        // 더하기 출력
        System.out.println(100 + 200);  // 300

        // 숫자 + 숫자 => 더하기 산술 연산
        // 문자 + 문자 => 이어 붙이기
        // 문자 + 숫자 => 숫자가 문자가 되어서 이어 붙이기
        System.out.println("100 + 200 = " + "300");  // 100 + 200 = 300
        System.out.println("100 + 200 = " + 300);  // 100 + 200 = 300
        System.out.println("100 + 200 = " + 100 + 200);  // 100 + 200 = 100200
        System.out.println("100 + 200 = " + (100 + 200));  // 100 + 200 = 300

        // 하나의 출력문에서 줄바꿈하기
        // 줄바꿈 문자 : \n
        System.out.println("안녕하세요\n반갑습니다.");

        // [예제]
        // 구구단 2단을 System.out.println 한번만 사용해서 출력해주세요.
        // 2 X 1 = 2
        // 2 X 2 = 4
        // 2 X 3 = 6
        // 2 X 4 = 8
        // ....
        // 2 X 9 = 18
        System.out.println(
            "2 X 1 = " + (2*1)
            + "\n2 X 2 = " + (2*2)
            + "\n2 X 3 = " + (2*3)
            + "\n2 X 4 = " + (2*4)
            + "\n2 X 5 = " + (2*5)
            + "\n2 X 6 = " + (2*6)
            + "\n2 X 7 = " + (2*7)
            + "\n2 X 8 = " + (2*8)
            + "\n2 X 9 = " + (2*9)
        );
    }
}