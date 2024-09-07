package day7.polymopism;

// 문제 : 아래가 실행되도록 해주세요.

public class Exam1 {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();

        warrior.age = 20;
        warrior.weapon = new Bow();
        warrior.weapon = new Sword();
    }

}

class Warrior {
    int age;
    Weapon weapon;
}

class Weapon {

}

class Bow extends Weapon {

}

class Sword extends Weapon {

}