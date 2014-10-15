<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookinf.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action=deldata.action method="post">
 <%!
    private String hh;
    private int j=1;
    private String hhh;
  %>
  <%
      hh=request.getParameter("h");
      //out.print(hh);
  
   %>
   <table border=1>
   <tr><th>ISBN</th><th>Title</th><th>Publisher</th><th>PublishDate</th><th>Price</th></tr>
  <c:forEach var="abook" items="${abooklist}">
    
   <tr><td>${abook.isbn }</td>
   <td>${abook.title }</td>
   
   
   <td>${abook.publish}</td>
   <td>${abook.date }</td>
   <td>${abook.price}</td>
   </tr>
     

    
    </c:forEach>
	<s:submit value="删除" action="deldata"></s:submit>
	</table>
    </form>
  </body>
</html>
