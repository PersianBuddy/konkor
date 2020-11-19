package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.konkor.R;
import com.example.konkor.helper.RVQuestionNumberAdapter;

public class QuestionActivity extends AppCompatActivity {
    private RVQuestionNumberAdapter adapter;
    private String[] questionNumbers;
    RecyclerView rvQuestionNumbers;
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

    }
}