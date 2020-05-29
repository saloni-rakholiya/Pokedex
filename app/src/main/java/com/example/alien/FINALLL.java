package com.example.alien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FINALLL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_i_n_a_l_l_l);
        String s=getIntent().getStringExtra("name");
        String x= Integer.parseInt(getIntent().getStringExtra("number"));

        TextView head=findViewById(R.id.texthead);
        ImageView img=findViewById(R.id.imagehere);
        head.setText(s);
        //here
        Glide.with(getApplicationContext())
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+x+".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img);
        //to here






        Toast.makeText(this,String.valueOf(x),5000).show();

    }
}
