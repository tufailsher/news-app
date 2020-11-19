package com.example.newsapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.newsapp.R;
import com.example.newsapp.adapter.MainDatumAdapter;
import com.example.newsapp.model.Datum;
import com.example.newsapp.model.Example;
import com.example.newsapp.model.Example;
import com.example.newsapp.rests.APIInterface;
import com.example.newsapp.rests.ApiClient;
import com.example.newsapp.utils.OnReclerViewItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnReclerViewItemClickListener {
    private Call<Example> call;
    // private static final String API_KEY = "b0b1e8e13a1d4089ba2bf142ade2fb21";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView mainRecycler = findViewById(R.id.activity_main_rv);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager
                .VERTICAL,false);

        mainRecycler.setLayoutManager(linearLayoutManager);

        final APIInterface apiService = ApiClient.getClient().create(APIInterface.class);

        Call<Example> call = apiService.getLatestNews();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
              //  if (response.body().getCjobTitle().equals("ok")) {
                    List<Datum> articleList = response.body().getData();
                    if (articleList.size() > 0) {
                        final MainDatumAdapter mainDatumAdapter = new MainDatumAdapter(articleList);
                        mainDatumAdapter.setOnRecyclerViewItemClickListener(MainActivity.this);

                        mainRecycler.setAdapter(mainDatumAdapter);
                    }
                }
            

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("out", t.toString());
            }
        });
    }

    @Override
    public void onItemClick(int position, View view) {
        switch (view.getId()) {
            case R.id.article_adapter_ll_parent:

                break;
        }
    }

}