package com.erp;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.DeptVO;
public class DeptLogic {
	Logger logger = Logger.getLogger(DeptLogic.class);
	public DeptDaoImpl deptDaoImpl = null;
	public void setDeptDaoImpl(DeptDaoImpl deptDaoImpl) {
		this.deptDaoImpl = deptDaoImpl;
	}
	public int deptInsert(DeptVO pdVO) {
		int result = deptDaoImpl.deptInsert(pdVO);
		return result;
	}
}








