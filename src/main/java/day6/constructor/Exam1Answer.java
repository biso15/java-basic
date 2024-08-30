package day6.constructor;

public class Exam1Answer {

    // 다음 클래스들을 생성자를 이용해 간단하게 값을 세팅해주세요.

    public static void main(String[] args) {

//        Person p1 = new Person(); // 사람이 태어납니다.
//        p1.age = 27;
//        p1.name = "홍길동";
        PersonAnswer p1 = new PersonAnswer(27, "홍길동");

//        Person p2 = new Person(); // 사람이 태어납니다.
//        p2.age = 25;
//        p2.name = "홍길순";
        PersonAnswer p2 = new PersonAnswer(25, "홍길순");

        p1.introduce(); // 안녕하세요 27살 홍길동입니다.
        p2.introduce(); // 안녕하세요 25살 홍길순입니다.

//        Car c1 = new Car(); // 자동차가 만들어집니다.
//        c1.model = "소나타";
//        c1.color = "하얀색";
//        c1.speed = 100;
        CarAnswer c1 = new CarAnswer("소나타", "하얀색", 100);

//        Car c2 = new Car(); // 자동차가 만들어집니다.
//        c2.model = "모닝";
//        c2.color = "검정색";
//        c2.speed = 70;
        CarAnswer c2 = new CarAnswer("모닝", "검정색", 70);

        c1.drive(); // 하얀색 소나타이/가 100km로 달립니다.
        c2.drive(); // 검정색 모닝이/가 70km로 달립니다.


//        Cat cat1 = new Cat(); // 고양이가 태어납니다.
//        cat1.name = "아리";
//        cat1.age = 4;
//        cat1.kind = "러시안블루";
        CatAnswer cat1 = new CatAnswer("아리", "러시안블루", 4);

//        Cat cat2 = new Cat(); // 고양이가 태어납니다.
//        cat2.name = "망고";
//        cat2.age = 6;
//        cat2.kind = "샴";
        CatAnswer cat2 = new CatAnswer("망고", "샴", 6);

        cat1.meow(); // 4살 러시안블루 고양이 아리가 야옹하고 웁니다.
        cat2.meow(); // 6살 샴 고양이 망고가 야옹하고 웁니다.


//        Warrior w1 = new Warrior(); // 전사가 태어납니다.
//        w1.name = "이순신";
//        w1.attack = 20;
//        w1.defense = 10;
        WarriorAnswer w1 = new WarriorAnswer("이순신", 20, 10);

//        Warrior w2 = new Warrior(); // 전사가 태어납니다.
//        w2.name = "강감찬";
//        w2.attack = 15;
//        w2.defense = 15;
        WarriorAnswer w2 = new WarriorAnswer("강감찬", 15, 15);

        w1.status(); // 이름 : 이순신, 공격력 : 20, 방어력 : 10
        w2.status(); // 이름 : 강감찬, 공격력 : 15, 방어력 : 15

        w1.attack(); // 이순신이 20의 데미지를 입힙니다.
        w2.attack(); // 강감찬이 15의 데미지를 입힙니다.

        w1.defense(); // 이순신이 10 데미지를 방어합니다.
        w2.defense(); // 강감찬이 15 데미지를 방어합니다.

    }
}

class PersonAnswer {
    int age;
    String name;

    // 생성자는 메서드 중에 가장 위에 놓는다.
    public PersonAnswer(int age, String name) {
        System.out.println("사람이 태어납니다.");

        // 매개변수와 class 내 변수 이름이 같을 경우 매개변수를 우선적으로 사용한다.
        // 그러므로 매개변수 = 매개변수 가 되므로 무의미한 코드가 된다.
        // 같은 이름을 사용하고 싶으면 this를 사용하거나 다른 이름으로 사용해야됨 => this를 붙이면 class 내 변수를 가르킴
        this.age = age;
        this.name = name;
    }

    public void introduce() {
        // 문자와 변수를 섞어서 사용할 경우문자 = %s, 숫자 = %d 를 사용하여 표현할 수 있다.
        System.out.printf("안녕하세요 %d살 %s입니다.\n", age, name);
    }
}

class CarAnswer {
    String model;
    String color;
    int speed;

    public CarAnswer(String model, String color, int speed) {
        System.out.println("자동차가 만들어집니다.");

        this.model = model;
        this.color = color;
        this.speed = speed;
    }

    public void drive() {
        System.out.printf("%s %s이/가 %dkm로 달립니다.\n", color, model, speed);
    }
}

class CatAnswer {
    String name;
    String kind;
    int age;

    public CatAnswer(String name, String kind, int age) {
        System.out.println("고양이가 태어납니다.");

        this.name = name;
        this.kind = kind;
        this.age = age;
    }

    public void meow() {
        System.out.printf(" %d살 %s 고양이 %s가 야옹하고 웁니다.\n", age, kind, name);
    }
}


class WarriorAnswer {

    // 상태
    String name;
    int attack;
    int defense;

    // 동작
    public WarriorAnswer(String name, int attack, int defense) {
        System.out.println("전사가 태어납니다.");

        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public void status() {
        System.out.printf("이름 : %s, 공격력 : %d, 방어력 : %d \n", name, attack, defense);
    }

    public void attack() {
        System.out.printf("%s이 %d의 데미지를 입힙니다.\n", name, attack);
    }

    public void defense() {
        System.out.printf("%s이 %d 데미지를 방어합니다.\n", name, defense);
    }
}