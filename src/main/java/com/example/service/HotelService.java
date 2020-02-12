package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル情報を操作するサービス.
 * 
 * @author nonaa
 *
 */
@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * 価格以下のホテルを検索する.
	 * 
	 * @param price 価格
	 * @return ホテルリスト
	 */
	public List<Hotel> searchByLessThanPrice(Integer price){
		List<Hotel> hotelList = hotelRepository.findByLessThanPrice(price);
		return hotelList;
	}
}
