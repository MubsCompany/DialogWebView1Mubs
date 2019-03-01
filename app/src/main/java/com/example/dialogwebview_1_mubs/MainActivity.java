package com.example.dialogwebview_1_mubs;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnUrl;
    EditText edtUrl;
    WebView webView;
    //untuk dialog
    LayoutInflater inflater;
    AlertDialog.Builder dialog;
    View dialogView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab = findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buatDialog();
            }
        } );

        btnUrl = findViewById( R.id.btn_url );
        edtUrl = findViewById( R.id.edt_url );
        webView = findViewById( R.id.web_view );


        webView.setWebViewClient( new MyClient() );
        webView.getSettings().setJavaScriptEnabled( true );

        btnUrl.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUrl.length() == 0) {
                    edtUrl.setError( "fill the land!" );
                } else {
                    webView.loadUrl( "https://www." + edtUrl.getText().toString() + ".com"  );

                }

            }
        } );


    }

    private void buatDialog() {

        dialog = new AlertDialog.Builder( this );
        inflater = getLayoutInflater();
        dialogView = inflater.inflate( R.layout.dialog_layout, null );
        dialog.setView( dialogView );
        dialog.setTitle( "Login...." );

        final EditText edtUsername, edtPassword;
        final TextView tvLogin;

        edtUsername = dialogView.findViewById( R.id.edt_username );
        edtPassword = dialogView.findViewById( R.id.edt_password );

        tvLogin = dialogView.findViewById( R.id.tv_login );

        tvLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.length() == 0 && edtPassword.length() == 0) {
                    edtUsername.setError( "fill land first!" );
                    edtPassword.setError( "fill land first!" );
                } else {
                    startActivity( new Intent( MainActivity.this, LoginResultActivity.class )
                            .putExtra( "username", edtUsername.getText().toString() )
                            .putExtra( "password", edtPassword.getText().toString() ) );
                }
            }
        } );


        dialog.setNegativeButton( "CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        } );

        dialog.setNeutralButton( "Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity( new Intent( MainActivity.this, RegisterActivity.class ) );
            }
        } );

        dialog.show();
    }

  private class MyClient extends WebViewClient {
  }
}
