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
import com.example.infs3605_group_project.database.User;
import com.example.infs3605_group_project.database.UserDatabase;

public class CreateUser extends AppCompatActivity {

    public Button back;
    public Button create;
    public EditText username;
    public EditText userpassword;

    public String name;
    public String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);


        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateUser.this, Login.class));
            }
        });

        username = findViewById(R.id.createuserName);
        userpassword = findViewById(R.id.createpassword);

        create = findViewById(R.id.create_button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = username.getText().toString();
                password = userpassword.getText().toString();

                User user = new User(name, password);
                try {
                    Context context = v.getContext();
                    UserDatabase db = UserDatabase.getInstance(context);
                    db.userDao().createUser(user);

                    Toast.makeText(getApplicationContext(), "User Created!",Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Username has been used, try another!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
