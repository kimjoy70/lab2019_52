package com.vo;

import java.util.ArrayList;
import java.util.List;

public class SNSMessageSet {
	// 메시지
	private SNSMessageVO msgVO;
	// 해당 메시지에 대한 댓글 목록
	private List<SNSReplyVO> reList = null;
	public SNSMessageVO getMsgVO() {
		return msgVO;
	}
	public void setMsgVO(SNSMessageVO msgVO) {
		this.msgVO = msgVO;
	}
	public List<SNSReplyVO> getReList() {
		return reList;
	}
	public void setReList(List<SNSReplyVO> reList) {
		this.reList = reList;
	}
}
