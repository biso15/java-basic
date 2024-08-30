package day6.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    public static void main(String[] args) {
        // 햄버거 키오스크 만들기

        // 햄버거 키오스크 v1
        // 1. 햄버거 선택
        // 2. 사이드 선택
        // 3. 음료수 선택
        // 4. 메뉴 취소
        // 5. 주문 하기
        //====== 주문 목록 =====
        // 버거: []
        // 사이드 : []
        // 음료수 : []
        // 총금액 : 0
        // 무엇을 하시겠습니까 : 1

        // === 햄버거 목록 ===
        // 1. 한우불고기버거 6000
        // 2. 치즈버거 3000
        // 3. 치킨버거 3500
        // 4. 새우버거 3200
        // 어떤 버거를 고르시겠습니까 : 1
        // 한우불고기버거를 고르셨습니다.


        // ================================================================


        // 햄버거 키오스크 v1
        // 1. 햄버거 선택
        // 2. 사이드 선택
        // 3. 음료수 선택
        // 4. 메뉴 취소
        // 5. 주문 하기
        //====== 주문 목록 =====
        // 버거: [한우불고기버거]
        // 사이드 : []
        // 음료수 : []
        // 총금액 : 6000
        // 무엇을 하시겠습니까 : 2

        // === 사이드 목록 ===
        // 1. 감자튀김 1800
        // 2. 치즈스틱 2000
        // 3. 치킨너겟 2500
        // 4. 오징어링 2700
        // 어떤 사이드를 고르시겠습니까 : 2
        // 치즈스틱을 고르셨습니다.

        // ================================================================

        // 햄버거 키오스크 v1
        // 1. 햄버거 선택
        // 2. 사이드 선택
        // 3. 음료수 선택
        // 4. 메뉴 취소
        // 5. 주문 하기
        //====== 주문 목록 =====
        // 버거: [한우불고기버거]
        // 사이드 : [치즈스틱]
        // 음료수 : []
        // 총금액 : 8000
        // 무엇을 하시겠습니까 : 2

        // === 사이드 목록 ===
        // 1. 감자튀김 1800
        // 2. 치즈스틱 2000
        // 3. 치킨너겟 2500
        // 4. 오징어링 2700
        // 어떤 사이드를 고르시겠습니까 : 1
        // 감자튀김을 고르셨습니다.

        // ================================================================

        // 햄버거 키오스크 v1
        // 1. 햄버거 선택
        // 2. 사이드 선택
        // 3. 음료수 선택
        // 4. 메뉴 취소
        // 5. 주문 하기
        //====== 주문 목록 =====
        // 버거: [한우불고기버거]
        // 사이드 : [치즈스틱, 감자튀김]
        // 음료수 : []
        // 총금액 : 9800
        // 무엇을 하시겠습니까 : 3

        // === 음료수 목록 ===
        // 1. 콜라 1000
        // 2. 에이드 2000
        // 3. 커피 1500
        // 4. 쉐이크 2500
        // 어떤 음료수를 고르시겠습니까 : 2
        // 에이드를 고르셨습니다.

        // ================================================================

        // 햄버거 키오스크 v1
        // 1. 햄버거 선택
        // 2. 사이드 선택
        // 3. 음료수 선택
        // 4. 메뉴 취소
        // 5. 주문 하기
        //====== 주문 목록 =====
        // 버거: [한우불고기버거]
        // 사이드 : [치즈스틱, 감자튀김]
        // 음료수 : [에이드]
        // 총금액 : 11800
        // 무엇을 하시겠습니까 : 4

        // 어떤 메뉴를 취소하겠습니까?
        // 1. 버거
        // 2. 사이드
        // 3. 음료수
        // 선택 : 2

        // 품목을 선택해주세요.
        // 1. 치즈스틱
        // 2. 감자튀김
        // 선택 : 1
        // 치즈스틱이 취소되었습니다.

        // ================================================================

        // 햄버거 키오스크 v1
        // 1. 햄버거 선택
        // 2. 사이드 선택
        // 3. 음료수 선택
        // 4. 메뉴 취소
        // 5. 주문 하기
        //====== 주문 목록 =====
        // 버거: [한우불고기버거]
        // 사이드 : [감자튀김]
        // 음료수 : [에이드]
        // 총금액 : 9800
        // 무엇을 하시겠습니까 : 5

        // 정말 주문하시겠습니까?(y/n) : y
        // 결제 금액을 입력해주세요 : 20000

        // 영수증 발급하시겠습니까?(y/n) : y

        // ==== 영수증 =====
        // 버거: [한우불고기버거]
        // 사이드 : [감자튀김]
        // 음료수 : [에이드]
        // 총금액 : 9800
        //==================

        // 거스름든 : 10200원
        // 이용해주셔서 감사합니다.

        // ================================================================

        Scanner scan = new Scanner(System.in);
        KioskMachine kiosk = new KioskMachine();

        System.out.println("햄버거 키오스크 v1");
        while (true) {
            System.out.println("1. 햄버거 선택");
            System.out.println("2. 사이드 선택");
            System.out.println("3. 음료수 선택");
            System.out.println("4. 메뉴 취소");
            System.out.println("5. 주문 하기");
            System.out.println("==== 주문 목록 =====");
            System.out.print("버거 : [");
            kiosk.print("cart", kiosk.burgerCart);
            System.out.println("]");
            System.out.print("사이드 : [");
            kiosk.print("cart", kiosk.sideCart);
            System.out.println("]");
            System.out.print("음료수 : [");
            kiosk.print("cart", kiosk.drinkCart);
            System.out.println("]");
            System.out.println("총금액 : " + kiosk.totalPrice);
            System.out.print("무엇을 하시겠습니까 : ");

            int menu = Integer.parseInt(scan.nextLine());

            if (menu == 1) {
                System.out.println("==== 햄버거 목록 ====");
                kiosk.print("menu", kiosk.burgers);

                System.out.print("어떤 버거를 고르시겠습니까 : ");  // 번호로 버거 선택
                int selectNo = Integer.parseInt(scan.nextLine()) - 1;  // 선택한 번호로 버거 가져오기
                kiosk.cartInput(kiosk.burgers, selectNo);

            } else if (menu == 2) {
                System.out.println("==== 사이드 목록=====");
                kiosk.print("menu", kiosk.sides);

                System.out.print("어떤 사이드를 고르시겠습니까 : ");  // 번호로 버거 선택
                int selectNo = Integer.parseInt(scan.nextLine()) - 1;
                kiosk.sideCart.add(kiosk.sides.get(selectNo));

                System.out.println(kiosk.sides.get(selectNo).name + "를 고르셨습니다.");
                kiosk.totalPrice += kiosk.sides.get(selectNo).price;
            } else if (menu == 3) {
                System.out.println("==== 음료수 목록=====");
                kiosk.print("menu", kiosk.drinks);

                System.out.print("어떤 음료수를 고르시겠습니까 : ");  // 번호로 버거 선택
                int selectNo = Integer.parseInt(scan.nextLine()) - 1;
                kiosk.drinkCart.add(kiosk.drinks.get(selectNo));

                System.out.println(kiosk.drinks.get(selectNo).name + "를 고르셨습니다.");
                kiosk.totalPrice += kiosk.drinks.get(selectNo).price;
            } else if (menu == 4) {
                System.out.println("어떤 메뉴를 취소하겠습니까?");
                System.out.println("1. 버거");
                System.out.println("2. 사이드");
                System.out.println("3. 음료수");
                System.out.print("선택 : ");

                int selectNo = Integer.parseInt(scan.nextLine());
                if (selectNo == 1) {
                    kiosk.print("itemSelect", kiosk.burgerCart);

                    selectNo = Integer.parseInt(scan.nextLine()) - 1;
                    System.out.println(kiosk.burgerCart.get(selectNo).name + "이 취소되었습니다.");
                    kiosk.totalPrice -= kiosk.burgerCart.get(selectNo).price;
                    kiosk.burgerCart.remove(kiosk.burgerCart.get(selectNo));
                } else if (selectNo == 2) {
                    kiosk.print("itemSelect", kiosk.sideCart);

                    selectNo = Integer.parseInt(scan.nextLine()) - 1;
                    System.out.println(kiosk.sideCart.get(selectNo).name + "이 취소되었습니다.");
                    kiosk.totalPrice -= kiosk.sideCart.get(selectNo).price;
                    kiosk.sideCart.remove(kiosk.sideCart.get(selectNo));
                } else if (selectNo == 3) {
                    kiosk.print("itemSelect", kiosk.drinkCart);

                    selectNo = Integer.parseInt(scan.nextLine()) - 1;
                    System.out.println(kiosk.drinkCart.get(selectNo).name + "이 취소되었습니다.");
                    kiosk.totalPrice -= kiosk.drinkCart.get(selectNo).price;
                    kiosk.drinkCart.remove(kiosk.drinkCart.get(selectNo));
                }
            } else if (menu == 5) {
                System.out.print("정말 주문하시겠습니까?(y/n) ");
                String order = scan.nextLine();
                if (order.equals("y")) {
                    System.out.print("결재 금액을 입력해주세요 : ");

                    int money = Integer.parseInt(scan.nextLine());

                    if (money >= kiosk.totalPrice) {
                        System.out.print("영수증 발급하시겠습니까?(y/n) ");
                        String receipt = scan.nextLine();

                        if (receipt.equals("y")) {
                            System.out.println("==== 영수증 ====");
                            System.out.print("버거 : [");
                            for (int i = 0; i < kiosk.burgerCart.size(); i++) {
                                if (i == kiosk.burgerCart.size() - 1) {
                                    System.out.print(kiosk.burgerCart.get(i).name);
                                    break;
                                }
                                System.out.print(kiosk.burgerCart.get(i).name + ", ");
                            }
                            System.out.println("]");
                            System.out.print("사이드 : [");
                            for (int i = 0; i < kiosk.sideCart.size(); i++) {
                                if (i == kiosk.sideCart.size() - 1) {
                                    System.out.print(kiosk.sideCart.get(i).name);
                                    break;
                                }
                                System.out.print(kiosk.sideCart.get(i).name + ", ");
                            }
                            System.out.println("]");
                            System.out.print("음료수 : [");
                            for (int i = 0; i < kiosk.drinkCart.size(); i++) {
                                if (i == kiosk.drinkCart.size() - 1) {
                                    System.out.print(kiosk.drinkCart.get(i).name);
                                    break;
                                }
                                System.out.print(kiosk.drinkCart.get(i).name + ", ");
                            }
                            System.out.println("]");
                            System.out.println("총금액 : " + kiosk.totalPrice);
                            System.out.println("================");
                        }
                        System.out.println("거스름돈 : " + (money - kiosk.totalPrice) + "원");
                        System.out.println("이용해주셔서 감사합니다.");
                        break;
                    }
                }
            }
        }
    }
}

