package com.mvc2;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.vo.BoardMasterVO;

public class RestController implements Controller {
	Logger logger = Logger.getLogger(RestController.class);
	String requestName = null;
	String crud = null;
	Gson g = null;
	BoardLogic bLogic = null;
	public RestController(String requestName, String crud) 
	{
		this.requestName = requestName;
		this.crud = crud;
		g = new Gson();
		bLogic = new BoardLogic();
	}	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String jsonStr = null;
		String crud = req.getParameter("crud");
		logger.info("crud : "+crud);
		BoardMasterVO pbmVO = new BoardMasterVO();
		if("jsonBoardList".equals(crud)) {
			List<Map<String,Object>> boardList = null;
			boardList = bLogic.boardList(pbmVO);
			jsonStr = g.toJson(boardList);
			logger.info("jsonStr:"+jsonStr);
		}
		return jsonStr;
	}

}