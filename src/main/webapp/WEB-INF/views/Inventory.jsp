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
<%!int clicks = 0;%>

<title>存貨管理</title>
</head>
<body>
	<%@include file="navbar.jspf"%>
	<div class="container theme-showcase" role="main">

		<div class="jumbotron" style="background-color: #93D0F1">
			<h1>存貨管理系統</h1>
			<a class="btn btn-info" href="Firm">廠商管理系統</a>
		</div>
		<div class="container">
			<div class="row">
				<br>
				<div class="col-md-12">
					<a class="btn btn-primary" href="insertInventory">新增</a>
					<table class="table">
						<tr>
							<th>存貨編號</th>
							<th>廠商編號</th>
							<th>存貨名稱</th>
							<th>庫存量</th>
							<th>成本</th>
							<th>-?</th>
							<th>本月成本</th>
							<th>
								
								<%-- <a class="btn btn-default"href="modifyInventory?inventory_id=${inventory.inventory_id}">修改</a> --%>
							</th>
						</tr>
						<c:forEach items="${inventoryList}" var="inventory">
							<tr>
								<td>${inventory.inventory_id}</td>
								<td>${inventory.firm_id}</td>
								<td>${inventory.inventory_name}</td>
								<td>${inventory.quantity}</td>
								<td>${inventory.price}</td>
								<td>${inventory.count}
									
									<a class="btn btn-sm btn-info clearUseBtn" href="#"data-toggle="modal" data-target="#clearUseModal"data-id="${inventory.inventory_id}">清除</a>
								</td>
								<td>${inventory.count*inventory.price}</td>
								<td><a class="btn btn-default"
									href="modifyInventory?inventory_id=${inventory.inventory_id}">修改</a>
									
									<%-- <a class="btn btn-warning" href="minusInventory?inventory_id=${inventory.inventory_id}">-1</a> --%>



									<c:if test="${inventory.quantity < 0}">
										<button class="btn btn-sm btn-warning minusBtn" onclick="myFunction()">-1</button>
									</c:if> 
									<c:if test="${inventory.quantity > 0}">
										<a class="btn btn-sm btn-warning minusBtn" href="#"data-toggle="modal" data-target="#minusModal"data-id="${inventory.inventory_id}">-1</a>
										
					  				</c:if> 
					  				<a class="btn btn-sm btn-success plusBtn" href="#"data-toggle="modal" data-target="#plusModal"data-id="${inventory.inventory_id}">+10</a> 
					  				<a class="btn btn-sm btn-danger deleteBtn" href="#"data-toggle="modal" data-target="#deleteModal"data-id="${inventory.inventory_id}">刪除</a></td>
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
						<form id="deleteForm" action="deleteInventory" method="post">
							<input type="hidden" name="inventory_id" id="deleteID">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-danger">確認刪除</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-sm" id="minusModal"tabindex="-1" role="dialog" aria-labelledby="myModalLabel"aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">-1</h4>
					</div>
					<div class="modal-body">
						<p>確認-1後，相關之訊息也將真的減一</p>
					</div>
					<div class="modal-footer">
						<form id="minusForm" action="minusInventory" method="post">
							<input type="hidden" name="inventory_id" id="minusID">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-warning">確認-1</button>
						</form>
						<form id="useForm" action="useInventory" method="post">
							<input type="hidden" name="inventory_id" id="useID">
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-sm" id="plusModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">-1</h4>
					</div>
					<div class="modal-body">
						<p>確認+10後，相關之訊息也將真的加十</p>
					</div>
					<div class="modal-footer">
						<form id="plusForm" action="plusInventory" method="post">
							<input type="hidden" name="inventory_id" id="plusID">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-success">確認+10</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade bs-example-modal-sm" id="clearUseModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">-1</h4>
					</div>
					<div class="modal-body">
						<p>確認清除後，相關之訊息也將清除</p>
					</div>
					<div class="modal-footer">
						<form id="clearUseForm" action="clearUse" method="post">
							<input type="hidden" name="inventory_id" id="clearUseID">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-info">確認清除</button>
						</form>
					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
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
		$(function() {

			$(".minusBtn").click(function() {
				//alert($(this).attr("data-id"));
				$("#minusID").val($(this).attr("data-id"));
			});
		});
		$(function() {
			$(".plusBtn").click(function() {
				//alert($(this).attr("data-id"));
				$("#plusID").val($(this).attr("data-id"));
			});
		});
		$(function() {
			$(".clearUseBtn").click(function() {
				//alert($(this).attr("data-id"));
				$("#clearUseID").val($(this).attr("data-id"));
			});
		});
		
		function myFunction() {
			alert("Hello! 不能小於0!");
		}
	</script>


</body>
</html>
