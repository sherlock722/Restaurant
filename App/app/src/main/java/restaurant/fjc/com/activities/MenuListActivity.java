package restaurant.fjc.com.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import restaurant.fjc.com.model.Menu;
import restaurant.fjc.com.model.MenuContent;
import restaurant.fjc.com.restaurant.R;

public class MenuListActivity extends AppCompatActivity {

    private URL mUrl;
    private ProgressBar mProgress;
    private Menu mMenu;
    //private ArrayAdapter mMenuArrayAdapter;
    private ArrayAdapter<MenuContent> mMenuArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        //Acceso a las vistas
        //ToolBar
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Le decimos a nuestra actividad que queremos usar esa vista toolbar como nuestra ToolBar
        //setSupportActionBar(toolbar);

        //Se monta la URL
        try {
            //mUrl = new URL("http://www.mocky.io/v2/57326b1a0f00007913ead755");
            mUrl = new URL("http://www.mocky.io/v2/571404851000008423a413f4");
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        mProgress = (ProgressBar) findViewById(R.id.menu_download_progress);
        downloadMenu();
    }

    private void downloadMenu() {

        AsyncTask<URL, Integer, String> menuDownloader = new AsyncTask<URL, Integer, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(URL... params) {

                URL url = params[0];
                InputStream input = null;
                String jsonString = new String("");

                try {

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    int responseLength = connection.getContentLength();
                    byte data[] = new byte[1024];
                    long currentBytes = 0;
                    int downloadedBytes;
                    input = connection.getInputStream();
                    StringBuilder sb = new StringBuilder();
                    while ((downloadedBytes = input.read(data)) != -1) {
                        sb.append(new String(data, 0, downloadedBytes));
                        if (responseLength > 0) {
                            currentBytes += downloadedBytes;

                        }
                    }
                    Log.v("JSON", "JSON Downloaded");
                    jsonString = sb.toString();


                } catch (Exception ex) {
                    Log.v("JSONError", "JSON Downloaded");
                    ex.printStackTrace();
                }

                return jsonString;
            }

            @Override
            protected void onPostExecute(String jsonString) {
                super.onPostExecute(jsonString);

                try {
                    // Process JSON
                    JSONObject jsonRoot = new JSONObject(jsonString);
                    //JSONArray menuContents = jsonRoot.getJSONArray("contentMenu");
                    JSONArray menuContents = jsonRoot.getJSONArray("dishes");

                    for (int i = 0; i < menuContents.length(); i++) {
                        JSONObject menuContent = menuContents.getJSONObject(i);
                        String name = menuContent.getString("name");
                        String description = menuContent.getString("description");
                        Float price = Float.valueOf(menuContent.getString("price"));
                        //ArrayList<String> allergens = new ArrayList<>();
                        //JSONArray jsonAllergens = menuContent.getJSONArray("allergens");
                        /*for (int j = 0; j < jsonAllergens.length(); j++) {
                            allergens.add(jsonAllergens.getString(j));
                        }*/

                        String imageURL = menuContent.getString("image");

                        //mMenu.addMenuContent(new MenuContent(name, description, price, imageURL));
                        //mMenuArrayAdapter.notifyDataSetChanged();
                    }

                    Log.v("JSON", "JSON Parsed");

                } catch (JSONException ex) {
                    ex.printStackTrace();
                }

                mProgress.setAlpha(0);
            }
        };

        menuDownloader.execute(mUrl);
    }
}
