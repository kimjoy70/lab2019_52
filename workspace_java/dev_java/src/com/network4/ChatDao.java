package com.network4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.jdbc.DBConnectionMgr2;
import com.vo.DeptVO;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

public class ChatDao {
	Connection con = null;
	CallableStatement cstmt = null;
	DBConnectionMgr2 dbMgr = new DBConnectionMgr2();	
	OracleCallableStatement ocstmt = null;
	ResultSet rs = null;
	public ChatDao() {
		// TODO Auto-generated constructor stub
	}
	public String login(String mem_id, String mem_pwd) {
		String mem_nick = "";
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_login(?,?,?)}");
			//����Ŭ ������ ���� ��ΰ� Ȯ�� �Ǿ��� �� ���� ?�ڸ� �� ù��°�� read�Ӽ��̹Ƿ�
			//p_empno�� ù��° ?�ڸ��� �����ؾ� ��.
			cstmt.setString(1, mem_id);
			cstmt.setString(2, mem_pwd);
			cstmt.registerOutParameter(3,OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet cursor =  ocstmt.getCursor(3);
		    while (cursor.next ()) {
		    	mem_nick = cursor.getString("mem_nick");
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage()+", "+e.toString());//��Ʈ�� ���� �� �ִ�.
		}		
		return mem_nick;
	}
}
