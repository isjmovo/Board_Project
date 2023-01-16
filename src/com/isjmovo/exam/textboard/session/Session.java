package com.isjmovo.exam.textboard.session;

import com.isjmovo.exam.textboard.dto.Member;

public class Session {
  public int loginMemberId;
  public Member loginMember;

  public Session() {
    loginMemberId = -1;
  }

  public void login(Member member) {
    loginMemberId = member.id;
    loginMember = member;
  }

  public boolean isLogined() {
    return loginMemberId != -1;
  }

  public void logout() {
    loginMemberId = -1;
    loginMember = null;
  }
}
