/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.19
 * Generated at: 2019-07-21 04:35:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.onLineTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class instructor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/onLineTest/bottom.jsp", Long.valueOf(1563664228516L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\", initial-scale=\"1\">\r\n");
      out.write("<title>강사진 - 코딩놀이</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap1.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- \r\n");
      out.write("======================================================================================================================\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\ttop 영역 시작\r\n");
      out.write("======================================================================================================================\r\n");
      out.write(" -->\r\n");
      out.write("<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">코딩놀이</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"nav navbar-nav\">\r\n");
      out.write("      <li class=\"active\"><a href=\"#\">Home</a></li>\r\n");
      out.write("      <li><a href=\"#\">소개</a></li>\r\n");
      out.write("      <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Front-End노트<span class=\"caret\"></span></a>\r\n");
      out.write("        <ul class=\"dropdown-menu\">\r\n");
      out.write("          <li><a href=\"#\">HTML5</a></li>\r\n");
      out.write("          <li><a href=\"#\">CSS</a></li>\r\n");
      out.write("          <li><a href=\"#\">JavaScript</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Back-End노트<span class=\"caret\"></span></a>\r\n");
      out.write("        <ul class=\"dropdown-menu\">\r\n");
      out.write("          <li><a href=\"#\">Java</a></li>\r\n");
      out.write("          <li><a href=\"#\">서블릿</a></li>\r\n");
      out.write("          <li><a href=\"#\">JSP</a></li>\r\n");
      out.write("          <li><a href=\"#\">Spring</a></li>\r\n");
      out.write("          <li><a href=\"#\">안드로이드</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>\r\n");
      out.write("     </ul>\r\n");
      out.write("     <div id=\"loginForm\" class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("        <form class=\"navbar-form navbar-right\" action=\"/action_page.php\">\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"usrname\" size=\"10\" placeholder=\"아이디\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"psw\" size=\"10\" placeholder=\"비밀번호\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-dark\" onclick=\"loginAction()\">Login</button>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- \r\n");
      out.write("======================================================================================================================\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\ttop 영역  끝\r\n");
      out.write("======================================================================================================================\r\n");
      out.write(" -->\r\n");
      out.write("     <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-xs-12\">\r\n");
      out.write("                <div class=\"panel panel-primary\">\r\n");
      out.write("                    <div class=\"panel-heading\">\r\n");
      out.write("                        <h3 class=\"panel-title\">\r\n");
      out.write("                            <span class=\"glyphicon glyphicon-tags\"></span>&nbsp;&nbsp;나신입\r\n");
      out.write("                        </h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"panel-body\">\r\n");
      out.write("                        <div class=\"media\">\r\n");
      out.write("                            <div class=\"media-left\">\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <img class=\"media-object\" src=\"../images/여진구.jpeg\" alt=\"개발자이미\">\r\n");
      out.write("                            </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"media-body\">\r\n");
      out.write("                                <h4 class=\"media-heading\">김유신</h4><br>\r\n");
      out.write("                                한국소프트웨어 인재 개발원 대표 강사입니다.\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <table class=\"table\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th>강사명</th>\r\n");
      out.write("                                <th>강의 번호</th>\r\n");
      out.write("                                <th>강의 제목</th>\r\n");
      out.write("                                <th>강의 날짜</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                        \t<tr>\r\n");
      out.write("                        \t\t<td>김승수</td>\r\n");
      out.write("                        \t\t<td>1</td>\r\n");
      out.write("                        \t\t<td><a href=\"lecture.html?lectureName=c\">C언어 강좌</a></td>\r\n");
      out.write("                        \t\t<td>2019-04-20</td>\r\n");
      out.write("                        \t</tr>\r\n");
      out.write("                        \t<tr>\r\n");
      out.write("                        \t\t<td>김유신</td>\r\n");
      out.write("                        \t\t<td>2</td>\r\n");
      out.write("                        \t\t<td><a href=\"lecture.html?lectureName=java\">JAVA 강좌</a></td>\r\n");
      out.write("                        \t\t<td>2019-03-20</td>\r\n");
      out.write("                        \t</tr>\r\n");
      out.write("                        \t<tr>\r\n");
      out.write("                        \t\t<td>이성계</td>\r\n");
      out.write("                        \t\t<td>3</td>\r\n");
      out.write("                        \t\t<td><a href=\"lecture.html?lectureName=oracle\">Oracle 강좌</a></td>\r\n");
      out.write("                        \t\t<td>2019-05-20</td>\r\n");
      out.write("                        \t</tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <div class=\"panel-footer\">\r\n");
      out.write("                        <blockquote>I Can Do It!!!</blockquote>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("<!-- \r\n");
      out.write("======================================================================================================================\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tbottom 영역 시작\r\n");
      out.write("======================================================================================================================\r\n");
      out.write(" -->\r\n");
      out.write("\r\n");
      out.write("    <footer style=\"background-color: #000000; color: #ffffff;\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("            <!-- 12개 범위에서 맞추어 준다. -->\r\n");
      out.write("                <div class=\"col-sm-2\" style=\"text-align: center;\"><h5>Copyright &copy; 2019</h5><h5>김유신</h5></div>\r\n");
      out.write("                <div class=\"col-sm-4\"><h4>대표자 소개</h4><p>한국소프트인재개발원에서 자바과정을 담당하고 있습니다.</p></div>\r\n");
      out.write("                <div class=\"col-sm-2\"><h4 style=\"text-align: center;\">내비게이션</h4>\r\n");
      out.write("                \t<div class=\"list-group\">\r\n");
      out.write("                     <a href=\"#\" class=\"list-group-item\">소개</a>   \r\n");
      out.write("                     <a href=\"#\" class=\"list-group-item\">강사진</a>\r\n");
      out.write("                     <a href=\"#\" class=\"list-group-item\">강의</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-2\"><h4 style=\"text-align: center;\">SNS</h4>\r\n");
      out.write("                    <div class=\"list-group\">\r\n");
      out.write("                     <a href=\"#\" class=\"list-group-item\">페이스북</a>   \r\n");
      out.write("                     <a href=\"#\" class=\"list-group-item\">유튜브</a>\r\n");
      out.write("                     <a href=\"#\" class=\"list-group-item\">네이버 TV</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                 </div>\r\n");
      out.write("                  <div class=\"col-sm-2\"><h4 style=\"text-align: center;\"><span class=\"glyphicon glyphicon-ok\" ></span>by &nbsp;김유신</h4></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>   ");
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("======================================================================================================================\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tbottom 영역  끝\r\n");
      out.write("======================================================================================================================\r\n");
      out.write(" -->\r\n");
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