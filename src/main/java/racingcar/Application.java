package racingcar;

import camp.nextstep.edu.missionutils.Console;
import controller.CarController;
import view.CarView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController carController = new CarController();
        CarView carView = new CarView(carController);

        carView.start();
    }
}
