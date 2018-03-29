package com.naingmyo.girlfriendname;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    private Timer timber;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView tv=(TextView)findViewById(R.id.textView);
        ImageView img=(ImageView)findViewById(R.id.imageView);

        ImageView image1 = (ImageView) findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade);
        image1.startAnimation(animation1);

        final long period =5000;
        timber=new Timer();
        timber.schedule(new TimerTask() {
            @Override
            public void run() {
                //this repeats every 100 ms
                //closing the timer
                timber.cancel();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                // close this activity

                finish();
            }
        }, 5000, period);
    }
}
