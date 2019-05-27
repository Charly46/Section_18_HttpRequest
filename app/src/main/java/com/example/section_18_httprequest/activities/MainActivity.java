package com.example.section_18_httprequest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.section_18_httprequest.API.API;
import com.example.section_18_httprequest.API.APIServices.WeatherService;
import com.example.section_18_httprequest.Models.City;
import com.example.section_18_httprequest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherService service = API.getApi().create(WeatherService.class);
       Call<City> cityCall = service.getCityCelcisus("Sevilla,ES", "metric",API.APPKEY);
       cityCall.enqueue(new Callback<City>() {
           @Override
           public void onResponse(Call<City> call, Response<City> response) {
               if (response.code() == 200){
                   String url = response.raw().request().url().toString();
                   City city = response.body();
                   String id = String.format("%d",city.getId());
                   Toast.makeText(MainActivity.this, url, Toast.LENGTH_LONG).show();
                   Toast.makeText(MainActivity.this, city.getCountry(),Toast.LENGTH_LONG).show();
               }
           }

           @Override
           public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
           }
       });


    }
}
