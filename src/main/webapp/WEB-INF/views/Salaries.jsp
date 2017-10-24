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


<title>薪資管理</title>
</head>
<body>
	<%@include file="navbar.jspf"%>
	<div class="container theme-showcase" role="main">

	<div class="jumbotron" style="background-color:#93D0F1">
			<h1>薪資管理系統</h1>
			<a class="btn btn-info" href="Employee">員工管理系統</a>
			<a class="btn btn-info" href="Attendence">到班狀況系統</a> 
			<a class="btn btn-info" href="Salaries">薪資管理系統</a>
		</div>
		<div class="container">
			<div class="row">
				<br>
				<div class="col-md-12">

					<table class="table">
						<tr>
							<th>員工編號</th>
							<th>年、月</th>
							<th>總時數</th>	
							<th>時薪</th>
							<th>薪水</th>
							
						</tr>
						<c:forEach items="${salariesList}" var="salaries">
							<tr>
								<td>${salaries.employee_id}</td>
								<td>${salaries.year_month}</td>
								<td>${salaries.diff}</td>
								
								<td>${salaries.salary_per_hour}</td>
								<td>${salaries.hours*salaries.salary_per_hour}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="modal fade bs-example-modal-sm" id="deleteModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">刪除</h4>
					</div>
					<div class="modal-body">
						<p>確認刪除後，相關之訊息也將刪除</p>
					</div>
					<div class="modal-footer">
						<form id="deleteForm" action="deleteProduct" method="post">
							<input type="hidden" name="id" id="deleteID">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
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
