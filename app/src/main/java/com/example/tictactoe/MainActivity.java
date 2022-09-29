package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //0:0,1:X,2: Empty

    int playerActive =0;
    int[] gameState ={2,2,2,2,2,2,2,2,2};
    public static  int count =0;

    boolean gameActive = true;
    int[][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @SuppressLint("SetTextI18n")
    public void onImageTap(View view){
        ImageView imageView =(ImageView)view;
        imageView.setTranslationY(-1000);

     int imageTapped = Integer.parseInt(imageView.getTag().toString());
        if(gameState[imageTapped] == 2 && gameActive) {
            if(count ==9){
                gameActive = false;
            }
            count++;
            gameState[imageTapped]=playerActive;
            if (playerActive == 0) {
                imageView.setImageResource(R.drawable.gblue);
                playerActive = 1;
                TextView status = findViewById(R.id.textView2);
                status.setText("X's Turn");
            } else {
                imageView.setImageResource(R.drawable.ncross);
                playerActive = 0;
                TextView status = findViewById(R.id.textView2);
                status.setText("0's Turn");
            }
            imageView.animate().translationYBy(1000).setDuration(200);
        }
        int draw = 1;
        for(int[]winningPostion: winningPosition){
            if (gameState[winningPostion[0]]==gameState[winningPostion[1]]&&
            gameState[winningPostion[1]] == gameState[winningPostion[2]]&&
            gameState[winningPostion[0]]!=2){
                draw =0;
                String Winner;
                if (gameState[winningPostion[0]]==0){
                    Winner ="O' has won";
                }else{
                    Winner ="X's has won";
                }
                TextView status = findViewById(R.id.textView2);
                status.setText(Winner);
                Button playAgainButton = findViewById(R.id.playAgainButton);
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }
        // draw condition
        if(count ==9 && draw == 1){
            TextView status =findViewById(R.id.textView2);
            status.setText("MATCH DRAW");
            Button playAgainButton = findViewById(R.id.playAgainButton);
            playAgainButton.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("SetTextI18n")
    public void playAgain(View view){
        Button playAgainButton = findViewById(R.id.playAgainButton);
        playAgainButton.setVisibility(View.INVISIBLE);

        TextView status = findViewById(R.id.textView2);
        status.setText("0's Turn");
        gameActive = true;
        playerActive =0;
        count =0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView0)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView1)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView2)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView3)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView4)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView5)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView6)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView7)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView8)).setImageDrawable(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playAgainButton = findViewById(R.id.playAgainButton);
        playAgainButton.setVisibility(View.INVISIBLE);
    }
}