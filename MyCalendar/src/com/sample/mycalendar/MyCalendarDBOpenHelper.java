/**
 * 
 */
package com.sample.mycalendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author wonjun
 *
 */
public class MyCalendarDBOpenHelper extends SQLiteOpenHelper {

	static final String DATABASE_NAME = "mycalendar.db";
	static final int DATABASE_VERSION = 1;

	public static final String TABLE_CALENDAR = "calendar";
	public static final String COL_ID = "_id";
	public static final String COL_YEAR = "year";
	public static final String COL_MONTH = "month";
	public static final String COL_DAY = "day";
	public static final String COL_DATE = "date";
	public static final String COL_TITLE = "title";
	public static final String COL_MEMO = "memo";
	public static final String COL_COUNTRY = "country";
	public static final String COL_HOLIDAY = "holiday";
	public static final String COL_LASTUPDATE = "lastupdate";

	public MyCalendarDBOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(  "CREATE TABLE " + TABLE_CALENDAR + " ("
			        + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			        + COL_YEAR + " INTEGER,"
			        + COL_MONTH + " INTEGER,"
			        + COL_DAY + " INTEGER,"
			        + COL_DATE + " TEXT,"
			        + COL_TITLE + " TEXT,"
			        + COL_MEMO + " TEXT,"
			        + COL_COUNTRY + " TEXT,"
			        + COL_HOLIDAY + " TEXT NOT NULL,"
			        + COL_LASTUPDATE + " TEXT NOT NULL);");
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALENDAR);
	    onCreate(db);
	}

}
