package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.konkor.R;
import com.example.konkor.helper.RVQuestionNumberAdapter;

public class QuestionActivity extends AppCompatActivity {
    private RVQuestionNumberAdapter adapter;
    private String[] questionNumbers;
    RecyclerView rvQuestionNumbers;
    public static int questionIndex = -1;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        btnSubmit = findViewById(R.id.btn_submit);
        rvQuestionNumbers = findViewById(R.id.question_number_list);
        questionNumbers = this.getResources().getStringArray(R.array.question_numbers);
        adapter = new RVQuestionNumberAdapter(this, questionNumbers);

        rvQuestionNumbers.setAdapter(adapter);
        rvQuestionNumbers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuestionActivity.this, String.valueOf(questionIndex), Toast.LENGTH_SHORT).show();
            }
        });

    }
}