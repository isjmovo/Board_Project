package com.isjmovo.exam.textboard;

public class Member {
  public int id;
  public String regDate;
  public String updateDate;
  public String loginId;
  public String loginPw;
  public String name;

  public Member(int id, String regDate, String updateDate, String loginId, String loginPw, String name) {
    this.id = id;
    this.regDate = regDate;
    this.updateDate = updateDate;
    this.loginId = loginId;
    this.loginPw = loginPw;
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("{id : %d, regDate: %s, updateDate: %s, loginId : \"%s\", loginPw : \"%s\", name : \"%s\"}", id, regDate, updateDate, loginId, loginPw, name);
  }
}

