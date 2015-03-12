package com.sample.mycalendar;



public class DayTextViewInfo {
	private int textViewId = 0;						//カレンダーテキストビューID
	private CustomCalendarView customObject =null;	//カスタムビューオブジェクト
	private int dayNum;						//日付
	private String title;					//タイトル
	private boolean isToDay = false;		//現在日付フラグ
	private boolean isSelected = false;		//日付選択フラグ
	
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
	 * dayNum 日付
	 * @return dayNum
	 */
	public int getDayNum() {
		return dayNum;
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
	 * @param dayNum 日付を設定
	 */
	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
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

	/**
	 * 日付を文字列に変換
	 * @return
	 */
	public String getDispString() {
		if(this.dayNum != 0) {
			return String.valueOf(this.dayNum);
		} else {
			return "";
		}
	}
}
