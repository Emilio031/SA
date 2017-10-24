<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        
    
	<title>Insert Employee</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
	<div class="container theme-showcase" role="main">
    
      <div class="jumbotron" style="background-color:#93D0F1">  
        <h1>員工管理系統</h1>
       
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" action="insertEmployee" id="insertForm">
					
					<!-- <div class="form-group">
						<label>編號</label>
						<input type="number" name="employee_id" placeholder="輸入" required>
						<p class="help-block">員工編號</p>
					</div> -->
					
					<div class="form-group">
						<label>名稱</label>
						<input type="text" name="employee_name" placeholder="輸入姓名" required>
						<p class="help-block">員工姓名</p>
					</div>
					<div class="form-group">
						<label>職稱</label>
						
						<select class="form-control" name="employee_position">
							<option value="店長" ${product.category==1?'selected':''}>店長</option>
							<option value="店員" ${product.category==2?'selected':''}>店員</option>
						</select>
						<p class="help-block">員工職位</p>
					</div>
					<div class="form-group">
						<label>電話</label>
						<input type="text" name="employee_tel" placeholder="員工手機" required>
						<p class="help-block">員工手機</p>
					</div>
			  		<button type="submit" class="btn btn-default">新增</button>
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