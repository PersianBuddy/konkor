package com.example.konkor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.konkor.activity.LoginActivity;
import com.example.konkor.activity.QuizActivity;
import com.example.konkor.activity.RegisterActivity;
import com.example.konkor.helper.SessionManager;

public class MainActivity extends AppCompatActivity {
    private ImageButton imgBtnStartQuiz, btnLogout;
    private SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btnLogout = findViewById(R.id.btn_logout);
        imgBtnStartQuiz = findViewById(R.id.img_btn_start_quiz);
        sessionManager = new SessionManager(getApplicationContext());


        imgBtnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(intent);
            }
        });

        //logout
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sessionManager.clearSession();
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        });
    }
}