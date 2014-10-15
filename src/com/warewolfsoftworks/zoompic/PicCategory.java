package com.warewolfsoftworks.zoompic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PicCategory extends Activity implements OnClickListener {

	int index = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pic_category);
		setUpWidgets();
	}
	
	private void setUpWidgets() {
		// TODO Auto-generated method stub
		Button landmarks = (Button) findViewById(R.id.bLandmarks);
		Button wildlife = (Button) findViewById(R.id.bWildlife);
		landmarks.setOnClickListener(this);
		wildlife.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.bLandmarks){
			Intent intent = new Intent(this, Game.class);
            ArrayList<String> landmarks = new ArrayList<String>(
                    Arrays.asList("landmarks", "file:///android_asset/pics/landmarks/colosseum.jpg",
                            "file:///android_asset/pics/landmarks/eiffel_tower.jpg", "file:///android_asset/pics/landmarks/golden_gate.jpg",
                            "file:///android_asset/pics/landmarks/mount_rushmore.jpg", "file:///android_asset/pics/landmarks/grand_canyon.jpg",
                            "file:///android_asset/pics/landmarks/pyramids.jpg", "file:///android_asset/pics/landmarks/statue_of_liberty.jpg",
                            "file:///android_asset/pics/landmarks/taj_mahal.jpg", "file:///android_asset/pics/landmarks/stonehenge.jpg",
                            "file:///android_asset/pics/landmarks/washington_monument.jpg"));
            Collections.shuffle(landmarks.subList(1, 11));
            intent.putExtra("strings", landmarks);
            intent.putExtra("index", index);
			startActivity(intent);
            finish();
		}
		
		if (v.getId() == R.id.bWildlife){
			Intent intent = new Intent(this, Game.class);
			String[] wildlife = new String[] {"wildlife", "file:///android_asset/pics/wildlife/giraffe.jpg"};
			intent.putExtra("strings", wildlife);
			startActivity(intent);
		}
	}

    @Override
    public void onBackPressed() {
    }
	
}
