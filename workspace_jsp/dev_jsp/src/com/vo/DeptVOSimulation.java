package com.vo;

public class DeptVOSimulation {

	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("������");
		dvo.setLoc("�λ�");
		EmpVO evo = new EmpVO();
		evo.setEname("�̼���");
		evo.setEmpno(8500);
		dvo.setEmpVO(evo);//���� ���ڵ忡 ���� ������ �� �ִ�.
		//�����ϱ�
		System.out.println(dvo.getEmpVO().getEname());
		System.out.println(dvo.getEmpVO().getEmpno());
		System.out.println(dvo.getEmpVO().getComm());
		
	}

}
