package com.sample.mycalendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MyCalendarMainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.sample.myCalendar.MESSAGE";

	private static final String HOLYDAY = "1";			// 1:休日
	private TextView headerMonthText = null;			// 年月表示テキストビュー
	
	private Calendar cal;								// カレンダー
			
	private int currentYear = 0;						// 表示年
	private int currentMonth = 0;						// 表示月
	private int currentDate = 0;						// 表示日
	
	private int nowYear = 0;							// 現在年
	private int nowMonth = 0;							// 現在月
	private int nowDate = 0;							// 現在日
	
	// 日付用テキストビューリスト
	private ArrayList<DayTextViewInfo> dayTextList = new ArrayList<DayTextViewInfo>();

	/**
	 * カレンダー初期化
	 */
	private void initializeControl() {
		this.headerMonthText = (TextView)findViewById(R.id.header_month_text);
		
		DayTextViewInfo info = null;
		
		// 1週間目
		info = new DayTextViewInfo(R.id.one_su_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.one_mo_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.one_tu_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.one_we_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.one_th_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.one_fr_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.one_sa_text);
		this.dayTextList.add(info);
		
		// 2週間目
		info = new DayTextViewInfo(R.id.two_su_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.two_mo_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.two_tu_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.two_we_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.two_th_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.two_fr_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.two_sa_text);
		this.dayTextList.add(info);

		// 3週間目
		info = new DayTextViewInfo(R.id.three_su_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.three_mo_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.three_tu_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.three_we_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.three_th_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.three_fr_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.three_sa_text);
		this.dayTextList.add(info);

		// 4週間目
		info = new DayTextViewInfo(R.id.four_su_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.four_mo_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.four_tu_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.four_we_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.four_th_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.four_fr_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.four_sa_text);
		this.dayTextList.add(info);

		// 5週間目
		info = new DayTextViewInfo(R.id.five_su_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.five_mo_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.five_tu_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.five_we_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.five_th_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.five_fr_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.five_sa_text);
		this.dayTextList.add(info);
		
		// 6週間目
		info = new DayTextViewInfo(R.id.six_su_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.six_mo_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.six_tu_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.six_we_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.six_th_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.six_fr_text);
		this.dayTextList.add(info);
		info = new DayTextViewInfo(R.id.six_sa_text);
		this.dayTextList.add(info);
		
		cal = Calendar.getInstance();
	    currentYear = cal.get(Calendar.YEAR);				// 表示年
	    currentMonth = cal.get(Calendar.MONTH) + 1;			// 表示月
	    currentDate = cal.get(Calendar.DATE);				// 表示日
	    nowYear = currentYear;								// 現在年
	    nowMonth = currentMonth;							// 現在月
	    nowDate = currentDate;								// 現在日	    
	    setCalendar(0);
	}

	/**
	 * カレンダー設定
	 */
	private void setCalendar(int offset) {
		
		String ymd = "";			// 年月日
		int year = 0;				// 年
		int month = 0;				// 月
		int date = 0;				// 日
		int col = 0;				// 曜日
		
		// 日付フォーマッター取得
		SimpleDateFormat formYmd = new SimpleDateFormat("yyyyMMdd");
		
	    // 表示月を計算
		currentMonth += offset;
		
		if (currentMonth > 12) {
			currentYear += 1;
			currentMonth = 1;
		} else if (currentMonth == 0) {
			currentYear -= 1;
			currentMonth = 12;
		}
		
		// 表示カレンダー設定
		cal.clear();
		cal.set(currentYear, currentMonth - 1, 1);
		
		currentYear = cal.get(Calendar.YEAR);				// 表示年
	    currentMonth = cal.get(Calendar.MONTH) + 1;			// 表示月
	    currentDate = cal.get(Calendar.DATE);				// 表示日

	    // 休日検索
 		CalendarDao dao  = new CalendarDao(this);
 		
 		String[] condition = new String[] {
 			String.valueOf(currentYear), 
 			String.valueOf(currentMonth), 
 			getString(R.string.country)
 		};
 		
 		Map<String, CalendarForm> holidays = dao.getHoliDay(condition);
 		
		// カレンダーの開始曜日を取得
		int dayOffset = 0;
		
	    // 月の初日の曜日を取得
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
	    
		// カレンダーの表示開始日を設定
		if (startDay + dayOffset == 1) {
			cal.add(Calendar.DATE, - ((startDay + dayOffset) + 6));
		} else {
			cal.add(Calendar.DATE, - ((startDay + dayOffset) - 1 % 7));
		}
		
		for (int i = 0 ; i < this.dayTextList.size(); i++) {
			
			// カレンダービュー取得
			DayTextViewInfo vi = this.dayTextList.get(i);
			CustomCalendarView ccv = (CustomCalendarView)findViewById(vi.getTextViewId());
			
			// textview取得
			TextView textDay = (TextView)ccv.findViewById(R.id.text_day);
			TextView textTitle = (TextView)ccv.findViewById(R.id.text_title);
			
			// 表示年月日取得
			ymd = formYmd.format(cal.getTime());
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			date = cal.get(Calendar.DATE);
			
			// 日付ビュー初期化
			ccv.setBackgroundResource(R.drawable.text_day_line);
			vi.setToDay(false);
			vi.setSelected(false);
			textDay.setTextColor(Color.BLACK);
			textDay.setText(String.valueOf(date));
			textTitle.setTextColor(Color.BLACK);
			textTitle.setText("");
			
			// 表示年月日 = 現在年月日
			if (year == nowYear && month == nowMonth && date == nowDate) {
				
				// フラグ変更、テキストビュースタイル変更
				ccv.setBackgroundResource(R.drawable.text_now_line);
				vi.setToDay(true);
			}
			
			// 現在年月の場合
			if (year == currentYear && month == currentMonth) {
				
				// 日曜日は赤文字
				if (col == ((0 + dayOffset) % 7)) {
					textDay.setTextColor(Color.RED);
				
				// 土曜日は青文字
				} else if (col == ((6 + dayOffset) % 7)) {
					textDay.setTextColor(Color.BLUE);
				
				// その他は黒文字
				} else {
					textDay.setTextColor(Color.BLACK);
				}
			
			// 前月・来月の月跨ぎはグレー文字					
			} else {
				textDay.setTextColor(Color.GRAY);
			}
			
			// 休日は赤文字
			if (holidays.containsKey(ymd)
				&& holidays.get(ymd).getHoliday().equals(HOLYDAY)) {
				
				// 休日は赤文字
				textDay.setTextColor(Color.RED);
				textTitle.setTextColor(Color.RED);
				
				// 休日のタイトルを設定
				textTitle.setText((holidays.get(ymd)).getTitle());
			}
			
			// 次の曜日
			col = ((col + dayOffset) + 1) % 7;
			
			// 次の日
			cal.add(Calendar.DATE, 1);
		}
		
		// 表示年月設定
		this.headerMonthText.setText(String.valueOf(currentYear) 
				+ getString(R.string.saperator) + String.valueOf(currentMonth));	    
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar_main);
        initializeControl();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_calendar_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void selectDay(View view) {

    	// Get Intent of DayCalendar Activity (MyCalendarDayActivity)
    	Intent intent = new Intent(this, MyCalendarDayActivity.class);

    	for(int i = 0 ; i < dayTextList.size(); i++) {
    		// Get dayTextViewInfo
    		DayTextViewInfo dayTextViewInfo = dayTextList.get(i);
    		
    		// Get customCalendarView
    		CustomCalendarView ccv = (CustomCalendarView)findViewById(dayTextViewInfo.getTextViewId());
    		
    		// When Selected TextView Then
    		if(dayTextViewInfo.getTextViewId() == view.getId()) {
    			
    			// Change Selected TextView's Background
    			ccv.setBackgroundResource(R.drawable.text_selected_line);
    			dayTextViewInfo.setSelected(true);
    			
    			// Get TextView From Selected TextView
    	    	TextView textView = (TextView) ccv.findViewById(R.id.text_day);

    	    	// Get Message From EditText
    	    	String message = textView.getText().toString();
    	    	
    	    	// Add Extended data to the Intent
    	    	intent.putExtra(EXTRA_MESSAGE, message);
			
    		// Else Other return to origin
    		} else {
    			
    			// When today TextView Then
    			if(dayTextViewInfo.isToDay() == true) {
    				ccv.setBackgroundResource(R.drawable.text_now_line);
    				dayTextViewInfo.setSelected(false);
			
				// Else then
	    		} else {
					ccv.setBackgroundResource(R.drawable.text_day_line);
					dayTextViewInfo.setSelected(false);
	    		}
    		}
		}
		
    	// Start Next Activity (DisplayMessageActivity)
    	startActivity(intent);
	}
	
	public void goPreviousMonth(View view) {
		setCalendar(-1);
	}
	
	public void goCurrentMonth(View view) {
		currentYear = nowYear;
		currentMonth = nowMonth;
		setCalendar(0);
	}
	
	public void goNextMonth(View view) {
		setCalendar(1);
	}
}
