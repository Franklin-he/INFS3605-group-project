package com.example.infs3605_group_project.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3605_group_project.R;
import com.example.infs3605_group_project.database.UserDatabase;

public class Login extends AppCompatActivity {

    public Button login;
    public Button signup;
    public EditText username, userpassword;
    public String user, password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = findViewById(R.id.signup_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, CreateUser.class));
            }
        });

        username = findViewById(R.id.userName);
        userpassword = findViewById(R.id.password);

        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = username.getText().toString();
                password = userpassword.getText().toString();

                try {
                    Context context = v.getContext();
                    UserDatabase db = UserDatabase.getInstance(context);
                    String thisuser = db.userDao().getUser(user,password);
                    String thispass = db.userDao().getPassword(user,password);

                    if (thisuser.equals(user) && thispass.equals(password)) {
                        Intent intent = new Intent(context, GeneralInfo.class);
                        intent.putExtra("user", thisuser);
                        context.startActivity(intent);
                    } else  {
                        Toast.makeText(getApplicationContext(), "Incorrect username or password.",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Incorrect username or password.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
