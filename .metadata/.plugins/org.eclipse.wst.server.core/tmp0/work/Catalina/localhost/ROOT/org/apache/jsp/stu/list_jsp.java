/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-08-03 02:40:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.stu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"row my-5\">\r\n");
      out.write("	<div class=\"col\">\r\n");
      out.write("		<h1 class=\"text-center mb-5\">학생목록</h1>\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<form class=\"col-6\" name=\"frm\">\r\n");
      out.write("				<div class=\"input-group\">\r\n");
      out.write("					<select class=\"form-select\" name=\"key\">\r\n");
      out.write("						<option value=\"scode\">학생번호</option>\r\n");
      out.write("						<option value=\"sname\" selected>학생이름</option>\r\n");
      out.write("						<option value=\"dept\">학생학과</option>\r\n");
      out.write("						<option value=\"pname\">교수이름</option>\r\n");
      out.write("						<option value=\"year\">학생학년</option>\r\n");
      out.write("					</select>&nbsp;\r\n");
      out.write("					<input class=\"form-control\" placeholder=\"검색어\" name=\"query\">\r\n");
      out.write("					<input type=\"submit\" value=\"검색\" class=\"btn btn-primary\">\r\n");
      out.write("				</div>\r\n");
      out.write("			</form>\r\n");
      out.write("			<div class=\"col text-end\">\r\n");
      out.write("				<button class=\"btn btn-primary\" id=\"btn-insert\">학생등록</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<hr>\r\n");
      out.write("		<div id=\"div_stu\"></div>\r\n");
      out.write("		<div id=\"pagination\" class=\"pagination justify-content-center mt-5\"></div>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 학생등록모달 -->\r\n");
      out.write("<div class=\"modal fade\" id=\"modal-insert\" data-bs-backdrop=\"static\" data-bs-keyboard=\"false\" tabindex=\"-1\" aria-labelledby=\"staticBackdropLabel\" aria-hidden=\"true\">\r\n");
      out.write("  <div class=\"modal-dialog\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <h1 class=\"modal-title fs-5\" id=\"staticBackdropLabel\">학생등록</h1>\r\n");
      out.write("        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "insert.jsp", out, false);
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 학생목록 템플릿-->\r\n");
      out.write("<script id=\"temp_stu\" type=\"text/x-handlebars-template\">\r\n");
      out.write("	<table class=\"table\">\r\n");
      out.write("		{{#each .}}\r\n");
      out.write("		<tr class=\"stu\" style=\"cursor:pointer;\" >\r\n");
      out.write("			<td>{{scode}}</td>\r\n");
      out.write("			<td>{{sname}}</td>\r\n");
      out.write("			<td>{{dept}}</td>\r\n");
      out.write("			<td>{{birthday}}</td>\r\n");
      out.write("			<td>{{year}}</td>\r\n");
      out.write("			<td>{{pname}}({{advisor}})</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		{{/each}}\r\n");
      out.write("	</table>\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("	let query=\"\";\r\n");
      out.write("	let key=$(frm.key).val();\r\n");
      out.write("	\r\n");
      out.write("	$(\"#div_stu\").on(\"click\", \".stu\", function(){\r\n");
      out.write("		const scode=$(this).attr(\"scode\")\r\n");
      out.write("		location.href=\"/stu/update?scode=\" +scode;\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"#btn-insert\").on(\"click\", function(){\r\n");
      out.write("		$(\"#modal-insert\").modal(\"show\");\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	getTotal();\r\n");
      out.write("	$(frm).on(\"submit\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		key=$(frm.key).val();\r\n");
      out.write("		query=$(frm.query).val();\r\n");
      out.write("		getTotal();\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	function getTotal(){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			type:\"get\",\r\n");
      out.write("			url:\"/stu/total\",\r\n");
      out.write("			data:{key:key, query:query},\r\n");
      out.write("			success:function(data){\r\n");
      out.write("				console.log(data);\r\n");
      out.write("				const totalPages=Math.ceil(data/5);\r\n");
      out.write("					if(totalPages==0){\r\n");
      out.write("						alert(\"검색 내용이 없습니다!\");\r\n");
      out.write("						$(frm.query).val();\r\n");
      out.write("						query=\"\";\r\n");
      out.write("						getTotal();\r\n");
      out.write("				}else{\r\n");
      out.write("					$(\"#pagination\").show();\r\n");
      out.write("					$(\"#pagination\").twbsPagination(\"changeTotalPages\", totalPages, 1);\r\n");
      out.write("					$(\"#div_stu\").show();\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function getList(page){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			type:\"get\",\r\n");
      out.write("			url: \"/stu/list.json\",\r\n");
      out.write("			data: {page: page, key:key, query:query},\r\n");
      out.write("			dataType:\"json\",\r\n");
      out.write("			success:function(data){\r\n");
      out.write("				console.log(data);\r\n");
      out.write("				const temp=Handlebars.compile($(\"#temp_stu\").html());\r\n");
      out.write("				const html=temp(data);\r\n");
      out.write("				$(\"#div_stu\").html(html);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	//페이지네이션 출력\r\n");
      out.write("	$('#pagination').twbsPagination({\r\n");
      out.write("	    totalPages:10,	// 총 페이지 번호 수\r\n");
      out.write("	    visiblePages: 5,	// 하단에서 한번에 보여지는 페이지 번호 수\r\n");
      out.write("	    startPage : 1, // 시작시 표시되는 현재 페이지\r\n");
      out.write("	    initiateStartPageClick: false,	// 플러그인이 시작시 페이지 버튼 클릭 여부 (default : true)\r\n");
      out.write("	    first : '<i class=\"bi bi-skip-start\"></i>',	// 페이지네이션 버튼중 처음으로 돌아가는 버튼에 쓰여 있는 텍스트\r\n");
      out.write("	    prev : '<i class=\"bi bi-caret-left\"></i>',	// 이전 페이지 버튼에 쓰여있는 텍스트\r\n");
      out.write("	    next : '<i class=\"bi bi-caret-right\"></i>',	// 다음 페이지 버튼에 쓰여있는 텍스트\r\n");
      out.write("	    last : '<i class=\"bi bi-skip-end\"></i>',	// 페이지네이션 버튼중 마지막으로 가는 버튼에 쓰여있는 텍스트\r\n");
      out.write("	    onPageClick: function (event, page) {\r\n");
      out.write("	    	getList(page);\r\n");
      out.write("	    }\r\n");
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
