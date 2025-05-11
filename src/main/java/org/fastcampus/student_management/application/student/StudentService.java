package org.fastcampus.student_management.application.student;

import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.StudentRepository;

public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void saveStudent(StudentInfoDto studentInfoDto) {
    Student student = new Student(studentInfoDto.getName(), studentInfoDto.getAge(), studentInfoDto.getAddress());
    studentRepository.save(student);
  }

  public Student getStudent(String name) {
    return studentRepository.findByName(name)
        .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));
  }

  public void activateStudent(String name) {
    // TODO: 과제 구현 부분 02.객체 지향 설계 실습 10:20 부근
    // 이름을 입력받고 있으므로 이름을 통해서 학생 객체를 가져오는 method가 있는 지 StudentRepository 확인
    Student student = getStudent(name);
    student.activate();
  }

  public void deactivateStudent(String name) {
    // TODO: 과제 구현 부분 activateStudent와 같이 처리!
    Student student = getStudent(name);
    student.deactivate();
  }
}
