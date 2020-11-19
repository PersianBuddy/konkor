package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private Button btnSubmit;
    private RadioGroup rbgAnswerOptions;
    private RadioButton rbSelectedAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        btnSubmit = findViewById(R.id.btn_next_question);
        rvQuestionNumbers = findViewById(R.id.question_number_list);
        questionNumbers = this.getResources().getStringArray(R.array.question_numbers);
        adapter = new RVQuestionNumberAdapter(this, questionNumbers);
        rbgAnswerOptions = findViewById(R.id.rbg_answer_options);

        rvQuestionNumbers.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rvQuestionNumbers.setLayoutManager(layoutManager);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(QuestionActivity.this, String.valueOf(questionIndex), Toast.LENGTH_SHORT).show();
                adapter.changeAnswerStatus(15, true);
                adapter.notifyItemChanged(15);
//                layoutManager.scrollToPosition(15);
//                adapter.notifyDataSetChanged();
//                rvQuestionNumbers.postDelayed(() -> {
//
//                    if(rvQuestionNumbers.findViewHolderForAdapterPosition(15)!=null )
//                    {
//                        adapter.changeAnswerStatus(15, true);
//                        adapter.notifyItemChanged(15);
////                        View view =  rvQuestionNumbers.findViewHolderForAdapterPosition(15).itemView;
////                         TextView textView=view.findViewById(R.id.txt_question_number_item);
////                         textView.setText("");
////                         textView.setBackground(getResources().getDrawable(R.drawable.ic_done));
//
////                        adapter.setSelectedItemIndex(15);
////                         View view =  rvQuestionNumbers.findViewHolderForAdapterPosition(15).itemView;
////                         TextView textView=view.findViewById(R.id.txt_question_number_item);
////                         textView.setBackground(getResources().getDrawable(R.drawable.solid_circle));
////                         textView.setTextColor(getResources().getColor(R.color.white));
//                    }
//                },50);

            }
        });


        rbgAnswerOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbSelectedAnswer != null){

                    rbSelectedAnswer.setBackground(getResources().getDrawable(R.drawable.custom_border));
                    rbSelectedAnswer.setTextColor(getResources().getColor(R.color.black));
                }

                rbSelectedAnswer = group.findViewById(checkedId);
                rbSelectedAnswer.setBackground(getResources().getDrawable(R.drawable.button_selected));
                rbSelectedAnswer.setTextColor(getResources().getColor(R.color.white));

            }
        });
    }
}