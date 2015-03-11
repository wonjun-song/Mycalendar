package com.sample.mycalendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MyCalendarMainActivity extends ActionBarActivity {

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
	    
		// カレンダーの開始曜日を取得
		int dayOffset = 0;
		
	    // 月の初日の曜日を取得
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		
		// カレンダーの表示開始日を設定
		startDay = (startDay + dayOffset - 1) % 7;
		cal.add(Calendar.DATE, - startDay);
		
		// 休日検索
		CalendarDao dao  = new CalendarDao(this);
		
		String[] condition = new String[] {
			String.valueOf(currentYear), 
			String.valueOf(currentMonth), 
			getString(R.string.country)
		};
		
		Map<String, CalendarForm> holidays = dao.getHoliDay(condition);
		
		String ymd = "";		// 年月日
		int year = 0;			// 年
		int month = 0;			// 月
		int date = 0;			// 日
		int col = 0;			// 曜日
		
		// 日付フォーマッター取得
		SimpleDateFormat formYmd = new SimpleDateFormat("yyyy/MM/dd");
		
		for (int i = 0 ; i < this.dayTextList.size(); i++) {
			
			// カレンダービュー取得
			DayTextViewInfo vi = this.dayTextList.get(i);
			CustomCalendarView ccv = (CustomCalendarView)findViewById(vi.getTextViewId());
			
			// textview取得
			TextView text1 = (TextView)ccv.findViewById(R.id.text1);
			TextView text2 = (TextView)ccv.findViewById(R.id.text2);
			
			// 表示年月日取得
			ymd = formYmd.format(cal.getTime());
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			date = cal.get(Calendar.DATE);
			
			// 日付ビュー初期化
			ccv.setBackgroundResource(R.drawable.text_day_line);
			vi.setNowDay(false);
			vi.setSelected(false);
			text1.setText(String.valueOf(date));
			
			// 表示年月日 = 現在年月日
			if (year == nowYear && month == nowMonth && date == nowDate) {
				
				// フラグ変更、テキストビュースタイル変更
				ccv.setBackgroundResource(R.drawable.text_now_line);
				vi.setNowDay(true);
			}
			
			// 現在年月の場合
			if (year == currentYear && month == currentMonth) {
				
				// 日曜日は赤文字
				if (col == ((0 + dayOffset) % 7)) {
					text1.setTextColor(Color.RED);
				
				// 土曜日は青文字
				} else if (col == ((6 + dayOffset) % 7)) {
					text1.setTextColor(Color.BLUE);
				
				// その他は黒文字
				} else {
					text1.setTextColor(Color.BLACK);
				}
			
			// 前月・来月の月跨ぎはグレー文字					
			} else {
				text1.setTextColor(Color.GRAY);
			}
			
			// 休日は赤文字
			if (holidays.containsKey(ymd)
				&& holidays.get(ymd).getHoliday().equals(HOLYDAY)) {
				
				// 休日は赤文字
				text1.setTextColor(Color.RED);
				text2.setTextColor(Color.RED);
				
				// 休日のタイトルを設定
				text2.setText((holidays.get(ymd)).getTitle());
			}
			
			// 次の曜日
			col += 1;
			
			// 次の週、日曜日からスタート
			if (col == 7) {
				col = 0;
			}
			
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
		for (int i = 0 ; i < dayTextList.size(); i++) {
			CustomCalendarView ccv = (CustomCalendarView)findViewById(dayTextList.get(i).getTextViewId());
			if (dayTextList.get(i).getTextViewId() == view.getId()) {
				ccv.setBackgroundResource(R.drawable.text_selected_line);
				dayTextList.get(i).setSelected(true);
			} else {
				if (dayTextList.get(i).isNowDay() == true) {
					ccv.setBackgroundResource(R.drawable.text_now_line);
					dayTextList.get(i).setSelected(false);
				}
				else if (dayTextList.get(i).isSelected()) {
					ccv.setBackgroundResource(R.drawable.text_day_line);
					dayTextList.get(i).setSelected(false);
				}
			}
		}
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
