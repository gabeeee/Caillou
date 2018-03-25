package com.example.gabriel.caillou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    Button signUpButton;
    EditText firstNameTextBox, lastNameTextBox, passwordTextBox, emailTextBox;
    String firstName, lastName, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = findViewById(R.id.signUpButton);
        firstNameTextBox = findViewById(R.id.firstNameTextBox);
        lastNameTextBox = findViewById(R.id.lastNameTextBox);
        passwordTextBox = findViewById(R.id.passwordTextBox);
        emailTextBox = findViewById(R.id.emailTextBox);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName =  firstNameTextBox.getText().toString();
                lastName = lastNameTextBox.getText().toString();
                password = passwordTextBox.getText().toString();
                email = emailTextBox.getText().toString();

                //TODO: check firstname, lastname, password, and email validity


                System.out.println(firstName + " " + lastName + " " + password + " " + email);
                //Toast.makeText(getApplicationContext(), (firstName + " " + lastName + " " + password + " " + email) , Toast.LENGTH_SHORT).show();


                finish();
            }
        });

    }
}
