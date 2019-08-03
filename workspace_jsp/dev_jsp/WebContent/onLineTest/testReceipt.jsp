<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO, java.util.Map, java.util.Iterator" %>    
<%@ page import="java.util.List, com.vo.TakeExaminationVO" %>    
<%
	Map<String,Object> pMap = (Map<String,Object>)session.getAttribute("pMap");
	String s_memid = null;
	String s_memname = null;
	if(pMap!=null){
		s_memid = pMap.get("mem_id").toString();
		s_memname = pMap.get("mem_name").toString();		
	}
	//시험 접수 내용 가져오기
	List<TakeExaminationVO> list = (List)pMap.get("key");
	Iterator<TakeExaminationVO> iter = list.iterator();
	while(iter.hasNext()) {
		TakeExaminationVO teVO = (TakeExaminationVO)iter.next();
		out.print("rMap:"+teVO.getExam_date()+" , "+teVO.getSub_cd()+" , "+teVO.getExam_no());
	}	
%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>자격시험 - 정보처리기사</title>
    <link rel="stylesheet" type="text/css" href="/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/demo/demo.css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
    	var g_paycheck=0;
    	function receipt(){
    		alert(g_paycheck);
    		if(g_paycheck==1){
	    		$("#f_receipt").attr("method","get");
	    		$("#f_receipt").attr("action","examReceipt.kos");
	    		$("#f_receipt").submit();
    		}else{
    			alert("응시료 납부하세요.");
    			return;
    		}
    	}
    	function goPayment(){
    		g_paycheck=1;
    		
    	}
    </script>
</head>
<body>
	<script type="text/javascript">
	    function myformatter(date){
	        var y = date.getFullYear();
	        var m = date.getMonth()+1;
	        var d = date.getDate();
	        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	    }
	    function myparser(s){
	        if (!s) return new Date();
	        var ss = (s.split('-'));
	        var y = parseInt(ss[0],10);//두번째 파라미터는 몇 진수인가를 의미함.
	        var m = parseInt(ss[1],10);
	        var d = parseInt(ss[2],10);
	        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
	            return new Date(y,m-1,d);
	        } else {
	            return new Date();
	        }
	    }	
		$(document).ready(function (){
			g_paycheck=0;
			$("#mem_name").textbox('setValue','<%=s_memname%>');
			$('#cb_subject').combobox({
			    url:'/onLineTest/subjectList.kos?work=onLineTest',
			    valueField:'SUB_CD',
			    textField:'SUB_NAME',
		        onSelect: function(rec){
		            var c_subcd = rec.SUB_CD;
		            $.ajax({
		            	method:"get",
		            	url:"/onLineTest/examFee.kos?work=onLineTest&sub_cd="+c_subcd,
		            	success:function(data){
		            		alert("fee : "+data);
		            		$("#exam_fee").textbox('setValue',data);
		            	}
		            });
		        }
			});			
		});
	</script>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="자격시험 접수" style="width:100%;max-width:600px;padding:30px 60px;">
    	<form id="f_receipt">
    		<input type="hidden" id="mem_id" name="mem_id" value="<%=s_memid%>"/>
    		<input type="hidden" id="work" name="work" value="onLineTest"/>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" id="mem_name" name="mem_name" label="이름:" labelPosition="top" style="width:160px;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-datebox" id="exam_date" name="exam_date" labelPosition="top" label="응시일:" data-options="formatter:myformatter,parser:myparser" style="width:150;">
        </div>
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" id="cb_subject" name="sub_cd" label="수험과목선택:" labelPosition="top" data-options="prompt:'수험과목을 선택하세요'" style="width:400px;">
            </select>
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" id="exam_fee" name="exam_fee" label="응시료:납부해야 접수 됩니다" labelPosition="top" style="width:200px;">
            <a href="javascript:goPayment()" class="easyui-linkbutton" iconCls="icon-ok" style="width:120px;height:32px">응시료납부</a>            
        </div>
        <div>
            <a href="javascript:receipt()" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">접수</a>
        </div>
        </form>
    </div>    
</body>
</html>