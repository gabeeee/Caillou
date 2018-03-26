package com.example.gabriel.caillou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView signUp;
    EditText usernameTextBox;
    EditText passwordTextBox;

    RequestQueue rq;
    String url = "http://192.168.0.17/login.php";
    String firstName, lastName, error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = (TextView) findViewById(R.id.signUpLabel);

        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                System.out.println("SignUp Activity Started");

                // TODO: This could be redundant...
                passwordTextBox = findViewById(R.id.loginPasswordBox);
                passwordTextBox.setText("");

                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void login(View view) throws JSONException, IOException {
        String username, password;
        JSONObject payload = new JSONObject(); //JSON Exception thrown must be applied after.

        usernameTextBox = (EditText) findViewById(R.id.loginBox);
        passwordTextBox = (EditText) findViewById(R.id.loginPasswordBox);

        username = usernameTextBox.getText().toString();
        password = passwordTextBox.getText().toString();

        payload.put("username", username);
        payload.put("password", password);

        // Comment out payload
        // sendJsonRequest function should have covered any exceptions. Might want to return a
        // boolean data type.

        /*
        if (payload != null) // This function should check the validity of the object and check if
                             // payload was sent and secured.
        {
            // Set up a dummy toast message
            Toast.makeText(getApplicationContext(), "Hello " + username, Toast.LENGTH_SHORT).show();
        } */

        rq = Volley.newRequestQueue(this);

        sendJsonRequest();

        // TODO: Open dashboard activity send JSONRequest should probably return a boolean value.
        // To make sure that user doesn't reach next activity if the login page doesn't let them.

    }

    public void sendJsonRequest()
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    firstName = response.getString("firstName");
                    lastName = response.getString("lastName");

                    // Toast test
                    Toast.makeText(getApplicationContext(), "Hello " + firstName + lastName, Toast.LENGTH_SHORT).show();

                    System.out.println(firstName + "------" + lastName);


                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("Error: Didn't recieve JSON payload.");
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Look into making this into a popup window.
                System.out.println("Error: Couldn't communicate to the server");
                Toast.makeText(getApplicationContext(), "Error: Couldn't communicate to the server", Toast.LENGTH_SHORT).show();
            }
        });

        rq.add(jsonObjectRequest);
    }
}
