/**
 * 
 */
package com.sample.mycalendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author wonjun
 *
 */
public class CustomCalendarView extends LinearLayout {
	
	public CustomCalendarView(Context context) {
		super(context);
		init(null);
	}
	
	public CustomCalendarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}
	
	public void init(AttributeSet attrs) {
		Context context = getContext();
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		//カスタムビューのxmlを読取る
		inflater.inflate(R.layout.view_custom_calendar, this);
		
		if (attrs == null) return;
		
		//カスタムビューのスタイル属性定義を読取る
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCalendarView);
		
		// カスタムビューの項目初期化
		String dayText = typedArray.getString(R.styleable.CustomCalendarView_dayText);
		String titleText = typedArray.getString(R.styleable.CustomCalendarView_titleText);
		
		//TypedArray　recycle
		typedArray.recycle();
		
		//カスタムビュー項目に初期値を設定
		TextView textView1 = (TextView) findViewById(R.id.text_day);
		textView1.setText(dayText);
		
		TextView textView2 = (TextView) findViewById(R.id.text_title);
		textView2.setText(titleText);
		
	}
}
