package com.example.retrieval;

import java.io.IOException;
import java.sql.SQLException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);
		 
		setContentView(R.layout.activity_main);
	
DatabaseHelper myDbHelper = new DatabaseHelper(this);
		   myDbHelper = new DatabaseHelper(this);
		    
		   try {
		    
		   myDbHelper.createDataBase();
		    
		   } catch (IOException ioe) {
		    
		   throw new Error("Unable to create database");
		    
		   }
		    
		   myDbHelper.openDataBase();
	
		
Button b1=(Button)findViewById(R.id.button1);
	
		Button b2=(Button)findViewById(R.id.button2);
b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(), Student.class);
			startActivity(intent);
			}
	});

b2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(v.getContext(), Staff.class);
	startActivity(intent);
	}
});

}
}
