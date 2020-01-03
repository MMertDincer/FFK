package com.example.ffk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button play;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    play = findViewById(R.id.play);

    play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Handler handler = new Handler();

        final Dialog dialogCorrect = new Dialog(MainActivity.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
          ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
          dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.splash_screen);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        handler.postDelayed(new Runnable() {
          public void run() {
            Intent intent = new Intent(MainActivity.this,login.class);
            startActivity(intent);
            finish();
          }
        }, 1000);
      }
    });

  }

}
