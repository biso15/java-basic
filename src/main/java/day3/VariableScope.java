package day3;

public class VariableScope {
    public static void main(String[] arg) {
        // 영역(지역) -> {}로 구분
        // 변수는 지역에서 만들어진다.
        // 변수는 해당 지역에서만 사용 가능
        int a = 10;
        System.out.print(a);

        // 서로 다른 지역에서 변수를 공유하고 싶으면 두 지역을 포함하는 더 큰 지역에 변수를 만들어라
        int d;
        if (true) {
           System.out.println(a);
           int c = 10;
        } else {
//            System.out.println(c);
        }

        {
            int b = 20;
            System.out.println(b);

            d = 20;
        }

        System.out.println(d);
//        System.out.println(b);
    }
}
