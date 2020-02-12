package com.example.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルを操作するレポジトリ.
 * 
 * @author nonaa
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** テーブル名 */
	private final static String TABLE_NAME = "hotels";
	
	/**
	 * ホテルを生成するローマッパー.
	 */
	private final static RowMapper<Hotel>Hotel_ROW_MAPPER=(rs, i)->{
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	/**
	 * 価格以下のホテルを検索する(価格順).
	 * 
	 * @return ホテルリスト
	 */
	public List<Hotel> findByLessThanPrice(Integer price){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking "
				     + "FROM " + TABLE_NAME + " WHERE price <= :price ORDER BY price";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = template.query(sql, param, Hotel_ROW_MAPPER);
		return hotelList;
	}
	
	/**
	 * ホテルを全件検索する(価格順).
	 * 
	 * @return ホテルリスト
	 */
	public List<Hotel> findAll(){
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking "
				     + "FROM " + TABLE_NAME  + " ORDER BY price";
		
		List<Hotel> hotelList = template.query(sql, Hotel_ROW_MAPPER);
		return hotelList;
	} 
}
