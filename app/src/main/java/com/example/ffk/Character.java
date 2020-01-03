package com.example.ffk;

import android.content.Context;
import android.content.SharedPreferences;

public class Character {
  int strength = 10;
  int hp = 20;
  int hp2 = 20;
  int gold = 0;

  static final String SHARE_PREF = "file";
  static final String PREF_NAME = "name";
  static final int PREF_STR = 10;
  static final int PREF_HP = 20;
  static final int PREF_HP2 = 20;
  static final int PREF_GOLD = 0;

  public String damageGiven(){
    hp2 = hp2 - strength;

    return "Hp: " + hp2;
  }

  public String damageTaken(){
    hp = hp - strength;

    return "Hp: " + hp;
  }


  public void saveName(Context context, String text){
    SharedPreferences settings = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = settings.edit();
    editor.putString(PREF_NAME, text);
    editor.commit();
  }

  public String getValueName(Context context){
    SharedPreferences settings = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    String name = settings.getString(PREF_NAME, null);
    return name;
  }

  public void earnGold(Context context, int coins){
    SharedPreferences settings2 = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = settings2.edit();
    editor.putInt("coins", coins);
    editor.commit();
  }

  public int getGold(Context context){
    SharedPreferences settings2 = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    int coins = settings2.getInt("coins", gold);
    return coins;
  }

  public void buyHeal(Context context, int hp){
    SharedPreferences settings3 = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = settings3.edit();
    editor.putInt("heal", hp);
    editor.commit();
  }

  public int getHealth(Context context){
    SharedPreferences settings3 = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    int heal = settings3.getInt("heal", hp);
    return heal;
  }

  public void incEnemyHp(Context context, int hp2){
    SharedPreferences settings3 = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = settings3.edit();
    editor.putInt("heal2", hp2);
    editor.commit();
  }

  public int getHealth2(Context context){
    SharedPreferences settings3 = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    int heal = settings3.getInt("heal2", hp2);
    return heal;
  }

  public void buyStr(Context context, int strength){
    SharedPreferences settings4 = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = settings4.edit();
    editor.putInt("str", strength);
    editor.commit();
  }

  public int getStr(Context context){
    SharedPreferences settings4 = context.getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE);
    int str = settings4.getInt("str", strength);
    return str;
  }
}
