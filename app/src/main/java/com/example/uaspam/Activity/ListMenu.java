package com.example.uaspam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.uaspam.API.APIRequestData;
import com.example.uaspam.API.RetroServer;
import com.example.uaspam.Adapter.AdapterData;
import com.example.uaspam.Model.DataModel;
import com.example.uaspam.Model.ResponseModel;
import com.example.uaspam.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterData mainAdapter;
    private Retrofit retrofit;
    private APIRequestData dataService;
    
    int foodImage [] = {R.drawable.pizza, R.drawable.pageti, R.drawable.burger, R.drawable.steak, R.drawable.fries, R.drawable.fries};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
        setupRetrofit();
        setupRecyclerView();
        attemptFetchPhotos();
    }

    private void setupRetrofit() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://retoolapi.dev/StWODX/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        dataService = retrofit.create(APIRequestData.class);
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setAdapter(mainAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
    }

    private void attemptFetchPhotos() {
        Call<ArrayList<DataModel>> call = dataService.ardRetrieveData();
        call.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
                ArrayList<DataModel> listData = response.body();
                mainAdapter = new AdapterData(ListMenu.this, listData, foodImage);
                recyclerView.setAdapter(mainAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {
                Toast.makeText(ListMenu.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }






}