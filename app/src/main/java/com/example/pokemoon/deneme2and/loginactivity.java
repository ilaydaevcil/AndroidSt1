package com.example.pokemoon.deneme2and;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class loginactivity extends AppCompatActivity {

    Database database;
    List<player> players;


    Button button;
    EditText editText;
    Adapterr adapterr;
    Database dt;
    ArrayList<HashMap<String, String>> kisiliste;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginekrani);

        database=new Database(this);
        players=player.cursorToArray(database.Listele());

        button = findViewById(R.id.buttonEkle);
        editText = findViewById(R.id.edittextName);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(editText.getText().toString()))
                {
                    database.KisiEkle(editText.getText().toString());
                    players.add(new player(editText.getText().toString(), dt.getLastId()));
                    editText.setText("");
                    adapterr.notifyDataSetChanged();

                }
                else
                    Toast.makeText(loginactivity.this, "boş yapma ticari yaz", Toast.LENGTH_SHORT).show();


            }


        });


        iniRV();






    }

    private void iniRV() {
        RecyclerView recyclerView = findViewById(R.id.recyleVievisim);
        adapterr = new Adapterr(this, players, database);
        recyclerView.setAdapter(adapterr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
