package com.example.redrock_work_five;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;


public class RegisteDialogFragment extends DialogFragment implements View.OnClickListener{


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog, null, false);


        EditText reg_name = (EditText) view.findViewById( R.id.reg_user_scan );
        EditText reg_psassword = (EditText) view.findViewById( R.id.reg_pass_scan );
        EditText reg_password_sceond = (EditText) view.findViewById( R.id.second_reg_pass_scan );

        Button reg_success = (Button) view.findViewById( R.id.reg_success );
        Button cancel_reg = (Button) view.findViewById( R.id.cancel_reg );

       cancel_reg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               getDialog().onBackPressed();

           }
       });

       reg_success.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String user_name = reg_name.getText().toString();
               String password_first = reg_psassword.getText().toString();
               String password_second = reg_password_sceond.getText().toString();

               if ( user_name.length() == 0 )
                   Toast.makeText( getDialog().getContext() , "用户名不能为空" , Toast.LENGTH_LONG ).show();
               else if ( password_first.length() == 0 )
                   Toast.makeText( getDialog().getContext() , "密码不能为空" , Toast.LENGTH_LONG ).show();
               else if ( password_second.length() == 0 )
                   Toast.makeText( getDialog().getContext() , "密码不能为空" , Toast.LENGTH_LONG ).show();
               else if ( !password_first.equals( password_second ) )
                   Toast.makeText( getDialog().getContext() , "两次密码不相同" , Toast.LENGTH_LONG ).show();
               else{
                   getDialog().onBackPressed();
                   Toast.makeText( MainActivity.instance , "注册成功！" , Toast.LENGTH_LONG ).show();


                   SharedPreferences sharedata = getActivity().getSharedPreferences("data",0);

                   SharedPreferences.Editor shared = getActivity().getSharedPreferences("data",0).edit();
                   shared.putString( user_name , password_first );
                   shared.commit();

                   EditText user_scan = (EditText) MainActivity.in.findViewById( R.id.user_scan );
                   EditText pass_scan = (EditText) MainActivity.in.findViewById( R.id.password_scan );

                   user_scan.setText( user_name );
                   pass_scan.setText( password_first );

                   return;

               }


           }
       });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        Window dialogWindow = getDialog().getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);

        lp.x = 0;
        lp.y = 500;
        lp.width = lp.MATCH_PARENT;
        lp.height = 1800;
        lp.alpha = 0.7f;
        dialogWindow.setAttributes(lp);


        return;

    }

    @Override
    public void onClick(View v) {
        return;
    }
}
