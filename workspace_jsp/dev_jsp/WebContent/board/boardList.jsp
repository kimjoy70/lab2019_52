<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%
//페이지 처리에 필요한 변수 선언
	int tot = 0;
	if(session.getAttribute("tot") !=null){
		tot = (Integer)session.getAttribute("tot");		
	}
	out.print(tot);
%>    
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> 이것때문에 한글깨짐.-->
<title>MVC기반의 계층형 게시판 구현하기</title>
<%@ include file="../common/easyui_common.jsp" %>
<script type="text/javascript">
	var g_no=0;//그리드에서 선택이 바뀔때 마다 변경된 값이 저장됨.
	var tb_value;
	function dlgIns_save(){
		//폼 전송 처리함.
		//$("#f_boardIns").attr("method","post");
		var bm_no = $("#bm_no").val();
		var bm_group = $("#bm_group").val();
		var bm_pos = $("#bm_pos").val();
		var bm_step = $("#bm_step").val();
		var param = "&bm_no="+bm_no+"&bm_group="+bm_group+"&bm_pos="+bm_pos+"&bm_step="+bm_step;
		$("#f_boardIns").attr("action","./boardList.mvc?crud=ins");
		$("#f_boardIns").submit();
	}
	function dlgIns_close(){
		$("#dlg_boardIns").dialog('close');
	}
	function getBoardList(){
		//alert("getBoardList호출");
		cb_value=user_combo;
		tb_value = $("#tb_search").val();
		alert(cb_value+" , "+tb_value);
		var x ="crud=sel&cb_search="+cb_value+"&tb_search="+tb_value+"&page=1&pageSize=2";
		//alert("url:"+x);
		var vtot=0;
    	$("#dg_board").datagrid({
    		url:"boardList.mvc?crud=sel&cb_search="+cb_value+"&tb_search="+tb_value+"&page=1&pageSize=2"
           ,onLoadSuccess:function(data){
        	   //data.total은 전체 datagrid의 레코드수를 출력함.
       	   		$.ajax({
       	   			url:"boardList.mvc?crud=total&cb_search="+cb_value+"&tb_search="+tb_value+"&timestamp="+new Date().getTime()
       	   		  , success:function(data){
       	   			  //alert("data : "+data);
       	   			  vtot = data;
       	   			  //alert("vtot:"+vtot);
               	   		$('#pn_board').pagination({
            		   //그 정보를 pagination 전체레코드수로 표시하기
           		   			total:vtot
           		   		});       	   			  
       	   			  //total:data;
       	   		  }
       	   		});        	   

/* 	            	J.messager.show({
                       title:'Info',
                       msg:'Load '+data.total+' records successfully'
                }); */
            }			
    	});		
	}
	//페이지 네이션에서 페이지 이동 버튼을 클릭했을 때 실제 페이지 이동처리 구현
	function pageMove(pageNumber, pageSize){
		$("#dg_board").datagrid({
//		    url:'./mvcBoard.bd?gubun=getBoardList&page='+pageNumber+'&pageSize='+pageSize
		    url:'./boardList.mvc?crud=sel&page='+pageNumber+'&pageSize='+pageSize
		});    		
	}  	
</script>
</head>
<body onLoad="getBoardList()">
<script type="text/javascript">
	var user_combo="bm_title";//제목|내용|작성자
	var v_date;//사용자가 선택한 날짜 정보 담기
//기본 날짜포맷을 재정의
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10? "0"+m:m)+'-'+(d<10? "0"+d:d);
	}
