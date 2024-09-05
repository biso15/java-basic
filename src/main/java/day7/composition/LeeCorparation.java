package day7.composition;

public class LeeCorparation {
    public static void main(String[] args) {

        // Killdong이와 Kilsoon이를 고용해서 leeCorp가 java와 python 수주가 가능하도록 해주세요.

        LeeCorp leeCorp = new LeeCorp();

        leeCorp.kildong = new Kildong2();
        // leeCorp.kildong = new Jinee2();  // 변수의 자료형에 맞는 객체만 만들 수 있음. 자료형 변경 필요

        leeCorp.kilsoon = new Kilsoon2();

        leeCorp.java();  // 자바 프로그래밍
        leeCorp.python();  // 파이썬 프로그래밍
    }
}

class LeeCorp {
    Kildong2 kildong;
    Kilsoon2 kilsoon;

    public void java() {
        kildong.java();
    }

    public void python() {
        kilsoon.python();
    }
}

class Kildong2 {
    public void java() {
        System.out.println("자바 22버전 프로그래밍");
    }
    public void python() {
        System.out.println("파이썬 프로그래밍");
    }
}

class Kilsoon2 {

    // 길동이한테 연락
    Kildong2 kildong = new Kildong2();

    public void java() {
        kildong.java();
    }

    public void python() {
        System.out.println("파이썬 프로그래밍");
    }
}

class Jinee2 {
    public void java() {
        System.out.println("아주 뛰어난 자바 프로그래밍");
    }
}