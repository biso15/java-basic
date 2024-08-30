package day5.arrayList;

import java.util.ArrayList;

// {5,4,3,2,1,0}을 ArrayList에 추가 해주세요.
// ArrayList의 사이즈를 출력해주세요.
// ArrayList의 3,4번째 값을 읽어서 출력해주세요. (인덱스 X, 1부터 )
// 1,2번째 값을 지운 뒤, 다시 3,4번째 값을 출력해주세요
// List의 모든 값을 출력해주세요.

public class Exam1 {
    public static void main(String[] args) {

        // 정수를 저장할 수 있는 ArrayList를 선언하고 만들어주세요.
        // 리스트에 값을 추가해주세요.
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(5);
        arrList.add(4);
        arrList.add(3);
        arrList.add(2);
        arrList.add(1);
        arrList.add(0);

        // size()
        // 리스트의 사이즈를 출력해주시고, 값이 6이 맞다면 계속 진행해주세요.
        // 출력결과 : 6
        System.out.println(arrList.size());

        // get()
        // 리스트의 3,4번째 값을 출력해주세요.
        // 출력결과 : 3, 2
        System.out.println(arrList.get(2) + ", " + arrList.get(3));

        // remove()
        // 리스트의 1,2번째 값을 지운 뒤, 다시 3,4번째 값을 출력해주시고 어떤 변화가 있는지 체크해주세요.
        // 출력 결과 : 1, 0
        arrList.remove(0);
        arrList.remove(0);  // 1번을 지우면 2번이 1번이 되므로 2번이 아니라 1번을 지워야 됨
        System.out.println(arrList.get(2) + ", " + arrList.get(3));

        // 반복문으로 출력.
        //
        // 리스트의 모든 값을 출력해주세요.
        // 출력 결과 : 3, 2, 1, 0
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + ", ");
        }
    }
}
