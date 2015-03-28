package com.example.retrieval;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;




import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Student extends Activity 
{
	 public final static String EXTRA_MESSAGE = "com.example.retrieval.MESSAGE";
	 Button b1=null;
	 private String[] year = { "1st Year", "2nd Year", "3rd Year", "4th Year" };
	 private String[] branch = { "Information Technology" };
	 private String[] section = { "A", "B" };
	 private String[] day = { "Monday","Tuesday","Wednesday","Thursday","Friday"};
		Spinner spinnerOsversions;
		Spinner e2;Spinner e4;Spinner e5;
		
		String selState="";
	 
     GregorianCalendar gcalendar = new GregorianCalendar();
     
     int time = gcalendar.get(Calendar.HOUR);

  
     
 public void onCreate(Bundle savedInstanceState) {
		 
	super.onCreate(savedInstanceState);
		 
	setContentView(R.layout.enter);
	
	final Context myContext;
			
	myContext=this.getApplicationContext();
			
	spinnerOsversions = (Spinner) findViewById(R.id.osversions);
	
	ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
		    android.R.layout.simple_spinner_item, year);
		  adapter_state
		    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		  spinnerOsversions.setAdapter(adapter_state);
	
	e2=(Spinner) findViewById(R.id.e2);
			 			
	ArrayAdapter<String> adapter_state1 = new ArrayAdapter<String>(this,
		    android.R.layout.simple_spinner_item, branch);
		  adapter_state1
		    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		  e2.setAdapter(adapter_state1);
	

			e4=(Spinner) findViewById(R.id.e4);
					 			
			ArrayAdapter<String> adapter_state2 = new ArrayAdapter<String>(this,
				    android.R.layout.simple_spinner_item, section);
				  adapter_state2
				    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				  e4.setAdapter(adapter_state2);
			
					
					e5=(Spinner) findViewById(R.id.e5);
							 			
					ArrayAdapter<String> adapter_state3 = new ArrayAdapter<String>(this,
						    android.R.layout.simple_spinner_item, day);
						  adapter_state3
						    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						  e5.setAdapter(adapter_state3);
	  
				  
		  
		  
		   final EditText e3=(EditText)findViewById(R.id.e3);
		  e3.setOnClickListener(new View.OnClickListener() {
		
		        	public void onClick(View v) {
		                // Process to get Current Date
		                final Calendar c = Calendar.getInstance();
		                int mYear = c.get(Calendar.HOUR_OF_DAY);
		                int mMonth = c.get(Calendar.MINUTE);
		                int mDay = c.get(Calendar.DAY_OF_MONTH);

		                // Launch Date Picker Dialog
		                TimePickerDialog dpd = new TimePickerDialog(Student.this,
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
		  
	Button b1=(Button)findViewById(R.id.b1);
		
       
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(), Data.class);
				//year 
			    spinnerOsversions = (Spinner) findViewById(R.id.osversions);
			    String message = spinnerOsversions.getSelectedItem().toString();
			  
				/*  EditText editText = (EditText)findViewById(R.id.e1);
			    String message = editText.getText().toString();
			   
			    EditText editText1 = (EditText)findViewById(R.id.e2);
			    String message1 = editText1.getText().toString();*/
			    
			    //branch
				e2=(Spinner) findViewById(R.id.e2);
				String message1 = e2.getSelectedItem().toString(); 
			   
				//section
				e4=(Spinner) findViewById(R.id.e4);
				String message4 = e4.getSelectedItem().toString(); 
				
				//day
				e5=(Spinner) findViewById(R.id.e5);
				String message5 = e5.getSelectedItem().toString(); 
				
//time
				EditText editText2 = (EditText)findViewById(R.id.e3);
			    String message2 = editText2.getText().toString();
			    String[] mes=message2.split(":");
				  String me=mes[0];
				  
			  //batch
			    intent.putExtra(EXTRA_MESSAGE, message);
			    
			    //branch
			    intent.putExtra("Branch", message1);
			   
			    //section
			    intent.putExtra("Section", message4);
			    
			    //day
			    intent.putExtra("Day", message5);
			    
			    //time
			    intent.putExtra("Time", me);
			    
			    startActivity(intent);
	
			}
		});
	}



	



}

/*Calendar calendar = Calendar.getInstance();
int day = calendar.get(Calendar.DAY_OF_WEEK);
Toast.makeText(myContext,  day, Toast.LENGTH_LONG).show();
*/
/*
ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
	    android.R.layout.simple_spinner_item, year);
	  adapter_state
	    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	  spinnerOsversions.setAdapter(adapter_state);
	  spinnerOsversions.setOnItemSelectedListener(new OnItemSelectedListener() {
	  public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
					  spinnerOsversions.setSelection(position);
					  String selState = (String) spinnerOsversions.getSelectedItem();
					}

					  @Override
					 public void onNothingSelected(AdapterView<?> arg0) {
					  // TODO Auto-generated method stub

					  }
	  });
*/

