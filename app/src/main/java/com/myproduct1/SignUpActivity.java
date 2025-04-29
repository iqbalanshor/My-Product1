package com.myproduct1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword;
    private Button btnSignIn;
    private TextView tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Inisialisasi view
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignIn = findViewById(R.id.tvSignIn);

        // Tombol Log In ditekan
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Disini bisa lanjut ke proses login / signup, misal kirim ke API
                    Toast.makeText(SignUpActivity.this, "Signed up successfully!", Toast.LENGTH_SHORT).show();

                    // Contoh lanjut ke halaman lain setelah signup sukses
                    // startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                    // finish();
                }
            }
        });

        // Kalau teks "Sign in" ditekan
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Contoh berpindah ke halaman login
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
