package com.example.ffk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class Game extends AppCompatActivity {
Button buttonA, buttonB, buttonC, buttonD, hp1, hp2, buttonNext;
TextView triviaQuestion, ch1, ch2;
TriviaQuizHelper triviaQuizHelper;
TriviaQuestion currentQuestion;
List<TriviaQuestion> list;
Character ch;
Context context = this;
int qId = 0;
int coin = 0;
int health, health2;
ImageView image;
String name;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    buttonA = findViewById(R.id.buttonA);
    buttonB = findViewById(R.id.buttonB);
    buttonC = findViewById(R.id.buttonC);
    buttonD = findViewById(R.id.buttonD);
    hp2 = findViewById(R.id.hpbar2);
    hp1 = findViewById(R.id.hpbar1);
    ch1 = findViewById(R.id.ch1);
    ch2 = findViewById(R.id.ch2);

    image = findViewById(R.id.imageView);

    triviaQuestion = findViewById(R.id.triviaQuestion);

    triviaQuizHelper = new TriviaQuizHelper(this);
    triviaQuizHelper.getWritableDatabase();

    ch = new Character();

    if (triviaQuizHelper.getAllOfTheQuestions().size() == 0) {
      triviaQuizHelper.allQuestion();
    }

    list = triviaQuizHelper.getAllOfTheQuestions();

    Collections.shuffle(list);

    currentQuestion = list.get(qId);

    updateQuestions();
  }

  public void updateQuestions() {

    triviaQuestion.setText(currentQuestion.getQuestion());
    buttonA.setText(currentQuestion.getOptA());
    buttonB.setText(currentQuestion.getOptB());
    buttonC.setText(currentQuestion.getOptC());
    buttonD.setText(currentQuestion.getOptD());

    health2 = ch.getHealth2(context);
    hp2.setText("Hp: " + health2);

    health = ch.getHealth(context);
    hp1.setText("Hp: " + health);
    //ch1.setText(ch.name);

    name = ch.getValueName(context);
    ch1.setText(name);
  }

  public void buttonA(View view) {
    if (currentQuestion.getOptA().equals(currentQuestion.getAnswer())) {
      if (qId < list.size() - 1) {
        disableButton();
        correctDialog();
        hp2.setText(ch.damageGiven());
        image.setImageResource(R.drawable.fscreen1);
        if (ch.hp2 <= 0){
          died();
        }
        coin = coin + 1;
        ch.earnGold(context, coin);
      }
      else {
        gameWon();
      }
    }
    else {
      correctDialog();
      hp1.setText(ch.damageTaken());
      image.setImageResource(R.drawable.fscreen2);
      if (ch.hp <= 0){
        died2();
      }
    }
  }

  public void buttonB(View view) {

    if (currentQuestion.getOptB().equals(currentQuestion.getAnswer())) {
      if (qId < list.size() - 1) {
        disableButton();
        correctDialog();
        hp2.setText(ch.damageGiven());
        image.setImageResource(R.drawable.fscreen1);
        if (ch.hp2 <= 0){
          died();
        }
        coin = coin + 1;
        ch.earnGold(context, coin);
      }
      else {
        gameWon();
      }
    }
    else {
      correctDialog();
      hp1.setText(ch.damageTaken());
      image.setImageResource(R.drawable.fscreen2);
      if (ch.hp <= 0){
        died2();
      }
    }
  }

  public void buttonC(View view) {

    if (currentQuestion.getOptC().equals(currentQuestion.getAnswer())) {
      if (qId < list.size() - 1) {
        disableButton();
        correctDialog();
        hp2.setText(ch.damageGiven());
        image.setImageResource(R.drawable.fscreen1);
        if (ch.hp2 <= 0){
          died();
        }
        coin = coin + 1;
        ch.earnGold(context, coin);
      }
      else {
        gameWon();
      }
    }
    else {
      correctDialog();
      hp1.setText(ch.damageTaken());
      image.setImageResource(R.drawable.fscreen2);
      if (ch.hp <= 0){
        died2();
      }
    }
  }

  public void buttonD(View view) {

    if (currentQuestion.getOptD().equals(currentQuestion.getAnswer())) {
      if (qId < list.size() - 1) {
        disableButton();
        correctDialog();
        hp2.setText(ch.damageGiven());
        image.setImageResource(R.drawable.fscreen1);
        if (ch.hp2 <= 0 || ch.hp <= 0){
          died();
        }
        coin = coin + 1;
        ch.earnGold(context, coin);
      }
      else {
        gameWon();
      }
    }
    else {
      correctDialog();
      hp1.setText(ch.damageTaken());
      image.setImageResource(R.drawable.fscreen2);
      if (ch.hp <= 0){
        died2();
      }
    }
  }

  public void gameWon() {
    Intent intent = new Intent(this, Won.class);
    startActivity(intent);
    finish();
  }

  public void died(){
    final Dialog dialogCorrect = new Dialog(Game.this);
    dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
    if (dialogCorrect.getWindow() != null) {
      ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
      dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
    }
    dialogCorrect.setContentView(R.layout.dialog_correct);
    dialogCorrect.setCancelable(false);
    dialogCorrect.show();

    coin = coin + 5;
    ch.earnGold(context, coin);

    health2 = ch.getHealth2(context);
    health2 = health2 + 10;
    ch.incEnemyHp(context, health2);


    onPause();

    buttonNext = dialogCorrect.findViewById(R.id.dialogNext);

    buttonNext.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(Game.this, Menu.class);
        startActivity(intent);
        finish();
      }
    });
  }

  public void died2(){
    final Dialog dialogCorrect = new Dialog(Game.this);
    dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
    if (dialogCorrect.getWindow() != null) {
      ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
      dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
    }
    dialogCorrect.setContentView(R.layout.dialog_wrong);
    dialogCorrect.setCancelable(false);
    dialogCorrect.show();

    onPause();

    buttonNext = dialogCorrect.findViewById(R.id.dialogNext);

    coin = coin - 1;
    ch.earnGold(context, coin);

    buttonNext.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(Game.this, Menu.class);
        startActivity(intent);
        finish();
      }
    });
  }

  public void correctDialog() {
    Handler handler = new Handler();

    handler.postDelayed(new Runnable() {
      public void run() {
        qId++;
        currentQuestion = list.get(qId);
        updateQuestions();

        image.setImageResource(R.drawable.fscreen3);

        enableButton();
      }
    }, 1000);
  }

  public void disableButton() {
    buttonA.setEnabled(false);
    buttonB.setEnabled(false);
    buttonC.setEnabled(false);
    buttonD.setEnabled(false);
  }

  public void enableButton() {
    buttonA.setEnabled(true);
    buttonB.setEnabled(true);
    buttonC.setEnabled(true);
    buttonD.setEnabled(true);
  }
}
