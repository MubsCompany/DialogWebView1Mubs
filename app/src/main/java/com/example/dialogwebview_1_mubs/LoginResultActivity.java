package com.example.dialogwebview_1_mubs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    TextView tvUsername, tvPassword, tvEmailHome;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_result );

        tvPassword = findViewById( R.id.tv_password );
        tvUsername = findViewById( R.id.tv_name );
        tvEmailHome = findViewById( R.id.tv_email_home );



        tvUsername.setText( "Welcome " + getIntent().getStringExtra( "username" ) + " !" );
        tvPassword.setText( "your password : " + getIntent().getStringExtra( "password" ) );
        tvEmailHome.setText(  getIntent().getStringExtra( "email" ) );


    }
}
