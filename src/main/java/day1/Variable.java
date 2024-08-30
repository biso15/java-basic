package day1;

public class Variable {
    public static void main(String[] args) {
        // 홍길동의 나이가 20
        // 홍길동 나이가 21로 올라감
        System.out.println(21);
        System.out.println(21);
        System.out.println(20);  // 수동으로 변경시 누락되는 경우 발생 가능
        System.out.println(21);
        System.out.println(21);
        System.out.println(21);

        // 변수를 사용해서 값을 저장할 수 있다.
        // 변수는 상자
        // 상자는 이름이 있어야 함
        // 상자는 크기와 모양이 있어야 함

        // 숫자
        // 상자(변수)를 만들어야 함. int(숫자) [name](이름);
        int age;

        // 값을 변수에 담아야 함
        // = 을 이용해서 저장 가능
        age = 20;

        // 문자
        String name;
        name = "홍길동";

        // 변수의 값을 꺼내서 사용
        System.out.println(age);
        System.out.println(name);

        // [예제]
        // 안녕하세요 저는 20살 홍길동입니다. 10번 출력
        // 홍길동의 나이를 21로 바꿔주세요.
        // 홍길동이 홍길만으로 개명을 했습니다. 홍길동의 이름을 홍길만으로 바꿔주세요.
        int age2;
        // age2 = 20;
        String name2;
        // name2 = "홍길동";
        age2 = 21;
        name2 = "홍길만";
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");
        System.out.println("안녕하세요 저는 " + age2 + "살 " + name2 + "입니다.");

        // 변수 사용시 유의사항
        // 동일한 이름의 변수가 2개 이상 존재할 수 없다.
        // 변수명이 숫자나 특수기호로 시작해서는 안된다. 숫자에 한해서는 뒤쪽에 붙이는건 가능
        // 변수는 재활용 가능
        // 변수는 = 기준 왼쪽, 저장할 값은 오른쪽
        int a;
        a = 10;
        System.out.println(a);
        a = 20;
        System.out.println(a);
    }
}
