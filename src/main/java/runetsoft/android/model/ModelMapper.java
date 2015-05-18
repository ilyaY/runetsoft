package runetsoft.android.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import runetsoft.android.R;

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
      View v = myContext.getLayoutInflater().inflate(R.layout.item, null);
      TextView date = (TextView) v.findViewById(R.id.date);
      date.setText(message.date);
      TextView text = (TextView) v.findViewById(R.id.name);
      text.setText(message.name);
      TextView body = (TextView) v.findViewById(R.id.description);
      body.setText(message.description);

      myTarget.addView(v);
    }

  }
}
