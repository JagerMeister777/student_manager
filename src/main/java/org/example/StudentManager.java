package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class StudentManager {
  List<Student> studentList = new ArrayList<>();

  //学生情報の追加
  public void addStudent(String name, int score) {
    Student student = new Student(name, score);
    studentList.add(student);
  }

  //学生情報の削除
  public void deleteStudent(String name) {
    //学生情報が一致すれば削除
    if(existStudent(name)){
      studentList.removeIf(studentName -> studentName.getName().equals(name));
    }else{
      Message.notFoundStudent(name);
    }
  }

  //点数の更新
  public void updateScore(String name, int score){
    //学生情報があれば点数の更新
    if(existStudent(name)){
      studentList.stream()
          .filter(student -> student.getName().equals(name))
          .forEach(student -> student.setScore(score));
    }else{
      Message.notFoundStudent(name);
    }
  }

  //平均点の表示
  public void averageScore() {
    //平均点の計算
    double result = studentList.stream()
        .mapToDouble(Student::getScore)
        .average().orElse(0);

    //学生情報が一つでもあれば平均点を表示
    if (!studentList.isEmpty()) {
      System.out.println("平均点: " + formatDouble(result) + "点");
    }else{
      System.out.println("学生情報がありません。");
    }
  }

  //学生一覧
  public void showStudentList() {
    //学生情報が一つでもあれば一覧を表示
    if (!studentList.isEmpty()) {
      System.out.println("学生一覧: ");
      studentList.forEach(student
          -> System.out.println(student.getName() + ": " + student.getScore() + "点"));
    }else{
      System.out.println("学生情報がありません。");
    }
  }

  // DecimalFormat を使って小数点第1位まで表示
  public static String formatDouble(double number) {
    DecimalFormat df = new DecimalFormat("0.#");
    return df.format(number);
  }

  //リスト内に学生情報があればTrue、なければFalse
  public boolean existStudent(String name) {
    List<Student> existStudent = studentList.stream()
        .filter(student -> student.getName().equals(name))
        .toList();
    return !existStudent.isEmpty();
  }

  //数値かどうかチェックする
  public boolean isNumber(String number) {
    try {
      //文字列を整数に変換して例外が起こればcatchへ
      Integer.parseInt(number);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
