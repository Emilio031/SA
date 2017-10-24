<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
    
    <title>產品管理</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" >    
        <h1>找茶🍵</h1>
        <p class="lead">xd</p>
 
      </div>
      <form action="j_spring_security_check" method="post" role="form">
			<div class="form-group">
			<label>帳號:</label>
			<input type="text" name="j_username">
			<p class="help-block">使用者帳號</p>
			</div>
			<div class="form-group">
			<label>密碼:</label>
			<input type="password" name="j_password">
			<p class="help-block">使用者密碼</p>
			</div>
	  		<button type="submit" class="btn btn-default">登入</button>
	  		<label class="label label-warning">${message}</label>
		</form>


    </div><!-- /.container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>


</body>
</html>