class KioskMachine {

    int totalPrice = 0;

    ArrayList<Item> burgers = new ArrayList<>();
    ArrayList<Item> burgerCart = new ArrayList<>();

    ArrayList<Item> sides = new ArrayList<>();
    ArrayList<Item> sideCart = new ArrayList<>();

    ArrayList<Item> drinks = new ArrayList<>();
    ArrayList<Item> drinkCart = new ArrayList<>();

    public KioskMachine() {

        Item b1 = new Item("한우불고기버거", 6000);
        Item b2 = new Item("치즈버거", 3000);
        Item b3 = new Item("치킨버거", 3500);
        Item b4 = new Item("새우버거", 3200);

        burgers.add(b1);
        burgers.add(b2);
        burgers.add(b3);
        burgers.add(b4);

        Item s1 = new Item("감자튀김", 1800);
        Item s2 = new Item("치즈스틱", 2000);
        Item s3 = new Item("치킨너겟", 2500);
        Item s4 = new Item("오징어링", 2700);

        sides.add(s1);
        sides.add(s2);
        sides.add(s3);
        sides.add(s4);

        Item d1 = new Item("콜라", 1000);
        Item d2 = new Item("에이드", 2000);
        Item d3 = new Item("커피", 1500);
        Item d4 = new Item("쉐이크", 2400);

        drinks.add(d1);
        drinks.add(d2);
        drinks.add(d3);
        drinks.add(d4);
    }

