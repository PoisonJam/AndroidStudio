package com.example.magicaltrevor.NewLoginApp;

import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class AppLogin extends AppCompatActivity {
    int lockOut = 3;
    String compUser = "iamsocool";
    String pass = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_login);

        final Button loginButton = findViewById(R.id.Login);
        final Button quitButton = findViewById(R.id.Quit);
        final TextView successBox = findViewById(R.id.success);

        final String username = String.valueOf(R.id.usernameText);
        final String password = String.valueOf(R.id.passwordText);

        loginButton.setOnClickListener
                (new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        if(lockOut > 0)
                        {
                            if(username == compUser && password == pass)
                            {
                                successBox.setText("Success");
                            }
                            else
                            {
                                lockOut --;
                                successBox.setText("Fail you have " + lockOut + " attempts left");
                            }
                        }
                        else
                        {
                            loginButton.setClickable(false);
                        }
                    }
                });
    }
}

