package com.isjmovo.exam.textboard.dto;

import java.util.Map;

public class Article {
  public int id;
  public String regDate;
  public String updateDate;
  public int memberId;
  public int hit;
  public String title;
  public String body;
  public String extra__writerName;

  public Article(Map<String, Object> articleMap) {
    this.id = (int) articleMap.get("id");
    this.regDate = (String) articleMap.get("regDate");
    this.updateDate = (String) articleMap.get("updateDate");
    this.memberId = (int) articleMap.get("memberId");
    this.hit = (int) articleMap.get("hit");
    this.title = (String) articleMap.get("title");
    this.body = (String) articleMap.get("body");

    if (articleMap.get("extra__writerName") != null) {
      this.extra__writerName = (String) articleMap.get("extra__writerName");
    }
  }

  @Override
  public String toString() {
    return String.format("{id : %d, regDate: %s, updateDate: %s, memberId : %s, hit : %d, title : %s, body : %s}", id, regDate, updateDate, memberId, hit, title, body);
  }
}