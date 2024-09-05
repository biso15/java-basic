package day7;
/* 가정
우리는 게임개발회사에 입사했다.
우리에게는 성격좋은 사수 한명이 있다.
내가 개발할 게임은 오리시뮬레이션 게임이다.
선임이 나의 개발을 도와주진 않지만 조언은 해준다.
*/

/* 요구사항
- D1 요구 : 오리를 생성하고 날게하시오.
- D1 완료 : 클래스와 메서드를 만들어서 처리
- D2 요구 : 게임의 디테일을 살리기 위해서 `청둥오리`와 `흰오리`를 생성하고 날게하시오.
- D2 완료 : 클래스와 메서드를 만들어서 처리
- D3 요구 : 오리 계열의 클래스에 날다 메서드가 중복되었습니다. 중복을 제거해주세요.
- D3 완료 : 상속을 사용해서 처리
- D4 요구 : 게임의 재미를 위하여 고무오리를 추가하고 날게 하시오.
- D4 완료 : 클래스와 메서드를 만들어서 처리
- D5 요구 : 주말 주주회의에서 고무오리가 하늘을 날아다니는 것에 대해서 태클이 들어왔습니다. 고무오리 계열은 하늘을 날 수 없게 해주세요.
- D5 완료 : 메서드 오버라이드를 사용해서 처리
- D6 요구 : 고무오리가 반응이 좋습니다. 고무2오리를 추가하고 날게 해주세요.
- D6 완료 : 고무2오리 추가후 고무오리 상속으로 해결
- D7 요구 : 새로운 기능인 헤엄치기를 추가하고 오리처럼 날고 고무오리처럼 헤엄치는 아수라 오리를 추가해주세요.
*/

public class DuckSimulation {
    public static void main(String[] args) {
        Duck d1 = new Duck();
        d1.fly();
        // 출력 : 오리가 날개로 날아갑니다.

        MallardDuck m1 = new MallardDuck();
        m1.fly();
        m1.swim();
        // 출력 : 오리가 날개로 날아갑니다.
        // 출력 : 오리가 오리발로 헤엄칩니다.

        WhiteDuck w1 = new WhiteDuck();
        w1.fly();
        w1.swim();
        // 출력 : 오리가 날개로 날아갑니다.
        // 출력 : 오리가 오리발로 헤엄칩니다.

        RubberDuck r1 = new RubberDuck();
        r1.fly();
        r1.swim();
        //출력 : 저는 날 수 없어요. ㅜㅠ
        // 출력 : 오리가 둥둥 떠다닙니다.

        RubberDuck2 r2 = new RubberDuck2();
        r2.fly();
        r2.swim();
        // 출력 : 저는 날 수 없어요. ㅜㅠ
        // 출력 : 오리가 둥둥 떠다닙니다.

        AsuraDuck a1 = new AsuraDuck();
        a1.fly();
        a1.swim();
        // 출력 : 오리가 날개로 날아갑니다.
        // 출력 : 오리가 둥둥 떠다닙니다.
    }
}

// Duck => 부모 클래스, 부모 객체, 상위클래스
// WhiteDuck => 자식 클래스, 자식 객체, 하위클래스
// WhiteDuck extends Duck => WhiteDuck이 Duck의 능력을 물려 받는다.
// "`WhiteDuck`은 `Duck`이다." 라고 자바에게 알려준다.

// `A 는 B 이다.` 테스트에 통과하는 것만 상속이 가능하다.
// 클래스와 객체는 명사이다.
// 메서드는 동사이다.

class Duck {
    public void fly () {
        System.out.println("오리가 날개로 날아갑니다.");
    }
    public void swim () {
        System.out.println("오리가 오리발로 헤엄칩니다.");
    }
}

class MallardDuck extends Duck {

}

class WhiteDuck extends Duck {

}

// 메서드 재정의 라고 합니다.
// 메서드 오버라이드 라고도 합니다.
// 메서드 재정의 => 부모가 물려준 능력을 다시 구현한다.
class RubberDuck extends Duck {
    public void fly () {
        System.out.println("저는 날 수 없어요. ㅜㅠ");
    }
    public void swim () {
        System.out.println("오리가 둥둥 떠다닙니다.");
    }
}

class RubberDuck2 extends RubberDuck {

}

// 상속의 한계
// 객체가 많아지고 상속 관계가 복잡해질수록 중복 해결이 어려워진다.
// 상속은 잘못 사용하면 큰일난다. -> 상위클래스가 변경되면 자식클래스도 변경되기 때문
class AsuraDuck extends Duck {
    public void swim () {
        System.out.println("오리가 둥둥 떠다닙니다.");
    }
}