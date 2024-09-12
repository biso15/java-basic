package last.exceptionHandle;

public class ExceptionHandle2 {

    public static void main(String[] args) {
        try {
            test(1);
            } catch (Exception e) {

        }
    }

    public static void test (int flag) throws Exception {
        // 개발자의 코드 오류같은 경우 말고 네트워크나 파일 오류 같은 경우(개발자가 컨트롤 할 수 없는 경우)는 try - catch를 사용해야 함
        // 예외 직접 발생시키기 -> 테스트 용도 / 어떤 상황에서는 프로그램 진행되는 것보다 강제로 종료시키고 바로 고치는게 나을 수 있다.
        if (flag == 1) {
            throw new Exception();  // ulhandle exception, checked exception => 무조건 try - catch 예외 처리 강제
//            try {
//                throw new Exception();
//            } catch (Exception e) {
//
//            }

        } else if (flag == 2) {
            throw new RuntimeException();  // runtime exception, unchecked exception => 예외처리 안해도 됨
        }

        System.out.println("hihi");
    }
}
