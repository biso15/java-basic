package day7.casting;

public class LeeCorparation2 {
    public static void main(String[] args) {

        // Killdong이와 Kilsoon이를 고용해서 leeCorp가 java와 python 수주가 가능하도록 해주세요.
        // LeeCorp에서 class 수정 없이 자바 개발자를 교체할 수 있게 해주세요.

        LeeCorp2 leeCorp = new LeeCorp2();

        //leeCorp.javadeveloper = new Kildong();
        leeCorp.javadeveloper = new Jinee();

        leeCorp.kilsoon = new Kilsoon();

        leeCorp.java();
        leeCorp.python();  // 파이썬 프로그래밍
    }
}

class LeeCorp2 {
    JavaDeveloper javadeveloper;
    Kilsoon kilsoon;

    public void java() {
        javadeveloper.java();
    }

    public void python() {
        kilsoon.python();
    }
}

class JavaDeveloper {
    public void java() {
        System.out.println("자바 프로그래밍");
    }
}

class Kildong extends JavaDeveloper {
    public void java() {
        System.out.println("자바 22 버전 프로그래밍");
    }
}

class Jinee extends JavaDeveloper {
    public void java() {
        System.out.println("아주 뛰어난 자바 프로그래밍");
    }
}

class Kilsoon {
    public void python() {
        System.out.println("파이썬 프로그래밍");
    }
}