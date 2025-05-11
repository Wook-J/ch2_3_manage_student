package org.fastcampus.student_management.domain;

public class Student {

  private final String name;
  private final int age;
  private final String address;
  private boolean activated;

  public Student(String name, int age, String address) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("이름은 필수 입력값입니다.");
    }

    this.name = name;
    this.age = age;
    this.address = address;
    this.activated = true;
  }

//  public void setActivated(boolean activated) {
//    if(activated && this.activated){
//      throw new IllegalArgumentException();
//    }
//
//    if(!activated && !this.activated){
//      throw new IllegalArgumentException();
//    }
//    this.activated = activated;
//    // 이대로 로직 구현하면 Exception 처리로 activate와 deactivate에 영향이 감
//  }

  public void activate(){
    if(this.activated){
      throw new IllegalArgumentException();
    }
    this.activated = true;
  }

  public void deactivate(){
    if(!this.activated){
      throw new IllegalArgumentException();
    }
    this.activated = false;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }
  public boolean isActivate() {
    return activated;
  }
}
