package com.example.countryquiz2101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    LinearLayout mainResultLayout;
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ArrayList<UserAnswer> userAnswers = (ArrayList<UserAnswer>) getIntent().getSerializableExtra("userAnswers");
        mainResultLayout = findViewById(R.id.mainResultLayout);
        resultTextView = findViewById(R.id.resultTextView);
        for (UserAnswer userAnswer : userAnswers) {
            LinearLayout linearLayout = new LinearLayout(ResultActivity.this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            resultTextView.append(getResources().getString(userAnswer.getCorrectAnswer())+" ответ: "+String.valueOf(userAnswer.isUserAnswer())+"\n");
            Log.i("SYSTEM INFO", String.valueOf(userAnswer.getQuestion()));
            Log.i("SYSTEM INFO", getResources().getString(userAnswer.getCorrectAnswer()));
            Log.i("SYSTEM INFO", String.valueOf(userAnswer.isUserAnswer()));
        }
    }
}