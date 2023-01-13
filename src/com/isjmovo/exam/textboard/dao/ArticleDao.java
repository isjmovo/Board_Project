package com.isjmovo.exam.textboard.dao;

import com.isjmovo.exam.textboard.Article;
import com.isjmovo.exam.textboard.util.DBUtil;
import com.isjmovo.exam.textboard.util.SecSql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleDao {
  private Connection conn;

  public ArticleDao(Connection conn) {
    this.conn = conn;
  }

  public Article getArticleById(int id) {
    SecSql sql = new SecSql();

    sql.append("SELECT *");
    sql.append("FROM article");
    sql.append("WHERE id = ?", id);

    Map<String, Object> articleMap = DBUtil.selectRow(conn, sql);

    if (articleMap.isEmpty()) {
      return null;
    }

    return new Article(articleMap);
  }

  public int add(String title, String body) {
    SecSql sql = new SecSql();

    sql.append("INSERT INTO article");
    sql.append("SET regDate = NOW(),");
    sql.append("updateDate = NOW(),");
    sql.append("title = ?,", title);
    sql.append("`body` = ?", body);

    return DBUtil.insert(conn, sql);
  }

  public boolean articleExists(int id) {
    SecSql sql = new SecSql();

    sql.append("SELECT COUNT(*) AS cnt");
    sql.append("FROM article");
    sql.append("WHERE id = ?", id);

    return DBUtil.selectRowBooleanValue(conn, sql);
  }

  public void delete(int id) {
    SecSql sql = new SecSql();

    sql.append("DELETE FROM article");
    sql.append("WHERE id = ?", id);

    DBUtil.delete(conn, sql);
  }

  public void update(int id, String title, String body) {
    SecSql sql = new SecSql();

    sql.append("UPDATE article");
    sql.append("SET updateDate = NOW(),");
    sql.append("title = ?,", title);
    sql.append("`body` = ?", body);
    sql.append("WHERE id = ?", id);

    DBUtil.update(conn, sql);
  }

  public List<Article> getArticles() {
    SecSql sql = new SecSql();

    sql.append("SELECT *");
    sql.append("FROM article");
    sql.append("ORDER BY id DESC");

    List<Map<String, Object>> articleListMap = DBUtil.selectRows(conn, sql);
    List<Article> articles = new ArrayList<>();

    for (Map<String, Object> articleMap : articleListMap) {
      articles.add(new Article(articleMap));
    }

    return articles;
  }
}
