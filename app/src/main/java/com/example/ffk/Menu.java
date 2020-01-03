package com.example.ffk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Menu extends AppCompatActivity {
Button play,stats,shop, about;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    play = findViewById(R.id.playGame);
    stats = findViewById(R.id.gold);
    shop = findViewById(R.id.shop);
    about = findViewById(R.id.heal);

    play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(Menu.this, Game.class);
        startActivity(intent);
        finish();
      }
    });

    stats.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Menu.this, Stats.class);
        startActivity(intent);
        finish();
      }
    });

    shop.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Menu.this, Shop.class);
        startActivity(intent);
        finish();
      }
    });

    about.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(Menu.this, About.class);
        startActivity(i);
        finish();
      }
    });
  }
}
