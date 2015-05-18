package runetsoft.android.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import runetsoft.android.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelMapper {
  private final Model myModel;
  private final ViewGroup myTarget;
  private final Activity myContext;

  public ModelMapper(Model model, ViewGroup viewGroup, Activity ctx) {
    myModel = model;
    myTarget = viewGroup;
    myContext = ctx;
  }

  public void update() {
    myTarget.removeAllViews();
    for (Message message : myModel.getMessages()) {
      try {
        View v = myContext.getLayoutInflater().inflate(R.layout.item, null);
        ((TextView) v.findViewById(R.id.date)).setText(toHumanReadableDate(message.date));
        ((TextView) v.findViewById(R.id.type)).setText(message.type);
        ((TextView) v.findViewById(R.id.name)).setText(message.name);
        ((TextView) v.findViewById(R.id.description)).setText(message.description);

        myTarget.addView(v);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

  }

  private String toHumanReadableDate(String utcDate) throws ParseException {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    Date date = format.parse(utcDate);
    return DateFormat.getDateTimeInstance().format(date);
    // return format.parse(utcDate).toString();
  }
}
