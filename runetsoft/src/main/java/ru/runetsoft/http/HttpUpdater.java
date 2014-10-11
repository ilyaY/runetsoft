package ru.runetsoft.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

public class HttpUpdater {
  private static final String ourServerUrl = "http://office.runetsoft.ru:8080/rnswebdebug/Images/NotifierNew.xml";

  public void update() {
    AsyncHttpClient client = new AsyncHttpClient();
    client.get(ourServerUrl, new AsyncHttpResponseHandler() {
      @Override
      public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String response = new String(responseBody);
        System.out.println(response);
      }

      @Override
      public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        error.printStackTrace();
      }
    });
  }
}
