package com.hfad.ronswansonofficial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.hfad.ronswansonofficial.R;

import java.sql.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class thePage extends AppCompatActivity implements View.OnClickListener {
    private TextView textView_quote;
    private ImageView imageOfRon;
    private String aQuote;
    private Button button_next;
    private Array theArray[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aQuote = "hello";


        wirewidgets();
        setOnClickListeners();
        getQuote();


    }

    private void setOnClickListeners() {
        button_next.setOnClickListener(this);
    }


    private void wirewidgets() {
        textView_quote = findViewById(R.id.textView_main_quote);
        button_next = findViewById(R.id.button_main_next);
        imageOfRon = findViewById(R.id.imageView);
    }


    private void getQuote() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ron-swanson-quotes.herokuapp.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetQuoteService service =
                retrofit.create(GetQuoteService.class);



//temp HARD CODED
        Call<String[]> quoteResponseCall = service.getAmountOfQuotes(1);

        quoteResponseCall.enqueue(new Callback<String[]>() {
            @Override
            public void onResponse(Call<String[]> call, Response<String[]> response) {
                aQuote = response.body()[0];
                textView_quote.setText(aQuote);

                Log.d("ENQUEUE", "onResponse"+ aQuote);
            }

            @Override
            public void onFailure(Call<String[]> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure" + t.getMessage());
            }
        });



    }

    @Override
    public void onClick(View v) {


        getQuote();
        changeImage();
    }

    private void changeImage() {
        int value = (int) (Math.random() * 10);
        if(value <= 2){
            imageOfRon.setImageResource(R.drawable.ron2);
        }
        else if (value <= 4){
            imageOfRon.setImageResource(R.drawable.ronplayground);
        }
        else if (value <= 6){
            imageOfRon.setImageResource(R.drawable.ron3);
        }
        else if (value <= 8){
            imageOfRon.setImageResource(R.drawable.ron4);
        }
        else if (value <= 10){
            imageOfRon.setImageResource(R.drawable.ron5);
        }
    }
}
