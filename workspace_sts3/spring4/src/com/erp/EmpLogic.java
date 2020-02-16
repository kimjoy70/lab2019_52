package com.erp;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vo.DeptVO;
import com.vo.EmpVO;
public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	public EmpDaoImpl empDaoImpl = null;
	public void setEmpDaoImpl(EmpDaoImpl empDaoImpl) {
		this.empDaoImpl = empDaoImpl;
	}
	public DeptDaoImpl deptDaoImpl = null;
	public void setDeptDaoImpl(DeptDaoImpl deptDaoImpl)
	{
		this.deptDaoImpl = deptDaoImpl;
	}
	public int doEmp(EmpVO peVO) {
		logger.info("doEmp");
		int result = 0;
		peVO.setEmpno(9003);
		peVO.setEname("나종일");
		peVO.setMgr(7902);
		peVO.setJob("CLERK");
		peVO.setHiredate("");
		peVO.setSal(2300);
		peVO.setComm(500);
		peVO.setDeptno(90);
		try {
			
			DeptVO pdVO = new DeptVO();
			pdVO.setDeptno(90);
			pdVO.setDname("총무부");
			pdVO.setLoc("부산");
			deptDaoImpl.deptInsert(pdVO);
			result = empDaoImpl.empInsert(peVO);
		} catch (DataAccessException de) {
			throw de;
		}
		return result;
	}
}








