package runetsoft.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Launcher extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    System.out.println("nCreate() YATSISHIN");


    setContentView(R.layout.main);
    System.out.println(findViewById(R.id.container));

    LinearLayout container = (LinearLayout) findViewById(R.id.container);
    for (int i = 0; i < 100; i++) {

      TextView text = new TextView(this);
      text.setText("yatsishin-" + i);

      container.addView(text);

    }
  }
}