//날짜 포맷을 적용	
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	}	
	$(document).ready(function(){//DOM구성이 완료된 시점-자바스크립트로 태그접근,설정변경,이미지
		$("#dg_board").datagrid({
			//url:'./mvcBoard.bd?gubun=getBoardList&page=1&pageSize=5',
		    //url:'./boardList.mvc?crud=sel&page=1&pageSize=2',
		    pagination:true,		
		    singleSelect:true,
		    onSelect: function(index,row){
				var row = $("#dg_board").datagrid("getSelected");
				g_no = row.BM_NO;
			},
			onDblClickCell: function(index,field,value){
				//alert("g_no:"+g_no);선택한 글번호의 값을 전역변수에 저장
				if("BM_TITLE"==field){
					cmm_window_popup("./boardList.mvc?crud=detail&bm_no="+g_no,"700","450","read.jsp");
					g_no = 0;
					$("#dg_board").datagrid("clearSelections");
				}
				if("BS_FILE"==field){
					location.href='downLoad.jsp?b_file='+value;
				}
			}	
			//alert("g_no:"+g_no);
		});
		$('#pn_board').pagination({
<%-- 		    total:<%=tot%> --%>
		    pageSize:2
		   ,pageList: [2,3,5,10]
		   ,onSelectPage:function(pageNumber, pageSize){//pageNumber:현재 내가 바라보는 페이지, pageSize:한페이지에 뿌릴 로우수
			   //alert("pageNumber:"+pageNumber+"\n pageSize:"+ pageSize);
			   pageMove(pageNumber, pageSize);
		   }
		});		
		//등록 날짜 정보를 선택했을 때
		$('#db_date').datebox({
			onSelect: function(date){
				alert(date.getFullYear()+":"
					+(date.getMonth()+1)+":"
					 +date.getDate());
				var y = date.getFullYear();
				var m = date.getMonth()+1;
				var d = date.getDate();
				v_date = y+'-'+(m<10? "0"+m:m)+'-'+(d<10? "0"+d:d);
			}
		});
		
		//검색 조건 콤보에 변경이 일어났을 때
		$('#cb_search').combobox({
			onChange:function(){
				user_combo = $("#cb_search").combobox('getValue');
				//alert(user_combo);//bm_title or bm_content or bm_writer
			}
		});

		$('#tb_search').textbox({
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					alert("검색");
					//$(e.data.target).textbox('setValue', 'Something added!');
					$("#dg_board").datagrid({
						method:"get"
					   ,url:"boardList.mvc?crud=sel&cb_search="+user_combo
							            +"&tb_search="+$("#tb_search").val()
					});
				}
			}]
		});
/* 		$('#tb_search').textbox('textbox').bind('keydown', function(e){
			if (e.keyCode == 13){	// when press ENTER key, accept the inputed value.
				//alert("엔터쳤을 때");
				$("#dg_board").datagrid({
					method:"get"
				   ,url:"boardList.mvc?crud=sel&cb_search="+user_combo
						            +"&tb_search="+$("#tb_search").val()
				});
			}
		});	 */	
	    $('#linkBtnSearch').bind('click', function(){
	        //alert('easyui');
	        getBoardList();
	    });
	    /*===================== CRUD버튼 시작 ====================*/	    
		//조회버튼 클릭했을 때
	    $('#crudBtnSel').bind('click', function(){
	    	getBoardList();
	    });
		$('#crudBtnIns').bind('click', function(){
	        //alert('입력 버튼');
	        $("#dlg_boardIns").dialog('open');
	    });	
		$('#crudBtnUpd').bind('click', function(){
	        alert('수정 버튼');
	    });	
		$('#crudBtnDel').bind('click', function(){
	        alert('삭제 버튼');
	    });			
	    /*===================== CRUD버튼 끝 ====================*/	    

	});///////////////// end of ready
</script>
<center>
    <table id="dg_board" class="easyui-datagrid" title="계층형 게시판 목록" style="width:800px;height:400px"
            data-options="rownumbers:true,singleSelect:true,toolbar:'#tb',footer:'#pn_board'">
        <thead>
            <tr>
                <th data-options="field:'BM_NO',width:60, align:'center', hidden:'true'">글번호</th>
                <th data-options="field:'BM_TITLE',width:350">제목</th>
                <th data-options="field:'BM_WRITER',width:80,align:'center'">작성자</th>
                <th data-options="field:'BM_DATE',width:100,align:'center'">작성일</th>
                <th data-options="field:'BS_FILE',width:170">첨부파일</th>
                <th data-options="field:'BM_HIT',width:60,align:'center'">조회수</th>
            </tr>
        </thead>
    </table>
