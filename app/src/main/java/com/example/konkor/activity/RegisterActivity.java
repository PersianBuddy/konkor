package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.konkor.R;
import com.example.konkor.helper.UserDbHelper;
import com.example.konkor.models.User;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout txtLayoutUserName, txtLayoutEmail, txtLayoutPass, txtLayoutRepeatPass;
    private Button btnRegister;
    private TextView txtLogin;
    UserDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtLayoutUserName = findViewById(R.id.txt_field_user_name);
        txtLayoutEmail = findViewById(R.id.txt_field_email);
        txtLayoutPass = findViewById(R.id.txt_field_password);
        txtLayoutRepeatPass = findViewById(R.id.txt_field_repeat_pass);
        txtLogin =findViewById(R.id.txt_login);
        btnRegister = findViewById(R.id.btn_register);
        dbHelper = new UserDbHelper(getApplicationContext());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()){
                    String email = txtLayoutEmail.getEditText().getText().toString();
                    String userName = txtLayoutUserName.getEditText().getText().toString();
                    String password = txtLayoutPass.getEditText().getText().toString();
                    
                    User user = new User(email, userName, password);
                    if(dbHelper.insertUser(user)) {
                        Toast.makeText(RegisterActivity.this, "User Added to database", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // Remove error as text of field changes
        txtLayoutUserName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    txtLayoutUserName.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtLayoutEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    txtLayoutEmail.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtLayoutPass.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    txtLayoutPass.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtLayoutRepeatPass.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    txtLayoutRepeatPass.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    private Boolean validateInput() {
        if (txtLayoutEmail.getEditText().getText().toString().equals("")){
            txtLayoutEmail.setErrorEnabled(true);
            txtLayoutEmail.setError(getString(R.string.error_empty_email_field));
            return false;
        }else if (txtLayoutUserName.getEditText().getText().toString().equals("")){

            txtLayoutUserName.setErrorEnabled(true);
            txtLayoutUserName.setError(getString(R.string.error_empty_user_name));
            return false;
        }else if (txtLayoutPass.getEditText().getText().toString().equals("")){
            txtLayoutPass.setErrorEnabled(true);
            txtLayoutPass.setError(getString(R.string.error_empty_password));
            return false;
        }else if (txtLayoutRepeatPass.getEditText().getText().toString().equals("")){
            txtLayoutRepeatPass.setErrorEnabled(true);
            txtLayoutRepeatPass.setError(getString(R.string.error_empty_password_repeat));
            return false;
        }else if (!txtLayoutPass.getEditText().getText().toString().equals(txtLayoutRepeatPass.getEditText().getText().toString()) ){
            txtLayoutRepeatPass.setErrorEnabled(true);
            txtLayoutRepeatPass.setError(getString(R.string.error_password_mismatch));
            return false;
        }

        return true;
    }
}