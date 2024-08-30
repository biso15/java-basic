package day1;

public class Exam16 {
    public static void main(String[] args) {

        int h = 5;

        for (int i = 0; i < h; i++) {
            String star = "";

            if (i < h / 2) {
                for (int x = 0; x <= i; x++) {
                    star = star + "*";
                }
            } else {
                for (int x = h - i; x > 0; x--) {
                    star = star + "*";
                }
            }
            System.out.println(star);
        }

        // 출력
        /*


         *
         **
         *


         */

        // 출력
        /*


         *
         **
         ***
         **
         *


         */

        // 출력
        /*


         *
         **
         ***
         ***
         **
         *


         */

    }
}
