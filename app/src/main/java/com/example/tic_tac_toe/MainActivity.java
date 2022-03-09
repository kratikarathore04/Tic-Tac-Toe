package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;                               // widget - import packages
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
int count = 0;                                              // counter value
Boolean turn = true;
Button b[][] = new Button[3][3];                            // 2D array for buttons
Button r;                                                   // reset button
TextView t;                                                 // text view for player who win
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.textview1);                   // findViewById is a method which return object
        r = findViewById(R.id.reset);                       // R - randomly generated class , store record
        b[0][0] = findViewById(R.id.button1);               // Id is the subclass of R
        b[0][1] = findViewById(R.id.button2);
        b[0][2] = findViewById(R.id.button3);
        b[1][0] = findViewById(R.id.button4);               // t, r, b[][] (LHS) all are addresses
        b[1][1] = findViewById(R.id.button5);
        b[1][2] = findViewById(R.id.button6);
        b[2][0] = findViewById(R.id.button7);
        b[2][1] = findViewById(R.id.button8);
        b[2][2] = findViewById(R.id.button9);

    }

    public void clickbox(View v)                        // clickbox - Event Handler
    {                                                   // View is the parent class
        Button b1 = (Button) v;                         // type casting - view into button
        String s=b1.getText().toString();
        if(s.equals("")==false)                         // If button is already clicked before i.e. already have 'x' or 'o'
            return;                                     // equals method compares (t,f), it accept strings or strcharacter

        if(count==0) {
            t.setText("");
        }
        if(turn==true) {
            b1.setText("X");
        } else {
            b1.setText("O");
        }
        count++;

        if(checkforwin()){
            if(turn==true){                                 // true for X
                t.setText("Winner X");
                clear1();
            } else{                                         // false for O
                t.setText("Winner O");
                clear1();
            }
        } else{ if(count == 9){                             // All blocks are filled and no one win
                t.setText("Match Draw");
                clear1();
            }
            turn = !turn;                               // for next player turn

    }
    }

    public boolean checkforwin(){                           // checkboxwin - Event Handler
        String[][] s= new String[3][3];                      // array which read full grid
        int i,j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++) {
                s[i][j] = b[i][j].getText().toString();
            }
        }

        // for row check
        for(i=0;i<3;i++) {
            if (s[i][0].equals(s[i][1]) && s[i][0].equals(s[i][2]) && (s[i][0].equals("") != true)) {
                return true;
            }
        }

        // for column check
        for(i=0;i<3;i++) {
            if (s[0][i].equals(s[1][i]) && s[0][i].equals(s[2][i]) && !s[0][i].equals("")) {
                return true;
            }
        }

        // for diagonal check
        if(s[0][0].equals(s[1][1]) && s[0][0].equals(s[2][2]) && !s[0][0].equals("")) {
            return true;
        }
        if(s[0][2].equals(s[1][1]) && s[0][2].equals(s[2][0]) && !s[0][2].equals("")) {
            return true;
        }
        return false;
    }

    public void clear(View v)                           // Event Handler - for RESET button
    {
        clear1();                                       // need to call clear1 method
        t.setText("");
    }

    public void clear1(){                               // clear1 method
        count = 0;
        turn = true;
        int i , j;
        for(i=0;i<3;i++) {
            for (j = 0; j < 3; j++) {
                b[i][j].setText("");
            }
        }
    }
}