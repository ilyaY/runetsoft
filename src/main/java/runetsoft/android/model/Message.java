package runetsoft.android.model;

public class Message {
  public final String date;
  public final String type;
  public final String name;
  public final String description;

  public Message(String date, String type, String name, String description) {
    this.date = date;
    this.type = type;
    this.name = name;
    this.description = description;
  }
}
