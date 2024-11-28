package org.example;

import java.util.ArrayList;
import java.util.List;


public class StudentManager {
  List<Student> studentList = new ArrayList<>();

  //学生情報の追加
  public void createStudent(String name, int score) {
    Student student = new Student(name, score);
    studentList.add(student);
  }

  //学生情報の削除
  public  void deleteStudent(String name) {
    //学生情報があれば正常に実行
    if(isFindStudent(name)){
      studentList.removeIf(studentName
          -> studentName.getName().equals(name));
    }else{
      Message.notFoundStudent(name);
    }
  }

  //点数の更新
  public void updateScore(String name, int score){
    //学生情報があれば正常に実行
    if(isFindStudent(name)){
      studentList.stream()
          .filter(student -> student.getName().equals(name))
          .forEach(student -> student.setScore(score));
    }else{
      Message.notFoundStudent(name);
    }
  }

  //平均点の表示
  public void averageScore() {
    //学生情報があれば正常に実行
    if (!studentList.isEmpty()) {
      double result = studentList.stream()
          .mapToDouble(Student::getScore)
          .average().orElse(0);
      System.out.println("平均点: " + Math.round(result) + "点");
    }else{
      System.out.println("学生情報がありません。");
    }
  }

  //学生一覧
  public void showStudentList() {
    //学生情報があれば正常に実行
    if (!studentList.isEmpty()) {
      System.out.println("学生一覧: ");
      studentList.forEach(student
          -> System.out.println(student.getName() + ": " + student.getScore() + "点"));
    }else{
      System.out.println("学生情報がありません。");
    }
  }

  //学生情報がリスト内にあればTrue、なければFalse
  public boolean isFindStudent(String name) {
    List<Student> isFindStudent = studentList.stream()
        .filter(student -> student.getName().equals(name))
        .toList();
    return !isFindStudent.isEmpty();
  }
}
