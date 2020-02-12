package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

/**
 * ホテルの検索結果を操作する.
 * 
 * @author nonaa
 *
 */
@Controller
@RequestMapping("ex02")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@ModelAttribute
	public HotelForm setUpForm() {
		return new HotelForm();
	}

	/**
	 * ホテル検索画面に遷移させる.
	 * 
	 * @return ホテル検索画面html
	 */
	@RequestMapping("")
	public String search() {
		return "hotel/hotel-search";
	}
	
	/**
	 * ホテルの検索結果を表示させる.
	 * 
	 * @param price 価格
	 * @param model リクエストスコープ
	 * @return ホテル検索結果画面html
	 */
	@RequestMapping("search")
	public String searchByLessThanPrice(@Validated HotelForm hotelForm
													, BindingResult result
												    , Model model) {
		
		if(result.hasErrors() && !(hotelForm.getPrice().equals(""))) {
			return search();
		}
		
		List<Hotel> hotelList = new ArrayList<>();
		
		if(hotelForm.getPrice().equals("")) {
			hotelList = hotelService.searchAll();
		}else {
			Hotel hotel = new Hotel(); 
			hotel.setPrice(hotelForm.getIntPrice());
			hotelList = hotelService.searchByLessThanPrice(Integer.parseInt(hotelForm.getPrice()));			
		}
		
		model.addAttribute("hotelList", hotelList);
		return "hotel/hotel-search";
	}
}
