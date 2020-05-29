package com.example.alien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t=findViewById(R.id.textView);
        Toast.makeText(this,"WELCOME TO POKEDEX",4000).show();

        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anii);

        t.startAnimation(anim);

        Thread timer=new Thread()
        {
            @Override
            public void run() {


                try {
                    sleep(4000);
                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        timer.start();
    }
}
