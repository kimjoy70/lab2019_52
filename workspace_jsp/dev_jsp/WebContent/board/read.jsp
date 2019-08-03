<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map"%>    
<%
	List<Map<String,Object>> getBoardList = 
		(List<Map<String,Object>>)request.getAttribute("boardList");
	String rb_email = null;
	String rb_file = null;
	String rb_title = null;
	String rb_name = null;
	String rb_content = null;
	String rb_pwd = null;
	String rb_no = null;
	String rb_group = null;
	String rb_pos = null;
	String rb_step = null;
	if(getBoardList!=null && getBoardList.size()>0){
		rb_email = getBoardList.get(0).get("BM_EMAIL").toString();
		rb_file = getBoardList.get(0).get("BS_FILE").toString();
		rb_title = getBoardList.get(0).get("BM_TITLE").toString();
		rb_name = getBoardList.get(0).get("BM_WRITER").toString();
		rb_content = getBoardList.get(0).get("BM_CONTENT").toString();
		rb_pwd = getBoardList.get(0).get("BM_PW").toString();
		rb_no = getBoardList.get(0).get("BM_NO").toString();
		rb_group = getBoardList.get(0).get("BM_GROUP").toString();
		rb_pos = getBoardList.get(0).get("BM_POS").toString();
		rb_step = getBoardList.get(0).get("BM_STEP").toString();
	}
	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글상세보기</title>
<!-- 공통 코드 include처리 -->
<%@ include file="../common/easyui_common.jsp" %>
<script type="text/javascript">
	//글삭제하기 이벤트 처리
	function boardDelView(){
		alert("boardDelView호출 성공");
		  $('#d_boardDel').dialog({
			    title: '글삭제',
			    buttons: btn_boardDel,
			    width: 420,
			    height: 250,
			    closed: true,
			    cache: false,
			    href: 'boardDelForm.jsp?bm_no=<%=rb_no%>&bm_pw=<%=rb_pwd%>',
			    modal: true
	   }); 
	   $('#d_boardDel').dialog('open');		
	}
	//글삭제 화면에서 확인 버튼을 클릭했을 때
	function boardDel(){
		var db_pw = <%=rb_pwd%>
		var u_pw = $("#db_pw").textbox('getValue');
		alert("db_pw:"+db_pw+", u_pw:"+u_pw);
		//alert("사용자가 입력한 비번:"+$("#db_pw").textbox('getValue'));
		//사용자가 입력한 비번과 DB에서 읽어온 비번을 비교하여
		//일치하면 삭제 처리 진행하고
		//불일치하면 비번을 다시 입력받도록 해주세요.
		if(u_pw==db_pw){
			//alert("같다");
			$.messager.confirm('Confirm','정말 삭제하시겠습니까?',function(r){
			 //r:true-ok, false-cancel
				if (r){//자바스크립트는 0이면 false 나머지 true
			    	location.href="./boardList.mvc?crud=del&b_no=<%=rb_no%>&b_file=<%=rb_file%>";    
			    }
			});
		}else{
			$("#db_pw").textbox('setValue','');
		}
	}
	function boardDelClose(){
		 $('#d_boardDel').dialog('close');
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
<%-- 		$("#b_title").textbox('setValue','<%=rb_title%>');
		$("#b_name").textbox('setValue','<%=rb_name%>');
		$("#b_content").textbox('setValue','<%=rb_content%>');
		$("#b_pwd").textbox('setValue','<%=rb_pwd%>'); --%>
	});
</script>
    <table align="center" id="p" class="easyui-panel" title="글상세보기" 
        style="width:670px;height:380px;padding:10px;background:#fafafa;">
	    	<tr>
	    	<td>제목</td>
	    	<td><input id="bm_title" value="<%=rb_title%>" name="bm_title" data-options="width:'450px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>작성자</td>
	    	<td><input id="bm_writer" value="<%=rb_name%>" name="bm_writer" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>이메일</td>
	    	<td><input id="bm_email" value="<%=rb_email%>" name="bm_email" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>내용</td>
	    	<td><input id="bm_content" value="<%=rb_content%>" name="bm_content" data-options="multiline:'true', width:'570px', height:'90px'" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    	<td>비밀번호</td>
	    	<td><input id="bm_pw" value="<%=rb_pwd%>" name="bm_pw" class="easyui-passwordbox"></td>
	    	</tr>	    	
	   </table>
	    <table align="center">
	    	<tr>
	    	<td>
				<a href="javascript:repleForm('<%=rb_no%>','<%=rb_group%>','<%=rb_pos%>','<%=rb_step%>')" class="easyui-linkbutton">댓글</a>
				<a href="javascript:updateForm()" class="easyui-linkbutton">수정</a>
				<a href="javascript:boardDelView()" class="easyui-linkbutton">삭제</a>
	    	</td>
	    	</tr>
	    </table>
		<!-- 글삭제 시작 -->
		<div id="d_boardDel" closed="true" class="easyui-dialog" style="padding:20px 50px">
			<div id="btn_boardDel" align="right">
			<a href="javascript:boardDel()" class="easyui-linkbutton" iconCls="icon-ok" style="width:90px">확인</a>
			<a href="javascript:boardDelClose()" class="easyui-linkbutton" iconCls="icon-cancel" style="width:90px">닫기</a>
			</div>
		</div>
		<!-- 글삭제  끝   -->
		<!-- 글수정 시작 -->
		<div id="d_boardUpd" closed="true" class="easyui-dialog" style="padding:20px 50px">
			<div id="btn_boardUpd" align="right">
			<a href="javascript:boardUpd()" class="easyui-linkbutton" iconCls="icon-ok" style="width:90px">등록</a>
			<a href="javascript:boardUpdClose()" class="easyui-linkbutton" iconCls="icon-cancel" style="width:90px">닫기</a>
			</div>
		</div>
		<!-- 글수정  끝  -->
		<!-- 댓글쓰기 시작 -->
		<div id="d_boardReple" closed="true" class="easyui-dialog" style="padding:20px 50px">
			<div id="btn_boardReple" align="right">
			<a href="javascript:boardReple()" class="easyui-linkbutton" iconCls="icon-ok" style="width:90px">등록</a>
			<a href="javascript:boardRepleClose()" class="easyui-linkbutton" iconCls="icon-cancel" style="width:90px">닫기</a>
			</div>
		</div>
		<!-- 댓글쓰기  끝  -->	    
</body>
</html>