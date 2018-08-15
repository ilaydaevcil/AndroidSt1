package com.example.pokemoon.deneme2and;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputLayout emailtest;
    TextInputLayout passwordtest;
    Button giristest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qwe);



        emailtest=findViewById(R.id.emailid);
        passwordtest=findViewById(R.id.passwordid);
        giristest=findViewById(R.id.login);

        giristest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailtest.getEditText().getText().toString().equals(""))
                    emailtest.setError("kullanıcı bos olamaz ");
                if(passwordtest.getEditText().getText().toString().equals(""))
                    passwordtest.setError("sifre bos olamaz ");
                else if (emailtest.getEditText().getText().toString().equals("ilayda") && passwordtest.getEditText().getText().toString().equals("123"))
                {
                    Toast.makeText(MainActivity.this, "helal ula", Toast.LENGTH_SHORT).show();
                    Intent inte= new Intent(MainActivity.this,loginactivity.class);
                    startActivity(inte);

                }

                else
                    Toast.makeText(MainActivity.this, "giremedi kii", Toast.LENGTH_SHORT).show();

            }
        });



        }
    }
