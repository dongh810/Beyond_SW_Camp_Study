package com.ohgiraffers.section03.abstraction;

public class CarRacer {

    /* 설명. 차 한대(Car 객체하나)를 필드로 가진다. */
    private Car myCar = new Car();

    /* 설명. 자신이 보유한 차량에 시동을 건다. */
    public void startUp() {
        this.myCar.startUp();
    }

    public void stepAccelator() {
        myCar.go();
    }

    public void stepBreak() {
        myCar.stop();
    }

    public void turnOff() {
        myCar.turnOff();
    }
}
