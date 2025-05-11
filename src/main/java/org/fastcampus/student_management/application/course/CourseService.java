package org.fastcampus.student_management.application.course;

import java.util.ArrayList;
import java.util.List;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

public class CourseService {
  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(), courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // TODO: 과제 구현 부분 02.객체 지향 설계 실습 06:30 부근
    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);
    // 간단하게 람다식 사용 : Course로 모인 List를 CourseInfoDto로 반환하는 List
    return courses.stream().map(CourseInfoDto::new).toList();
  }

  public void changeFee(String studentName, int fee) {
    // TODO: 과제 구현 부분 02.객체 지향 설계 실습 19:49 부근
    List<Course> courses = courseRepository.getCourseListByStudent(studentName);
    CourseList courseList = new CourseList(courses);
    courseList.changeAllCoursesFee(fee);

//    CourseList로 이동
//    for(Course course : courses) {
//      if(course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
//        course.changeFee((int) (fee * 1.5));
//      }
//      course.changeFee(fee);
//    }
  }
}
