package com.example.shareddemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shareddemo.Model.UserInfo;
import com.example.shareddemo.R;
import com.google.gson.Gson;

public class UserInfoActivity extends AppCompatActivity {

    EditText et_name,et_age;
    TextView title_age,title_name;
    Button btn_set_data,btn_get_data;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        title_name = findViewById(R.id.title_name);
        title_age = findViewById(R.id.title_age);
        btn_set_data = findViewById(R.id.btn_set_data);
        btn_get_data = findViewById(R.id.btn_get_data);
        sharedPreferences = getSharedPreferences(MainActivity.FILE_NAME,MODE_PRIVATE);


        btn_set_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                UserInfo userInfo = new UserInfo(et_name.getText().toString(),Integer.valueOf(et_age.getText().toString()));
                Gson gson = new Gson();
                String jsonStr = gson.toJson(userInfo,UserInfo.class);
                editor.putString("custom_data",jsonStr);
                editor.apply();

            }
        });

        btn_get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              String getdata =   sharedPreferences.getString("custom_data","");

                Gson gson = new Gson();
               UserInfo userInfo =  gson.fromJson(getdata,UserInfo.class);

                Toast.makeText(UserInfoActivity.this,userInfo.getName(),Toast.LENGTH_SHORT).show();
               title_name.setText(userInfo.getName());
               title_age.setText(""+userInfo.getAge());

            }
        });

    }
}
