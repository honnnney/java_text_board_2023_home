package com.ksh.exam.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);



    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    int articleLastId = 0;
    Article lastArticle = null;

    while (true){
      System.out.printf("명령) ");
      String cmd = scanner.nextLine();

      if (cmd.equals("/usr/article/write")){
        System.out.println("== 게시물 등록 ==");
        System.out.printf("제목 : ");
        String title = scanner.nextLine();
        System.out.printf("내용 : ");
        String body = scanner.nextLine();
        int id = articleLastId + 1;
        articleLastId++;

        Article article = new Article(id, title, body);
        lastArticle = article;
        System.out.println("생성 된 게시물 객체 : " + article);

        System.out.printf("%d번 게시물이 등록되었습니다.\n", article.id);
      }

      else if (cmd.equals("/usr/article/detail")){

        if (lastArticle == null){
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }
        Article article = lastArticle;


        System.out.println("- 게시물 상세보기 -");
        System.out.printf("번호 : %d\n", article.id);
        System.out.printf("제목 : %s\n", article.title);
        System.out.printf("내용 : %s\n", article.body);
      }


      else if (cmd.equals("exit")){
        break;
      }
      else {
        System.out.printf("입력된 명령어 : %s\n", cmd);
      }
    }

    System.out.println("== 프로그램 종료 ==");
    scanner.close();
  }
}

class Article {
  String title;
  String body;
  int id;

  public Article(int id, String title, String body){
    this.id = id;
    this.title = title;
    this.body = body;
  }

  @Override
  public String toString() {
    return String.format("{id: %d, title: %s, body: %s}", id, title, body);
  }
}