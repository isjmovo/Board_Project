package com.isjmovo.exam.textboard;

import com.isjmovo.exam.textboard.exception.SQLErrorException;

public class Main {
  public static void main(String[] args) {
    try {
      new App().run();
    } catch (SQLErrorException e) {
      System.out.println(e.getMessage());
      e.getOrigin().printStackTrace();
    }
  }
}