package com.mvc1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.SNSMessageSet;
import com.vo.SNSMessageVO;

public class SNSLogic {
	Logger logger = Logger.getLogger(SNSLogic.class);
	SNSDao sDao = new SNSDao();
	public List<SNSMessageSet> getAll(String mem_id) {
		logger.info("getAll 호출 성공");
		List<SNSMessageSet> msgAllList = null;
		msgAllList = sDao.getAll(mem_id);
		return msgAllList;
	}
}
