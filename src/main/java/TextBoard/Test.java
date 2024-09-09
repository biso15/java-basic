package TextBoard;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        ArrayList<String> aa = new ArrayList<>();

        try {
            aa.add("hihi");
//            System.out.println(10 / 0);
//            System.out.println(aa.get(1));

        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱싱 문제인듯..");
        } catch (ArithmeticException e2) {
            System.out.println("0으로 나누지마");
        }


        System.out.println("실행");

    }
}
