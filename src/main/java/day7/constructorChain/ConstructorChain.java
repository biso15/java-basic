package day7.constructorChain;

public class ConstructorChain {
    public static void main(String[] args) {
        WhiteDuck2 wd = new WhiteDuck2();
        wd.fly();
    }
}

class Duck2 {
    public Duck2() {
        System.out.println("Duck이 생성됩니다.");
    }
    public void fly() {
        System.out.println("오리가 납니다.");
    }
}

class WhiteDuck2 extends Duck2 {
    public WhiteDuck2() {
        System.out.println("WhiteDuck이 생성됩니다.");
    }
    public void fly() {
        System.out.println("흰오리가 납니다.");
    }
    // Duck.fly()를 덮어쓰는 것이 아니라 WhiteDuck.fly()가 생기는 것임
    // 객체는 자기 자신의 메서드를 우선적으로 사용하기 때문에 WhiteDuck.fly()가 실행됨
}

// 부모 객체가 먼저 생성되고 자식 객체가 생성됨
// Duck이 생성됩니다.
// WhiteDuck이 생성됩니다.
// 흰오리가 납니다.