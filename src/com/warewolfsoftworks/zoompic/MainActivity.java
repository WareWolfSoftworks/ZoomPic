package com.warewolfsoftworks.zoompic;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpWidgets();
        
    }

    private void setUpWidgets() {
		// TODO Auto-generated method stub
    	Button startGame = (Button) findViewById(R.id.bStartGame);
        Button tutorial = (Button) findViewById(R.id.bTutorial);
		startGame.setOnClickListener(this);
        tutorial.setOnClickListener(this);

		
	}
    
    @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
    	if (v.getId()==R.id.bStartGame){
    		Intent intent = new Intent(getBaseContext(), PicCategory.class);
            startActivity(intent);
            finish();

    	}

    	if (v.getId()==R.id.bTutorial){
    		Intent tutorial = new Intent(getBaseContext(), Tutorial.class);
            startActivity(tutorial);
            finish();
    	}
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
    }
    
}
