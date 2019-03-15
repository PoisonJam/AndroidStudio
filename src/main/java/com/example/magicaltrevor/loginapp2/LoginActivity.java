package com.example.magicaltrevor.loginapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    int lockOut = 3;
    String userLogin = "user";
    String userPass = "password";

    EditText userName;
    EditText password;
    EditText successBox;
    Button login;
    Button quit;

    private View.OnClickListener quitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.exit(0);
        }
    };
    private View.OnClickListener logListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String user = userName.getText().toString();
            String pass = password.getText().toString();

            if(lockOut > 0){
                if(user == userLogin && pass == userPass){
                    successBox.setText("Success");
                }
                else{
                    lockOut--;
                    successBox.setText("Failed, you have " + lockOut + " attempts remaining");
                }
            }
            else{
                successBox.setText("Your account has been locked");
                login.setEnabled(false);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.loginButton);
        quit = (Button) findViewById(R.id.Quit);
        userName = (EditText) findViewById(R.id.userText);
        password = (EditText) findViewById(R.id.passText);
        successBox = (EditText) findViewById(R.id.Success);

        quit.setOnClickListener(quitListener);
        login.setOnClickListener(logListener);
    }
}