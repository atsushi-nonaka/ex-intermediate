package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.BaseballTeam;

/**
 * 野球チーム一覧情報を検索する処理の記述
 * 
 * @author nonaa
 *
 */
@Controller
@RequestMapping("")
public class BaseballTeamController {
	
	public String showList(Model model) {
		BaseballTeam baseballTeam = new BaseballTeam();
		
		return "show-list";
	}
}
