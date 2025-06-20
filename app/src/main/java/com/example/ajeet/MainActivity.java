package com.example.ajeet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//    <---------- take variable ------------->

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int flag=0;
    int cout=0;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //        <-----------fetch the data from registration from ----------------->
        Intent fromact = getIntent();
        String title1 = fromact.getStringExtra("title1");
        String title2 = fromact.getStringExtra("title2");


        TextView txt_view = findViewById(R.id.txt_view);
        txt_view.setText( title1 + " v/s " + title2);



//        <------------- call init function for get button ID ------------------>

        init();
        Button btn_restart;

        btn_restart = findViewById(R.id.btn_restart);
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
                Toast.makeText(MainActivity.this, "Restart Successfully", Toast.LENGTH_SHORT).show();

                winner("Restart game Successfully");

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }




//    <--------------- get btn view ID ----------------->

    private  void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

//    <--------- logical part for btn -------------->

public void check(View view)
    {
    //        <--------- detected current button ----------->
        Button btnCurrent = (Button)view;
        if (btnCurrent.getText().toString().equals("")) {
            cout++;
    //    <------------ toggal btn ----------------->
            if (flag == 0) {
                btnCurrent.setText("X");
                flag = 1;
            } else {
                btnCurrent.setText("O");
                flag = 0;
            }

    //    <--------------- btn ke value ko string me conversion ----------------->

            if (cout > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

    //        <------------ Condition --------------->
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
    //            1
                    Toast.makeText(this, "winner is " + b1, Toast.LENGTH_SHORT).show();
                    winner("WINNER IS : "+b1);
                    newGame();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
    //            2
                    Toast.makeText(this, "winner is " + b4, Toast.LENGTH_SHORT).show();
                    winner("WINNER IS : "+b4);
                    newGame();

                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
    //            3
                    Toast.makeText(this, "winner is " + b7, Toast.LENGTH_SHORT).show();
                    winner("WINNER IS : "+b7);
                    newGame();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
    //            4
                    Toast.makeText(this, "winner is " + b1, Toast.LENGTH_SHORT).show();btn1.setText("");
                    winner("WINNER IS : "+b1);
                    newGame();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
    //            5
                    Toast.makeText(this, "winner is " + b2, Toast.LENGTH_SHORT).show();
                    winner("WINNER IS : "+b2);
                    newGame();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
    //            6
                    Toast.makeText(this, "winner is " + b3, Toast.LENGTH_SHORT).show();
                    winner("WINNER IS : "+b3);
                    newGame();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
    //            7
                    Toast.makeText(this, "winner is " + b1, Toast.LENGTH_SHORT).show();
                    winner("WINNER IS : "+b1);
                    newGame();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
    //            8
                    Toast.makeText(this, "winner is " + b3, Toast.LENGTH_SHORT).show();
                    winner("WINNER IS : "+b3);
                    newGame();
                } else if ( !b1.equals("") && !b2.equals("") && !b3.equals("")
                            && !b4.equals("") && !b5.equals("") && !b6.equals("")
                            && !b7.equals("") && !b8.equals("") && !b9.equals("")) {
//                    game is draw
                    Toast.makeText(this,"Game is draw",Toast.LENGTH_SHORT).show();
                    winner("Game is Draw");
                    newGame();
                }


            }
        }

    }



    public void winner(String b){

        Intent iwin = new Intent(MainActivity.this, WinnerActivity.class);
        iwin.putExtra("winner1", b);
        startActivity(iwin);

    }




    public void newGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        cout = 0;
    }

}