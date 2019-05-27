package com.example.section_18_httprequest.API.APIServices;

import com.example.section_18_httprequest.Models.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    // weather?q=mexico&appid=ebc9d5f883a3a1bc76d230290b7e2360
    @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);

    @GET("weather")
    Call<City> getCityCelcisus(@Query("q") String city, @Query("units") String value, @Query("appid") String key);
}
