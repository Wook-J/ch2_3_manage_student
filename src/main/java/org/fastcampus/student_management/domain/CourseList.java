package org.fastcampus.student_management.domain;

import java.util.List;

/* 1급 컬렉션
* 장점
* - 로직을 한눈에 파악하기 쉽다(메서드 명으로만 로직 파악이 용이)
* - 재사용이 가능함(VO에서 다뤘던 것과 비슷)
* - 테스트가 쉬워짐
* */
public class CourseList {

    private final List<Course> courses;

    public CourseList(List<Course> courses) {
        this.courses = courses;
    }

    public void changeAllCoursesFee(int fee){
        for(Course course : courses){
            if(course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
                course.changeFee((int) (fee * 1.5));
            }
            course.changeFee(fee);
        }
    }
}
