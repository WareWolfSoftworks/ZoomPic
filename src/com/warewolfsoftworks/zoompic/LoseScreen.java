package com.warewolfsoftworks.zoompic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class LoseScreen extends Activity implements OnClickListener{

    Button bNext;
    TextView tvCorrect;
    ArrayList<String> category;
    int index;
    long cumulativeScore;
    String answer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lose_screen);
        setUpWidgets();
        setAnswerKey();
		loseScreen();
	}

    private void setUpWidgets() {
        tvCorrect = (TextView) findViewById(R.id.tvCorrectAnswer);
        bNext = (Button) findViewById(R.id.bNextL);
        bNext.setOnClickListener(this);
        Intent intent = getIntent();
        category = intent.getStringArrayListExtra("strings");
        cumulativeScore = intent.getLongExtra("cumulativeScore", 0);
        index = intent.getIntExtra("index", 0);
    }

    private void setAnswerKey() {
        if (category.get(index).equals("file:///android_asset/pics/landmarks/colosseum.jpg")){
            answer = "Roman Colosseum";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/eiffel_tower.jpg")){
            answer = "Eiffel Tower";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/golden_gate.jpg")){
            answer = "Golden Gate Bridge";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/mount_rushmore.jpg")){
            answer = "Mount Rushmore";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/grand_canyon.jpg")){
            answer = "Grand Canyon";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/pyramids.jpg")){
            answer = "Egyptian Pyramids";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/statue_of_liberty.jpg")){
            answer = "Statue of Liberty";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/taj_mahal.jpg")){
            answer = "Taj Mahal";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/stonehenge.jpg")){
            answer = "Stonehenge";
        }

        if (category.get(index).equals("file:///android_asset/pics/landmarks/washington_monument.jpg")){
            answer = "Washington Monument";
        }
    }

    private void loseScreen() {
        tvCorrect.setText("The correct answer was: " + answer);
        cumulativeScore += 0;
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
