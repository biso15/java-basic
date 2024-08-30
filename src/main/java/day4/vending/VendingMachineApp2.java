package day4.vending;

import java.util.Scanner;

public class VendingMachineApp2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VendingMachine vm = new VendingMachine();
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
                if (vm.getRemainder() >= vm.prices[target]) {
                    String beverage = vm.selectBeverage(target);
                    System.out.println( beverage + "을/를 뽑으셨습니다.");
                    int remainder = vm.getRemainder();
                    System.out.println("잔액은 " + remainder + " 원입니다.");
                } else {
                    System.out.println("잔액이 부족합니다.");
                }
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

class VendingMachine {
    int remainder = 0;
    String[] names = {"콜라", "사이다", "커피"};
    int[] prices = {1000, 1200, 800};

    public void inputMoney(int money) {
        remainder += money;
    }

    public String selectBeverage(int target) {
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