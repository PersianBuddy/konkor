package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.konkor.R;

public class QuizResultActivity extends AppCompatActivity {
    private ProgressBar pbQuizResult;
    private Button btnShowAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        pbQuizResult = findViewById(R.id.pb_quiz_result);
        btnShowAnswers = findViewById(R.id.btn_show_answers);

        btnShowAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AnswersActivity.class);
                startActivity(intent);
            }
        });
        setQuizResult(1);
    }

    private void setQuizResult(int score){
        LayerDrawable pbLayerDrawable = (LayerDrawable) pbQuizResult.getProgressDrawable();
        Drawable pbDrawable = pbLayerDrawable.getDrawable(1);
        int progress =(int) (((float)score/20.0) * 100);
        pbQuizResult.setProgress(progress);
        if (progress <  50){
            pbDrawable.setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN);
        }else if (progress <= 70){
            pbDrawable.setColorFilter(getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_IN);
        }else if (progress <= 80){
            pbDrawable.setColorFilter(getResources().getColor(R.color.light_green), PorterDuff.Mode.SRC_IN);
        }else {
            pbDrawable.setColorFilter(getResources().getColor(R.color.green), PorterDuff.Mode.SRC_IN);
        }
    }
}