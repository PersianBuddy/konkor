package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.konkor.R;
import com.example.konkor.helper.RVQuestionNumberAdapter;

public class QuestionActivity extends AppCompatActivity {
    private RVQuestionNumberAdapter adapter;
    private String[] questionNumbers;
    RecyclerView rvQuestionNumbers;
    private Button btnNextQuestion, btnEndQuiz;
    private RadioGroup rbgAnswerOptions;
    private RadioButton rbSelectedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        btnNextQuestion = findViewById(R.id.btn_next_question);
        btnEndQuiz = findViewById(R.id.btn_end_quiz);
        rvQuestionNumbers = findViewById(R.id.question_number_list);
        questionNumbers = this.getResources().getStringArray(R.array.question_numbers);
        adapter = new RVQuestionNumberAdapter(this, questionNumbers);
        rbgAnswerOptions = findViewById(R.id.rbg_answer_options);

        rvQuestionNumbers.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rvQuestionNumbers.setLayoutManager(layoutManager);

        btnNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeAnswerStatus(15, true);
                adapter.notifyItemChanged(15);
            }
        });


        rbgAnswerOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbSelectedAnswer != null){

                    rbSelectedAnswer.setBackground(getResources().getDrawable(R.drawable.solid_round_white_rectangle));
                    rbSelectedAnswer.setTextColor(getResources().getColor(R.color.black));
                }

                rbSelectedAnswer = group.findViewById(checkedId);
                rbSelectedAnswer.setBackground(getResources().getDrawable(R.drawable.button_selected));
                rbSelectedAnswer.setTextColor(getResources().getColor(R.color.white));

            }
        });

        btnEndQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizResultActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}