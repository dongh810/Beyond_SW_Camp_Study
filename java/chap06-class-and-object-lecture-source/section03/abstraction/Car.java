package com.ohgiraffers.section03.abstraction;

public class Car {

    private boolean isOn = false;

    private int speed;

    /* 설명. 시동이 걸려있는 상태인 경우에는 할 일이 없고, 시동이 걸려있지 않은 상태인 경우 시동을 건다. */
    public void startUp() {
        if(this.isOn) {      // 시동이 걸려있으면
            System.out.println("이미 시동이 걸려 있습니다.");
        } else {        // 시동이 걸려 있지 않다면
            this.isOn = true; //isOn 앞에는 this. 이 있는 거지만 this.을 생략해도 자동으로 적힌다.
            System.out.println("시동을 걸었습니다. 부릉부릉~");
        }
    }

    /* 설명. 시동이 걸린 상태인 경우에만 호출시마다 10km/h씩 속도를 증가시킨다. */
    public void go() {
        if(isOn) {          // 시동이 켜져있어 달릴 수 있음.
            System.out.println("차가 앞으로 움직입니다.");
            speed += 10;
            System.out.println("현재 차의 시속은 " + speed + "km/h 입니다.");
        } else {            // 시동이 꺼져있어 달릴 수 없음
            System.out.println("차의 시동이 걸려있지 않습니다. 시동을 먼저 걸어주세요.");
        }
    }

    /* 설명. 시동이 걸려있고 달리는 상태인 경우에만 멈출 수 있다.*/
    public void stop() {
        if(isOn) {
            if(speed > 0) {
                speed = 0;
                System.out.println("급 브레이크를 밟았습니다. 차를 멈춥니다.");
            } else{
                System.out.println("차는 이미 멈춰있는 상태입니다.");
            }
        } else {
            System.out.println("차의 시동이 걸려있지 않았습니다. 시동을 먼저걸어주세요.");
        }
    }

    /* 설명. 시동이 걸려있는 상태인경우 시동을 끄고, 이미 꺼진 상태라면 끌 수 있고 주행중이라면 끌 수 없다. */
    public void turnOff() {
        if(isOn) {
            if(speed > 0){
                System.out.println("달리는 상태에서 시동을 끌 수 없습니다. 차를 우선 멈춰주세요.");
            } else {
                isOn = false;
                System.out.println("시동을 끕니다. 다시 운행하시려면 시동을 켜 주세요!~ ");
            }
        } else {
            System.out.println("이미 시동이 꺼져 있는 상태입니다. 시동 상태를 확인해 주세요.");
        }
    }
}
