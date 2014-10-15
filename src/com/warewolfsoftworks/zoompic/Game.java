package com.warewolfsoftworks.zoompic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity implements OnClickListener{
	
	ArrayList<String> category;
	WebView wvPicture;
	TextView tvTimer;
	EditText etGuess;
	Button bZoom, bGuess;
	String answer;
	int index, guesses, zooms;
    long seconds, cumulativeScore;
    CountDownTimer timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		setUpWidgets();
		game();
		
	}
	
	private void setUpWidgets() {
		bZoom = (Button) findViewById(R.id.bZoom);
		bGuess = (Button) findViewById(R.id.bGuess);
		tvTimer = (TextView) findViewById(R.id.tvTimer);
		etGuess = (EditText) findViewById(R.id.etGuess);
		wvPicture = (WebView) findViewById(R.id.wvPicture);
		bZoom.setOnClickListener(this);
		bGuess.setOnClickListener(this);
        category = new ArrayList<String>();
		Intent intent = getIntent();
        index = intent.getIntExtra("index", 1);
		category = intent.getStringArrayListExtra("strings");
        cumulativeScore = intent.getLongExtra("cumulativeScore", 0);
	}
	
	private void game() {
		// TODO Auto-generated method stub
        wvPicture.loadUrl(category.get(index));
		wvPicture.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		wvPicture.setScrollbarFadingEnabled(false);
		wvPicture.setInitialScale(3000);
		guesses = 0;
        seconds = 0;
		timer = new CountDownTimer(120000, 1000) {

			public void onTick(long millisUntilFinished) {
                seconds++;
			    tvTimer.setText(""+String.format(" %d Min %d Sec", 
			                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
			                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - 
			                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
			    }

	        public void onFinish() {
                timer.cancel();
	        	Intent loseIntent = new Intent(getApplicationContext(), LoseScreen.class);
                loseIntent.putExtra("strings", category);
                loseIntent.putExtra("cumulativeScore", cumulativeScore);
                loseIntent.putExtra("index", index);
	            startActivity(loseIntent);
                finish();
	        }
	     }.start();
		};
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.bZoom) {
            zooms++;
			wvPicture.zoomOut();
		}
		if (v.getId() == R.id.bGuess){
			answer = etGuess.getText().toString().toLowerCase();
			if (answer != null && !answer.isEmpty()) {
				  checkAnswer();
				}
		}
	}

	private void checkAnswer() {
		// TODO Auto-generated method stub
		if (category.get(0).equals("landmarks")){
			landmarksAnswers();
		}
		if (category.get(0).equals("wildlife")){
			wildlifeAnswers();
		}
	}

	private void landmarksAnswers() {
		// TODO Auto-generated method stub
		guesses++;

		if (category.get(index).equals("file:///android_asset/pics/landmarks/colosseum.jpg")){
			if (answer.equals("colosseum") || answer.equals("the colosseum") || answer.equals("the roman colosseum")
					|| answer.equals("roman colosseum") || answer.equals("the coliseum")  || answer.equals("coliseum")
					|| answer.equals("the roman coliseum") || answer.equals("roman coliseum") || answer.equals("coloseum")
                    || answer.equals("the coloseum") || answer.equals("the roman coloseum") || answer.equals("roman coloseum")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		
		if (category.get(index).equals("file:///android_asset/pics/landmarks/eiffel_tower.jpg")){
			if (answer.equals("eiffel tower") || answer.equals("the eiffel tower")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		
		if (category.get(index).equals("file:///android_asset/pics/landmarks/golden_gate.jpg")){
			if (answer.equals("golden gate bridge") || answer.equals("golden gate") || answer.equals("the golden gate")
					|| answer.equals("the golden gate bridge")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds",seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		
		if (category.get(index).equals("file:///android_asset/pics/landmarks/mount_rushmore.jpg")){
			if (answer.equals("mount rushmore") || answer.equals("mnt rushmore") || answer.equals("rushmore")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		if (category.get(index).equals("file:///android_asset/pics/landmarks/grand_canyon.jpg")){
			if (answer.equals("grand canyon") || answer.equals("the grand canyon")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		if (category.get(index).equals("file:///android_asset/pics/landmarks/pyramids.jpg")){
			if (answer.equals("pyramids") || answer.equals("the pyramids") || answer.equals("egyptian pyramids")
					|| answer.equals("the egyptian pyramids") || answer.equals("pyramid") || answer.equals("the pyramid")
					|| answer.equals("egyptian pyramid")|| answer.equals("the egyptian pyramids")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		if (category.get(index).equals("file:///android_asset/pics/landmarks/statue_of_liberty.jpg")){
			if (answer.equals("statue of liberty") || answer.equals("the statue of liberty")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		if (category.get(index).equals("file:///android_asset/pics/landmarks/taj_mahal.jpg")){
			if (answer.equals("taj mahal") || answer.equals("the taj mahal")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		if (category.get(index).equals("file:///android_asset/pics/landmarks/stonehenge.jpg")){
			if (answer.equals("stonehenge") || answer.equals("vatican") || answer.equals("the stonehenge") ||
					answer.equals("stonehinge") || answer.equals("stone henge") || answer.equals("stone hinge")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
		if (category.get(index).equals("file:///android_asset/pics/landmarks/washington_monument.jpg")){
			if (answer.equals("washington monument") || answer.equals("the washington monument")){
                timer.cancel();
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
				intent.putExtra("guesses", guesses);
				intent.putExtra("strings", category);
                intent.putExtra("seconds", seconds);
                intent.putExtra("zooms", zooms);
                intent.putExtra("cumulativeScore", cumulativeScore);
                intent.putExtra("index", index);
	    		  startActivity(intent);
                finish();
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}
	}
	private void wildlifeAnswers() {
		// TODO Auto-generated method stub
		guesses = 0;
		
		if (category.get(index).equals("file:///android_asset/pics/wildlife/giraffe.jpg")){
			guesses++;
			if (answer.equals("giraffe")){
				Intent intent = new Intent(getBaseContext(), ScoreActivity.class);
	    		  startActivity(intent);
			}else{
				Toast.makeText(getApplicationContext(), "That is Incorrect. Try Again.",
						Toast.LENGTH_LONG).show();
			}
		}

}
    @Override
    public void onBackPressed() {
    }
}
