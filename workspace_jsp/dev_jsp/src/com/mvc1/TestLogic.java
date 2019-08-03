package com.mvc1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	TestDao tDao = new TestDao();
	public int examFee(String p_subcd) {
		logger.info("examFee 호출 성공");
		int fee = 0;
		fee = tDao.examFee(p_subcd);
		return fee;
	}
	public List<Map<String, Object>> subjectList() {
		logger.info("subjectList 호출 성공");
		List<Map<String, Object>> subList = null;
		subList = tDao.subjectList();
		return subList;
	}
	public int examReceipt(Map<String, Object> pMap) {
		logger.info("examReceipt 호출 성공");
		int result = 0;
		String exam_no = null;//수험번호 채번 담기
		exam_no = tDao.getExamNo();
		pMap.put("exam_no",exam_no);
		result = tDao.examReceipt(pMap);
		return result;
	}
	public List<Map<String, Object>> swDesignExam() {
		logger.info("swDesignExam 호출 성공");
		List<Map<String, Object>> designList = null;
		designList = tDao.swDesignExam();
		return designList;
	}
	public String isOk(Map<String, Object> pMap) {
		logger.info("isOk 호출 성공");
		String msg = null;
		msg = tDao.isOk(pMap);
		return msg;
	}
	public String examPaperAdd(Map<String, Object> pMap) {
		logger.info("examPaperAdd 호출 성공");
		String msg = null;
		msg = tDao.examPaperAdd(pMap);
		return msg;
	}


}
