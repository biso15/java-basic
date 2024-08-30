package day3.Method;

// 문제 : 자동차가 3번 달리게 해주세요.
// 출력 : 자동차가 달립니다.
public class Exam7 {
    public static void main(String[] args) {
        //v1. 1개의 자동차가 3번 달리게 해주세요.
        Car c1 = new Car();
        c1.run();
        c1.run();
        c1.run();
        //v2. 3개의 자동차가 1번씩 달리게 해주세요.
        Car c2 = new Car();
        c2.run();
        Car c3 = new Car();
        c3.run();
        Car c4 = new Car();
        c4.run();

        //자동차가 달립니다.
        //자동차가 달립니다.
        //자동차가 달립니다.
        //자동차가 달립니다.
        //자동차가 달립니다.
        //자동차가 달립니다.
    }
}

class Car {
    public void run() {
        System.out.println("자동차가 달립니다.");
    }
}

