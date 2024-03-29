package com.mvc2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.BoardMasterVO;

public class BoardMasterDao {
	Logger logger = Logger.getLogger(BoardMasterDao.class);
	private SqlSessionFactory sqlSessionFactory = null;
	public BoardMasterDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		logger.info("sqlSessionFactory: "+sqlSessionFactory);
	}
	public List<Map<String, Object>> boardList(BoardMasterVO bmVO) 
	throws SQLException{
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = 
				new ArrayList<Map<String,Object>>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardList = sqlSession.selectList("boardList", bmVO);
		return boardList;
	}
	/****************************************************************
	 * 글 번호 채번하기 구현
	 * @return
	 ***************************************************************/
	public int getBmNo() {
		logger.info("getBmNo 호출 성공");
		int bm_no = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		bm_no = sqlSession.selectOne("getBmNo");
		logger.info("채번한 글 번호 bm_no"+bm_no);
		return bm_no;
	}
	public int boardMINS(Map<String, Object> pMap) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("boardMINS", pMap);
		sqlSession.commit();
		return result;
	}
	public int totalRecord(BoardMasterVO pbmVO) {
		logger.info("cb_search:"+pbmVO.getCb_search()+", tb_search:"+pbmVO.getTb_search());
		int total = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		total=sqlSession.selectOne("totalRecord",pbmVO);
		return total;
	}
	public void bmStepUpdate(Map<String, Object> pMap) {
		logger.info("bmStepUpdate 호출 성공");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("bmStepUpdate",pMap);
	}
	public int getBmGroup() {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.selectOne("getBmGroup");
		return result;
	}
	public void boardMDelete(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		
	}
	
}
