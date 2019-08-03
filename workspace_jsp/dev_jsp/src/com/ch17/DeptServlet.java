package com.ch17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vo.DeptVO;

public class DeptServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		List<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("������");
		dvo.setLoc("����");
		deptList.add(dvo);
		dvo = new DeptVO();
		dvo.setDeptno(20);
		dvo.setDname("�ѹ���");
		dvo.setLoc("����");
		deptList.add(dvo);	
		dvo = new DeptVO();
		dvo.setDeptno(30);
		dvo.setDname("���ߺ�");
		dvo.setLoc("���ֵ�");
		deptList.add(dvo);			
		//���
		req.setAttribute("deptList", deptList);
		//������
		//req.getAttribute("deptList");
		//�̵�ó��
		//�׽�Ʈ �ó�����
		//���� - getDeptList.jsp��û - �� �������� �ε� - DeptServlet�������� ����
		//���� - jsp�� ���� ��û���� ���� ������ ���� ��û����. - ��� �ڵ���� -
		//    - URL�� ���� ȣ�� URL�״�� ������.
		//���ǻ��� - web.xml�� ������ �⵿�� �� �� �ѹ� ��ĵ�� ������ ������.
		//         ������ ��⵿ �ؾ� ��ĵ�� ���� �ݿ���.
		//        jsp�� �������� �� ��� �ݿ� ��
		RequestDispatcher view = req.getRequestDispatcher("jsonGetDeptList.jsp");
		view.forward(req, res);
	}
}





