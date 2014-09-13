package com.beatit.challenges;

import java.text.DateFormat;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;




import com.beatit.activity.R;
import com.beatit.activity.R.id;
import com.beatit.activity.R.layout;
import com.beatit.entities.Challenge;
import com.beatit.persistence.UsainBoltDAO;

public class UsainBolt extends Challenge implements OnClickListener,
		LocationListener {

	private LocationManager locationManager;

	private static final long MIN_TIME = 0;
	private static final float MIN_DISTANCE = 0;
	private static final float MAX_SPEED = 2.0f;

	private int longitude;
	private int latitude;
	private float speed;

	private double score = 0;
	private int challengeId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.usainbolt_layout_vieja);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				MIN_TIME, MIN_DISTANCE, this);
		findViewById(R.id.settings_button).setOnClickListener(this);
		
	
//		String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
//
//		// textView is the TextView view that should display it
//		((TextView) findViewById(R.id.textView_Start_Time_Value))
//		.setText(currentDateTimeString);

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		startActivity(intent);
	}

	@Override
	public void onLocationChanged(Location loc) {

		this.setLatitude((int) loc.getLatitude());
		this.setLongitude((int) loc.getLongitude());
		this.setSpeed((float) ((loc.getSpeed()*3600)/1000));

		this.setScore(this.getSpeed() * 2);
		
//		((TextView) findViewById(R.id.locat_label))
//				.setText("Fine Location = (lat:"
//						+ Integer.toString(this.getLatitude()) + ", lng:"
//						+ Integer.toString(this.getLongitude()) + ", vel:"
//						+ Float.toString(this.getSpeed()) + ", score:"+ Double.toString(this.getScore())+ ")");

		if (this.getSpeed() >= MAX_SPEED) {
			
//			((TextView) findViewById(R.id.textView_Start_Time_Value))
//			.setText(Float.toString(this.getSpeed()));
			
			Toast.makeText(
					getBaseContext(),
					"Ha alcanzado el objetivo con una velocidad de "
							+ loc.getSpeed() + ". Obtuvo " + this.getScore() + "puntos.", Toast.LENGTH_LONG).show();
			locationManager.removeUpdates(this);
			
			UsainBoltDAO db = new UsainBoltDAO(this);
			
			UsainBolt challenge = (UsainBolt)db.getUsainBolt(0);
			challenge.setLatitude(this.getLatitude());
			challenge.setLongitude(this.getLongitude());
			challenge.setSpeed(this.getSpeed());
			challenge.setScore(this.getScore());
			
			db.updateChallenge(challenge);
		}

	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				MIN_TIME, MIN_DISTANCE, this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(this);
	}

	
	
	
	/*
	 *  Getter & Setters 
	 */
	
	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

	@Override
	public String toString() {

		return "UsainBolt[speed=" + this.getSpeed() + ", score="
				+ this.getScore() + "]" + super.toString();

	}

}
