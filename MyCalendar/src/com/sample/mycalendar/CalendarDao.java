package com.sample.mycalendar;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CalendarDao {

	private MyCalendarDBOpenHelper dbHelper;
	
	/**
	 * Constructor
	 * 
	 * @param context
	 */
	public CalendarDao(Context context) {
		this.dbHelper = new MyCalendarDBOpenHelper(context);
	}
	
	/**
	 * getHoliDay
	 * get Holiday From calendar table
	 * 
	 * @return MapMap<String date, CalendarForm>
	 */
	public Map<String, CalendarForm> getHoliDay(String[] condition) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
        Map<String, CalendarForm> resultMap = new HashMap<String, CalendarForm>();
        
        String sql = "SELECT " +
        			 "	DATE, " +
        			 "	TITLE, " +
        			 "	HOLIDAY " +
        			 "FROM " +
        			 "	CALENDAR " +
        			 "WHERE " +
        			 "	YEAR = ? " +
        			 "	AND MONTH = ? " +
        			 "	AND COUNTRY = ? " +
        			 "ORDER BY " +
        			 "	DATE";
        
        try{
            //SQL実行
            Cursor cursor = db.rawQuery(sql, condition);
	        
        	//結果取得
        	while (cursor.moveToNext()) {
        		CalendarForm calForm = new CalendarForm();
        		calForm.setDate(cursor.getString(cursor.getColumnIndex("date")));
        		calForm.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        		calForm.setHoliday(cursor.getString(cursor.getColumnIndex("holiday")));
        		resultMap.put(cursor.getString(0), calForm);
        	}
        } catch (Exception e) {
        	Log.e("SQL Error Occurred From getHoliday method ", e.getMessage());
	    } finally {
	    	db.close();
	    }
        
        return resultMap;
	}
}
