package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private List<Item> mItems; //response 받아올 리스트
    private TextView station_message; //TextView

    String stSrch = "홍대입구"; //요청변수 (우선 하드코드로 작성)
    String type = "json"; // 요청타입
    private RetrofitAPI retrofitAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        station_message = findViewById(R.id.t);
        button.setOnClickListener(new View.OnClickListener() { // 버튼 클릭하면
            @Override public void onClick(View view)
            {
                Station_InFo();
            }
        });
    }


    void Station_InFo() {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if(retrofitClient != null){
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getData(key,stSrch,type).enqueue(new Callback<Station>() {
                @Override
                public void onResponse(Call<Station> call, Response<Station> response) {
                    if (response.isSuccessful() && response.body() != null)
                    {
                        mItems = response.body().getMsgBody().getItemList();

                      //  Log.d("String 결과값", "response.body().toString() : " + response.body().toString());
                        Log.d("mItems 결과값", " response.body().getMsgBody().getItemList() : " +response.body().getMsgBody().getItemList().get(0).getPoiNm());
                        if(mItems != null) {
                            station_message.setText("버스정류장 x 좌표 :" + response.body().getMsgBody().getItemList().get(0).getPosX() + "\n" + "버스정류장 y 좌표 :"
                                    + response.body().getMsgBody().getItemList().get(0).getPosY()
                                    );
                        }
                    }

                }
                @Override
                public void onFailure(Call<Station> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "network failure", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}