    public void print(String type, ArrayList<Item> item) {
        if (type.equals("menu")) {
            for (int i = 0; i < item.size(); i++) {
                System.out.println((i + 1) + ". " + item.get(i).name + " " + item.get(i).price);
            }
        } else if (type.equals("itemSelect")) {
            System.out.println("품목을 선택해주세요.");
            for (int i = 0; i < item.size(); i++) {
                System.out.println((i + 1) + ". " + item.get(i).name);
            }
            System.out.print("선택 : ");
        } else if (type.equals("cart")) {
            for (int i = 0; i < item.size(); i++) {
                if (i == item.size() - 1) {
                    System.out.print(item.get(i).name);
                    break;
                }
                System.out.print(item.get(i).name + ", ");
            }
        }

    }

    public void cartInput(ArrayList<Item> item, int selectNo) {
        item.add(item.get(selectNo));

        System.out.println(item.get(selectNo).name + "를 고르셨습니다.");
        totalPrice += item.get(selectNo).price;
    }
}

//    int totalPrice = 0;
//
//    public void burgerPrint() {
//        System.out.println("==== 햄버거 목록 ====");
//        for (int i = 0; i < burgers.size(); i++) {
//            System.out.println((i + 1) + ". " + burgers.get(i).name + " " + burgers.get(i).price);
//        }
//    }
//
//
//
//    public void totalPrice(int price) {
//        totalPrice += price;
//    }
//
//}

class Item {
    String name;
    int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}