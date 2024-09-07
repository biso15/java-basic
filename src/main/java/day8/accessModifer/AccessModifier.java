package day8.accessModifer;

public class AccessModifier {
    public static void main(String[] args) {

        // 자원(변수 + 메서드)에 접근할 수 있는 권한
        // public : 모두 사용 가능(중요)
        // protected : 상속관계 + 같은 폴더 안에 있는 객체끼리 사용 가능
        // default : 같은 폴더 안에 있는 객체끼리 사용 가능(생략 가능)
        // private : 자신만 사용 가능(중요)

        Calculator c1 = new Calculator();
        c1.divide();
        // c1.num2 = 0;  // 여기서 0을 넣은게 문제의 원인. 누구나 접근해서 바꿔버릴 수 있음. private를 이용해 Calculator의 데이터를 보호할 수 있다.

        // c1.num1 = 10; num1이 private라 접근 불가능
        c1.setNum1(20);  // setNum1() 메서드는 public이라 접근 가능
        c1.setNum2(0);  // 변수로 직접 값을 바꾸는 것이 아니라 메서드로 값을 바꿀 경우 메서드 내에서 우회 가능(오류데이터 처리)
        c1.divide();

        // System.out.println(c1.num1);  // 오류
        System.out.println("Num1 : " + c1.getNum1());

        // 객체 변수는 객체 내의 모든 메서드에 영향을 주므로 외부의 접근을 일반적으로 private로 막는다.
        // 변수에 접근이 필요하면 getter와 setter 메서드를 public으로 만들어 사용한다.

    }
}

class Calculator {
    // 변수를 사용할 때 private를 붙여서 사용할 것
    private int num1 = 10;
    private int num2 = 2;

    // 메서드는 변수를 사용해서 작동하는게 대부분
    // 객체의 변수에 잘못된 정보가 들어오면 메서드가 고장난다.
    // 객체의 변수는 함부로 바꾸면 안된다.
    public void divide() {
        System.out.println(num1 / num2);
    }

    // setter
    // 명명규칙 -> set변수명() => 카멜표기법 적용
    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        if (num2 == 0) {
            System.out.println("0은 나눌 수 없습니다. 기본값인 1로 초기화합니다.");
            num2 = 1;
        }
        this.num2 = num2;
    }

    // getter
    // 명명규칙 -> get변수명() => 카멜표기법 적용
    public int getNum1() {
        return num1;
    }
}