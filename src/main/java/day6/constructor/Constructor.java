package day6.constructor;

public class Constructor {
    public static void main(String[] args) {

        // 객체를 만들고 나서 변수를 잘 세팅해야 된다. 그렇지 않으면 객체는 제대로 동작하지 않는다.
        // 객체 변수 세팅은 필수
        // 사람은 실수로 위와 같은 필수 작업을 누락할 수도 있다.
        // 객체가 만들어질 때 반드시 실행하는 코드를 세팅할 수 있다. -> 생성자 이용

        // 생성자 함수 사용 안했을 때
        // Person p1 = new Person();
        // p1.introduce();  // 안녕하세요. 0살 null 입니다.

        // 생성자 함수 사용 했을 때
        Person p2 = new Person("이순신", 20);  // 사람이 한명 태어납니다.
        p2.introduce();
        // 더이상 Person p2 = new Person(); 처럼 파라미터 없이 사용 불가
    }
}

class Person {
    String name;
    int age;

    // 리턴타입 X, class 명과 동일한 이름의 특수한 메서드 ==> 생성자
    // 객체가 new로 생성되면 생성자는 무조건 실행된다.
    // 초기화 하는 용도로 사용할 수 있다.
    public Person(String nameParam, int ageParam) {
        System.out.println("사람이 한명 태어납니다.");
        name = nameParam;
        age = ageParam;
    }

    public void introduce() {
        System.out.println("안녕하세요. " + age + "살 " + name + " 입니다.");
    }
}