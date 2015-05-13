package com.sample.mycalendar;

public class DayTextViewInfo {
	private int textViewId = 0;							// カレンダーテキストビューID
	private CustomCalendarView customObject = null;		// カスタムビューオブジェクト
	private String date;								// 日付
	private String title;								// タイトル
	private boolean isToDay = false;					// 現在日付フラグ
	private boolean isSelected = false;					// 日付選択フラグ
	
	/**
	 * コンストラクター
	 */
	public DayTextViewInfo(int controlId){
		this.setTextViewId(controlId);
	}
	
	/**
	 * @return textViewId
	 */
	public int getTextViewId() {
		return textViewId;
	}
	/**
	 * @param textViewId カレンダーテキストビューID
	 */
	public void setTextViewId(int textViewId) {
		this.textViewId = textViewId;
	}
	
	/**
	 * date 日付
	 * @return String 日付
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * @param String 日付を設定
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * @return the customObject
	 */
	public CustomCalendarView getCustomObject() {
		return customObject;
	}
	
	/**
	 * @param customObject the customObject to set
	 */
	public void setCustomObject(CustomCalendarView customObject) {
		this.customObject = customObject;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * isToDay 現在日付フラグを返す
	 * @return isToDay
	 */
	public boolean isToDay() {
		return isToDay;
	}
	
	/**
	 * @param isToDay 現在日付を設定
	 */
	public void setToDay(boolean isToDay) {
		this.isToDay = isToDay;
	}
	
	/**
	 * isSelected 選択フラグを返す
	 * @return isSelected
	 */
	public boolean isSelected() {
		return isSelected;
	}
	
	/**
	 * @param isSelected 選択フラグを設定
	 */
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
