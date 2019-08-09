package com.vo;

public class DeptVOSimulation {

	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("영업부");
		dvo.setLoc("부산");
		EmpVO evo = new EmpVO();
		evo.setEname("이순신");
		evo.setEmpno(8500);
		dvo.setEmpVO(evo);//나는 이코드에 대해 설명할 수 있다.
		//검증하기
		System.out.println(dvo.getEmpVO().getEname());
		System.out.println(dvo.getEmpVO().getEmpno());
		System.out.println(dvo.getEmpVO().getComm());
		
	}

}
