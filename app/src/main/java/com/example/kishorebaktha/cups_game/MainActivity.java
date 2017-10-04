package com.example.kishorebaktha.cups_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView left, middle, right;
    int choice;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        left=(ImageView)findViewById(R.id.imageView2);
        middle=(ImageView)findViewById(R.id.imageView3);
        right=(ImageView)findViewById(R.id.imageView4);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice=1;
            }
        });
        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              choice=2;
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  choice=3;
            }
        });
    }
    public void Next(View view)
    {
        Intent intent=new Intent(getApplicationContext(),game.class);
        intent.putExtra("choice",choice);
        startActivity(intent);
    }
}
