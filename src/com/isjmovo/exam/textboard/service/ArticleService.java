package com.isjmovo.exam.textboard.service;

import com.isjmovo.exam.textboard.Container;
import com.isjmovo.exam.textboard.dto.Article;
import com.isjmovo.exam.textboard.dao.ArticleDao;

import java.util.List;

public class ArticleService {
  private ArticleDao articleDao;

  public ArticleService() {
    articleDao = Container.articleDao;
  }

  public int add(String title, String body) {
    return articleDao.add(title, body);
  }

  public boolean articleExists(int id) {
    return articleDao.articleExists(id);
  }

  public void delete(int id) {
    articleDao.delete(id);
  }

  public Article getArticleById(int id) {
    return articleDao.getArticleById(id);
  }

  public void update(int id, String title, String body) {
    articleDao.update(id, title, body);
  }

  public List<Article> getArticles() {
    return articleDao.getArticles();
  }
}
