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
    
    <title>My JSP 'booklist.jsp' starting page</title>
    
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
  <form action="bookif.action" method="post">
  <%!
  	private int i=0;
  	private String h;
  	//private String h;
  	%>
    <h1>查询结果</h1>
    <table border=1>
    <tr><th>作者ID</th><th>书名</th></tr>
   <c:forEach var="book" items="${booklist}">
    
    	
   		<% i++;
   		//out.print(i);
  		h=Integer.toString(i);	
   		%>
     <tr><td><a href="authorif.action?">${book.authorID}</a></td> 
    <td><a href="bookif.action?h=<%= h %>">${book.title}</a></td></tr>
    
     
    </c:forEach>
    <%
      i=0;
      h=Integer.toString(i);
     %>
    </table>
	</form>
  </body>
</html>
