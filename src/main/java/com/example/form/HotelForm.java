package com.example.form;

import org.hibernate.validator.constraints.Range;

/**
 * ホテルのフォーム.
 * 
 * @author nonaa
 *
 */
public class HotelForm {
	/** 価格 */
	@Range(min=0, message="価格の値が不正です")
	private String price;

	public String getPrice() {
		return price;
	}
	
	/**
	 * 価格をInteger型に変換する.
	 * 
	 * @return 価格
	 */
	public Integer getIntPrice() {
		return Integer.parseInt(price);
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelForm [price=" + price + "]";
	}
}
