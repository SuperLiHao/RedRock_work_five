package com.example.redrock_work_five;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.AndroidViewModel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "Hao_pp's Test";
    public static Context instance;

    public static Activity in;



    int intwidth = 0;
    int intheight = 0;



    Random r = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;

        in = this;

        setContentView(R.layout.activity_main);

        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        intwidth =metric.widthPixels;  //宽度（PX）
        intheight =metric.heightPixels;  //高度（PX）


        Button login = (Button) findViewById( R.id.login );

        Toast msg = Toast.makeText( MainActivity.this , "" , Toast.LENGTH_LONG );


        EditText user_scan = (EditText) findViewById( R.id.user_scan );
        EditText password_scan = (EditText) findViewById( R.id.password_scan );

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if ( user_scan.getText().length() == 0 ){

                    msg.setText( "用户名不能为空" );
                    msg.show();

                }else if ( password_scan.getText().length() == 0 ){

                    msg.setText( "密码不能为空" );
                    msg.show();

                }else{

                    SharedPreferences sharedata = getSharedPreferences("data", 0);

                    if ( !sharedata.contains( user_scan.getText().toString() )){

                        Toast.makeText( MainActivity.this , "用户名不存在" , Toast.LENGTH_LONG ).show();
                        return;

                    }else if( !sharedata.getString(user_scan.getText().toString() , null).equals( password_scan.getText().toString() ) ){
                        Toast.makeText( MainActivity.this , "密码错误" , Toast.LENGTH_LONG ).show();
                        return;
                    }else{

                        Toast.makeText( MainActivity.this , "登陆成功!!!!!!" , Toast.LENGTH_LONG ).show();
                        return;

                    }




                }




            }
        });

        Button reg = (Button) findViewById( R.id.reg );

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegisteDialogFragment mdf = new RegisteDialogFragment();

                mdf.show( getSupportFragmentManager() , "123" );

            }
        });

        user_scan.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if ( user_scan.getText().length() == 0 )
                    return true;

                password_scan.requestFocus();
                password_scan.setSelection( password_scan.getText().length() );

                return true;
            }
        });

        password_scan.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                login.callOnClick();

                return false;
            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                getSupportActionBar().hide();

                EditText et = (EditText) findViewById( R.id.password_scan );

                et.setY( et.getY() - 30 );

            }
        },3000); // 延时3秒



    }



    private void initLogin( String name , String password ){


        return;
    }

    @Override
    public void onClick(View v) {
        return;
    }
}
