package com.example.lucas.scarnedicelucas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // UI Elements
    ImageView diceImage;
    TextView playerOneScoreText;
    TextView playerTwoScoreText;
    TextView currentScoreText;
    int playerOneScore;
    int playerTwoScore;
    int currentScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage = (ImageView) findViewById(R.id.dice_image);
        playerOneScoreText = (TextView) findViewById(R.id.player_1_score);
        playerTwoScoreText = (TextView) findViewById(R.id.player_2_score);
        currentScoreText = (TextView) findViewById(R.id.current_score);

        playerOneScore = 0;
        playerTwoScore = 0;
        currentScore = 0;
    }

    public void roll(View view) {
        int rolledNumber =(int)(Math.random() * 6) + 1;

        currentScore += rolledNumber;
        currentScoreText.setText("" + currentScore);
        switch (rolledNumber) {
            case 1: diceImage.setImageResource(R.drawable.dice1);
                currentScore = 0;
                currentScoreText.setText("0");
                p2Turn();
                break;
            case 2: diceImage.setImageResource(R.drawable.dice2);
                break;
            case 3: diceImage.setImageResource(R.drawable.dice3);
                break;
            case 4: diceImage.setImageResource(R.drawable.dice4);
                break;
            case 5: diceImage.setImageResource(R.drawable.dice5);
                break;
            case 6: diceImage.setImageResource(R.drawable.dice6);
                break;
        }
    }

    public void hold(View view) {
        playerOneScore += currentScore;
        playerOneScoreText.setText("" + playerOneScore);
        currentScoreText.setText("0");
        currentScore = 0;
        if(playerOneScore > 100){
            playerOneScore = 0;
            playerTwoScore = 0;
            currentScore = 0;
            playerOneScoreText.setText("0");
            playerTwoScoreText.setText("0");
            currentScoreText.setText("0");
            Intent win = new Intent(getApplicationContext(), WinningActivity.class);
            win.putExtra("winner", "Player Won");
            startActivity(win);
        }
        p2Turn();
    }

    public void reset(View view) {

    }

    private void p2Turn(){
        int p2RoundTotal = 0;
        int randNum;

        for(int i = 0; i < 3; i++){
            randNum = (int) (Math.random() * 6) + 1;
            p2RoundTotal += randNum;

            if(randNum == 1){
                p2RoundTotal = 0;
                Toast.makeText(getApplicationContext(), "Player 2 rolled a 1!", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        playerTwoScore += p2RoundTotal;

        if(playerTwoScore > 100){
            playerOneScore = 0;
            playerTwoScore = 0;
            currentScore = 0;
            playerOneScoreText.setText("0");
            playerTwoScoreText.setText("0");
            currentScoreText.setText("0");
            Intent win = new Intent(getApplicationContext(), WinningActivity.class);
            win.putExtra("winner", "Computer Won");
            startActivity(win);
        }
        playerTwoScoreText.setText("" + playerTwoScore);
    }
}
