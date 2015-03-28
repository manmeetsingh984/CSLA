package com.example.retrieval;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper
{
	//String DB_PATH =null;
private static String DB_PATH = "/data/data/com.example.retrieval/databases/";	
//private static final String Database_Name="data";
private static final String DB_NAME="gnedata";
	public static final String CONTACTS_COLUMN_NAME = "Room";
private SQLiteDatabase myDataBase;
	 
	 private final Context myContext;
    
	public DatabaseHelper(Context context) {
		 
		super(context, DB_NAME, null, 1);
		this.myContext=context;
	}
public void createDataBase() throws IOException{
		 
		 boolean dbExist = checkDataBase();
		  
		 if(dbExist){
		 //do nothing - database already exist
		 }else{
		  
		 //By calling this method and empty database will be created into the default system path
		 //of your application so we are gonna be able to overwrite that database with our database.
		 this.getReadableDatabase();
		  
		 try {
		  
		 copyDataBase();
		  
		 } catch (IOException e) {
		  
		 throw new Error("Error copying database");
		  
		 }
		 }
		  
		 }
		  
		 /**
		   * Check if the database already exist to avoid re-copying the file each time you open the application.
		   * @return true if it exists, false if it doesn't
		   */
		 private boolean checkDataBase(){
		  
		 SQLiteDatabase checkDB = null;
		  
		 try{
		 String myPath = DB_PATH + DB_NAME;
		 checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		  
		 }catch(SQLiteException e){
		  
		 //database does't exist yet.
		  
		 }
		  
		 if(checkDB != null){
		  
		 checkDB.close();
		  
		 }
		  
		 return checkDB != null ? true : false;
		 }
		  
		 /**
		   * Copies your database from your local assets-folder to the just created empty database in the
		   * system folder, from where it can be accessed and handled.
		   * This is done by transfering bytestream.
		   * */
		 private void copyDataBase() throws IOException{
		  
		 //Open your local db as the input stream
		 InputStream myInput = myContext.getAssets().open(DB_NAME);
		  
		 // Path to the just created empty db
		 String outFileName = DB_PATH + DB_NAME;
		  
		 //Open the empty db as the output stream
		 OutputStream myOutput = new FileOutputStream(outFileName);
		  
		 //transfer bytes from the inputfile to the outputfile
		 byte[] buffer = new byte[1024];
		 int length;
		 while ((length = myInput.read(buffer))>0){
		 myOutput.write(buffer, 0, length);
		 }
		  
		 //Close the streams
		 myOutput.flush();
		 myOutput.close();
		 myInput.close();
		  
		 }
		  
		 public void openDataBase() throws SQLException{
		  
		 //Open the database
		 String myPath = DB_PATH + DB_NAME;
		 myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		  
		 }
		  
		 @Override
		 public synchronized void close() {
		  
		 if(myDataBase != null)
		 myDataBase.close();
		  
		 super.close();
		  
		 }
		  
	
				@Override
		 
		public void onCreate(SQLiteDatabase database) {
		 
		//database.execSQL("CREATE TABLE manmeet (_id INTEGER PRIMARY KEY AUTOINCREMENT, Batch TEXT, Branch Text, Section Text, Day Text, Time Text, Room Text);");
		 
		}
		 
		@Override
		 
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 
		//db.execSQL("DROP TABLE IF EXISTS manmeet");
		 
		//onCreate(db);
		 
		}
		public void addFriend(String batch,String branch, String time, String section,String day, String room)
		 
		{
		 
		ContentValues values=new ContentValues(4);
		 
		values.put("Batch", batch);
		 
		values.put("Branch", branch);
		
		values.put("Time", time);
		
		values.put("Room", room);
		
		getWritableDatabase().insert("manmeet", null, values);
		 
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public ArrayList getFriends(String batch,String br, String section,String day, String time)
		 
		{
			ArrayList array_list = new ArrayList();
		      //hp = new HashMap();
			
			String Batch=batch;
			String Branch=br;
			String Section=section;
			String Day=day;
			String Time=time;
			
		      SQLiteDatabase db = this.getReadableDatabase();
		      Cursor res =  db.rawQuery( "select * from manmeet where Batch=? and Branch=? and Section=? and Day=? and Time=?", new String[]{Batch,Branch,Section,Day,Time}  );
		      res.moveToFirst();
		      while(res.isAfterLast() == false){
		      array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
		      res.moveToNext();
		      }
		      
		   return array_list;
				}
		
		public ArrayList getData1(String name, String time, String day)
		 
		{
			ArrayList array_list = new ArrayList();
		      //hp = new HashMap();
			
			String Name=name;
			String Time=time;
			String Day=day;
		      SQLiteDatabase db1 = this.getReadableDatabase();
		      Cursor res1 =  db1.rawQuery( "select * from manmeet2 where name=? and time=? and day=?", new String[]{Name,Time,Day}  );
		      res1.moveToFirst();
		      while(res1.isAfterLast() == false){
		      array_list.add(res1.getString(res1.getColumnIndex("class")));
		      res1.moveToNext();
		      }
		      
		   return array_list;
		}

		public ArrayList getData2(String branch)
		 
		{
			ArrayList array_list5 = new ArrayList();
		      //hp = new HashMap();
			
		      SQLiteDatabase db5 = this.getReadableDatabase();
		      Cursor res5 =  db5.rawQuery( "select * from manmeet3 where branch=?", new String[]{branch});
		      res5.moveToFirst();
		      while(res5.isAfterLast() == false){
		      array_list5.add(res5.getString(res5.getColumnIndex("name")));
		      res5.moveToNext();
		      }
		      
		   return array_list5;
		}
		
		public Set<String> getData(String message) {
			Set<String> set = new HashSet<String>();

			

			SQLiteDatabase db = this.getReadableDatabase();
			Cursor cursor = db.rawQuery("select * from manmeet1 where branch=?", new String[]{message});

			cursor.moveToFirst();
		      while(cursor.isAfterLast() == false){
		      set.add(cursor.getString(cursor.getColumnIndex("name")));
		      cursor.moveToNext();
		      }
		      
			return set;
		}
		
}
