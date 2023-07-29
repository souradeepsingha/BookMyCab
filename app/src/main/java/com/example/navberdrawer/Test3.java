package com.example.navberdrawer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class test3 extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView navHeaderText;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if the user is already logged in
        if (isLoggedIn()) {
            // User is already logged in, redirect to MainActivity
            startActivity(new Intent(test3.this, MainActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_loginpage);

        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        // Check username and password here
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Example login logic (replace with your own)
        if (!username.isEmpty() && !password.isEmpty()) {
            // Mark user as logged in
            setLoggedIn(true);

            startActivity(new Intent(test3.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("login1", MODE_PRIVATE);
        return sharedPreferences.getBoolean("loggedIn1", false);
    }

    private void setLoggedIn(boolean loggedIn) {
        SharedPreferences sharedPreferences = getSharedPreferences("login1", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("loggedIn1", loggedIn);
        editor.apply();
    }
}
