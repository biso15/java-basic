package day1;

public class Exam14 {
    public static void main(String[] args) {
        int h = 3;
        String star = "*";
        for (int i = 1; i <= h; i++) {
            System.out.println(star);
            star = star + "*";
        }

        // 출력
        /*
        높이 : [3]

        *
        **
        ***


        */

        /*

        높이 : [5]

        *
        **
        ***
        ****
        *****

        */

        /*

        높이 : [7]

        *
        **
        ***
        ****
        *****
        ******
        *******

        */
    }
}
