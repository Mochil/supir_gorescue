package com.digitallight.s_gorescue;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    //Root URL of our web service
    public static final String ROOT_URL = "http://developsalis.esy.es/";

    Button b1;
    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        getSupportActionBar().hide();
        b1 = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLogin();
            }
        });
    }

    private void getLogin() {
        //While the app fetched data we are displaying a progress dialog
        final ProgressDialog loading = ProgressDialog.show(this, "Validasi Akun", "Tunggu sebentar", false, false);
        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, Main.class);
        startActivity(intent);
        finish();
    }

    long lastPress;
    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPress > 5000){
            Toast.makeText(getBaseContext(),"Tekan lagi untuk keluar",Toast.LENGTH_LONG).show();
            lastPress = currentTime;
        }else{
            super.onBackPressed();
            Log.i(getClass()+"","keluar dari aplikasi");
            finish();
            System.exit(0);
        }
    }

}
