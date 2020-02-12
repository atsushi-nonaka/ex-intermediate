package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
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

	/**
	 * ホテル検索画面に遷移させる.
	 * 
	 * @return ホテル検索画面html
	 */
	@RequestMapping("")
	public String search() {
		return "hotel/hotel-search";
	}
	
	@RequestMapping("search")
	public String searchByLessThanPrice(Integer price, Model model) {
		List<Hotel> hotelList = hotelService.searchByLessThanPrice(price);
		model.addAttribute("hotelList", hotelList);
		return "hotel/hotel-search";
	}
}
