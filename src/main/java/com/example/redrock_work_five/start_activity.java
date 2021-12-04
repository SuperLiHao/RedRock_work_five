package com.example.redrock_work_five;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._start_activity);

        getSupportActionBar().hide();

        ImageView backgroundLight = (ImageView) findViewById(R.id.dialog_loading_img);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.loading);
        LinearInterpolator lin = new LinearInterpolator();//设置动画匀速运动
        animation.setInterpolator(lin);
        backgroundLight.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent( start_activity.this , MainActivity.class );

                startActivity( i );

            }
        },3000); // 延时3秒

    }
}