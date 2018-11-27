package edu.illinois.cs.cs125.lab11;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Lab11:Main";

    /** Request queue for our API requests. */
    private static RequestQueue requestQueue;
    /**
     * Run when this activity comes to the foreground.
     */
    private ImageButton click;
    /**
     * asd.
     */
    /**
     * asd.
     */
    public static TextView city;
    public static TextView country;
    public static TextView descrip;
    public static TextView temp;
    public static TextView small;
    public static TextView big;
    public static TextView flood;
    public static ImageView beauty;

    @Override
    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        // Set up the queue for our API requests
        requestQueue = Volley.newRequestQueue(this);

        setContentView(R.layout.activity_main);
//        final Button mybutton = findViewById(R.id.button);
//        mybutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View v) {
//                startAPICall("192.17.96.8");
//            }
//        });
        final EditText textInputCity = (EditText) findViewById(R.id.needCity);
        city = (TextView) findViewById(R.id.City);
        country = (TextView) findViewById(R.id.Country);
        descrip = (TextView) findViewById(R.id.main);
        temp = (TextView) findViewById(R.id.temp);
        small = (TextView) findViewById(R.id.min);
        big = (TextView) findViewById(R.id.max);
        flood = (TextView) findViewById(R.id.humidity);
        beauty = (ImageView) findViewById(R.id.weather);

        click = (ImageButton) findViewById(R.id.clickme);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fetchData process = new fetchData();
                process.execute();
            }
        });



    }
//    public void find_weather() {
//            public void OnResponse(final JSONObject response) {
//                try {
//                    JSONObject main_object = response.getJSONObject("main");
//                    JSONArray array = response.getJSONArray("weather");
//                    JSONObject object = array.getJSONObject(0);
//                    String temp = String.valueOf(main_object.getDouble("temp"));
//                    String description = object.getString("description");
//                    String city = response.getString("name");
//
//                    t1_temp.setText(temp);
//                    t2_city.setText(city);
//                    t3_description.setText(description);
//
//                    Calendar calendar = Calendar.getInstance();
//                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE=MM-dd");
//                    String formatted_data = sdf.format(calendar.getTime());
//
//                    t4_date.setText(formatted_data);
//
//                    double temp_int = Double.parseDouble(temp);
//                    double centi = (temp_int - 32) / 1.8;
//                    centi = Math.round(centi);
//                    int i = (int) centi;
//                    t1_temp.setText(String.valueOf(i));
//                } catch(JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }
//        );
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(jor);
//    }

    /**
     * Run when this activity is no longer visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Make a call to the IP geolocation API.
     *
     * @param ipAddress IP address to look up
     */
    void startAPICall(final String ipAddress) {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://ipinfo.io/" + ipAddress + "/json",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            apiCallDone(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(final VolleyError error) {
                            Log.e(TAG, error.toString());
                        }
                    });
            jsonObjectRequest.setShouldCache(false);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handle the response from our IP geolocation API.
     *
     * @param response response from our IP geolocation API.
     */
    void apiCallDone(final JSONObject response) {
        try {
            Log.d(TAG, response.toString(2));
            // Example of how to pull a field off the returned JSON object
            Log.i(TAG, response.get("hostname").toString());
            final TextView myresult = findViewById(R.id.City);
            myresult.setText(response.toString(2));
        } catch (JSONException ignored) { }
    }
}
