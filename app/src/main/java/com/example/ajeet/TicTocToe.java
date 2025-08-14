package com.example.ajeet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TicTocToe extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ajeet);


        EditText fname, sname;
        Button btnNext;

        fname = findViewById(R.id.fname);
        sname = findViewById(R.id.sname);
        btnNext = findViewById(R.id.btnNext);


        Intent iNext;
        iNext = new Intent(TicTocToe.this, MainActivity.class);
        
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f = fname.getText().toString();
                String s = sname.getText().toString();

                // Save names
                SharedPreferences prefs = getSharedPreferences("GameData", MODE_PRIVATE);
                prefs.edit()
                        .putString("player1", f)
                        .putString("player2", s)
                        .apply();

                iNext.putExtra("title1", f);
                iNext.putExtra("title2", s);
                startActivity(iNext);
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }
}
