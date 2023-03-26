package com.example.countryquiz2101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Question[] questions = {
      new Question(R.drawable.ad, R.string.ad),
      new Question(R.drawable.ae, R.string.ae),
      new Question(R.drawable.af, R.string.af),
      new Question(R.drawable.ag, R.string.ag),
      new Question(R.drawable.ai, R.string.ai),
      new Question(R.drawable.al, R.string.al),
      new Question(R.drawable.am, R.string.am),
      new Question(R.drawable.ao, R.string.ao),
      new Question(R.drawable.aq, R.string.aq),
      new Question(R.drawable.ru, R.string.ru)
    };
    List<Question> questionList = Arrays.asList(questions);
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        Collections.shuffle(questionList); // перемешиваем элементы коллекции в случайном порядке
        questionList.toArray(questions); // превращаем обратно в массив
        imageView.setImageResource(questions[0].getImageResId());
        ArrayList<Button> answerButtons = new ArrayList<>();
        answerButtons.add(button1);
        answerButtons.add(button2);
        answerButtons.add(button3);
        answerButtons.add(button4);
        Collections.shuffle(answerButtons);
        answerButtons.get(0).setText(questions[random.nextInt(questions.length-1)].getCorrectAnswer());
        answerButtons.get(1).setText(questions[random.nextInt(questions.length-1)].getCorrectAnswer());
        answerButtons.get(2).setText(questions[0].getCorrectAnswer());
        answerButtons.get(3).setText(questions[random.nextInt(questions.length-1)].getCorrectAnswer());
    }
}