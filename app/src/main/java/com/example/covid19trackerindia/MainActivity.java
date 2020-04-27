package com.example.covid19trackerindia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView statewise;
    RecyclerView staterecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statewise=findViewById(R.id.statewise);
        staterecycler=findViewById(R.id.staterecycler);


        staterecycler.setLayoutManager(new LinearLayoutManager(this));
        RetrofitClient.getClient(NetworkConstraint.BASE_URL)
                .create(StateRequest.class)
                .getstatewisedata()
                .enqueue(new Callback<StateWiseData>() {
                    @Override
                    public void onResponse(Call<StateWiseData> call, Response<StateWiseData> response) {
                        staterecycler.setAdapter(new StateRecyclerAdapter(MainActivity.this,response.body().getStatewise()));
                        Log.i("dsfsxf", "onResponse: "+response.toString());
                        Log.i("dsfsxf", "onResponse: "+response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<StateWiseData> call, Throwable t) {

                    }
                });
    }
}
