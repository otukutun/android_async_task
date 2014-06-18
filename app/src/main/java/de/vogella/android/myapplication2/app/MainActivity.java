package de.vogella.android.myapplication2.app;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity{
    static String api = "http://api.nanapi.jp/v1/recipeSearchDetails/?key=4b542e23e43f6&format=json";
    Context mActivity;
    private String[] items = {"a","a","f","f"};
    //private String[] items;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listView = (ListView) findViewById(R.id.listView);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        //listView.setAdapter(adapter);
        //String str = this.httpGetMethod(api);
        //Log.v("TAG","a");
        //asyncGet.execute("http://alpacat.com/");
        AsyncGet asyncGet = new AsyncGet(new AsyncCallback() {
            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(String result) {
                try {
                    mActivity = MainActivity.this;
                    ArrayList<String> list = new ArrayList<String>();
                    JSONObject  json = new JSONObject(result);
                    JSONArray jsonArray = json.getJSONObject("response").getJSONArray("recipes");
                    for (int i = 0; i< jsonArray.length(); i++) {
                        String title = jsonArray.getJSONObject(i).getString("title");
                        list.add(title);
                        //System.out.println(jsonObject.getString("title"));
                    }
                    listView = (ListView) findViewById(R.id.listView);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mActivity,android.R.layout.simple_list_item_1,list);
                    listView.setAdapter(adapter);
                } catch (Exception e) {

                }


            }

            @Override
            public void onProgressUpdate(int progress) {

            }

            @Override
            public void onCancelled() {

            }
        });
        /*ArrayList<String> list = new ArrayList<String>();
        try {
        JSONObject json = new JSONObject(str);
        JSONArray jsonArray = json.getJSONObject("response").getJSONArray("recipes");
        for (int i = 0; i< jsonArray.length(); i++) {
            String title = jsonArray.getJSONObject(i).getString("title");
            list.add(title);
            //System.out.println(jsonObject.getString("title"));
        }
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        } catch (Exception e) {

        }*/

        asyncGet.execute(api);
    }

    public void onClick(View view) {
        //asyncGet.execute(api);
        AsyncGet asyncGet = new AsyncGet(new AsyncCallback() {
            @Override
            public void onPreExecute() {

            }

            @Override
            public void onPostExecute(String result) {
                try {
                    mActivity = MainActivity.this;
                    ArrayList<String> list = new ArrayList<String>();
                    JSONObject  json = new JSONObject(result);
                    JSONArray jsonArray = json.getJSONObject("response").getJSONArray("recipes");
                    for (int i = 0; i< jsonArray.length(); i++) {
                        String title = jsonArray.getJSONObject(i).getString("title");
                        list.add(title);
                        //System.out.println(jsonObject.getString("title"));
                    }
                    listView = (ListView) findViewById(R.id.listView);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mActivity,android.R.layout.simple_list_item_1,list);
                    listView.setAdapter(adapter);
                } catch (Exception e) {

                }


            }

            @Override
            public void onProgressUpdate(int progress) {

            }

            @Override
            public void onCancelled() {

            }
        });
        asyncGet.execute(api);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String httpGetMethod(String... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(params[0]);
        HttpResponse httpResponse;
        try {
            httpClient.execute(httpGet);
        } catch (Exception e) {
            Log.d("HttpSampleActivity", "Error Execute");
        }
        try {
            /*HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(outputStream);
                return outputStream.toString();
            }*/
        } catch ( Exception e) {
            return null;
        }
        return null;
    }


}
