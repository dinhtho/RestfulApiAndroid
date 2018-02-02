package com.example.pcpv.restfulapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private MerchantsUpdateRequest merchantsUpdateRequest;
    private static final String TAG = "MainActivity";
    private String userToken = "u7HoTZTaDUBp9Wc9EKx5O2gSvGPLUpPo";
    private String id = "532";
    private String type = "user";
    private final String BASE_URL = "http://link.com/api";
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String data = "{\"is_tab\": \"3\"}";

        try {
            result = java.net.URLEncoder.encode(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        merchantsUpdateRequest = new MerchantsUpdateRequest();
        merchantsUpdateRequest.setBusinessName("st124v1test124v1test124v1test124v1test124v1test124v1test124v1test124v1test124v1test124v1test124v1tes");
        merchantsUpdateRequest.setAccountBankNo("123445676701");
        merchantsUpdateRequest.setBankName("test");
        merchantsUpdateRequest.setBusinessAddress("518 Princes Hwy, Bolwarra VIC 3305, Australia");
        merchantsUpdateRequest.setCategoryId("1");
        merchantsUpdateRequest.setCountryId("1");
        merchantsUpdateRequest.setDescription("mea");
        merchantsUpdateRequest.setPhone("1234643443");
        merchantsUpdateRequest.setRedemptionCode("1234");
        merchantsUpdateRequest.setImageId("2487");
        merchantsUpdateRequest.setStatus(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Query 1 parameter and path
                Log.i(TAG, "run: " + getJsonData(BASE_URL + "/redemptions/redemptions/" + id + "/purchase/history?" + "type=" + type));
                // Query with multiple parameter
                Log.i(TAG, "run: " + getJsonData(BASE_URL + "/redemptions/redemptions?" + "page=1" + "&pageSize=20" + "&sort=" + "&order=ASC" + "&data=" + result));
                // put method
                putData(BASE_URL + "/merchants/merchants/120", merchantsUpdateRequest);


            }
        }).start();

        Button button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SerializedObjectDemo serializedObjectDemo = new SerializedObjectDemo("A", "22");
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data", serializedObjectDemo);
                startActivity(intent);
            }
        });

    }


    public String getJsonData(String url) {
        try {
            URL Url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
            connection.setRequestProperty("USER-TOKEN", userToken);
            connection.setRequestMethod("GET");
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            line = sb.toString();
            connection.disconnect();
            is.close();
            sb.delete(0, sb.length());
            return line;
        } catch (Exception e) {
            return null;
        }
    }

    private void putData(String mUrl, MerchantsUpdateRequest merchantsUpdateRequest) {
        URL url = null;
        try {
            url = new URL(mUrl);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestProperty("USER-TOKEN", userToken);
            httpCon.setRequestProperty("Content-Type", "application/json");
            httpCon.setRequestMethod("PUT");

            httpCon.setDoOutput(true); // to be able to write.
            httpCon.setDoInput(true); // to be able to read.


            Gson gson = new Gson();
            String json = gson.toJson(merchantsUpdateRequest);
            Log.i(TAG, "putData: " + json);

            OutputStreamWriter osw = new OutputStreamWriter(httpCon.getOutputStream());
            osw.write(json);
            osw.flush();
            osw.close();

            int responseCode = httpCon.getResponseCode();
            switch (responseCode) {
                case 200: //all ok
                    Log.i(TAG, "putData: ok");
                    String json_response = "";
                    InputStreamReader in = new InputStreamReader(httpCon.getInputStream());
                    BufferedReader brSuccess = new BufferedReader(in);
                    String text = "";
                    while ((text = brSuccess.readLine()) != null) {
                        json_response += text;
                    }
                    Log.i(TAG, "putData: " + json_response);
                    break;
                case 401:
                case 403:
                    Log.i(TAG, "putData: authorized");
                    // authorized
                    break;
                default:
                    //whatever else...
                    BufferedReader brError = new BufferedReader(new InputStreamReader(httpCon.getErrorStream()));
                    String line;
                    try {
                        while ((line = brError.readLine()) != null) {
                            Log.i("putData", "    " + line);
                        }
                    } catch (Exception ex) {
                        //nothing to do here
                    }

                    break;
            }

            httpCon.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            Log.i(TAG, "putData: a");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

       /*
    on Retrofit
    * @GET("redemptions/redemptions/{id}/purchase/history")
    Observable<RestMessageResponse<RedemptionHistoryOfPurchaseResponse>> getListRedemptionHistory(
            @Header("USER-TOKEN")
                    String token,
            @Path("id")
                    String purchaseId,
            @Query("type")
                    String type);
    * */


    /*
    *
    *  @GET("redemptions/redemptions")
    Observable<RestMessageResponse<List<PaymentResponse>>> getMyPurchases(
            @Header("USER-TOKEN")
                    String token,
            @Query("page")
                    int page,
            @Query("pageSize")
                    int pageSize,
            @Query("sort")
                    String sort,
            @Query("order")
                    String order,
            @Query("data")
                    String data);
    * */
    /*
    *    @PUT("merchants/merchants/{id}")
    Observable<RestMessageResponse<MerchantResponse>> updateMerchants(
            @Header("USER-TOKEN")
                    String token,
            @Path("id")
                    String id,
            @Body
                    MerchantsUpdateRequest merchantsRequest);
    * */


}
