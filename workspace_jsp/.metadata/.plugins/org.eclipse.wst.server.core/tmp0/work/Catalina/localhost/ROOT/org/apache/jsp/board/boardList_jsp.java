/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.19
 * Generated at: 2019-08-08 23:45:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class boardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/board/../common/easyui_common.jsp", Long.valueOf(1559345538162L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");

//페이지 처리에 필요한 변수 선언
	int tot = 0;
	if(session.getAttribute("tot") !=null){
		tot = (Integer)session.getAttribute("tot");		
	}
	out.print(tot);

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<!-- <meta charset=\"UTF-8\"> 이것때문에 한글깨짐.-->\r\n");
      out.write("<title>MVC기반의 계층형 게시판 구현하기</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://www.jeasyui.com/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/commons.js\"></script>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar g_no=0;//그리드에서 선택이 바뀔때 마다 변경된 값이 저장됨.\r\n");
      out.write("\tvar tb_value;\r\n");
      out.write("\tfunction dlgIns_save(){\r\n");
      out.write("\t\t//폼 전송 처리함.\r\n");
      out.write("\t\t//$(\"#f_boardIns\").attr(\"method\",\"post\");\r\n");
      out.write("\t\tvar bm_no = $(\"#bm_no\").val();\r\n");
      out.write("\t\tvar bm_group = $(\"#bm_group\").val();\r\n");
      out.write("\t\tvar bm_pos = $(\"#bm_pos\").val();\r\n");
      out.write("\t\tvar bm_step = $(\"#bm_step\").val();\r\n");
      out.write("\t\tvar param = \"&bm_no=\"+bm_no+\"&bm_group=\"+bm_group+\"&bm_pos=\"+bm_pos+\"&bm_step=\"+bm_step;\r\n");
      out.write("\t\t$(\"#f_boardIns\").attr(\"action\",\"./boardList.mvc?crud=ins\");\r\n");
      out.write("\t\t$(\"#f_boardIns\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction dlgIns_close(){\r\n");
      out.write("\t\t$(\"#dlg_boardIns\").dialog('close');\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction getBoardList(){\r\n");
      out.write("\t\t//alert(\"getBoardList호출\");\r\n");
      out.write("\t\tcb_value=user_combo;\r\n");
      out.write("\t\ttb_value = $(\"#tb_search\").val();\r\n");
      out.write("\t\talert(cb_value+\" , \"+tb_value);\r\n");
      out.write("\t\tvar x =\"crud=sel&cb_search=\"+cb_value+\"&tb_search=\"+tb_value+\"&page=1&pageSize=2\";\r\n");
      out.write("\t\t//alert(\"url:\"+x);\r\n");
      out.write("\t\tvar vtot=0;\r\n");
      out.write("    \t$(\"#dg_board\").datagrid({\r\n");
      out.write("    \t\turl:\"boardList.mvc?crud=sel&cb_search=\"+cb_value+\"&tb_search=\"+tb_value+\"&page=1&pageSize=2\"\r\n");
      out.write("           ,onLoadSuccess:function(data){\r\n");
      out.write("        \t   //data.total은 전체 datagrid의 레코드수를 출력함.\r\n");
      out.write("       \t   \t\t$.ajax({\r\n");
      out.write("       \t   \t\t\turl:\"boardList.mvc?crud=total&cb_search=\"+cb_value+\"&tb_search=\"+tb_value+\"&timestamp=\"+new Date().getTime()\r\n");
      out.write("       \t   \t\t  , success:function(data){\r\n");
      out.write("       \t   \t\t\t  //alert(\"data : \"+data);\r\n");
      out.write("       \t   \t\t\t  vtot = data;\r\n");
      out.write("       \t   \t\t\t  //alert(\"vtot:\"+vtot);\r\n");
      out.write("               \t   \t\t$('#pn_board').pagination({\r\n");
      out.write("            \t\t   //그 정보를 pagination 전체레코드수로 표시하기\r\n");
      out.write("           \t\t   \t\t\ttotal:vtot\r\n");
      out.write("           \t\t   \t\t});       \t   \t\t\t  \r\n");
      out.write("       \t   \t\t\t  //total:data;\r\n");
      out.write("       \t   \t\t  }\r\n");
      out.write("       \t   \t\t});        \t   \r\n");
      out.write("\r\n");
      out.write("/* \t            \tJ.messager.show({\r\n");
      out.write("                       title:'Info',\r\n");
      out.write("                       msg:'Load '+data.total+' records successfully'\r\n");
      out.write("                }); */\r\n");
      out.write("            }\t\t\t\r\n");
      out.write("    \t});\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t//페이지 네이션에서 페이지 이동 버튼을 클릭했을 때 실제 페이지 이동처리 구현\r\n");
      out.write("\tfunction pageMove(pageNumber, pageSize){\r\n");
      out.write("\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("//\t\t    url:'./mvcBoard.bd?gubun=getBoardList&page='+pageNumber+'&pageSize='+pageSize\r\n");
      out.write("\t\t    url:'./boardList.mvc?crud=sel&page='+pageNumber+'&pageSize='+pageSize\r\n");
      out.write("\t\t});    \t\t\r\n");
      out.write("\t}  \t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onLoad=\"getBoardList()\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar user_combo=\"bm_title\";//제목|내용|작성자\r\n");
      out.write("\tvar v_date;//사용자가 선택한 날짜 정보 담기\r\n");
      out.write("//기본 날짜포맷을 재정의\r\n");
      out.write("\t$.fn.datebox.defaults.formatter = function(date){\r\n");
      out.write("\t\tvar y = date.getFullYear();\r\n");
      out.write("\t\tvar m = date.getMonth()+1;\r\n");
      out.write("\t\tvar d = date.getDate();\r\n");
      out.write("\t\treturn y+'-'+(m<10? \"0\"+m:m)+'-'+(d<10? \"0\"+d:d);\r\n");
      out.write("\t}\r\n");
      out.write("//날짜 포맷을 적용\t\r\n");
      out.write("\t$.fn.datebox.defaults.parser = function(s){\r\n");
      out.write("\t\tvar t = Date.parse(s);\r\n");
      out.write("\t\tif (!isNaN(t)){\r\n");
      out.write("\t\t\treturn new Date(t);\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn new Date();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\t\r\n");
      out.write("\t$(document).ready(function(){//DOM구성이 완료된 시점-자바스크립트로 태그접근,설정변경,이미지\r\n");
      out.write("\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t//url:'./mvcBoard.bd?gubun=getBoardList&page=1&pageSize=5',\r\n");
      out.write("\t\t    //url:'./boardList.mvc?crud=sel&page=1&pageSize=2',\r\n");
      out.write("\t\t    pagination:true,\t\t\r\n");
      out.write("\t\t    singleSelect:true,\r\n");
      out.write("\t\t    onSelect: function(index,row){\r\n");
      out.write("\t\t\t\tvar row = $(\"#dg_board\").datagrid(\"getSelected\");\r\n");
      out.write("\t\t\t\tg_no = row.BM_NO;\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tonDblClickCell: function(index,field,value){\r\n");
      out.write("\t\t\t\t//alert(\"g_no:\"+g_no);선택한 글번호의 값을 전역변수에 저장\r\n");
      out.write("\t\t\t\tif(\"BM_TITLE\"==field){\r\n");
      out.write("\t\t\t\t\tcmm_window_popup(\"./boardList.mvc?crud=detail&bm_no=\"+g_no,\"700\",\"450\",\"read.jsp\");\r\n");
      out.write("\t\t\t\t\tg_no = 0;\r\n");
      out.write("\t\t\t\t\t$(\"#dg_board\").datagrid(\"clearSelections\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(\"BS_FILE\"==field){\r\n");
      out.write("\t\t\t\t\tlocation.href='downLoad.jsp?b_file='+value;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t\t//alert(\"g_no:\"+g_no);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$('#pn_board').pagination({\r\n");
      out.write("\r\n");
      out.write("\t\t    pageSize:2\r\n");
      out.write("\t\t   ,pageList: [2,3,5,10]\r\n");
      out.write("\t\t   ,onSelectPage:function(pageNumber, pageSize){//pageNumber:현재 내가 바라보는 페이지, pageSize:한페이지에 뿌릴 로우수\r\n");
      out.write("\t\t\t   //alert(\"pageNumber:\"+pageNumber+\"\\n pageSize:\"+ pageSize);\r\n");
      out.write("\t\t\t   pageMove(pageNumber, pageSize);\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t\t//등록 날짜 정보를 선택했을 때\r\n");
      out.write("\t\t$('#db_date').datebox({\r\n");
      out.write("\t\t\tonSelect: function(date){\r\n");
      out.write("\t\t\t\talert(date.getFullYear()+\":\"\r\n");
      out.write("\t\t\t\t\t+(date.getMonth()+1)+\":\"\r\n");
      out.write("\t\t\t\t\t +date.getDate());\r\n");
      out.write("\t\t\t\tvar y = date.getFullYear();\r\n");
      out.write("\t\t\t\tvar m = date.getMonth()+1;\r\n");
      out.write("\t\t\t\tvar d = date.getDate();\r\n");
      out.write("\t\t\t\tv_date = y+'-'+(m<10? \"0\"+m:m)+'-'+(d<10? \"0\"+d:d);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//검색 조건 콤보에 변경이 일어났을 때\r\n");
      out.write("\t\t$('#cb_search').combobox({\r\n");
      out.write("\t\t\tonChange:function(){\r\n");
      out.write("\t\t\t\tuser_combo = $(\"#cb_search\").combobox('getValue');\r\n");
      out.write("\t\t\t\t//alert(user_combo);//bm_title or bm_content or bm_writer\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$('#tb_search').textbox({\r\n");
      out.write("\t\t\ticons: [{\r\n");
      out.write("\t\t\t\ticonCls:'icon-search',\r\n");
      out.write("\t\t\t\thandler: function(e){\r\n");
      out.write("\t\t\t\t\talert(\"검색\");\r\n");
      out.write("\t\t\t\t\t//$(e.data.target).textbox('setValue', 'Something added!');\r\n");
      out.write("\t\t\t\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t\t\t\tmethod:\"get\"\r\n");
      out.write("\t\t\t\t\t   ,url:\"boardList.mvc?crud=sel&cb_search=\"+user_combo\r\n");
      out.write("\t\t\t\t\t\t\t            +\"&tb_search=\"+$(\"#tb_search\").val()\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$('#tb_search').textbox('textbox').bind('keydown', function(e){\r\n");
      out.write("\t\t\tif (e.keyCode == 13){\t// when press ENTER key, accept the inputed value.\r\n");
      out.write("\t\t\t\t//alert(\"엔터쳤을 때\");\r\n");
      out.write("\t\t\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t\t\tmethod:\"get\"\r\n");
      out.write("\t\t\t\t   ,url:\"boardList.mvc?crud=sel&cb_search=\"+user_combo\r\n");
      out.write("\t\t\t\t\t\t            +\"&tb_search=\"+$(\"#tb_search\").val()\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\t\t\r\n");
      out.write("\t    $('#linkBtnSearch').bind('click', function(){\r\n");
      out.write("\t        //alert('easyui');\r\n");
      out.write("\t        getBoardList();\r\n");
      out.write("\t    });\r\n");
      out.write("\t    /*===================== CRUD버튼 시작 ====================*/\t    \r\n");
      out.write("\t\t//조회버튼 클릭했을 때\r\n");
      out.write("\t    $('#crudBtnSel').bind('click', function(){\r\n");
      out.write("\t    \tgetBoardList();\r\n");
      out.write("\t    });\r\n");
      out.write("\t\t$('#crudBtnIns').bind('click', function(){\r\n");
      out.write("\t        //alert('입력 버튼');\r\n");
      out.write("\t        $(\"#dlg_boardIns\").dialog('open');\r\n");
      out.write("\t    });\t\r\n");
      out.write("\t\t$('#crudBtnUpd').bind('click', function(){\r\n");
      out.write("\t        alert('수정 버튼');\r\n");
      out.write("\t    });\t\r\n");
      out.write("\t\t$('#crudBtnDel').bind('click', function(){\r\n");
      out.write("\t        alert('삭제 버튼');\r\n");
      out.write("\t    });\t\t\t\r\n");
      out.write("\t    /*===================== CRUD버튼 끝 ====================*/\t    \r\n");
      out.write("\r\n");
      out.write("\t});///////////////// end of ready\r\n");
      out.write("</script>\r\n");
      out.write("<center>\r\n");
      out.write("    <table id=\"dg_board\" class=\"easyui-datagrid\" title=\"계층형 게시판 목록\" style=\"width:800px;height:400px\"\r\n");
      out.write("            data-options=\"rownumbers:true,singleSelect:true,toolbar:'#tb',footer:'#pn_board'\">\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th data-options=\"field:'BM_NO',width:60, align:'center', hidden:'true'\">글번호</th>\r\n");
      out.write("                <th data-options=\"field:'BM_TITLE',width:350\">제목</th>\r\n");
      out.write("                <th data-options=\"field:'BM_WRITER',width:80,align:'center'\">작성자</th>\r\n");
      out.write("                <th data-options=\"field:'BM_DATE',width:100,align:'center'\">작성일</th>\r\n");
      out.write("                <th data-options=\"field:'BS_FILE',width:170\">첨부파일</th>\r\n");
      out.write("                <th data-options=\"field:'BM_HIT',width:60,align:'center'\">조회수</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("    </table>\r\n");
      out.write("<!-- 툴바 추가 중 조건검색 화면 시작 -->    \r\n");
      out.write("    <div id=\"tb\" style=\"padding:2px 5px;\">\r\n");
      out.write("                                    <!-- \r\n");
      out.write("                                    req.getParameter(\"cb_search\"):String\r\n");
      out.write("                                    SELECT * FROM board_master_t\r\n");
      out.write("                                    WHERE ?(컬럼) LIKE %||?||%\r\n");
      out.write("                                     -->\r\n");
      out.write("        <select class=\"easyui-combobox\" id=\"cb_search\" name=\"cb_search\" panelHeight=\"auto\" style=\"width:100px\">\r\n");
      out.write("            <option selected>선택</option>\r\n");
      out.write("            <option value=\"bm_title\">제목</option>\r\n");
      out.write("            <option value=\"bm_content\">내용</option>\r\n");
      out.write("            <option value=\"bm_writer\">작성자</option>\r\n");
      out.write("        </select>\r\n");
      out.write("        <input id=\"tb_search\" name=\"tb_search\" class=\"easyui-textbox\" style=\"width:320px\">\r\n");
      out.write("        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                작성일: <input id=\"db_date\" class=\"easyui-datebox\" name=\"bm_date\" style=\"width:110px\">\r\n");
      out.write("<!-- 태그내에서 속성(width, align, href)이나  -->   \r\n");
      out.write("        <a id=\"linkBtnSearch\" class=\"easyui-linkbutton\" iconCls=\"icon-search\">Search</a>\r\n");
      out.write("<!--    <a id=\"linkBtnSearch\" href=\"javascript:btnSearch()\" class=\"easyui-linkbutton\" iconCls=\"icon-search\">Search</a> -->\r\n");
      out.write("\t<!-- 버튼 추가 화면 시작 --> \r\n");
      out.write("\t    <div id=\"ft\" style=\"padding:2px 5px;\">\r\n");
      out.write("\t        <a id=\"crudBtnSel\" href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\">조회</a>\r\n");
      out.write("\t        <a id=\"crudBtnIns\" href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">입력</a>\r\n");
      out.write("\t        <a id=\"crudBtnUpd\" href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\">수정</a>\r\n");
      out.write("\t        <a id=\"crudBtnDel\" href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-cut\" plain=\"true\">삭제</a>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t<!-- 버튼 추가 화면 끝 -->     \r\n");
      out.write("    </div>\r\n");
      out.write("<!-- 툴바 추가 중 조건검색 화면 끝 -->   \r\n");
      out.write("<!-- 페이지 네이션 추가 시작 -->\r\n");
      out.write("\t<div id=\"pn_board\" class=\"easyui-pagination\" style=\"background:#efefef;border:1px solid #ccc;\">\r\n");
      out.write("\t</div>\r\n");
      out.write("<!-- \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$('#pn_board').pagination({\r\n");
      out.write("\t\tpageList: [5,10,15,20]\r\n");
      out.write("\t   ,pageSize:5\r\n");
      out.write("\t   ,layout:['list','sep','first','prev','links','next','last','sep']\r\n");
      out.write("\t   ,onSelectPage:function(pageNumber, pageSize){\r\n");
      out.write("\t\t\t//alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);\r\n");
      out.write("\t\t   pageMove(pageNumber, pageSize);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});///////////////end of pagination\t\r\n");
      out.write("</script>\t\r\n");
      out.write(" -->\r\n");
      out.write("<!-- 페이지 네이션 추가   끝  -->\r\n");

	String gubun = request.getParameter("gubun");
	if("list".equals(gubun)){

      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\tgetBoardList();\r\n");
      out.write("</script>\t\r\n");
		
	}

      out.write("\r\n");
      out.write("<!-- 글입력 화면 추가 시작 -->\r\n");
      out.write("    <div id=\"dlg_boardIns\" footer=\"#tb_boardIns\" class=\"easyui-dialog\" title=\"글쓰기\" data-options=\"modal:true,closed:true\" style=\"width:600px;height:350px;padding:10px\">\r\n");
      out.write("        <form id=\"f_boardIns\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t    <input type=\"hidden\" id=\"bm_no\" name=\"bm_no\" value=\"0\">\r\n");
      out.write("\t    <input type=\"hidden\" id=\"bm_group\" name=\"bm_group\" value=\"0\">\r\n");
      out.write("\t    <input type=\"hidden\" id=\"bm_pos\" name=\"bm_pos\" value=\"0\">\r\n");
      out.write("\t    <input type=\"hidden\" id=\"bm_step\" name=\"bm_step\" value=\"0\">\r\n");
      out.write("        \t<table>\r\n");
      out.write("        \t\t<tr>\r\n");
      out.write("        \t\t\t<td width=\"100px\">제&nbsp;&nbsp;&nbsp;목</td>\r\n");
      out.write("        \t\t\t<td width=\"500px\"><input id=\"bm_title\" name=\"bm_title\" class=\"easyui-textbox\" data-options=\"width:'250px'\" required></td>\r\n");
      out.write("        \t\t</tr>\r\n");
      out.write("        \t\t<tr>\r\n");
      out.write("        \t\t\t<td width=\"100px\">작&nbsp;성&nbsp;자</td>\r\n");
      out.write("        \t\t\t<td width=\"500px\"><input id=\"bm_writer\" name=\"bm_writer\" class=\"easyui-textbox\" data-options=\"width:'150px'\" required></td>\r\n");
      out.write("        \t\t</tr>\r\n");
      out.write("        \t\t<tr>\r\n");
      out.write("        \t\t\t<td width=\"100px\">이&nbsp;메&nbsp;일</td>\r\n");
      out.write("        \t\t\t<td width=\"500px\"><input id=\"bm_email\" name=\"bm_email\" class=\"easyui-textbox\" data-options=\"width:'150px'\" required></td>\r\n");
      out.write("        \t\t</tr>\r\n");
      out.write("        \t\t<tr>\r\n");
      out.write("        \t\t\t<td width=\"100px\">내&nbsp;&nbsp;&nbsp;용</td>\r\n");
      out.write("        \t\t\t<td width=\"500px\"><input id=\"bm_content\" name=\"bm_content\" class=\"easyui-textbox\" data-options=\"multiline:'true',width:'350px', height:'90px'\" required></td>\r\n");
      out.write("        \t\t</tr>\r\n");
      out.write("        \t\t<tr>\r\n");
      out.write("        \t\t\t<td width=\"100px\">비&nbsp;&nbsp;&nbsp;번</td>\r\n");
      out.write("        \t\t\t<td width=\"500px\"><input id=\"bm_pw\" name=\"bm_pw\" class=\"easyui-textbox\" data-options=\"width:'100px'\" required></td>\r\n");
      out.write("        \t\t</tr>\r\n");
      out.write("        \t\t<tr>\r\n");
      out.write("        \t\t\t<td width=\"100px\">첨부파일</td>\r\n");
      out.write("        \t\t\t<td width=\"500px\"><input id=\"bs_file\" name=\"bs_file\" class=\"easyui-filebox\" data-options=\"width:'350px'\"></td>\r\n");
      out.write("        \t\t</tr>\r\n");
      out.write("        \t</table>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- 다이얼로그 화면 버튼 추가 시작 -->\r\n");
      out.write("\t<div id=\"tb_boardIns\">\r\n");
      out.write("\t<a href=\"javascript:dlgIns_save()\" class=\"easyui-linkbutton\">저장</a>\r\n");
      out.write("\t<a href=\"javascript:dlgIns_close()\" class=\"easyui-linkbutton\">닫기</a>\r\n");
      out.write("\t</div>    \r\n");
      out.write("    <!-- 다이얼로그 화면 버튼 추가  끝   -->\r\n");
      out.write("<!-- 글입력 화면 추가  끝   -->\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}