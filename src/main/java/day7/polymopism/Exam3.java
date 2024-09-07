package day7.polymopism;

public class Exam3 {
    public static void main(String[] args) {

        Warrior3 warrior = new Warrior3();

        String name = "홍길동";
        warrior.name = name;
        warrior.age = 20;
        warrior.introduce();
        // 안녕하세요 저는 20살 홍길동입니다.

        warrior.weapon = new Bow3();
        warrior.attack();
        // 출력 : 홍길동이/가 활로 공격합니다.

        warrior.useSkill();
        // 출력 : 홍길동이/가 불화살 스킬을 사용합니다. 1.5배(15)의 피해를 입힙니다.

        warrior.weapon = new Sword3();
        warrior.attack();
        // 출력 : 홍길동이/가 칼로 공격합니다.

        warrior.useSkill();
        // 출력 : 홍길동이/가 연속 베기 스킬을 사용합니다. 2배(30)의 피해를 입힙니다.
    }
}
class Warrior3 {
    // 인스턴스 변수
    String name;
    // 인스턴스 변수
    int age;
    // 인스턴스 변수
    Weapon3 weapon;

    void introduce() {
        System.out.println("안녕하세요. 저는 " + age + "살 " + name + " 입니다.");
    }

    public void attack() {
        System.out.println(name + "이/가 " + weapon.name + "로 공격합니다.");
    }

    public void useSkill() {
        System.out.println(name + "이/가 " + weapon.skill + " 스킬을 사용합니다. " + weapon.damage + "의 피해를 입힙니다.");
    }
}

class Weapon3 {
    String name;
    String skill;
    String damage;
}

class Sword3 extends Weapon3 {
    public Sword3() {
        name = "칼";
        skill = "연속 베기";
        damage = "2배(30)";
    }
}

class Bow3 extends Weapon3 {
    public Bow3() {
        name = "활";
        skill = "불화살";
        damage = "1.5배(15)";
    }
}