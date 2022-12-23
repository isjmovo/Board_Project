public class Article {
  public int id;
  public String title;
  public String body;

  public Article (int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public String toString() {
    return String.format("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
  }
}
