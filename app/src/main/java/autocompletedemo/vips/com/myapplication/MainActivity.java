package autocompletedemo.vips.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import autocompletedemo.vips.com.myapplication.json_response.MyJsonResponse;
import autocompletedemo.vips.com.myapplication.json_response.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_data = findViewById(R.id.rv_data);
        /*Response gson = new Gson().fromJson(loadJSONFromAsset(), JsonArray.class);
        rv_data.setAdapter(new RawData_Adapter(gson.getJsonResponses()));

        Type collectionType = new TypeToken<List<ChannelSearchEnum>>(){}.getType();
        List<ChannelSearchEnum> lcs = (List<ChannelSearchEnum>) new Gson()
                .fromJson( jstring , collectionType);*/

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("samplerequest.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
