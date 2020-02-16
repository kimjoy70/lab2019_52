package com.mvc2;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.HashMapBinder;
import com.vo.BoardMasterVO;
//@Controller
//public class BoardController{
public class BoardController implements Controller {
	Logger logger = Logger.getLogger(BoardController.class);
	String requestName = null;
	String crud = null;
	//@Autowired
	//private BoardLogic boardLogic = null;
	BoardLogic boardLogic = new BoardLogic();
	int tot = 0;
	public BoardController(String requestName
			             , String crud) 
	{
		this.requestName = requestName;
		this.crud = crud;
		BoardMasterVO bmVO = new BoardMasterVO();
		tot = boardLogic.getTot(bmVO);
	}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String path = "";
		String crud = req.getParameter("crud");
		logger.info("crud:"+crud);
		HttpSession session = req.getSession();
		session.setAttribute("tot", tot);
		BoardMasterVO bmVO = new BoardMasterVO();
		if("boardView".equals(crud)) {
			path = "redirect:boardList.jsp";
		}
		else if("total".equals(crud)) {
			bmVO.setCb_search(req.getParameter("cb_search"));
			bmVO.setTb_search(req.getParameter("tb_search"));
			bmVO.setBm_date(req.getParameter("bm_date"));
			tot = boardLogic.getTot(bmVO);
			req.setAttribute("rtot", tot);
			path = "forward:totalRecord.jsp";
		}
		else if("sel".equals(crud)) {
			//페이지 처리에 관련된 정보 담기
			int page=0;
			int pageSize=0;
			logger.info("pageSize:"+req.getParameter("pageSize"));
			if(req.getParameter("page")!=null) {
				page = Integer.parseInt(req.getParameter("page"));
			}
			if(req.getParameter("pageSize")!=null) {
				pageSize = Integer.parseInt(req.getParameter("pageSize"));
			}
			bmVO.setPage(page);
			bmVO.setPageSize(pageSize);
			bmVO.setCb_search(req.getParameter("cb_search"));
			bmVO.setTb_search(req.getParameter("tb_search"));
			bmVO.setBm_date(req.getParameter("bm_date"));
			List<Map<String,Object>> boardList = null;
			boardList = boardLogic.boardList(bmVO);
			req.setAttribute("boardList", boardList);
			path = "forward:/board/jsonBoardList.jsp";
		}
		else if("detail".equals(crud)) {
			bmVO = null;
			bmVO = new BoardMasterVO();
			int bm_no = 0;
			if(req.getParameter("bm_no")!=null) {
				bm_no = Integer.parseInt(req.getParameter("bm_no"));
				bmVO.setBm_no(bm_no);
			}
			List<Map<String,Object>> boardList = null;
			boardList = boardLogic.boardList(bmVO);
			req.setAttribute("boardList", boardList);
			path = "forward:/board/read.jsp";
		}
		else if("ins".equals(crud)) {
			int result = 0;
			//insert here
			Map<String,Object> pMap = new HashMap<String,Object>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.multiBind(pMap);
			result = boardLogic.boardINS(pMap);			
			if(result == 1) {//
				path = "redirect:/board/boardList.jsp";
			}else if(result ==0) {
				path ="redirect:/board/boardInsFail.jsp"; 
			}
			
		}
		else if("upd".equals(crud)) {
			logger.info("수정하기");
			//insert here
			
		}
		//삭제
		else if("del".equals(crud)) {
			Map<String,Object> pMap = new HashMap<String,Object>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			boardLogic.boardDEL(pMap);
		}
		return path;
	}

}
