package day3.Method;

public class Exam3 {
    public static void main(String[] args) {

        Test2 t1 = new Test2();

        t1.print(4); // 출력: 4
        t1.print(10); // 출력: 10
        t1.print(100); // 출력: 100

    }
}

class Test2 {
    public void print(int num) {
        System.out.println(num);
    }
}