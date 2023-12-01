package com.example.approject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText username = findViewById(R.id.username);
        MaterialButton regbtn = findViewById(R.id.signupbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();
                Toast.makeText(Register.this, "Username is " + username1, Toast.LENGTH_SHORT).show();

                // Open the Payment activity
                Intent intent = new Intent(Register.this, PaymentpageActivity.class); // Replace PaymentActivity with the correct activity name
                startActivity(intent);
            }
        });
    }
}
