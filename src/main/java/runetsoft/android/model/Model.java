package runetsoft.android.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
  private final List<Message> myMessages = new ArrayList<Message>();

  public void add(Message message) {
    myMessages.add(message);
  }

  public void clear() {
    myMessages.clear();
  }

  public void reverse() {
    Collections.reverse(myMessages);
  }

  public List<Message> getMessages() {
    return Collections.unmodifiableList(myMessages);
  }
}
