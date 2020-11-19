package com.example.newsapp.rests;
import com.example.newsapp.model.Datum;
import com.example.newsapp.model.Datum;
import com.example.newsapp.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface APIInterface {
    @GET("search-jobs.php?search=web")
    Call<Example> getLatestNews();
}
