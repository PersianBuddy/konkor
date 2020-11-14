package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.konkor.MainActivity;
import com.example.konkor.R;
import com.example.konkor.helper.SessionManager;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout txtUserNameOrEmail, txtPassword;
    Button btnLogin;
    SessionManager sessionManager;
    TextView txtRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUserNameOrEmail = findViewById(R.id.txt_field_user_name_email);
        txtPassword = findViewById(R.id.txt_field_password);
        btnLogin = findViewById(R.id.btn_login);
        txtRegister =findViewById(R.id.txt_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });


        txtUserNameOrEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    txtUserNameOrEmail.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    txtPassword.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.sessionExist()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private boolean validateInput(){
        if (txtUserNameOrEmail.getEditText().getText().toString().equals("")){
            txtUserNameOrEmail.setErrorEnabled(true);
            txtUserNameOrEmail.setError(getString(R.string.empty_user_name_email_error));
            return false;
        }
        if (txtPassword.getEditText().getText().toString().equals("")){
            txtPassword.setErrorEnabled(true);
            txtPassword.setError(getString(R.string.error_empty_password));
            return false;
        }
        return true;
    }
}