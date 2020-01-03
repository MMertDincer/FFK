package com.example.ffk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Shop extends AppCompatActivity {
  Button heal, str, back;
  Character ch;
  Context context = this;
  int hp, coin, strength;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    heal = findViewById(R.id.health);
    str = findViewById(R.id.strength);
    back = findViewById(R.id.back);

    ch = new Character();

    heal.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        coin = ch.getGold(context);
        if(coin > 5){
          coin = coin - 5;
          ch.earnGold(context, coin);
          hp = ch.getHealth(context);
          hp = hp + 10;
          ch.buyHeal(context, hp);
        }
      }
    });

    str.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        coin = ch.getGold(context);
        if(coin > 5){
          coin = coin - 5;
          ch.earnGold(context, coin);
          strength = ch.getStr(context);
          strength = strength + 10;
          ch.buyStr(context, strength);
        }
      }
    });

    back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(Shop.this, Menu.class);
        startActivity(i);
        finish();
      }
    });

  }
}
