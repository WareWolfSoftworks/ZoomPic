package com.warewolfsoftworks.zoompic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ScoreActivity extends Activity implements OnClickListener{


	int guesses, zooms, index;
	TextView tvTimeRemaining, tvGuesses, tvScore, tvZooms;
    ArrayList<String> category;
	Button bNext;
    long seconds, score, cumulativeScore;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_activity);
        setUpWidgets();
		scoreScreen();
		
	}

	private void setUpWidgets() {
		// TODO Auto-generated method stub
		bNext = (Button) findViewById(R.id.bNext);
		tvTimeRemaining = (TextView) findViewById (R.id.tvTimeRemaining);
		tvGuesses = (TextView) findViewById (R.id.tvGuesses);
		tvScore = (TextView) findViewById (R.id.tvScore);
        tvZooms = (TextView) findViewById(R.id.tvZooms);
		Intent intent = getIntent();
		guesses = intent.getIntExtra("guesses", 0);
		category = intent.getStringArrayListExtra("strings");
        seconds = intent.getLongExtra("seconds", 0);
        zooms = intent.getIntExtra("zooms", 0);
        cumulativeScore = intent.getLongExtra("cumulativeScore", 0);
        index = intent.getIntExtra("index", 0);
		bNext.setOnClickListener(this);
    }
	
	private void scoreScreen() {
		// TODO Auto-generated method stub
		tvGuesses.setText("Number of Guesses: " + guesses);
        tvZooms.setText("Zoom Outs Used: " + zooms);
        seconds = 120 - seconds;
        score = (seconds * 31) - (guesses * 23) - (zooms * 42);
        tvScore.setText("Score: " + score);
        tvTimeRemaining.setText("Time Remaining: " + String.format(" %d Min %d Sec",
                TimeUnit.SECONDS.toMinutes(seconds),
                TimeUnit.SECONDS.toSeconds(seconds) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(seconds))));
        cumulativeScore += score;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (v.getId() == R.id.bNext);
        {
            index++;
            if (index == 11) {
                Intent finish = new Intent(this, FinalScore.class);
                finish.putExtra("cumulativeScore", cumulativeScore);
                startActivity(finish);
            } else {
                Intent intent = new Intent(this, Game.class);
                intent.putExtra("strings", category);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
                startActivity(intent);
                finish();
            }
        }
	}

    @Override
    public void onBackPressed() {
    }
}
