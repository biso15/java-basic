package day7.casting;

public class Casting2 {
    public static void main(String[] args) {

        // 형변환은 유사한 타입에서만 가능
        String str = "hi";
        int num = 10;

        // num = (int)str;  // 이건 말도 안되는 형변환


        // 객체간의 형변환
        // 객체간의 형변환은 상속 관계에서 허용.
        Dog d1 = new Dog();
        d1.bark();

        Cat c1 = new Cat();
        c1.moew();

        // d1 = c1;  // Dog 변수에 Cat이 대입될 수 없다.

        // 객체간 자동 형변환 => 안전
        Animal a1 = d1;
        a1 = c1;
        // Animal 타입 변수에 Dog가 대입되었다 (X) -> Dog가 Animal로 모습을 바꿔서 대입 (O)
        // Dog 자신의 변수나 메서드는 사용 불가하며, Animal의 변수나 메서드만 사용 가능
        a1.eat();
        // a1.bark();  // 사용 불가. Dog 자신의 메서드이기 때문

        // 객체간 수동 형변환 => 위험
        c1 = (Cat)a1; // Animal을 Cat으로 수동형변환

        a1 = d1;  // Dog
        Cat c2 = (Cat)a1;  // Dog -> Cat
        c2.eat();
        // c2.meow();  // 불가

        // 자식 객체가 부모 객체로 모습을 바꾸는 것은 안전하다. 자식은 부모의 기능을 무조건 가지고 있기 때문
        // 부모 객체가 자식 객체로 모습을 바꾸는 것은 위험하다. 부모 객체는 여러 자식 객체를 포함할 수 있기 때문에 특정 객체로 확신할 수 없다.

    }
}

class Animal {
    public void eat() {
        System.out.println("먹다.");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    public void moew () {
        System.out.println("야옹");
    }
}