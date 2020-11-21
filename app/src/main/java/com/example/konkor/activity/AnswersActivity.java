package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.konkor.R;
import com.example.konkor.adapter.RVAnswersListAdapter;
import com.example.konkor.models.Question;

import java.util.ArrayList;

public class AnswersActivity extends AppCompatActivity {
    private RecyclerView rvAnswersList;
    private RVAnswersListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        int[] dummyUserAnswers = {1,0,3,2,2,2,-1,1,-1,1,1,2,2,2,2,2,2,2,-1};
        ArrayList<Question> dummyQuestions = getDummyQuestions();
        adapter = new RVAnswersListAdapter(getApplicationContext(),dummyQuestions, dummyUserAnswers );
        rvAnswersList = findViewById(R.id.rv_answers_list);
        rvAnswersList.setAdapter(adapter);
        rvAnswersList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private ArrayList<Question> getDummyQuestions(){
        String [] dummyAnswers = {"گزینه یک", "گزینه دو ", "گزینه سه", "گزینه چهار"};
        ArrayList<Question> dummyQuestions = new ArrayList<>();
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,2,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,2,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,2,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,3,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,0,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,2,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,2,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,1,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,2,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,1,null, null));
        dummyQuestions.add(new Question(getString(R.string.dummy_question),dummyAnswers,2,null, null));

        return dummyQuestions;
    }
}