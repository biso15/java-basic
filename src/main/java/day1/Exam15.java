package day1;

public class Exam15 {
    public static void main(String[] args) {

        int h = 5;
        for (int i = 1; i <= h; i++) {
            String space = "";
            String star = "";

            for (int x = 0; x <= h - i; x++) {
                space = space + " ";
            }

            for (int y = 0; y < i; y++) {
                star = star + "*";
            }

            System.out.println(space + star);
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
