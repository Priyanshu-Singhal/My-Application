package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class Welcome extends AppCompatActivity
{

    Button btnSignIn;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        //Hiding Action Bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnSignIn = findViewById(R.id.signin);
        btnSignUp = findViewById(R.id.signup);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this, SignIn.class);
                startActivity(intent);
            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling an intent by using Async Task bcoz main thread is doing too much work
                Welcome.NewIntent newIntent = new Welcome.NewIntent();
                newIntent.execute();

            }
        });
    }

    public class NewIntent extends AsyncTask {
        @Override
        protected Object doInBackground(Object... objects) {
            try {
                Intent intent = new Intent(Welcome.this, SignUp.class);
                startActivity(intent);
            } catch (Exception e) {
                System.out.println(e);
            }
            return null;
        }
    }
}
