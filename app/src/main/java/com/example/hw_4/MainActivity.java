package com.example.hw_4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ConstraintLayout mainLayout;
    private TextView welcomeText;
    private TextView instructionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
           setContentView(R.layout.activity_main);


        emailEditText = findViewById(R.id.email_text);
         passwordEditText = findViewById(R.id.pasw_text);
        loginButton = findViewById(R.id.btn);
        mainLayout = findViewById(R.id.main);
            welcomeText = findViewById(R.id.welcome_text);
        instructionText = findViewById(R.id.text_view);


        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);


        loginButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.equals("admin") && password.equals("admin")) {
                 Snackbar.make(mainLayout, "Вы успешно зарегистрировались", Snackbar.LENGTH_LONG).show();
                welcomeText.setVisibility(View.VISIBLE);
                 instructionText.setVisibility(View.GONE);
                emailEditText.setVisibility(View.GONE);
                passwordEditText.setVisibility(View.GONE);
                loginButton.setVisibility(View.GONE);
            } else {
                Snackbar.make(mainLayout, "Неправильный логин и пароль", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            updateButtonBackground();
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    private void updateButtonBackground() {
        if (emailEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty()) {
            loginButton.setBackgroundColor(getResources().getColor(R.color.grey));
        } else {
            loginButton.setBackgroundColor(getResources().getColor(R.color.orange));
        }
    }
}