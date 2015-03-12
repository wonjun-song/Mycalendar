package com.sample.mycalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MyCalendarDayActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_calendar_day);
		
		// Get Message From Intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MyCalendarMainActivity.EXTRA_MESSAGE);
		
		// Create Text View
		TextView textView = (TextView)findViewById(R.id.header_day_text);
		textView.setText(message);
//		
//		// Show Contents
//		setContentView(textView);
//		
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//		
//		
//		if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                .add(R.id.container, new PlaceholderFragment()).commit();
//        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_calendar_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
//		if (id == R.id.action_search) {
//			return true;
//		}
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() { }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                  Bundle savedInstanceState) {
//              View rootView = inflater.inflate(R.layout.activity_display_message,
//                      container, false);
//              return rootView;
//        }
//    }
	
	public void goBack(View view) {
    	finish();
    }
}
