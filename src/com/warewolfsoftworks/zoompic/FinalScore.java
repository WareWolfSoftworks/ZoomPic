package com.warewolfsoftworks.zoompic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class FinalScore extends Activity implements OnClickListener {

    TextView tvFinalScore;
    Button bReturn;
    long cumulativeScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_score);
        setUpWidgets();
        scoreScreen();
    }

    private void setUpWidgets() {
        tvFinalScore = (TextView) findViewById(R.id.tvFinalScore);
        bReturn = (Button) findViewById(R.id.bReturn);
        bReturn.setOnClickListener(this);
        Intent intent = getIntent();
        cumulativeScore = intent.getLongExtra("cumulativeScore", cumulativeScore);
    }

    private void scoreScreen() {
        tvFinalScore.setText("" + cumulativeScore);
    }

    public void onClick (View v){
        if (v.getId() == R.id.bReturn);
        {
            Intent mainMenu = new Intent(this, MainActivity.class);
            startActivity(mainMenu);
            finish();
        }
    }

}
