package day4.methodReturn;

// 1 부터 n까지 수 중 짝수인 것만 출력
// Test4 class에 있는 printEven과 isEven을 완성하여 해결해주세요,
public class Exam4 {
    public static void main(String[] args) {

        Test4 t1 = new Test4();

        t1.printEven(10); // 출력: 2 4 6 8 10
        t1.printEven(20); // 출력: 2 4 6 8 10 12 14 16 18 20
        t1.printEven(5); // 출력: 2 4
    }
}

class Test4 {

//    int[] even;
//    int index;

    public void printEven(int n) {
//        isEven(n);
//        for (int i = 0; i < even.length; i++) {
//            System.out.print(even[i] + " ");
//        }
//        System.out.println();

        for (int i = 1; i <= n; i++) {
            if (isEven(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public boolean isEven(int num) {
//        public void isEven(int num) {
//        even = new int[num / 2];
//        index = 0;
//
//        for (int i = 1; i <= num; i++) {
//            if (i % 2 == 0) {
//                even[index] = i;
//                index++;
//            }
//        }

        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}