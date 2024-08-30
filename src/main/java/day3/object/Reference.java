package day3.object;

public class Reference {
    public static void main(String[] args) {
        // 자바의 변수는 최대 크기가 제한이 되어 있다. -> 8바이트
        // 숫자(int) -> 4바이트

        // 숫자 3개짜리 객체 -> 12바이트
        // 객체는 크기가 커서 변수에 저장되지 않습니다. -> 변수도 마찬가지
        // 변수에 저장될 작은 크기의 리모콘(참조값)을 제공한다. -> 리모콘은 8바이트
        Test t1 = new Test();

//        int a = 10;
//        int b = a;
//
//        System.out.println(b);

        t1.num1 = 10;
        System.out.println(t1.num1);

        Test t2 = t1;  // t1이 t2로 리모콘이 복사되었다.
        System.out.println(t2.num1);

        t2.num1 = 100;
        System.out.println(t1.num1);  // 값이 복사되는게 아닌 리모콘이 복사되는 것이기 때문에 t1 객체의 값도 바뀌게 됨

        Test t3;  // 객체 X. 객체의 리모콘을 저장할 변수. 대입한 것이 없기 때문에 비어있다.
        Test t4 = new Test();  // new를 하면 객체가 생성됨과 동시에 해당 객체를 조종할 수 있는 리모콘이 같이 만들어짐

        // 리모콘을 잃어버리게 되면 해당 객체에 접근할 수 있는 방법이 없다.
        // 위와 같이 리모콘과 연결이 해제된 객체를 가비지 객체라고 해서 나중에 자바가 싹 다 지워버린다.(가비지컬렉터)
    }
}
