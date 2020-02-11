package repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import domain.BaseballTeam;

/**
 * teamsテーブルを操作するレポジトリ.
 * 
 * @author nonaa
 *
 */
@Repository
public class BaseballTeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** テーブル名 */
	private final static String TABLE_NAME = "teams";
	
	/**
	 * 野球チームを生成するローマッパー.
	 */
	private final static RowMapper<BaseballTeam> BaseballTeam_ROW_MAPPER = (rs, i) ->{
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setHistory(rs.getString("history"));
		return baseballTeam;
	};
	
	/**
	 * 野球チームの全件検索.
	 * 
	 * @return
	 */
	public List<BaseballTeam> findAll(){
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM " + TABLE_NAME;
		List<BaseballTeam> teamList = new LinkedList<BaseballTeam>();
		teamList = template.query(sql, BaseballTeam_ROW_MAPPER);
		return teamList;
	}
}
