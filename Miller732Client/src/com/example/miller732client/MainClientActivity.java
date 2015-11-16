package com.example.miller732client;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainClientActivity extends Activity {
	
	private static TextView timeText, latlongText;
	private static Time now = new Time(Time.getCurrentTimezone());
	private static Location here = new Location("gps");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_client);
		
		timeText = (TextView) this.findViewById(R.id.TimeText);
		latlongText = (TextView) this.findViewById(R.id.LatLongText);
		
		now.setToNow();
		here.reset();
		here.setLatitude(35.705685);
		here.setLongitude(139.752058);
		
		timeText.setText(now.format("Date: %h-%d-%Y  |  Time: %r"));
		latlongText.setText("Lat: " + here.getLatitude() + "  |  Long: " + here.getLongitude());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_client, menu);
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
}
