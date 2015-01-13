package com.sample.mycalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarInfo {
	private int year;       								//年
	private int month;      								//月
	private int startDayOfWeek;								//月の開始曜日
	private int maxDateOfThisMonth;							//月の日数
	private String[][] calendarMatrix = new String[6][7];	//カレンダー配列
	private SimpleDateFormat form; 

	/**
	�@* コンストラクター
	�@* @param year  年(..., 2005, 2006, 2007, ...)
	�@* @param month 月(1, 2, 3, ..., 10, 11, 12)
	 */
	public CalendarInfo(int year, int month) {
		this.year = year;
		this.month = month;
		this.createFields();
	}
	/**
	 * 表示する年月のカレンダー配列を初期化
	 */
	private void createFields() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		
		//表示する年月の初日の曜日を取得する
		calendar.set(year, month - 1, 1);
		this.startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		//表示する年月の日数を取得する
		this.maxDateOfThisMonth = calendar.getActualMaximum(Calendar.DATE);
		
		//月跨ぎを考慮したカレンダーの表示開始日を設定
		calendar.add(Calendar.DATE, -this.startDayOfWeek);
		
		boolean isEnd = false;
		this.form = new SimpleDateFormat("yyyyMMdd"); 
		
		for(int i = 0; i < 6; i++) {
			
			//最終日の場合終了
			if (isEnd) {
				break;
			}
			
			for(int j = 0; j < 7 ; j++) {
				
				//カレンダー配列に日付を設定する
				calendar.add(Calendar.DATE, 1);
				this.calendarMatrix[i][j] = form.format(calendar.getTime());
				
				//最終日の場合フラグを設定
				if (calendar.get(Calendar.YEAR) == year
					&& calendar.get(Calendar.MONTH) + 1 == month
					&& calendar.get(Calendar.DATE) == maxDateOfThisMonth) {
					isEnd = true;
				}
			}
		}
	}
	
	/**
	 * @return the startDayOfWeek
	 */
	public int getStartDayOfWeek() {
		return this.startDayOfWeek;
	}
	/**
	 * @return the maxDateOfThisMonth
	 */
	public int getMaxDateOfThisMonth() {
		return this.maxDateOfThisMonth;
	}
	/**
	 * @return the calendarMatrix
	 */
	public String[][] getCalendarMatrix() {
		return this.calendarMatrix;
	}
}
