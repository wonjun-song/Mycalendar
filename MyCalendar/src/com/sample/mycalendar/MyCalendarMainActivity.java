package com.sample.mycalendar;

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

	private static final String HOLYDAY = "1";			//1:休日
	
	private TextView headerMonthText = null;			//年月表示テキストビュー
			
	private int currentYear = 0;						//現在年
	private int currentMonth = 0;						//現在月
	
	private int nowYear = 0;							//表示中の年
	private int nowMonth = 0;							//表示中の月
	private int nowDay = 0;								//表示中の日
	
	//日付用テキストビューリスト
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
		
	    Calendar cal = Calendar.getInstance();
	    this.currentYear = cal.get(Calendar.YEAR);			//現在年取得
	    this.currentMonth = cal.get(Calendar.MONTH) + 1;	//現在月取得
	    
	    this.nowYear = this.currentYear;
	    this.nowMonth = this.currentMonth;
	    this.nowDay = cal.get(Calendar.DATE);				//表示日（現在日）取得
	    
		int id = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7 ; j++){
				CustomCalendarView tv = (CustomCalendarView)findViewById(this.dayTextList.get(id).getTextViewId());
				tv.setBackgroundResource(R.drawable.text_day_line);
				this.dayTextList.get(id).setCustomObject(tv);
				id++;
			}
		}
		
		this.setCalendar(0);
	}

	/**
	 * カレンダー設定
	 */
	private void setCalendar(int offset) {
		this.currentMonth += offset;
		
		if(currentMonth > 12) {
			this.currentYear += 1;
			this.currentMonth = 1;
		}
		else if(currentMonth == 0) {
			this.currentMonth = 12;
			this.currentYear -= 1;
		}
	    
		//日付ビュー初期化
		for(int i = 0 ; i < this.dayTextList.size(); i++) {
			DayTextViewInfo tg = this.dayTextList.get(i);
			
			if(tg.isNowDay() || tg.isSelected() ) {
				tg.getCustomObject().setBackgroundResource(R.drawable.text_day_line);
			}
			
			tg.setNowDay(false);
			tg.setDayNum(0);
			tg.setSelected(false);
			((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text1)).setText(tg.getDispString());
			((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text2)).setText("");
		}
		
		//カレンダー情報生成
		CalendarInfo cl = new CalendarInfo(currentYear, currentMonth);
		
		//休日検索
		CalendarDao dao  = new CalendarDao(this);
		
		String[] condition = new String[] {
			String.valueOf(this.currentYear), 
			String.valueOf(this.currentMonth), 
			getString(R.string.country)
		};
		
		Map<String, CalendarForm> holidays = dao.getHoliDay(condition);
		
		String calYmd = "";		//年月日
		int yearNum = 0;		//年
		int monthNum = 0;		//月
		int dayNum = 0;			//日
		
		int row = 0;
		int col = 0;
		
		for(int i = 0 ; i < this.dayTextList.size(); i++) {
			DayTextViewInfo tg = this.dayTextList.get(i);
			
			//初期化
			calYmd =  "";
			yearNum = 0;
			monthNum = 0;
			dayNum = 0;
			
			//カレンダー配列の年月日を変数に設定
			if (cl.getCalendarMatrix()[row][col] != null
				&& cl.getCalendarMatrix()[row][col].length() == 8) {
				calYmd = cl.getCalendarMatrix()[row][col];
				yearNum = Integer.parseInt(calYmd.substring(0, 4));
				monthNum = Integer.parseInt(calYmd.substring(4, 6));
				dayNum = Integer.parseInt(calYmd.substring(6, 8));
			}
			
			//表示年月 = 現在年月
			if(this.nowYear == this.currentYear 
				&& this.nowMonth == this.currentMonth 
				&& this.nowDay == dayNum) {
				//フラグ変更、テキストビュースタイル変更
				tg.setNowDay(true);
				((CustomCalendarView)findViewById(tg.getTextViewId())).setBackgroundResource(R.drawable.text_now_line);
			}
			
			//現在年月の場合
			if (yearNum == this.currentYear && monthNum == this.currentMonth) {
				//日曜日は赤文字
				if(col == 0) {
					((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text1)).setTextColor(Color.RED);
				//土曜日は青文字
				} else if(col == 6) {
					((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text1)).setTextColor(Color.BLUE);
				//その他は黒文字
				} else {
					((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text1)).setTextColor(Color.BLACK);
				}
			//前月・来月の月跨ぎはグレー文字					
			} else {
				((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text1)).setTextColor(Color.GRAY);
			}
			
			//休日は赤文字
			if (holidays.containsKey(calYmd)
				&& holidays.get(calYmd).getHoliday().equals(HOLYDAY)) {
				((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text1)).setTextColor(Color.RED);
				((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text2)).setTextColor(Color.RED);
			}
			
			//テキストビューに日付を設定
			if (dayNum != 0) { 
				tg.setDayNum(dayNum);
				((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text1)).setText(tg.getDispString());
			}
			
			//休日のタイトルを設定
			if (holidays.containsKey(calYmd)) {
				((TextView)((CustomCalendarView)findViewById(tg.getTextViewId())).findViewById(R.id.text2)).setText((holidays.get(calYmd)).getTitle());
			}
			
			//次の曜日
			col += 1;
			
			//次の週、日曜日からスタート
			if (col == 7) {
				row += 1;
				col = 0;
			}
		}
		
		//表示年月設定
		this.headerMonthText.setText(String.valueOf(this.currentYear) 
				+ getString(R.string.saperator) + String.valueOf(this.currentMonth));	    
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
		for(int i = 0 ; i < this.dayTextList.size(); i++) {
			if(this.dayTextList.get(i).getTextViewId() == view.getId()) {
				((CustomCalendarView)findViewById(this.dayTextList.get(i).getTextViewId())).setBackgroundResource(R.drawable.text_selected_line);
				this.dayTextList.get(i).setSelected(true);
			}
			else {
				if(this.dayTextList.get(i).isNowDay() == true) {
					((CustomCalendarView)findViewById(this.dayTextList.get(i).getTextViewId())).setBackgroundResource(R.drawable.text_now_line);
					this.dayTextList.get(i).setSelected(false);
				}
				else if(this.dayTextList.get(i).isSelected()) {
					((CustomCalendarView)findViewById(this.dayTextList.get(i).getTextViewId())).setBackgroundResource(R.drawable.text_day_line);
					this.dayTextList.get(i).setSelected(false);
				}
			}
		}
	}
	
	public void goPreviousMonth(View view) {
		setCalendar(-1);
	}
	
	public void goCurrentMonth(View view) {
		this.currentYear = this.nowYear;
		this.currentMonth = this.nowMonth;
		setCalendar(0);
	}
	
	public void goNextMonth(View view) {
		setCalendar(1);
	}
}
