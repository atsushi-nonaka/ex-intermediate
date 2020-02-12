package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;


/**
 * 野球チーム一覧情報を検索する処理の記述.
 * 
 * @author nonaa
 *
 */
@Controller
@RequestMapping("/")
public class BaseballTeamController {
	
	@Autowired
	private BaseballTeamService baseballTeamService;
	
	/**
	 * 野球チーム一覧の出力.
	 * 
	 * @param model リクエストスコープ
	 * @return 野球チーム全件表示html
	 */
	@RequestMapping("/show-list")
	public String showList(Model model) {
		List<BaseballTeam> teamList = baseballTeamService.findAll();
		model.addAttribute("teamList", teamList);
		return "team/show-list";
	}
	
	/**
	 * 野球チーム詳細ページの出力.
	 * 
	 * @param id ID
	 * @param model リクエストスコープ
	 * @return 野球チーム詳細表示html
	 */
	@RequestMapping("/show-detail")
	public String showDetail(Integer id, Model model) {
		BaseballTeam baseballTeam = baseballTeamService.load(id);
		model.addAttribute("baseballTeam", baseballTeam);
		return "team/show-detail";
	}
}
