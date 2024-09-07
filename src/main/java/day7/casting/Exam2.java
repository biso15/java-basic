package day7.casting;

public class Exam2 {
    public static void main(String[] args) {
        Weapon weapon = new Weapon();
        weapon = new Bow();
        weapon = new Spear();
    }
}

class Weapon {

}

class Bow extends Weapon {

}

class Spear extends Weapon {

}