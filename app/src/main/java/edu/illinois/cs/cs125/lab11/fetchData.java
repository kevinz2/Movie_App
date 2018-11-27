package edu.illinois.cs.cs125.lab11;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * asd.
 */
public class fetchData extends AsyncTask<Void, Void, Void> {
    /**
     * asd.
     */
    private String data = "";
    /**
     * asd.
     */
    private String dataParsed = "";
    /**
     * asd.
     */
    private String singleParsed = "";
    private String mycountry = "";
    private String temperature = "";
    private String little = "";
    private String huge = "";
    public String situation = "";
    private String water = "";
    public int id;
    /**
     * asd.
     */
    private String input;

    /**
     * asd.
     * @param temp
     */
    fetchData(final String temp) {
        input = temp;
    }

    /**
     * asd.
     */
    fetchData() {
    }
    @Override
    /**
     * asd.
     * @param voids
     * @return
     */
    protected Void doInBackground(final Void... voids) {
        try {
            URL url = new URL("http://www.omdbapi.com/?i=tt3896198&apikey=b2ac4536");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data += line;
            }
            JSONObject js = new JSONObject(data);
            water += "Title:" + js.getString("Title");
//            JSONArray array = js.getJSONArray("weather");
//            singleParsed += "City: ";
//            singleParsed = singleParsed + (String) js.getString("name") + "\n";
//            water += (String) js.getJSONObject("main").getString("humidity") + "%";
//            mycountry += (String) js.getJSONObject("sys").getString("country") + "\n";
//            for (int i = 0; i < array.length(); i++) {
//                situation += array.getJSONObject(i).getString("main") + "\n";
//                id = array.getJSONObject(i).getInt("id");
//            }
//            temperature += (String) js.getJSONObject("main").getString("temp")
//                    +  "\u00b0" + "F" + "\n";
//            little += (String) js.getJSONObject("main").getString("temp_min")
//                    + "\u00b0" + "F" + "\n";
//            huge += (String) js.getJSONObject("main").getString("temp_max")
//                    + "\u00b0" + "F" + "\n";
//            dataParsed = dataParsed + singleParsed;
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(final Void aVoid) {
        super.onPostExecute(aVoid);
//        if (this.mycountry.isEmpty()) {
//            MainActivity.city.setText("City is not found");
//        } else {
//            MainActivity.city.setText(this.input);
//        }
//        MainActivity.country.setText(this.mycountry);
//        MainActivity.descrip.setText(this.situation);
//        MainActivity.temp.setText(this.temperature);
//        MainActivity.small.setText(this.little);
//        MainActivity.big.setText(this.huge);
        MainActivity.flood.setText(this.water);

    }
}
