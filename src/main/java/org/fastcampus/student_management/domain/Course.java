package org.fastcampus.student_management.domain;

public class Course {
  private final Student student;
  private final String courseName;
  private CourseFee fee;
  private final DayOfWeek dayOfWeek;
  private final Long courseTime;

  /* 기존 int fee 에서 CourseFee로 변경
  * 1.수강료 라는 것이 한번에 확인이 됨
  * 2. 만약 다른 객체에서도 수강료를 사용하게 된다면 같은 유효성 검사를 중복해서 하지 않아도 됨
  * */

  public Course(Student student, String courseName, int fee, DayOfWeek dayOfWeek, Long courseTime) {
    if (student == null) {
      throw new IllegalArgumentException("학생은 필수 입력값입니다.");
    }

    this.student = student;
    this.courseName = courseName;
    this.fee = new CourseFee(fee);
    this.dayOfWeek = dayOfWeek;
    this.courseTime = courseTime;
  }

  public void changeFee(int fee){
    this.fee.changeFee(fee);
  }

  public String getCourseName() {
    return courseName;
  }

  public boolean isSameDay(DayOfWeek dayOfWeek) {
    return this.dayOfWeek.equals(dayOfWeek);
  }

  public boolean isActivateUser() {
    return student.isActivate();
  }

  public String getStudentName() {
    return student.getName();
  }

  public int getFee() {
    return this.fee.getFee();
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public Long getCourseTime() {
    return courseTime;
  }
}
