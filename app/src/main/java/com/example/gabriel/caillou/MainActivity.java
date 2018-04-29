package com.example.gabriel.caillou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
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
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView signUp;
    EditText usernameTextBox;
    EditText passwordTextBox;
    User user;

    RequestQueue rq;
    String url = "http://34.201.255.155/scripts/login.php";
    String firstName, lastName, error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = (TextView) findViewById(R.id.signUpLabel);

        populate();

        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                System.out.println("SignUp Activity Started");

                passwordTextBox = findViewById(R.id.loginPasswordBox);
                passwordTextBox.setText("");

                // TODO: Create class for User data (implement parcable to pass intent along with
                // class object)
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


        rq = Volley.newRequestQueue(this);

        //sendJsonRequest();

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.d("Error.Response", error.toString());
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("email", "pizza@gmail.com");
                    params.put("psw", "pizza");

                    return params;
                }
            }; rq.add(postRequest);

        /*JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

        rq.add(getRequest);*/

        // TODO: Open dashboard activity send JSONRequest should probably return a boolean value.
        // To make sure that user doesn't reach next activity if the login page doesn't let them.
        Intent intent = new Intent(MainActivity.this, DashboardHomev2.class);
        intent.putExtra("Example User", user);
        startActivity(intent);
    }

    public void sendJsonRequest()
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    firstName = response.getString("email");
                    lastName = response.getString("psw");


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

    public void populate()
    {
        user = new User("Pablo", "Pizzazo");
        user.setEmail("Pablito@yago.com");
        user.addTeam(new Team("Group 1", "Group 1 description"),
                     new Team("Group 2", "Group 2 description"),
                     new Team("Group 3", "Group 3 description"));
    }
}
