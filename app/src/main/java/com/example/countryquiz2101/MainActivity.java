package com.example.countryquiz2101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
    int questionIndex = 0;
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
        imageView.setImageResource(questions[questionIndex].getImageResId());
        ArrayList<Button> answerButtons = new ArrayList<>();
        answerButtons.add(button1);
        answerButtons.add(button2);
        answerButtons.add(button3);
        answerButtons.add(button4);
        renderQuestion(answerButtons);
    }
    public void renderQuestion(ArrayList<Button> answerButtons){
        Collections.shuffle(answerButtons);
        ArrayList<Integer> randomIndexes = new ArrayList<>();
        randomIndexes.add(questionIndex);
        for (int i=0; i<answerButtons.size(); i++) {
            int randomIndex = random.nextInt(questions.length-1);
            if(i == answerButtons.size()-1){ // Правильный вариант ответа
                answerButtons.get(i).setText(questions[questionIndex].getCorrectAnswer());
                answerButtons.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkAnswer(true);
                        renderQuestion(answerButtons);
                    }
                });
            }else
            if(randomIndexes.contains(randomIndex)) {
                i--;
                continue;
            }
            else { // Любая страна (неправильный вариант ответа)
                answerButtons.get(i).setText(questions[randomIndex].getCorrectAnswer());
                answerButtons.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkAnswer(false);
                        renderQuestion(answerButtons);
                    }
                });
            }
            randomIndexes.add(randomIndex);
        }
    }
    public void checkAnswer(boolean btn){
        if(btn)
            Toast.makeText(MainActivity.this, "Правильно", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Не правильно", Toast.LENGTH_SHORT).show();
        questionIndex++;
        imageView.setImageResource(questions[questionIndex].getImageResId());
    }
}