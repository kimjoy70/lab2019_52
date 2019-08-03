package com.mvc;
/*
 * 페이지 이동처리
 * 1)redirect
 * 2)forward
 * 고려:페이지의 path정보
 */
public class ActionForward {
	private String path = null;
	private boolean isRedirect = false;//true:redirect,  false:forward
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
