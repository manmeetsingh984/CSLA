package com.example.retrieval;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Staff extends Activity
{	
	
	public void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);
		 
		setContentView(R.layout.staff);

			
		final Spinner spin1=(Spinner)findViewById(R.id.spinner);
		
		final Spinner s1=(Spinner)findViewById(R.id.spinner2);
		
	
		final String[] branch = { "Information Technology","Computer Science"};
		
		final String[] day = { "Monday","Tuesday","Wednesday","Thursday","Friday"};
			
		final Button btn1;
		final Button btn2;
	
		DatabaseHelper db;
		db = new DatabaseHelper(Staff.this);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		//TextView tv5=(TextView)findViewById(R.id.textView5);
	final Context myContext=this.getApplicationContext();
	
	ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
		    android.R.layout.simple_spinner_item, branch);
		  adapter_state
		    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		  spin1.setAdapter(adapter_state);
		

			ArrayAdapter<String> adapter_state2 = new ArrayAdapter<String>(this,
				    android.R.layout.simple_spinner_item, day);
				  adapter_state
				    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				  s1.setAdapter(adapter_state2);
				 
		  btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			String message=spin1.getSelectedItem().toString();
			
			load(message);
			
			
			}
		});
		  final EditText e3=(EditText)findViewById(R.id.e3);
		  e3.setOnClickListener(new View.OnClickListener() {
		
		        	public void onClick(View v) {
		                // Process to get Current Date
		                final Calendar c = Calendar.getInstance();
		                int mYear = c.get(Calendar.HOUR_OF_DAY);
		                int mMonth = c.get(Calendar.MINUTE);
		                int mDay = c.get(Calendar.DAY_OF_MONTH);

		                // Launch Date Picker Dialog
		                TimePickerDialog dpd = new TimePickerDialog(Staff.this,
		                        new TimePickerDialog.OnTimeSetListener() {

		                            @Override
		                            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
		                                // Display Selected date in textbox
		                                e3.setText(selectedHour + ":" + selectedMinute);

		                            }

							                        
          }, mYear, mMonth, false);
		                    dpd.show();
		                }
		  });
		  

		  
		  btn2.setOnClickListener(new View.OnClickListener() {
				
				

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(v.getContext(), Data1.class);
					Spinner spin2=(Spinner)findViewById(R.id.spinner1);
					String message1=spin2.getSelectedItem().toString();
					//Toast.makeText(v.getContext(), message1, Toast.LENGTH_LONG).show();
					
					Spinner s2=(Spinner)findViewById(R.id.spinner2);
					String message3=s2.getSelectedItem().toString();
					//Toast.makeText(v.getContext(), message3, Toast.LENGTH_LONG).show();
					
					EditText editText2 = (EditText)findViewById(R.id.e3);
				    String message2 = editText2.getText().toString();
				    String[] mes=message2.split(":");
					String me=mes[0];
					//Toast.makeText(v.getContext(), me, Toast.LENGTH_LONG).show();
					intent.putExtra("Time", me);
					intent.putExtra("Name", message1);
					intent.putExtra("Day", message3);
					startActivity(intent);
				}
			});


	}	  
		  public void load(String msg)
		  {
				DatabaseHelper db;
				db = new DatabaseHelper(Staff.this);
			  Set<String> set = db.getData(msg);

				List<String> list = new ArrayList<String>(set);

				ArrayAdapter<String> adapter = new ArrayAdapter<String>(Staff.this,
						android.R.layout.simple_spinner_item, list);

				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				
				Spinner spin2=(Spinner)findViewById(R.id.spinner1);
				
				spin2.setAdapter(adapter);
				spin2.setWillNotDraw(false);

			}

			public void onItemSelected(AdapterView<?> parent, View v, int position,
					long id) {
				String name = parent.getItemAtPosition(position).toString();
				showToast("You Selected Item :: " + name);
			}

			
			public void onNothingSelected(AdapterView<?> arg0) {

			}

			private void showToast(String msg) {
				Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
			}

		  }
		  
		  
		  
	
		
		
		
		
		
