package view;

import camp.nextstep.edu.missionutils.Console;
import controller.CarController;

public class CarView {
    private CarController carController;

    public CarView(CarController carController) {
        this.carController = carController;
    }

    // 시작 메서드
    public void start(){
        inputName();
        int count = inputCount();
        running(count);
        winner(count);
    }

    // 자동차의 이름을 입력 받는다.
    private void inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        carController.inputCheck(input);
    }

    // 몇 번의 이동을 할 것인지 입력 받는다.
    private int inputCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        int count = carController.intCheck(Console.readLine());

        return count;
    }

    // 입력 받은 만큼 실행시키고 전진한 값을 업데이트 후 상태를 보여준다.
    private void running(int count){
        for(int i = 0; i < count; i++){
            carController.update();
            showStatus();
        }
    }

    // 현재 상태 출력
    private void showStatus(){
        carController.showList();
        System.out.println();
    }

    // 우승자들 출력
    private void winner(int max){
        System.out.println("최종 우승자 : "+carController.winner(max));
    }
}
