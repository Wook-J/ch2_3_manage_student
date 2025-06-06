package org.fastcampus.student_management.domain;

public class CourseFee {
    // 이런 VO를 쓰면 생기는 장점 : 재사용이 가능하고, 캡슐화가 될 뿐만 아니라 눈에 확 보임

    private int fee;

    public CourseFee(int fee) {
        this.fee = fee;
    }

    public void changeFee(int fee){
        this.fee = fee;
    }

    private void checkFee(int fee){
        if(fee < 0){
            throw new IllegalArgumentException("수강료는 0원 이상이어야 합니다.");
        }
    }

    public int getFee() {
        return fee;
    }
}
