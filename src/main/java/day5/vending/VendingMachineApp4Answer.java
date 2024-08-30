package day5.vending;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineApp4Answer {

    // 현재 투입된 금액은 2000원입니다.

    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 4
    // 현재 잔액은 2000원 입니다.

    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 4
    // 현재 잔액은 2000원 입니다.

    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 3
    // == 음료수 목록 ==
    // 0. 콜라 : 1000원, 남은 수량 : 1
    // 1. 사이다 : 1200원, 남은 수량 : 2
    // 2. 커피 : 800원, 남은 수량 : 1

    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 2
    // 음료수를 선택해주세요 : 0
    // 콜라 를 뽑으셨습니다.
    // 잔액은 1000 원입니다.

    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 4
    // 현재 잔액은 1000원 입니다.

    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 3
    // == 음료수 목록 ==
    // 0. 콜라 : 1000원, 남은 수량 : 0
    // 1. 사이다 : 1200원, 남은 수량 : 2
    // 2. 커피 : 800원, 남은 수량 : 1

    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 2
    // 음료수를 선택해주세요 : 1
    // 잔액이 부족합니다.
    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 2
    // 음료수를 선택해주세요 : 0
    // 수량이 부족합니다.
    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 2
    // 음료수를 선택해주세요 : 2
    // 커피 를 뽑으셨습니다.
    // 잔액은 200 원입니다.
    // 기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : 5
    // 자판기 프로그램을 종료합니다. 남은 돈 200원이 반환됩니다.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VendingMachine4 vm = new VendingMachine4();
        while (true) {
            System.out.print("기능 선택 (1. 돈 투입,  2. 음료 선택,  3.음료 목록 확인, 4.잔액 확인, 5. 사용 종료) : ");
            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                System.out.print("돈을 투입해주세요 : ");
                int money = Integer.parseInt(sc.nextLine());
                vm.inputMoney(money);
                System.out.println("현재 투입된 금액은 " + money + "원입니다.");
            }
            else if (menu == 2) {
                System.out.print("음료수를 선택해주세요 : ");
                int target = Integer.parseInt(sc.nextLine());
                String beverage = vm.selectBeverage(target);

                if (beverage.equals("잔액 부족")) {
                    System.out.println("잔액이 부족합니다.");
                    continue;
                }

                if (beverage.equals("수량 부족")) {
                    System.out.println("수량이 부족합니다.");
                    continue;
                }

                System.out.println( beverage + "을/를 뽑으셨습니다.");
                int remainder = vm.getRemainder();
                System.out.println("잔액은 " + remainder + " 원입니다.");
            }
            else if (menu == 3) {
                vm.printBeverages();
            }
            else if (menu == 4) {
                int remainder = vm.getRemainder();
                System.out.println("현재 잔액은 " + remainder + "원 입니다.");
            }
            else if (menu == 5) {
                int remainder = vm.getRemainder();
                System.out.println("자판기 프로그램을 종료합니다. 남은 돈 " + remainder  + "원이 반환됩니다.");
                break;
            }
        }
    }
}

class VendingMachine4Answer {
    int remainder = 0;

    ArrayList<String> names = new ArrayList<>() {{
        add("콜라");
        add("사이다");
        add("커피");
    }};

    ArrayList<Integer> prices = new ArrayList<>(List.of(1000, 1200, 800));
    ArrayList<Integer> quantities = new ArrayList<>(List.of(1, 2, 1));

    public void inputMoney(int money) {
        remainder = remainder + money;  // 증감연산
        // 증감연산의 경우 짧게 표현하는 방법 존재.
        remainder += money;  // 위와 같은 코드
    }

    public String selectBeverage(int target) {
        if (prices.get(target) > getRemainder()) {
            return "잔액 부족";  // return 되면 메서드는 거기서 종료. 더이상 밑으로 안내려감
        }

        if (quantities.get(target) <= 0) {
            return "수량 부족";
        }

        remainder -= prices.get(target);
        quantities.set(target, quantities.get(target) - 1);
        return names.get(target);
    }

    public int getRemainder() {
        return remainder;
    }

    public void printBeverages() {
        System.out.println("== 음료수 목록 ==");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(i + ". " + names.get(i) + " : " + prices.get(i) + "원, 남은 수량 : " + quantities.get(i));
        }
    }
}