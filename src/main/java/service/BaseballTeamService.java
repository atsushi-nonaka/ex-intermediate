package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.BaseballTeam;
import repository.BaseballTeamRepository;

/**
 * 野球チーム情報を操作するサービス.
 * 
 * @author nonaa
 *
 */
@Service
public class BaseballTeamService {
	
	@Autowired
	private BaseballTeamRepository repository;
	
	/**
	 * 野球チームの全件検索.
	 * 
	 * @return チームリスト
	 */
	public List<BaseballTeam> findAll(){
		List<BaseballTeam> teamList = repository.findAll();
		return teamList;
	}
}
