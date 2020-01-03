package com.example.ffk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Stats extends AppCompatActivity {
  Button back;
  TextView gold, nickName, heal, strength;
  Character ch;
  Context context = this;
  String name;
  int coin, health, str;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_stats);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    back = findViewById(R.id.back);
    gold = findViewById(R.id.gold);
    heal = findViewById(R.id.heal);
    strength = findViewById(R.id.strength);

    nickName = findViewById(R.id.name);

    ch = new Character();

    name = ch.getValueName(context);
    nickName.setText(name);

    coin = ch.getGold(context);
    gold.setText("Gold: " + coin);

    health = ch.getHealth(context);
    heal.setText("Health: " + health);

    str = ch.getStr(context);
    strength.setText("Strength: " + str);

    back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Stats.this, Menu.class);
        startActivity(intent);
        finish();
      }
    });

  }
}
