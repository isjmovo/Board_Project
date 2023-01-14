package com.isjmovo.exam.textboard.controller;

import com.isjmovo.exam.textboard.Container;
import java.util.Scanner;

public abstract class Controller {
  protected Scanner sc;

  public Controller() {
    this.sc = Container.scanner;
  }
}
