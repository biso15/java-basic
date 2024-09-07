package day7.polymopism;

public class Exam2 {
    public static void main(String[] args) {

        Warrior2 warrior = new Warrior2();

        String name = "홍길동";
        warrior.name = name;
        warrior.age = 20;
        warrior.introduce();
        // 안녕하세요 저는 20살 홍길동입니다.

        warrior.weapon = new Bow2();
        warrior.attack();
        // 출력 : 홍길동이/가 활로 공격합니다.

        warrior.weapon = new Sword2();
        warrior.attack();
        // 출력 : 홍길동이/가 칼로 공격합니다.
    }
}

class Warrior2 {
    // 인스턴스 변수
    String name;
    // 인스턴스 변수
    int age;
    // 인스턴스 변수
    Weapon2 weapon;

    void introduce() {
        System.out.println("안녕하세요. 저는 " + age + "살 " + name + " 입니다.");
    }

    void attack() {
        System.out.println(name + "이/가 " + weapon.name + "로 공격합니다.");
    }
}

class Weapon2 {
    String name;
}

class Sword2 extends Weapon2 {
    // 메서드는 자기 자신의 메서드를 우선순위로 하지만 변수는 부모의 변수를 우선순위로 사용
    public Sword2() {
        name = "칼";
    }
}

class Bow2 extends Weapon2 {
    public Bow2() {
        name = "활";
    }
}