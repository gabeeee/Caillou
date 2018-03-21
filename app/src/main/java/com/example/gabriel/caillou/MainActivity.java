package com.example.gabriel.caillou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView signUp;
    EditText usernameTextBox;
    EditText passwordTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = (TextView) findViewById(R.id.signUpLabel);

        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                System.out.println("SignUp Activity Started");
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void login(View view) throws JSONException {
        String username, password;
        JSONObject payload = new JSONObject(); //JSON Exception thrown must be applied after.

        usernameTextBox = (EditText) findViewById(R.id.loginBox);
        passwordTextBox = (EditText) findViewById(R.id.loginPasswordBox);

        username = usernameTextBox.getText().toString();
        password = passwordTextBox.getText().toString();

        payload.put("username", username);
        payload.put("password", password);

        if (payload != null) // This function should check the validity of the object and check if
                             // payload was sent and secured.
        {
            // Set up a dummy toast message
            Toast.makeText(getApplicationContext(), "Hello " + username, Toast.LENGTH_SHORT).show();
        }

    }
}
