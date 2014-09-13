package com.example.prueba;

import java.util.List;

import com.beatit.challenges.UsainBolt;
import com.beatit.persistence.UsainBoltDAO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class RankingActivity extends Activity{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.ranking_layout);
	        
	    	UsainBoltDAO db = new UsainBoltDAO(this);
	    	
			List<UsainBolt> challenges = db.getAllUsainBolt();
			
			String ranking = "Ranking :";
			
			
			for(UsainBolt challenge : challenges){
				
				ranking += challenge.toString();
				
			}
			
			((TextView) findViewById(R.id.ranking_label)).setText(ranking);

			
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	    
	    public void usainBoltChallenge(View view) 
	    {
//	    	Toast.makeText(this, "Click", Toast.LENGTH_LONG).show();;
	        Intent intent = new Intent(RankingActivity.this, UsainBolt.class);
	        startActivity(intent);
	    }

}
