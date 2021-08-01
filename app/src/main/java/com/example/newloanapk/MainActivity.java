package com.example.newloanapk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button btn;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.length() == 0) {
                    email.setError("Please Enter Your Email");
                } else if (password.length() == 0) {
                    password.setError("Please Enter Your Password");
                } else {
                    String uemail = email.getText().toString();
                    String upass = password.getText().toString();
                    String url = "https://demo.microfinancesoftware.in/testing/public/api/auth/login";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    Toast.makeText(MainActivity.this, response.trim(), Toast.LENGTH_SHORT).show();

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                    Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() {

                            Map<String, String> params = new HashMap<String, String>();
                            params.put("email", s);
                            params.put("password", s);
                            return params;

                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    requestQueue.add(stringRequest);
                }
            }
        });

    }
}