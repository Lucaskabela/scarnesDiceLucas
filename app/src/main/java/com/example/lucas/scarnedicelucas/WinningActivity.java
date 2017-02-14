package com.example.lucas.scarnedicelucas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WinningActivity extends AppCompatActivity {

    TextView winnerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
        winnerText = (TextView) findViewById(R.id.winnerText);

        Intent winner = getIntent();
        String winWho = winner.getStringExtra("winner");
        winnerText.setText(winWho);
    }
}
