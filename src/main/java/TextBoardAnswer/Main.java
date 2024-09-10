package TextBoardAnswer;

import TextBoardAnswer.controller.BoardApp;

public class Main {

    // 핵심 로직을 main 메서드에 작성하지 않는다.
    public static void main(String[] args) {
        BoardApp app = new BoardApp();
        app.start();
    }
}
