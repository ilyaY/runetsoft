package runetsoft.android.http;

import com.turbomanage.httpclient.AsyncCallback;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.ParameterMap;
import com.turbomanage.httpclient.android.AndroidHttpClient;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import runetsoft.android.model.Message;
import runetsoft.android.model.Model;

import java.io.ByteArrayInputStream;

public class HttpService {
  // ToDo insert here
  private static final String USERNAME = "";
  private static final String PASSWORD = "";

  private static final String URL = "http://office.runetsoft.ru:8081/RNSWeb/images/notifiernew.ashx";
  private static final String DATE = "Date";
  private static final String NAME = "Name";
  private static final String DESCRIPTION = "Description";

  private final Model myModel;

  public HttpService(Model model) {
    myModel = model;
  }

  public void update(final Runnable doOnComplete) {
    AndroidHttpClient httpClient = new AndroidHttpClient(URL);
    httpClient.setMaxRetries(5);
    ParameterMap params = httpClient.newParams()
        .add("user", USERNAME)
        .add("password", PASSWORD);
    httpClient.post("", params, new AsyncCallback() {
      @Override
      public void onComplete(HttpResponse httpResponse) {
        try {
          //System.out.println(httpResponse.getBodyAsString());
          doUpdate(httpResponse.getBody());
          doOnComplete.run();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
      @Override
      public void onError(Exception e) {
        e.printStackTrace();
      }
    });
  }

  private void doUpdate(byte[] data) throws Exception {
    myModel.clear();

    Document document = new SAXBuilder().build(new ByteArrayInputStream(data));
    Element root = document.getRootElement();
    for (Object obj : root.getChildren()) {
      Element item = (Element) obj;

      Message message = new Message(item.getChildText(DATE), item.getChildText(NAME), item.getChildText(DESCRIPTION));
      myModel.add(message);
    }
  }
}