package com.example.kishorebaktha.cups_game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by KISHORE BAKTHA on 7/9/2017.
 */

public class game extends AppCompatActivity
{
    ImageView left,middle,right;
    List<Integer> cards;
    int score=0;
    int choice;
    TextView t1,t2;
    MediaPlayer play2;
    Context context=this;
    final Handler mHandler = new Handler();
    // Create runnable for posting
    final Runnable mUpdateResults = new Runnable() {
        public void run()
        {
            Collections.shuffle(cards);
            left.setImageResource(R.drawable.bs);
            middle.setImageResource(R.drawable.bs);
            right.setImageResource(R.drawable.bs);
            Animation anim_left= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left);
            Animation anim_middle= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.middle);
            Animation anim_right= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right);
            left.startAnimation(anim_left);
            middle.startAnimation(anim_middle);
            right.startAnimation(anim_right);
            left.setEnabled(true);
            middle.setEnabled(true);
            right.setEnabled(true);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent=getIntent();
        choice=intent.getIntExtra("choice",1);
        left=(ImageView)findViewById(R.id.imageView2);
        middle=(ImageView)findViewById(R.id.imageView3);
        right=(ImageView)findViewById(R.id.imageView4);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t1.setText("SCORE: "+score);
        new CountDownTimer(60*1000,1000)
        {
            public void onTick(long milliuntilfinished)
            {
                t2.setText("TIME LEFT: "+milliuntilfinished/1000);
            }
            public void onFinish()
            {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(game.this);
                a_builder.setMessage(" YOUR SCORE IS- "+score)
                        .setCancelable(false)
                        .setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                AlertDialog ab = a_builder.create();
                ab.setTitle("Alert");
                ab.show();
            }
        }.start();
        cards=new ArrayList<>();
        cards.add(1);
        cards.add(2);
        cards.add(3);
        Collections.shuffle(cards);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play2 = MediaPlayer.create(context, R.raw.success);
                play2.start();
                if(cards.get(0)==choice) {
                    if(choice==1)
                    left.setImageResource(R.drawable.adice);
                    else if(choice==2)
                        left.setImageResource(R.drawable.twodice);
                    else if(choice==3)
                        left.setImageResource(R.drawable.threeclover);
                    Toast.makeText(getApplicationContext(),"GUESSED",Toast.LENGTH_SHORT).show();
                    score++;
                    t1.setText("SCORE: "+score);
                }
                else if(cards.get(0)==1)
                    left.setImageResource(R.drawable.adice);
                else if(cards.get(0)==2)
                    left.setImageResource(R.drawable.twodice);
                else  if(cards.get(0)==3)
                    left.setImageResource(R.drawable.threeclover);

                if(cards.get(1)==1) {
                    middle.setImageResource(R.drawable.adice);
                }
                else if(cards.get(1)==2)
                    middle.setImageResource(R.drawable.twodice);
                else  if(cards.get(1)==3)
                    middle.setImageResource(R.drawable.threeclover);

                if(cards.get(2)==1) {
                    right.setImageResource(R.drawable.adice);
                }
                else if(cards.get(2)==2)
                    right.setImageResource(R.drawable.twodice);
                else  if(cards.get(2)==3)
                    right.setImageResource(R.drawable.threeclover);
                left.setEnabled(false);
                middle.setEnabled(false);
                right.setEnabled(false);
                startTestThread();
            }
        });
        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play2 = MediaPlayer.create(context, R.raw.success);
                play2.start();
                if(cards.get(1)==choice) {
                    if(choice==1)
                        middle.setImageResource(R.drawable.adice);
                    else if(choice==2)
                        middle.setImageResource(R.drawable.twodice);
                    else if(choice==3)
                        middle.setImageResource(R.drawable.threeclover);
                    Toast.makeText(getApplicationContext(),"GUESSED",Toast.LENGTH_SHORT).show();
                    score++;
                    t1.setText("SCORE: "+score);
                }
                else if(cards.get(1)==1)
                    middle.setImageResource(R.drawable.adice);
                else if(cards.get(1)==2)
                    middle.setImageResource(R.drawable.twodice);
                else  if(cards.get(1)==3)
                    middle.setImageResource(R.drawable.threeclover);

                if(cards.get(2)==1) {
                    right.setImageResource(R.drawable.adice);
                }
                else if(cards.get(2)==2)
                    right.setImageResource(R.drawable.twodice);
                else  if(cards.get(2)==3)
                    right.setImageResource(R.drawable.threeclover);

                if(cards.get(0)==1) {
                    left.setImageResource(R.drawable.adice);
                }
                else if(cards.get(0)==2)
                    left.setImageResource(R.drawable.twodice);
                else  if(cards.get(0)==3)
                    left.setImageResource(R.drawable.threeclover);
                left.setEnabled(false);
                middle.setEnabled(false);
                right.setEnabled(false);
                startTestThread();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play2 = MediaPlayer.create(context, R.raw.success);
                play2.start();
                if(cards.get(2)==choice) {
                    if(choice==1)
                        right.setImageResource(R.drawable.adice);
                    else if(choice==2)
                        right.setImageResource(R.drawable.twodice);
                    else if(choice==3)
                        right.setImageResource(R.drawable.threeclover);
                    Toast.makeText(getApplicationContext(),"GUESSED",Toast.LENGTH_SHORT).show();
                    score++;
                    t1.setText("SCORE: "+score);
                }
                else if(cards.get(2)==1)
                    right.setImageResource(R.drawable.adice);
                else if(cards.get(2)==2)
                    right.setImageResource(R.drawable.twodice);
                else  if(cards.get(2)==3)
                    right.setImageResource(R.drawable.threeclover);

                if(cards.get(1)==1) {
                    middle.setImageResource(R.drawable.adice);
                }
                else if(cards.get(1)==2)
                    middle.setImageResource(R.drawable.twodice);
                else  if(cards.get(1)==3)
                    middle.setImageResource(R.drawable.threeclover);

                if(cards.get(0)==1) {
                    left.setImageResource(R.drawable.adice);
                }
                else if(cards.get(0)==2)
                    left.setImageResource(R.drawable.twodice);
                else  if(cards.get(0)==3)
                    left.setImageResource(R.drawable.threeclover);
                left.setEnabled(false);
                middle.setEnabled(false);
                right.setEnabled(false);
                startTestThread();
            }
        });
    }
    protected void startTestThread() {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.postDelayed(mUpdateResults,200);
            }
        };
        t.start();
    }
}
