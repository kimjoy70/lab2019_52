package com.mvc1;
/*
 * 표준 서블릿이 제공하는 메소드는 모두 리턴 타입이 void였다.
 * 내가 설계하는 클래스 에서는 리턴 타입을 따로 설계하여 추가 하고 싶다.
 * execute메소드의 리턴 타입을 ActionForward로 한다.
 * 
 */
public class ActionForward {
	private String viewName = null;
	private boolean isRedirect = false;//true이면 redirect, false이면 forward
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
}
