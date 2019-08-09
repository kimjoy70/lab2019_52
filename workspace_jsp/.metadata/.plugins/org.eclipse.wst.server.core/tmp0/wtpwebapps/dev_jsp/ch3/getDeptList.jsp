<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
	List<Map<String,Object>> deptList =
		(List<Map<String,Object>>)request.getAttribute("deptList");
	int size = 0;
	if(deptList!=null){
		size = deptList.size();
	}
%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>부서목록</title>
<%@ include file="../common/easyui_common.jsp" %>
</head>
<body>
    <h2>Basic DataGrid</h2>
    <p>The DataGrid is created from markup, no JavaScript code needed.</p>
    <div style="margin:20px 0;"></div>
    
    <table class="easyui-datagrid" title="부서목록" style="width:700px;height:250px"
            data-options="singleSelect:true,collapsible:true,method:'get',toolbar:toolbar">
        <thead>
            <tr>
                <th data-options="field:'deptno',width:100, align:'center'">부서번호</th>
                <th data-options="field:'dname',width:150, align:'center'">부서명</th>
                <th data-options="field:'loc',width:150, align:'center'">지역</th>
            </tr>
        </thead>
<%
	for(int i=0;i<size;i++){
		Map<String,Object> rMap = deptList.get(i);
%>        
        <tr>
            <td><%=rMap.get("deptno") %></td>
            <td><%=rMap.get("dname") %></td>
            <td>지역</td>
        </tr>
<%	
	}
%>        
    </table>
    <script type="text/javascript">
        var toolbar = [{
            text:'조회',
            iconCls:'icon-search',
            handler:function(){alert('조회')}
        }];
    </script> 
</body>
</html>