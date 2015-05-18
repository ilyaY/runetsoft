package runetsoft.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import runetsoft.android.http.HttpService;
import runetsoft.android.model.Model;
import runetsoft.android.model.ModelMapper;

public class Launcher extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    System.out.println("onCreate() YATSISHIN");


    setContentView(R.layout.main);

    final Model model = new Model();


    final LinearLayout container = (LinearLayout) findViewById(R.id.container);
    new HttpService(model).update(new Runnable() {
      @Override
      public void run() {
        new ModelMapper(model, container, Launcher.this).update();
      }
    });
  }
}
