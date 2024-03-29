package com.mvc1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.MemberVO;
import com.vo.ZipCodeVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao mDao = new MemberDao();
	ZipCodeDao zDao = new ZipCodeDao();
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert 호출 성공");
		int result = 0;
		result = mDao.memberInsert(pMap);
		return result;
	}
	public List<Map<String, Object>> memberList() {
		logger.info("memberList 호출 성공");
		List<Map<String, Object>> memList = null;
		memList = mDao.memberList();
		return memList;
	}
	public List<ZipCodeVO> zipcodeList(ZipCodeVO zVO) {
		logger.info("zipcodeList 호출 성공");
		List<ZipCodeVO> zipList = null;
		zipList = zDao.zipcodeList(zVO);
		return zipList;
	}
	public MemberVO login(MemberVO mVO) {
		logger.info("login 호출 성공");
		MemberVO rmVO = null;
		Map<String,Object> rMap = mDao.idId(mVO);
		if("아이디가 존재합니다.".equals(rMap.get("STATUS").toString())) {
			logger.info("아이디가 존재할 때");
			rmVO = mDao.login(mVO);		
			if(rmVO.getMem_name().length()>1) {
				rmVO.setMem_id(mVO.getMem_id());
			}
		}
		else {
			rmVO.setMem_name("아이디가 존재하지 않습니다.");
		}
		return rmVO;
	}
	public Map<String,Object> proc_login(MemberVO mVO) {
		logger.info("proc_login 호출 성공");
		Map<String,Object> pMap = mDao.proc_login(mVO);
		//mDao.my_proc();
		return pMap;
	}

}






