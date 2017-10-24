<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        
    
	<title>Insert Attendence</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
	<div class="container theme-showcase" role="main">
    
      <div class="jumbotron" style="background-color:#93D0F1">    
        <h1>出席管理系統</h1>
        
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" action="insertAttendence" id="insertForm">
					<input type="hidden" name="employee_id" value="${attendence.employee_id}">
					<div class="form-group">
					<%
						out.print("您好, ");
						
						//String id = (String) session.getAttribute("sid");
						//out.print(id);
					%>
					${session}
					<% 
					out.print("號員工 ");
					
					
					%>
					<br>
						
						<label>日期</label>
						
						<p type="date" name="date" ></p>
						<!-- <input type="date" name="date" value="ft" required> -->
						<% 
 						 Date dNow = new Date( );
 						 SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
 						 out.print(ft.format(dNow));
 						 
 						%>
						
					</div>
					<div class="form-group">
						<label>時間</label>
						<p type="time" name="arrivaltime"></p>
						<!-- <input type="time" name="arrivaltime" placeholder="輸入姓名" required> -->
						<%
							SimpleDateFormat ft2 =  new SimpleDateFormat ("HH:mm:ss");
							out.print(ft2.format(dNow));
						%>
						
					</div>
					
			  		<button type="submit" class="btn btn-default">上班</button>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</div><!-- /.container -->
	    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
    <script src="<c:url value="/resources/js/jsadditional-methods.js" />"></script>
    <script src="<c:url value="/resources/js/messages_zh_TW.js" />"></script>

	<script>
	$("#insertForm").validate();
	</script>
</body>
</html>