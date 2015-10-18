package com.app.andy.bulkapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainFragment.ListShowListener {
	private FragmentTransaction ft;
	private MainFragment mainFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.placeholder, mainFragment = new MainFragment());
		ft.addToBackStack(null);
		ft.commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu); return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onListShow() {
		Fragment foodItemListView = new FoodItemListView();
		ft = getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.placeholder, foodItemListView).addToBackStack("1");
		ft.commit();
	}

	public void onClick(View v) {
		mainFragment.onClick(v);
	}

}
