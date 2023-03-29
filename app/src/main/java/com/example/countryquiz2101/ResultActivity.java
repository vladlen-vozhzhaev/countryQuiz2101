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
import android.widget.LinearLayout;
import android.widget.TextView;

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
        String[] strings = new String[100];
        for (int i = 0; i < 100; i++) {
            strings[i] = "Hello "+i;
        }
        recycleView.setLayoutManager(new LinearLayoutManager(ResultActivity.this));
        UserAnswerAdapter adapter = new UserAnswerAdapter(strings);
        recycleView.setAdapter(adapter);

    }
    public class UserAnswerViewHolder extends RecyclerView.ViewHolder{
        TextView userAnswerTextView;
        public UserAnswerViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.single_user_answer, parent, false));
            userAnswerTextView = itemView.findViewById(R.id.userAnswerTextView);
        }
        public void bind(String string){
            userAnswerTextView.setText(string);
        }
    }
    public class UserAnswerAdapter extends RecyclerView.Adapter<UserAnswerViewHolder>{
        String[] strings;
        public UserAnswerAdapter(String[] strings) {
            this.strings = strings;
        }

        @Override
        public UserAnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(ResultActivity.this);
            return new UserAnswerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(UserAnswerViewHolder holder, int position) {
            holder.bind(strings[position]);
        }

        @Override // Сколько всего элементов списка
        public int getItemCount() {
            return strings.length;
        }
    }
}