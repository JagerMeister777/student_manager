package org.example;

import java.util.Scanner;

public class Message {

  public static String selectMenu(){

    Scanner scanner = new Scanner(System.in);
    printLine();
    System.out.println("1. 学生を追加");
    System.out.println("2. 学生を削除");
    System.out.println("3. 点数を更新");
    System.out.println("4. 平均点を計算");
    System.out.println("5. 全学生の情報を表示");
    System.out.println("6. 終了");
    printLine();
    System.out.print("選択してください: ");
    return scanner.nextLine();

  }

  //見やすいように境界線を引く
  public static void printLine() {
    System.out.println("=======================================================================");
  }

  //学生情報がない時のメッセージ
  public static void notFoundStudent(String name){
    System.out.println(name + "の情報はありません。");
  }
}
