package com.example.demo;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BoardController {
	private static final Logger logger = LogManager.getLogger(BoardController.class);
	@Autowired
	public BoardLogic boardLogic = null;
	@RequestMapping("board/htmlBoardList.do")
	public String htmlBoardList(Model model) {
		logger.info("htmlBoardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.getBoardList();
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageName", "htmlBoardList");
		return "board/htmlBoardList";
	}
	@RequestMapping("board/{name}.do2")
	public String getBoardListVer2(@PathVariable String name, Model model) {
		logger.info("getBoardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.getBoardList();
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageName", name);
		return "board/getBoardList";
	}
	@RequestMapping("board/{name}.do")
	public String getBoardList(@PathVariable String name, Model model) {
		logger.info("getBoardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.getBoardList();
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageName", name);
		return "board/getBoardList";
	}
}
