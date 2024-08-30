package day4.vending;

import java.util.Scanner;

public class VendingMachineApp2Answer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VendingMachineAnswer vm = new VendingMachineAnswer();
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

class VendingMachineAnswer {

    // 값을 세팅 X
    // 연습용으로 하나의 객체만 사용할 때는 미리 넣어두는 것이 편하니까 그냥 넣어둠
    int remainder = 0;
    String[] names = {"콜라", "사이다", "커피"};
    int[] prices = {1000, 1200, 800};

    public void inputMoney(int money) {
        remainder = remainder + money;
    }

    public String selectBeverage(int target) {
        if (prices[target] > getRemainder()) {
            return "잔액 부족";  // return 되면 메서드는 거기서 종료. 더이상 밑으로 안내려감
        }

        remainder -= prices[target];
        return names[target];
    }

    public int getRemainder() {
        return remainder;
    }

    public void printBeverages() {
        System.out.println("== 음료수 목록 ==");
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + ". " + names[i] + " : " + prices[i] + "원");
        }
    }
}