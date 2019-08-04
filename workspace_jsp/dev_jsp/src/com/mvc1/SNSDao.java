package com.mvc1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.SNSMessageSet;
import com.vo.SNSMessageVO;
import com.vo.SNSReplyVO;

public class SNSDao {
	Logger logger = Logger.getLogger(TestDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	public SNSDao() {
		sqlSessionFactory=mcf.getSqlSessionFactory();		
	}
	public List<SNSMessageSet> getAll(String mem_id) {
		List<SNSMessageSet> datas = new ArrayList<SNSMessageSet>();
		List<SNSMessageVO> msgList = new ArrayList<>();
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			msgList = sqlSession.selectList("messageList",mem_id);
			if(msgList!=null) {
				for(int i=0;i<msgList.size();i++) {
					SNSMessageSet smSet = new SNSMessageSet();
					SNSMessageVO smVO = msgList.get(i);
					int mno = msgList.get(i).getMno();
					logger.info("mno:"+mno);
					List<SNSReplyVO> reList = getReply(mno);
					smVO.setReplycount(reList.size());
					smSet.setMsgVO(smVO);
					smSet.setReList(reList);
					datas.add(smSet);
				    
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return datas;
	}
	public List<SNSReplyVO> getReply(int mno) {
		logger.info("mno:"+mno);
		List<SNSReplyVO> repleList = new ArrayList<>();
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			repleList = sqlSession.selectList("replyList",mno);
			logger.info("repleList.size():"+repleList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return repleList;
	}
	
}
