package com.example.ffk;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


class TriviaQuizHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuiz.db";

    private static final int DB_VERSION = 2;

    private static final String TABLE_NAME = "TQ";

    private static final String UID = "_UID";

    private static final String QUESTION = "QUESTION";

    private static final String OPTA = "OPTA";

    private static final String OPTB = "OPTB";

    private static final String OPTC = "OPTC";

    private static final String OPTD = "OPTD";

    private static final String ANSWER = "ANSWER";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    TriviaQuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void allQuestion() {
        ArrayList<TriviaQuestion> arraylist = new ArrayList<>();

        arraylist.add(new TriviaQuestion("Galileo was an Italian astronomer who developed?", "Telescope", "Airoplane", "Electricity", "Train", "Telescope"));

        arraylist.add(new TriviaQuestion("Who is the father of Geometry ?", "Aristotle", "Euclid", "Pythagoras", "Kepler", "Euclid"));

        arraylist.add(new TriviaQuestion("Which racer holds the record for the most Grand Prix wins ?", "Micheal Schumacher", "Fernando Alonso", "Charles Leclerc", "Max Verstappen", "Micheal Schumacher"));

        arraylist.add(new TriviaQuestion("The first woman in space was ?", "Valentina Tereshkova", "Sally Ride", "Naidia Comenci", "Tamara Press", "Valentina Tereshkova"));

        arraylist.add(new TriviaQuestion("What percentage of our bodies is made up of wate", "70 - 80", "60 - 65", "65 - 70", "55 - 60", "60 - 65"));

        arraylist.add(new TriviaQuestion("what year was the first ever Wimbledon Championship held?", "1917", "1877", "1887", "1897", "1887"));

        arraylist.add(new TriviaQuestion("What is the symbol for potassium ?", "Na", "H", "Li", "K", "K"));

        arraylist.add(new TriviaQuestion("Who is often credited with creating the world’s first car?", "Gustav Otto", "Enzo Ferrari", "Karl Benz", "Louis Renault", "Karl Benz"));

        arraylist.add(new TriviaQuestion("King Henry VIII had a collection of more than 6,000 what?", "Wings", "Rings", "Statues", "Handgun", "Handgun"));

        arraylist.add(new TriviaQuestion("Which boxer was known as “The Greatest” and “The People’s Champion”?", "Muhammad Ali", " Mike Tyson", " Floyd Mayweather", "Conor McGregor", "Muhammad Ali"));

        arraylist.add(new TriviaQuestion("Where was gunpowder invented?", "China", "Germany", "Canada", "Morracco", "China"));

        arraylist.add(new TriviaQuestion("Who invented the famous formula E=mc^2", "Albert Einstein", "Galilio", "Sarvesh", "Bill Gates", "Albert Einstein"));

        arraylist.add(new TriviaQuestion("Who is elected as president of us 2016", "Donald Trump", "Hilary Clinton", "Jhon pol", "Barack Obama", "Donald Trump"));

        arraylist.add(new TriviaQuestion("Who was the founder of company Microsoft", "Bill Gates", "Bill Clinton", "Jhon rio", "Steve jobs", "Bill Gates"));

        arraylist.add(new TriviaQuestion("What alphabet does the English language use?", "Greek", "Latin", "Arabic", "Cyrillic", "Latin"));

        arraylist.add(new TriviaQuestion("Who was the founder of company Google ?", "Steve Jobs", "Bill Gates", "Larry Page", "Sundar Pichai", "Larry Page"));

        arraylist.add(new TriviaQuestion("Who is know as god of cricket ?", "Sachin Tendulkar", "Kapil Dev", "Virat Koli", "Dhoni", "Sachin Tendulkar"));

        arraylist.add(new TriviaQuestion("What is the name of the fictional African country in Black Panther ?", "Laos", "Wakanda", "Kenyatta", "East Guinea", "Wakanda"));

        arraylist.add(new TriviaQuestion("who has won ballon d'or of 2014 ?", "Neymar", "Lionel Messi", "Cristiano Ronaldo", "Kaka", "Cristiano Ronaldo"));

        arraylist.add(new TriviaQuestion("the Founder of the most famous gaming platform steam is ?", "Bill Cliton", "Bill Williams", "Gabe Newell", "Bill Gates", "Gabe Newell"));

        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<TriviaQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (TriviaQuestion question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(OPTD, question.getOptD());
                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    List<TriviaQuestion> getAllOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            TriviaQuestion question = new TriviaQuestion();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setOptD(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
