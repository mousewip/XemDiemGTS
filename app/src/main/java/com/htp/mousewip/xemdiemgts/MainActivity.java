package com.htp.mousewip.xemdiemgts;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<HocPhan> mang;
    ListView lv;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        context = getApplicationContext();
        mang = new ArrayList<HocPhan>();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJSON().execute("http://mousewip.esy.es");
            }
        });




    }




    class docJSON extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONArray mangJson = new JSONArray(s);
                for(int i=0; i<mangJson.length(); i++)
                {
                    JSONObject obj = mangJson.getJSONObject(i);
                    mang.add(new HocPhan(
                            obj.getString("stt"),
                            obj.getString("maHP"),
                            obj.getString("tenHP"),
                            obj.getString("lopHoc"),
                            obj.getString("soTC"),
                            obj.getString("diemQT"),
                            obj.getString("diemThi"),
                            obj.getString("diem10"),
                            obj.getString("diem4"),
                            obj.getString("diemChu"),
                            obj.getString("xepLoai"),
                            obj.getString("ghiChu")

                    ));
                }
                Toast.makeText(context, "" + mang.size(), Toast.LENGTH_LONG).show();

                ListAdapter lAdapter = new ListAdapter(
                        context, R.layout.activity_hoc_phan, mang
                );
                lv.setAdapter(lAdapter);



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



    private static String docNoiDung_Tu_URL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }

}
