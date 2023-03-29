package com.example.countryquiz2101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    LinearLayout mainResultLayout;
    RecyclerView recycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ArrayList<UserAnswer> userAnswers = (ArrayList<UserAnswer>) getIntent().getSerializableExtra("userAnswers");
        mainResultLayout = findViewById(R.id.mainResultLayout);
        recycleView = findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(ResultActivity.this));
        UserAnswerAdapter adapter = new UserAnswerAdapter(userAnswers);
        recycleView.setAdapter(adapter);

    }
    public class UserAnswerViewHolder extends RecyclerView.ViewHolder{
        TextView userAnswerTextView;
        TextView correctAnswerTextView;
        ImageView answerImage;
        public UserAnswerViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.single_user_answer, parent, false));
            userAnswerTextView = itemView.findViewById(R.id.userAnswerTextView);
            answerImage = itemView.findViewById(R.id.answerImage);
            correctAnswerTextView = itemView.findViewById(R.id.correctAnswerTextView);
        }
        public void bind(UserAnswer userAnswer){
            answerImage.setImageResource(userAnswer.getQuestion());
            correctAnswerTextView.setText(userAnswer.getCorrectAnswer());
            userAnswerTextView.setText(String.valueOf(userAnswer.isUserAnswer()));
        }
    }
    public class UserAnswerAdapter extends RecyclerView.Adapter<UserAnswerViewHolder>{
        ArrayList<UserAnswer> userAnswers;
        public UserAnswerAdapter(ArrayList<UserAnswer> userAnswers) {
            this.userAnswers = userAnswers;
        }

        @Override
        public UserAnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(ResultActivity.this);
            return new UserAnswerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(UserAnswerViewHolder holder, int position) {
            holder.bind(userAnswers.get(position));
        }

        @Override // Сколько всего элементов списка
        public int getItemCount() {
            return userAnswers.size();
        }
    }
}