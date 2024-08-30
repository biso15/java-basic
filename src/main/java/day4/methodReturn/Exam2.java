package day4.methodReturn;

public class Exam2 {
    public static void main(String[] args) {
        Test2 t1 = new Test2();

        int rst1 = t1.plus(10, 20);
        System.out.println(rst1);  // 출력 : 30

        int rst2 = t1.minus(10, 20);
        System.out.println(rst2); // 출력 : -10

        int rst3 = t1.multiple(5, 4);
        System.out.println(rst3); // 출력 : 20

        int rst4 = t1.divide(10, 3);
        System.out.println(rst4); // 출력 : 3

        int rst5 = t1.square(5);
        System.out.println(rst5); // 출력 : 25
    }
}

class Test2 {
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiple(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public int square(int num) {
        return num * num;
    }
}