package com.refectoring.effectivejava.eff.staticfactorymethod;

public enum OrderStatus {
    // 상수 목록을 담을 수 있는 데이터 타입
    // 특정한 변수가 가질 수 있는 값을 제한할 수 있음(Type-Safety)
    // JVM 레벨(자바프로그램이 가상머신에서 돌아가기 위한 단계)에서 하나의 인스턴스만 있음을 보장하기 때문에 == 연산자를 사용,
    // equals 를 사용하면 NullPointException 을 피할 수 없음

    PREPARING(1), SHIPPED(2), DELIVERING(3), DELIVERED(4);

    int cnt;
    OrderStatus(int cnt) {
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }
}
