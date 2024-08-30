package day3.Method;

// 문제 : 자동차 객체를 담을 변수를 만들어주세요.
// 자동차 객체를 변수에 담고 그 변수를 이용해 최고속력이 서로 다르게 만들어주세요.
// 각 자동차가 자신의 최고속력으로 달리게 해주세요.
public class Exam8 {
    public static void main(String[] args) {
        Car2 c1 = new Car2();
        c1.speed = 220;
        c1.fastRun();

        Car2 c2 = new Car2();
        c2.speed = 250;
        c2.fastRun();

        // 출력 : 자동차가 최대속력 220km로 달립니다.
        // 출력 : 자동차가 최대속력 250km로 달립니다.
    }
}

class Car2 {
    int speed;

    public void fastRun() {
        System.out.println("자동차가 최대속력 " + speed + "km로 달립니다.");
    }
}

