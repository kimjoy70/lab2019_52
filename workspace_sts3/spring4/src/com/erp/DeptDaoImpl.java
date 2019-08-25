package com.erp;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.DeptVO;

public class DeptDaoImpl implements DeptMapper{
	Logger logger =   
			Logger.getLogger(DeptDaoImpl.class);
	public SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public int deptInsert(DeptVO pdVO) {
		logger.info("deptInsert 호출 성공");
		int result = 
			sqlSessionTemplate.insert("deptInsert",pdVO);
		return result;
	}
}




