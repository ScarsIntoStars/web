/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-08-04 01:52:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<form name=\"frm1\">\r\n");
      out.write("	<div class=\"input-group mb-2\">\r\n");
      out.write("		<span class=\"input-group-text\">교수이름</span>\r\n");
      out.write("		<input name=\"pname\" class=\"form-control\">\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"input-group mb-2\">\r\n");
      out.write("		<span class=\"input-group-text\">교수학과</span>\r\n");
      out.write("		<select name=\"dept\" class=\"form-select\">\r\n");
      out.write("			<option value=\"컴정\">컴퓨터정보공학</option>\r\n");
      out.write("			<option value=\"전자\">전자공학</option>\r\n");
      out.write("			<option value=\"건축\">건축공학과</option>\r\n");
      out.write("		</select>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"input-group mb-2 pt-2\">\r\n");
      out.write("		<span class=\"input-group-text\">교수직급</span>&nbsp;&nbsp;\r\n");
      out.write("		<input type=\"radio\" name=\"title\" value=\"정교수\">\r\n");
      out.write("		<span class=\"pt-2\">정교수</span>&nbsp;&nbsp;\r\n");
      out.write("		<input type=\"radio\" name=\"title\" value=\"부교수\" checked>\r\n");
      out.write("		<span class=\"pt-2\">부교수</span>&nbsp;&nbsp;\r\n");
      out.write("		<input type=\"radio\" name=\"title\" value=\"정교수\">\r\n");
      out.write("		<span class=\"pt-2\">조교수</span>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"input-group mb-2\">\r\n");
      out.write("		<span class=\"input-group-text\">교수급여</span>\r\n");
      out.write("		<input name=\"salary\" class=\"form-control\" value=\"0\">\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"input-group mb-2\">\r\n");
      out.write("		<span class=\"input-group-text\">임용일자</span>\r\n");
      out.write("		<input name=\"hiredate\" class=\"form-control\" type=\"date\">\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"text-center mt-5\">\r\n");
      out.write("		<input type=\"submit\" value=\"교수등록\" class=\"btn btn-primary\">\r\n");
      out.write("		<input type=\"reset\" value=\"등록취소\" class=\"btn btn-secondary\">\r\n");
      out.write("	</div>\r\n");
      out.write("</form>\r\n");
      out.write("<script>\r\n");
      out.write("	$(frm1).on(\"submit\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		const pname=$(frm1.pname).val();\r\n");
      out.write("		const salary=$(frm1.salary).val();\r\n");
      out.write("		const title=$(frm1.title).val();\r\n");
      out.write("		const dept=$(frm1.dept).val();\r\n");
      out.write("		const hiredate=$(frm1.date).val();\r\n");
      out.write("		\r\n");
      out.write("		if(pname==\"\"){\r\n");
      out.write("			alert(\"교수이름을 입력하세요!\");\r\n");
      out.write("			$(frm1.pname).focus();\r\n");
      out.write("		}else if(salary.replace(/[0-9]/g, '')){\r\n");
      out.write("			alert(\"급여를 숫자로 입력하세요!\");\r\n");
      out.write("			$(frm1.salary).val(\"\");\r\n");
      out.write("			$(frm1.salary).focus();\r\n");
      out.write("		}else{\r\n");
      out.write("			if(confirm(\"새로운 교수를 등록하실래요?\")){\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					type:\"post\",\r\n");
      out.write("					url:\"/pro/insert\",\r\n");
      out.write("					data:{pname:pname, salary:salary, title:title, dept:dept, hiredate:hiredate},\r\n");
      out.write("					success:function(){\r\n");
      out.write("						getTotal();\r\n");
      out.write("						$('#insert').modal(\"hide\");\r\n");
      out.write("					}\r\n");
      out.write("				})\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(frm1).on(\"reset\", function(){\r\n");
      out.write("		$(\"#insert\").modal(\"hide\")\r\n");
      out.write("	});\r\n");
      out.write("</script>");
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
