package com.isjmovo.exam.textboard.service;

import com.isjmovo.exam.textboard.Container;
import com.isjmovo.exam.textboard.dao.MemberDao;
import com.isjmovo.exam.textboard.dto.Member;

public class MemberService {
  private MemberDao memberDao;

  public MemberService() {
    memberDao = Container.memberDao;
  }

  public boolean isLoginedDup(String loginId) {
    return memberDao.isLoginedDup(loginId);
  }

  public int join(String loginId, String loginPw, String name) {
    return memberDao.join(loginId, loginPw, name);
  }

  public Member getMemberByLoginId(String loginId) {
    return memberDao.getMemberByLoginId(loginId);
  }
}
