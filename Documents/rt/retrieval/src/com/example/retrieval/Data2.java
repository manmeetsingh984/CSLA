package com.example.retrieval;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Data2 extends Activity{
	private static final Context myContext = null;

	String[] branch = { "Information Technology" };
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data2);

final Context myContext;
		
		myContext=this.getApplicationContext();
	 
		Spinner spinner = (Spinner)findViewById(R.id.spinner);
		
		ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
			    android.R.layout.simple_spinner_item, branch);
			  adapter_state
			    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			  spinner.setAdapter(adapter_state);
		Button button=(Button)findViewById(R.id.button);
		final String message = spinner.getSelectedItem().toString();
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
						
		absent(message);
			}
		
		});
	}
		public void absent(String message){
		// TODO Auto-generated method stub
		DatabaseHelper dbHelper = new DatabaseHelper(myContext);
		
		ArrayList array_list=dbHelper.getData2(message);
		
		if(array_list.isEmpty()){
			Toast.makeText(myContext, "No Data Available", Toast.LENGTH_LONG).show();
		}
		else{
			 ArrayAdapter<String> codeLearnArrayAdapter = new ArrayAdapter<String>(myContext, android.R.layout.simple_list_item_1, array_list);

			 ListView codeLearnLessons = (ListView)findViewById(R.id.list);
			 
			 codeLearnLessons.setAdapter(codeLearnArrayAdapter);
			}

	}


	}
