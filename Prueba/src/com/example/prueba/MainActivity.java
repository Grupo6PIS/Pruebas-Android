package com.example.prueba;

import com.beatit.challenges.UsainBolt;
import com.beatit.persistence.UsainBoltDAO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    	UsainBoltDAO db = new UsainBoltDAO(this);
    	
		UsainBolt challenge = new UsainBolt();
		challenge.setChallengeId(0);
		challenge.setName("Usain Bolt");
		challenge.setDescription("Debes llegar a la velocidad 6km/h en el menor tiempo posible.");
		challenge.setDuration(1);
		challenge.setLevel(1);
		
		db.addUsainBolt(challenge);
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
//    	Toast.makeText(this, "Click", Toast.LENGTH_LONG).show();;
        Intent intent = new Intent(MainActivity.this, UsainBolt.class);
        startActivity(intent);
    }
    
    public void ranking(View view){
    	
    	 Intent intent = new Intent(MainActivity.this, RankingActivity.class);
         startActivity(intent);
    	
    	
    }
}
