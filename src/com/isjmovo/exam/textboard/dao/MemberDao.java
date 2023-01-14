package com.isjmovo.exam.textboard.dao;

import com.isjmovo.exam.textboard.Container;
import com.isjmovo.exam.textboard.dto.Member;
import com.isjmovo.exam.textboard.util.DBUtil;
import com.isjmovo.exam.textboard.util.SecSql;

import java.util.Map;

public class MemberDao {
  public boolean isLoginedDup(String loginId) {
    SecSql sql = new SecSql();

    sql.append("SELECT COUNT(*) > 0");
    sql.append("FROM `member`");
    sql.append("WHERE loginId = ?", loginId);

    return DBUtil.selectRowBooleanValue(Container.conn, sql);
  }

  public int join(String loginId, String loginPw, String name) {
    SecSql sql = new SecSql();

    sql.append("INSERT INTO `member`");
    sql.append("SET regDate = NOW(),");
    sql.append("updateDate = now(),");
    sql.append("loginId = ?,", loginId);
    sql.append("loginPw = ?,", loginPw);
    sql.append("name = ?", name);

    return DBUtil.insert(Container.conn, sql);
  }

  public Member getMemberByLoginId(String loginId) {
    SecSql sql = new SecSql();

    sql.append("SELECT *");
    sql.append("FROM `member`");
    sql.append("WHERE loginId = ?", loginId);

    Map<String, Object> memberMap = DBUtil.selectRow(Container.conn, sql);

    if (memberMap.isEmpty()) {
      return null;
    }

    return new Member(memberMap);
  }
}
