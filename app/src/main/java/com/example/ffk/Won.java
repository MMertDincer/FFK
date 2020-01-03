package com.example.ffk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Won extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_won);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
  }

  public void PlayAgain(View view) {
    Intent intent = new Intent(Won.this, Game.class);
    startActivity(intent);
    finish();
  }
}