<!-- 툴바 추가 중 조건검색 화면 시작 -->    
    <div id="tb" style="padding:2px 5px;">
                                    <!-- 
                                    req.getParameter("cb_search"):String
                                    SELECT * FROM board_master_t
                                    WHERE ?(컬럼) LIKE %||?||%
                                     -->
        <select class="easyui-combobox" id="cb_search" name="cb_search" panelHeight="auto" style="width:100px">
            <option selected>선택</option>
            <option value="bm_title">제목</option>
            <option value="bm_content">내용</option>
            <option value="bm_writer">작성자</option>
        </select>
        <input id="tb_search" name="tb_search" class="easyui-textbox" style="width:320px">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                작성일: <input id="db_date" class="easyui-datebox" name="bm_date" style="width:110px">
<!-- 태그내에서 속성(width, align, href)이나  -->   
        <a id="linkBtnSearch" class="easyui-linkbutton" iconCls="icon-search">Search</a>
<!--    <a id="linkBtnSearch" href="javascript:btnSearch()" class="easyui-linkbutton" iconCls="icon-search">Search</a> -->
	<!-- 버튼 추가 화면 시작 --> 
	    <div id="ft" style="padding:2px 5px;">
	        <a id="crudBtnSel" href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
	        <a id="crudBtnIns" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">입력</a>
	        <a id="crudBtnUpd" href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true">수정</a>
	        <a id="crudBtnDel" href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true">삭제</a>
	    </div>
	<!-- 버튼 추가 화면 끝 -->     
    </div>
<!-- 툴바 추가 중 조건검색 화면 끝 -->   
<!-- 페이지 네이션 추가 시작 -->
	<div id="pn_board" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;">
	</div>
<!-- 
<script type="text/javascript">
	$('#pn_board').pagination({
		pageList: [5,10,15,20]
	   ,pageSize:5
	   ,layout:['list','sep','first','prev','links','next','last','sep']
	   ,onSelectPage:function(pageNumber, pageSize){
			//alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
		   pageMove(pageNumber, pageSize);
		}
	});///////////////end of pagination	
</script>	
 -->
<!-- 페이지 네이션 추가   끝  -->
<%
	String gubun = request.getParameter("gubun");
	if("list".equals(gubun)){
%>	
<script type="text/javascript">
		getBoardList();
</script>	
<%		
	}
%>
<!-- 글입력 화면 추가 시작 -->
    <div id="dlg_boardIns" footer="#tb_boardIns" class="easyui-dialog" title="글쓰기" data-options="modal:true,closed:true" style="width:600px;height:350px;padding:10px">
        <form id="f_boardIns" method="post" enctype="multipart/form-data">
	    <input type="hidden" id="bm_no" name="bm_no" value="0">
	    <input type="hidden" id="bm_group" name="bm_group" value="0">
	    <input type="hidden" id="bm_pos" name="bm_pos" value="0">
	    <input type="hidden" id="bm_step" name="bm_step" value="0">
        	<table>
        		<tr>
        			<td width="100px">제&nbsp;&nbsp;&nbsp;목</td>
        			<td width="500px"><input id="bm_title" name="bm_title" class="easyui-textbox" data-options="width:'250px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">작&nbsp;성&nbsp;자</td>
        			<td width="500px"><input id="bm_writer" name="bm_writer" class="easyui-textbox" data-options="width:'150px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">이&nbsp;메&nbsp;일</td>
        			<td width="500px"><input id="bm_email" name="bm_email" class="easyui-textbox" data-options="width:'150px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">내&nbsp;&nbsp;&nbsp;용</td>
        			<td width="500px"><input id="bm_content" name="bm_content" class="easyui-textbox" data-options="multiline:'true',width:'350px', height:'90px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">비&nbsp;&nbsp;&nbsp;번</td>
        			<td width="500px"><input id="bm_pw" name="bm_pw" class="easyui-textbox" data-options="width:'100px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">첨부파일</td>
        			<td width="500px"><input id="bs_file" name="bs_file" class="easyui-filebox" data-options="width:'350px'"></td>
        		</tr>
        	</table>
        </form>
    </div>
    <!-- 다이얼로그 화면 버튼 추가 시작 -->
	<div id="tb_boardIns">
	<a href="javascript:dlgIns_save()" class="easyui-linkbutton">저장</a>
	<a href="javascript:dlgIns_close()" class="easyui-linkbutton">닫기</a>
	</div>    
    <!-- 다이얼로그 화면 버튼 추가  끝   -->
<!-- 글입력 화면 추가  끝   -->
</center>
</body>
</html>