<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>s
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
	<title>Modify Employee</title>
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
				<form method="post" action="modifyEmployee" id="updateForm">
					<div class="form-group">
					<input type="hidden" name="employee_id" value="${employee.employee_id}">
					</div>
					<div class="form-group">
						<label>描述:</label>
						<input type="text" name="employee_name" placeholder="輸入員工名稱" value="${employee.employee_name}"required>
						<p class="help-block">員工姓名</p>
					</div>
					<div class="form-group">
						<label>職位:</label>
						<select class="form-control" name="employee_position">
							<option value="店長" ${employee.employee_position=="店長"?'selected':''}>店長</option>
							<option value="店員" ${employee.employee_position=="店員"?'selected':''}>店員</option>
						</select>
					</div>
					<div class="form-group">
						<label>電話:</label>
						<input type="text" name="employee_tel" placeholder="輸入員工電話" value="${employee.employee_tel}" required>
						<p class="help-block">員工聯絡方式</p>
					</div>
					<button type="submit" class="btn btn-primary">修改</button>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	</div>
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/jquery.validate.js" />"></script>
    <script src="<c:url value="/resources/js/jsadditional-methods.js" />"></script>
    <script src="<c:url value="/resources/js/messages_zh_TW.js" />"></script>
	<script>
	$("#updateForm").validate();
	</script>
</body>
</html>