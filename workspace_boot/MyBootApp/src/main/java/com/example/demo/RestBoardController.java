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
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestBoardController {
	private static final Logger logger = LogManager.getLogger(RestBoardController.class);
	@Autowired
	public BoardLogic boardLogic = null;
	@RequestMapping("board/jsonBoardList.do")
	public List<Map<String,Object>> jsonBoardList(Model model) {
		logger.info("jsonBoardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.getBoardList();
		return boardList;
	}
}
