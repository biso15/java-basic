package day5.arrayList;

import java.util.ArrayList;

public class Exam2 {
    public static void main(String[] args) {

        // 선언
        // 이름을 저장할 수 있는 ArrayList를 선언하고 만들어주세요.
        ArrayList<String> arrList = new ArrayList<>();

        // add()
        // 리스트에 값을 추가해주세요.
        // "홍길동", "이순신", "황진이", "임꺽정", "강감찬", "을지문덕" 을 ArrayList에 추가 해주세요.
        arrList.add("홍길동");
        arrList.add("이순신");
        arrList.add("황진이");
        arrList.add("임꺽정");
        arrList.add("강감찬");
        arrList.add("을지문덕");

        // size()
        // 리스트의 사이즈를 출력해주시고, 값이 6이 맞다면 계속 진행해주세요.
        // 출력결과 : 6
        System.out.println(arrList.size());

        // get()
        // 리스트의 2,3 인덱스의 값을 출력해주세요.
        // 출력결과 : 황진이, 임꺽정
        System.out.println(arrList.get(2) + ", " + arrList.get(3));

        // 리스트의 모든 값을 출력해주세요.
        // 출력 결과 : 홍길동 이순신 황진이 임꺽정 강감찬 을지문덕
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();

        // remove()
        // 리스트에서 홍길동, 이순신을 지운 뒤, 다시 2,3 인덱스의 값을 출력해주시고 어떤 변화가 있는지 체크해주세요.
        // 출력 결과 : 강감찬, 을지문덕
        arrList.remove(0);
        arrList.remove(0);
        System.out.println(arrList.get(2) + ", " + arrList.get(3));

        // 리스트의 모든 값을 출력해주세요.
        // 출력 결과 : 황진이 임꺽정 강감찬 을지문덕
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();

        // add()
        // 리스트에 정약용을 추가시켜주세요.
        arrList.add("정약용");

        // 리스트의 모든 값을 출력해주세요.
        // 출력 결과 : 황진이 임꺽정 강감찬 을지문덕 정약용
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();

        // set()
        // 임꺽정과 을지문덕을 신사임당과 유관순으로 바꿔주세요.
        for (int i = 0; i < arrList.size(); i++) {  // index를 하나하나 찾기 보다는 반복문으로 확인하는게 좋다
            if (arrList.get(i).equals("임꺽정")) {
                arrList.set(i, "신사임당");
            }

            if (arrList.get(i).equals("을지문덕")) {
                arrList.set(i, "유관순");
            }
        }

        // 리스트의 모든 값을 출력해주세요.
        // 출력 결과 : 황진이 신사임당 강감찬 유관순 정약용
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();

        // 리스트에서 황진이 신사임당 유관순만 출력해주세요.
        // 출력 결과 : 황진이 신사임당 유관순
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i).equals("황진이")) {
                System.out.print(arrList.get(i) + " ");
            }

            if (arrList.get(i).equals("신사임당")) {
                System.out.print(arrList.get(i) + " ");
            }

            if (arrList.get(i).equals("유관순")) {
                System.out.print(arrList.get(i));
            }
        }
    }
}
