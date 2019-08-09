package com.mvc2;

public class SplitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String command = "redirect:/ch9/member/login.mvc";
		String strs[] = command.split("/");
		for(String str:strs) {
			System.out.println(str);
		}
	}

}
