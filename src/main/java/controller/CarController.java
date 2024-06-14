package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.CarDTO;

import java.util.ArrayList;

public class CarController {
    private ArrayList<CarDTO> list = new ArrayList<>();

    // 입력받은 자동차의 이름이 5자 이하이면 자동차의 모델을 만든다.
    public void inputCheck(String name){
        String[] result = name.split(",");
        for(int i = 0; i < result.length; i++){
            if(result[i].length() <= 5){
                CarDTO carDTO = new CarDTO();
                carDTO.setCarname(result[i]);
                carDTO.setCount("");
                list.add(carDTO);
            }else{
                throw new IllegalArgumentException();
            }
        }
    }

    // 입력받은 회수가 숫자인지 체크하다
    public int intCheck(String count){
        try {
            int su = Integer.parseInt(count);
            return su;
        } catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    // 자동차의 전진하는 조건
    public String running(){
        int random = Randoms.pickNumberInRange(0,9);
        String result = "";
        if(random <= 4){
            result = "-";
        }

        return result;
    }

    // 자동차가 전진하고 값 업데이트
    public void update(){
        for(CarDTO c : list){
            c.setCount(c.getCount() + running());
        }
    }

    // 현재 자동차의 상태를 보여준다.
    public void showList(){
        for(CarDTO c : list){
            System.out.printf("%s : %s\n", c.getCarname(), c.getCount());
        }
    }
    // 우승자들 목록 반환;
    public String winner(int max){
        String result = "";
        for(CarDTO c : list){
            if(c.getCount().length() == max){
                result += c.getCarname() + "/";
            }
        }

        return winnerDataProcessing(result);
    }

    // 우승자의 데이터 가공
    public String winnerDataProcessing(String winners){
        String[] result = winners.split("/");
        String winner = "";
        for(int i = 0; i < result.length; i++){
            if(i == result.length - 1){
                winner += result[i];
            } else{
                winner += result[i] + ", ";
            }
        }

        return winner;
    }
}
