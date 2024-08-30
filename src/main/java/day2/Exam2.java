package day2;

// 배열의 모든 요소를 세번 출력해주세요.
public class Exam2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        for (int x = 0; x < 3 ; x++) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
