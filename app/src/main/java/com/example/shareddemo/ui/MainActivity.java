package com.example.shareddemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shareddemo.R;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_email;
    Button btn_login;
    SharedPreferences sharedPreferences;
    public  static String FILE_NAME ="my_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        btn_login = findViewById(R.id.btn_login);

        sharedPreferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);

        et_name.setText( sharedPreferences.getString("name",""));
        et_email.setText( sharedPreferences.getString("email",""));

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email",et_email.getText().toString());
                editor.putString("name",et_name.getText().toString());
                editor.putInt("id",8);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });

    }
}
