package day5.arrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListInit {

}

class Test {

    // 명령 코드 => 연산은 class에서 실행 불가능 => 연산은 메서드에서만 가능
    // a = 20; -> 대입연산
    // a++; -> 증가연산
    // System.out.println("안녕"); -> 출력연산

    // class에서는 변수선언, 메서드 정의만 사용 가능
    // int a = 20; -> 선언과 동시에 초기화는 가능
    // ArrayList도 마찬가지로 선언만 가능하고 대입이 안되므로 선언과 동시에 초기화를 해야 함


    int a = 10; // 변수 선언 => 선언과 동시에 초기화

    ArrayList<String> list = new ArrayList<>();  // ArrayList 선언
    ArrayList<String> list2 = new ArrayList<>() {{
        add("apple");
        add("banana");
    }}; // ArrayList 선언과 동시에 초기화

    int[] arr = new int[5];  // array 선언
    int[] arr2 = {1,2,3,4,5}; // 선언과 동시에 1,2,3,4,5를 대입


    // ArrayList 초기화 방법1
    ArrayList<String> names1 = new ArrayList<>() {{
        add("콜라");
        add("사이다");
        add("커피");
    }};
    ArrayList<Integer> prices1 = new ArrayList<>() {{
        add(1000);
        add(1200);
        add(800);
    }};
    ArrayList<Integer> quantities1 = new ArrayList<>() {{
        add(1);
        add(2);
        add(1);
    }};

    // ArrayList 초기화 방법2
    ArrayList<String> names2 = new ArrayList<>(Arrays.asList("콜라", "사이다", "커피"));
    ArrayList<Integer> prices2 = new ArrayList<>(Arrays.asList(1000, 1200, 800));
    ArrayList<Integer> quantities2 = new ArrayList<>(Arrays.asList(1, 2, 1));
}