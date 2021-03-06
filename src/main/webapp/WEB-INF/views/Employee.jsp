<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">


<title>員工管理</title>
</head>
<body>
	<%@include file="navbar.jspf"%>
	<div class="container theme-showcase" role="main">

		<div class="jumbotron" style="background-color:#93D0F1">
			<h1>員工管理系統</h1>
			<a class="btn btn-info" href="Employee">員工管理系統</a>
			<a class="btn btn-info" href="Attendence">到班狀況系統</a> 
			<a class="btn btn-info" href="Salaries">薪資管理系統</a>
			<p class="lead"></p>
		</div>
		<div class="container">
			<div class="row">
				<br>
				
					<a class="btn btn-primary" href="insertEmployee">新增</a>
					<table class="table">
						<tr>
							<th>編號</th>
							<th>姓名</th>
							<th>職位</th>
							<th>電話</th>
							

						</tr>
						<c:forEach items="${employeeList}" var="employee">
							<tr>
								<td>${employee.employee_id}</td>
								<td>${employee.employee_name}</td>
								<td>${employee.employee_position}</td>
								<td>${employee.employee_tel}</td>
								

								<td>
									<a class="btn btn-default" href="modifyEmployee?employee_id=${employee.employee_id}">修改</a> 
									<a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${employee.employee_id}">刪除</a>
									
									<a class="btn btn-success" href="insertAttendence?employee_id=${employee.employee_id}">上班</a>
									<!-- <input type="hidden" name="sessionid" value="employee_id"> -->
									<%	
										//session.setAttribute("ename",employee.employee_name);
										//session.getAttribute("ename",employee.employee_name);
										
										String id = session.getId();
										session.setAttribute("sid", id);
									%>
									<a class="btn btn-warning" href="modifyAttendence?employee_id=${employee.employee_id}">下班</a>
									<form class="btn btn-link" action="searchAttendence" method="post"style="display:inline-block">
										<input type="hidden" name="employee_id" value="${employee.employee_id}">
										<input type="submit" value="詳細"class="btn btn-info">
									</form>
									
					  		</td>
					  	</tr>
				  	</c:forEach>
				</table>
			
		</div>
	</div>
	<div class="modal fade bs-example-modal-sm" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">刪除</h4>
                </div>
                <div class="modal-body">
                    <p>確認刪除後，相關之訊息也將刪除</p>
                </div>
                <div class="modal-footer">
	                <form id="deleteForm" action="deleteEmployee" method="post">
	            		<input type="hidden" name="employee_id" id="deleteID">
	                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	                    <button type="submit" class="btn btn-danger">確認刪除</button>
						</form>
					</div>
				</div>
			</div>
		</div>


	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script>
		$(function() {
			$(".deleteBtn").click(function() {
				//alert($(this).attr("data-id"));
				$("#deleteID").val($(this).attr("data-id"));
			});
		});
	</script>


</body>
</html>
