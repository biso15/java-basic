package day2;

public class Exam3 {
    public static void main(String[] args) {
        // 배열에 5개의 값을 입력하고 거꾸로 출력해주세요.
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
