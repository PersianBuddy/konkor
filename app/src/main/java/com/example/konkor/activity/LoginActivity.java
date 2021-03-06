package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.konkor.MainActivity;
import com.example.konkor.R;
import com.example.konkor.helper.SessionManager;
import com.example.konkor.helper.UserDbHelper;
import com.example.konkor.models.User;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout txtUserNameOrEmail, txtPassword;
    Button btnLogin;
    SessionManager sessionManager;
    TextView txtRegister;
    UserDbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUserNameOrEmail = findViewById(R.id.txt_field_user_name_email);
        txtPassword = findViewById(R.id.txt_field_password);
        btnLogin = findViewById(R.id.btn_login);
        txtRegister =findViewById(R.id.txt_register);
        sessionManager = new SessionManager(getApplicationContext());
        dbHelper = new UserDbHelper(getApplicationContext());

        autoFill();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()){
                    String tmp_userNameOrEmail = txtUserNameOrEmail.getEditText().getText().toString().trim();
                    String tmp_pass = txtPassword.getEditText().getText().toString();
                    if (Patterns.EMAIL_ADDRESS.matcher(tmp_userNameOrEmail).matches()){
                        User tmpUser = dbHelper.getUserByEmail(tmp_userNameOrEmail, tmp_pass);
                        if ( tmpUser!= null){
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            sessionManager.saveData(tmpUser);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }else {
                            new MaterialAlertDialogBuilder(LoginActivity.this)
                                    .setTitle("خطا")
                                    .setMessage("آدرس ایمیل یا رمز عبور اشتباه می باشد")
                                    .setPositiveButton(R.string.okay, null)
                                    .show();

                        }
                    }else {
                        User tmpUser = dbHelper.getUserByUserName(tmp_userNameOrEmail, tmp_pass);
                        if (tmpUser != null){
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            sessionManager.saveData(tmpUser);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }else {
                            new MaterialAlertDialogBuilder(LoginActivity.this)
                                    .setTitle("خطا")
                                    .setMessage("نام کاربری یا رمز عبور اشتباه می باشد")
                                    .setPositiveButton(R.string.okay, null)
                                    .show();
                        }
                    }

                }
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
        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.sessionExist()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        super.onStart();
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

    private void autoFill() {
        Intent intent = getIntent();
        if (intent != null){
            String userName = intent.getStringExtra("user_name");
            if (userName!= null){
                txtUserNameOrEmail.getEditText().setText(userName);
            }
        }
    }
}