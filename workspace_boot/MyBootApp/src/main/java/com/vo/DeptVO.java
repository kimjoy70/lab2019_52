package com.vo;

public class DeptVO {
	int ck = 0;
	int deptno = 0;
	String dname = null;
	String loc = null;
	//���̺� �����ϴ� �÷��� �ƴϳ� ���ν����� ����ó������� ���� ��������
	String report = null;
	int empno = 0;
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public static void main(String args[]) {
		DeptVO dvo = new DeptVO();
		// getter�� ���� �о�� �� ����մϴ�.
	}

	public int getDeptno() {
		return deptno;
	} 

	// setter�� ���� ������ �� ����մϴ�.
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getCk() {
		return ck;
	}

	public void setCk(int ck) {
		this.ck = ck;
	}

}
