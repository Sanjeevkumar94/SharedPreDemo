package com.example.shareddemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shareddemo.R;
import com.example.shareddemo.ui.MainActivity;

public class Dashboard extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView tv_name,tv_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sharedPreferences = getSharedPreferences(MainActivity.FILE_NAME,MODE_PRIVATE);
        tv_name = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_email);
        tv_name.setText( sharedPreferences.getString("name",""));
        tv_email.setText( sharedPreferences.getString("email",""));


    }
}
