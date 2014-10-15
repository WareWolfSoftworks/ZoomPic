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
        Button mainMenu = (Button) findViewById(R.id.bMain);
		landmarks.setOnClickListener(this);
		wildlife.setOnClickListener(this);
        mainMenu.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
        if (v.getId() == R.id.bMain){
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
            finish();
        }
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
            ArrayList<String> wildlife = new ArrayList<String>(
                    Arrays.asList("wildlife", "file:///android_asset/pics/wildlife/giraffe.jpg",
                            "file:///android_asset/pics/wildlife/gorilla.jpg", "file:///android_asset/pics/wildlife/grasshopper.jpg",
                            "file:///android_asset/pics/wildlife/hippo.jpg", "file:///android_asset/pics/wildlife/kangaroo.jpg",
                            "file:///android_asset/pics/wildlife/panda.jpg", "file:///android_asset/pics/wildlife/rabbit.jpg",
                            "file:///android_asset/pics/wildlife/raccoon.jpg", "file:///android_asset/pics/wildlife/snake.jpg",
                            "file:///android_asset/pics/wildlife/tiger.jpg"));
            Collections.shuffle(wildlife.subList(1, 11));
			intent.putExtra("strings", wildlife);
            intent.putExtra("index", index);
			startActivity(intent);
            finish();
		}
	}

    @Override
    public void onBackPressed() {
    }
	
}
