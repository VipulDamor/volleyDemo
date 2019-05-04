package autocompletedemo.vips.com.myapplication;

import android.app.ProgressDialog;
import android.icu.text.DisplayContext;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import autocompletedemo.vips.com.myapplication.json_response.MyJsonResponse;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    RecyclerView rv_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("please wait....");
        rv_data = findViewById(R.id.rv_data);
        requestWithSomeHttpHeaders();
    }

    public void requestWithSomeHttpHeaders() {
        progressDialog.show();
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://www.yahbank.com/cyclos/rest/accounts/info";
        final StringRequest getRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                MyJsonResponse[] projectsList = new Gson().fromJson(response.toString(), MyJsonResponse[].class);
                List<AccountData> accountDataList = new ArrayList<>();
                for(MyJsonResponse wrapper : projectsList){
                    System.out.println(wrapper.getAccount().getId());
                    AccountData accountData = new AccountData();
                    accountData.setAccountName(wrapper.getAccount().getType().getName());
                    accountData.setFormattedAccountBalance(wrapper.getStatus().getFormattedBalance());
                    accountData.setFormattedAvailableBalance(wrapper.getStatus().getFormattedAvailableBalance());
                    accountData.setFormattedReservedAmount(wrapper.getStatus().getFormattedReservedAmount());
                    accountData.setFormattedCreditLimit(wrapper.getStatus().getFormattedCreditLimit());

                    accountDataList.add(accountData);
                }
                rv_data.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv_data.setAdapter(new RawData_Adapter(accountDataList));
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, error.getMessage()+"", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Authorization", "Basic " +base64Encode("test2"+":"+"1234"));
                return params;
            }
        };
        queue.add(getRequest);

    }

    public static String base64Encode(String token) {
        byte[] data = new byte[0];
        data = token.getBytes(StandardCharsets.UTF_8);
        return Base64.encodeToString(data, Base64.NO_WRAP);
    }

}
