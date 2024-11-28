package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //学生の名前と点数の管理
    //名前の追加、削除、点数の更新、平均点の計算
    //ループ処理はwhile文
    Scanner scanner = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();

    boolean isFinish = false;

    //「6:プログラム終了」が選ばれたらループ処理を終了
    while (!isFinish) {

      //メニューの選択
      String selectMode = Message.selectMenu();

      Message.printLine();

      //selectModeが数字かどうかチェックする
      boolean isNumber = checkNumber(selectMode);

      //selectModeが数字なら正常に実行
      if (isNumber) {
        switch (Integer.parseInt(selectMode)) {
          //学生情報の追加
          case 1 -> {
            System.out.print("追加する学生の名前を入力してください: ");
            String name = scanner.next();
            System.out.print(name + "の点数を入力してください: ");
            String score = scanner.next();

            //点数が数値で入力されているか
            isNumber = checkNumber(score);

            //数値の場合、正常に実行
            if (isNumber){
              studentManager.createStudent(name, Integer.parseInt(score));
            }else{
              System.out.println("入力が正しくありません。点数は数値を入力してください。");
            }
          }

          //学生情報の削除
          case 2 -> {
            System.out.print("削除する学生の名前を入力してください: ");
            String studentName = scanner.next();
            studentManager.deleteStudent(studentName);
          }

          //点数の更新
          case 3 -> {
            System.out.print("点数の更新をする学生の名前を入力してください: ");
            String studentName = scanner.next();
            System.out.print(studentName + "の新しい点数を入力してください: ");
            String score = scanner.next();

            //点数が数値で入力されているか
            isNumber = checkNumber(score);

            //scoreが数値なら正常に実行
            if (isNumber){
              studentManager.updateScore(studentName, Integer.parseInt(score));
            }else{
              System.out.println("入力が正しくありません。点数は数値を入力してください。");
            }
          }

          //登録している学生の平均点表示
          case 4 -> {
            studentManager.averageScore();
          }

          //学生情報一覧
          case 5 -> {
            studentManager.showStudentList();
          }

          //プログラム終了
          case 6 -> {
            System.out.println("プログラムを終了します。");
            isFinish = true;
          }

          default -> System.out.println("入力が正しくありません。1〜6で選択してください。");

        }
      }else{
        System.out.println("入力が正しくありません。1〜6で選択してください。");
      }
    }
  }

  //数字かどうかチェックする
  public static boolean checkNumber(String number) {
    try {
      //文字列を整数に変換して例外が起こればcatchへ
      Integer.parseInt(number);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
