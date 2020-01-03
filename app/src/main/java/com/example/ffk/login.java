package com.example.ffk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
Button go;
EditText nickname;
Character ch;
Context context = this;
String name;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    go = findViewById(R.id.go);
    nickname = findViewById(R.id.userName);

    ch = new Character();

    go.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Handler handler = new Handler();

        name = nickname.getText().toString();
        ch.saveName(context, name);

        handler.postDelayed(new Runnable() {
          public void run() {
            Intent intent = new Intent(login.this, Menu.class);
            startActivity(intent);
            finish();
          }
        }, 1000);
      }
    });
  }
}
