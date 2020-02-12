package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;


/**
 * 野球チーム情報を操作するサービス.
 * 
 * @author nonaa
 *
 */
@Service
public class BaseballTeamService {
	
	@Autowired
	private BaseballTeamRepository baseballTeamRepository;
	
	/**
	 * 野球チームの全件検索.
	 * 
	 * @return チームリスト
	 */
	public List<BaseballTeam> findAll(){
		List<BaseballTeam> teamList = baseballTeamRepository.findAll();
		return teamList;
	}
	
	/**
	 * 野球チームの1件検索.
	 * 
	 * @param id ID
	 * @return 野球チーム
	 */
	public BaseballTeam load(Integer id) {
		BaseballTeam baseballTeam = baseballTeamRepository.load(id);
		return baseballTeam;
	}
}
