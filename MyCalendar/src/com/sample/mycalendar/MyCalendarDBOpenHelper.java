/**
 * 
 */
package com.sample.mycalendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author wonjun song
 *
 */
public class MyCalendarDBOpenHelper extends SQLiteOpenHelper {

	static final String DATABASE_NAME = "mycalendar.db";
	static final int DATABASE_VERSION = 1;

	public MyCalendarDBOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(  "CREATE TABLE calendar ("
			        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
			        + "year INTEGER,"
			        + "month INTEGER,"
			        + "day INTEGER,"
			        + "date TEXT,"
			        + "title TEXT,"
			        + "memo TEXT,"
			        + "country TEXT,"
			        + "holiday TEXT NOT NULL,"
			        + "lastupdate TEXT NOT NULL);");
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS calendar");
	    onCreate(db);
	}

}
