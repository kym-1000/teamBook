/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2023-04-24 05:36:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bookDetailView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

private static org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:replace", org.apache.taglibs.standard.functions.Functions.class, "replace", new Class[] {java.lang.String.class, java.lang.String.class, java.lang.String.class});
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/SPRING%20_wk/5조_ww프로젝트파일(최종본)/book1-main/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/book/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1671504856282L));
    _jspx_dependants.put("jar:file:/C:/SPRING%20_wk/5조_ww프로젝트파일(최종본)/book1-main/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/book/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<!-- CSS only -->\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n");
      out.write("<link href=\"/resources/css/bookDetailView.css\" rel=\"stylesheet\" /> \n");
      out.write("<style>\n");
      out.write(".intro {\n");
      out.write("	display: -webkit-box;\n");
      out.write("	word-wrap: break-word;\n");
      out.write("	-webkit-line-clamp: 3;\n");
      out.write("	-webkit-box-orient: vertical;\n");
      out.write("	overflow: hidden;\n");
      out.write("	text-overflow: ellipsis;\n");
      out.write("	line-height: 18px;\n");
      out.write("	height: 54px;\n");
      out.write("	text-decoration: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".bookDetail {\n");
      out.write("	width: 1260px;\n");
      out.write("	margin: 0 auto;\n");
      out.write("	display: flex;\n");
      out.write("	flex-direction: column;\n");
      out.write("	align-items: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".title {\n");
      out.write("	margin: 0 auto;\n");
      out.write("	width: 1260px;\n");
      out.write("	height: 100px;\n");
      out.write("	font-size: 40px;\n");
      out.write("	text-align: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".seoji, .infoEtc {\n");
      out.write("	width: 300px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".infoEtc {\n");
      out.write("	    padding: 136px 0px;\n");
      out.write("    text-align: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".seoji {\n");
      out.write("	text-align: center;\n");
      out.write("	margin: 85px auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".intro {\n");
      out.write("	width: 600px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".detail {\n");
      out.write("	width: 1000px;\n");
      out.write("	margin: 30px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".review {\n");
      out.write("	\n");
      out.write("}\n");
      out.write("\n");
      out.write(".detailViewBox {\n");
      out.write("	display: flex;\n");
      out.write("	width: 1000px;\n");
      out.write("	justify-content: space-between;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".arrow {\n");
      out.write("	display: flex;\n");
      out.write("	flex-direction: column;\n");
      out.write("}\n");
      out.write("\n");
      out.write("img.upArrow, img.downArrow {\n");
      out.write("	width: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".qty {\n");
      out.write("	display: flex;\n");
      out.write("	flex-direction: row;\n");
      out.write("	justify-content: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".qty > input {\n");
      out.write("	height: 20px;\n");
      out.write("	width: 40px;\n");
      out.write("	margin: 15px 7px;\n");
      out.write("	text-align: right;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".qty > span {\n");
      out.write("	margin: 13px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("hr {\n");
      out.write("	width: 1260px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#rightBoxHr {\n");
      out.write("	width: 300px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".book_img {\n");
      out.write("	width: 400px;\n");
      out.write("	height: 450px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("textarea#reviewContents {\n");
      out.write("	width: 1000px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button#revPostBtn:hover {\n");
      out.write("	background-color: #80808042;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button#revPostBtn {\n");
      out.write("	border-radius: 8px;\n");
      out.write("	background-color: white;\n");
      out.write("	border: 1px solid gray;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#cmtListArea {\n");
      out.write("	margin-bottom: 40px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#writer {\n");
      out.write("	font-size: 35px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#rightBoxHr {\n");
      out.write("	width: 285px;\n");
      out.write("	margin: 20px auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write("span#price {\n");
      out.write("	font-size: 45px;\n");
      out.write("}\n");
      out.write(".bcc{\n");
      out.write("   border-style: groove;\n");
      out.write("   width: 80px;\n");
      out.write("   height: 40px;\n");
      out.write("   line-height:40px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".susu{\n");
      out.write("   margin-right: 20px;\n");
      out.write("   margin-top: 20px;\n");
      out.write("}\n");
      out.write(".btnBox {\n");
      out.write("    float: right;\n");
      out.write("    padding-right: 5px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layout/header.jsp", out, false);
      out.write("\n");
      out.write("	<div class=\"bookDetail\">\n");
      out.write("		<div class=\"title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\n");
      out.write("			<div class=\"detailViewBox\">\n");
      out.write("				<div class=\"infoEtc\">\n");
      out.write("					<span id=\"writer\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_writer}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span><br> <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_publisher}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("					<spna>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</spna>\n");
      out.write("				</div>\n");
      out.write("				<div class=\"pyoji\">\n");
      out.write("					<img class=\"book_img\" src=\"/upload/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:replace(fList[0].save_dir,'\\\\','/')}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, _jspx_fnmap_0));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fList[0].uuid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('_');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fList[0].file_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" alt=\"bookThumbnail\">\n");
      out.write("					");
      out.write("\n");
      out.write("				</div>\n");
      out.write("				<div class=\"seoji\">\n");
      out.write("					");
      out.write("\n");
      out.write("					<span id=\"price\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("원</span>\n");
      out.write("					<hr id=\"rightBoxHr\">\n");
      out.write("					<div class=\"qty\">\n");
      out.write("						<!-- <span>수량</span>\n");
      out.write("						 <input type=\"number\" name=\"book_count\" min=\"1\" value=\"1\">\n");
      out.write("						  <div id=\"book_cnt\">1</div>\n");
      out.write("						<div class=\"arrow\">\n");
      out.write("							<a href=\"#\"><img type=\"button\" onclick='count(\"plus\")' src=\"/resources/img/upArrow.png\" class=\"upArrow\" alt=\"upArrow\"></a> \n");
      out.write("							<a href=\"#\"><img type=\"button\" onclick='count(\"minus\")' src=\"/resources/img/downArrow.png\" class=\"downArrow\" alt=\"downArrow\"></a><br> <br>\n");
      out.write("							\n");
      out.write("						</div> -->\n");
      out.write("						 <div class=\"susu\">수량</div>\n");
      out.write("                    <span class=\"bcc\" id=\"book_cnt\">1</span>\n");
      out.write("                  <div class=\"arrow\">\n");
      out.write("                     <img onclick='count(\"plus\")' src=\"/resources/img/upArrow.png\" class=\"upArrow\" alt=\"upArrow\" style=\"width: 35px\">\n");
      out.write("                     <img onclick='count(\"minus\")' src=\"/resources/img/downArrow.png\" class=\"downArrow\" alt=\"downArrow\" style=\"width: 35px\"><br> <br>\n");
      out.write("                  </div>\n");
      out.write("					</div>\n");
      out.write("					\n");
      out.write("					<input type=\"hidden\" id=\"mem_num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ses.mem_num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("					<input type=\"hidden\" id=\"book_num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("					<div class=\"btnBox\">\n");
      out.write("					<!-- 	<button type=\"button\" class=\"btn btn-secondary\">장바구니 담기</button>\n");
      out.write("						<button type=\"button\" class=\"btn btn-success\">바로구매</button> -->\n");
      out.write("						<!-- 로그인이 되었을때 -->\n");
      out.write("            ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("			\n");
      out.write("			");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("			<!-- 로그인 되지 않았을때 -->\n");
      out.write("			");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("			\n");
      out.write("			");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("					\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("\n");
      out.write("					<input type=\"hidden\" id=\"book_inventory\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("		<br>\n");
      out.write("\n");
      out.write("\n");
      out.write("		<hr>\n");
      out.write("\n");
      out.write("		<div class=\"detail\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("		<div class=\"review\">\n");
      out.write("			<form class=\"mb-3\" name=\"myform\" id=\"myform\" method=\"post\">\n");
      out.write("				<fieldset>\n");
      out.write("					<span class=\"text-bold\">별점을 선택해주세요</span> <input type=\"radio\" name=\"review_rating\" value=\"5\" id=\"rate1\"> <label for=\"rate1\">★</label> <input type=\"radio\" name=\"review_rating\" value=\"4\" id=\"rate2\"> <label for=\"rate2\">★</label> <input type=\"radio\" name=\"review_rating\" value=\"3\" id=\"rate3\"> <label for=\"rate3\">★</label> <input type=\"radio\" name=\"review_rating\" value=\"2\" id=\"rate4\"> <label for=\"rate4\">★</label> <input type=\"radio\" name=\"review_rating\" value=\"1\" id=\"rate5\"> <label for=\"rate5\">★</label>\n");
      out.write("				</fieldset>\n");
      out.write("				<div class=\"reviewBox\">\n");
      out.write("					<span class=\"input-group-text\" id=\"revWriter\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ses.mem_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("					<textarea class=\"col-auto form-control\" name=\"review_content\" id=\"reviewContents\" placeholder=\"좋은 감상평을 남겨주시면 저자에게 큰 힘이 됩니다!\"></textarea>\n");
      out.write("					<br> <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${review_mem_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("					<span class=\"btnBox\">\n");
      out.write("					<button type=\"button\" id=\"revPostBtn\" name=\"revPostBtn\">리뷰등록</button></span>\n");
      out.write("				</div>\n");
      out.write("			</form>\n");
      out.write("			<div id=\"cmtListArea\"></div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	\n");
      out.write("	<script type=\"text/javascript\">\n");
      out.write("		const revVal = '");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("';\n");
      out.write("		console.log(revVal);\n");
      out.write("	</script>\n");
      out.write("	<script type=\"text/javascript\" src=\"/resources/js/reviewComment.js\"></script>\n");
      out.write("	<script type=\"text/javascript\" src=\"/resources/js/bookDetailCnt.js\"></script>\n");
      out.write("	<script type=\"text/javascript\">\n");
      out.write("		getReviewList(revVal);\n");
      out.write("	</script>\n");
      out.write("\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../layout/footer.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/book/bookDetailView.jsp(203,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ses.mem_id !=null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("			<button type=\"button\" class=\"btn btn-secondary\" id=\"Cart_btn\" >장바구니</button>\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/book/bookDetailView.jsp(207,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ses.mem_id != null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("			<button type=\"button\" class=\"btn btn-success\" id=\"Purchase_btn\" >바로구매</button>\n");
          out.write("				\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /WEB-INF/views/book/bookDetailView.jsp(212,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ses.mem_id == null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("					<button type=\"button\" class=\"btn btn-secondary\">\n");
          out.write("					<a href=\"/mem/loginPage\" onclick=\"gologin(event)\" style=\"color: white;\">장바구니</a></button>\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent(null);
      // /WEB-INF/views/book/bookDetailView.jsp(217,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ses.mem_id == null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("			<button type=\"button\" class=\"btn btn-success\">\n");
          out.write("					<a href=\"/mem/loginPage\" onclick=\"gologin(event)\" style=\"color: white;\">바로구매</a>\n");
          out.write("					</button>\n");
          out.write("			");
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f0_reused = false;
    try {
      _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f0.setParent(null);
      // /WEB-INF/views/book/bookDetailView.jsp(252,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bvo.book_num }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
      if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      _jspx_th_c_005fout_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f0_reused);
    }
    return false;
  }
}
