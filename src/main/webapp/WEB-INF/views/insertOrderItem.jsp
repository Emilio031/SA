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
        
    
	<title>Insert OrderItem</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
	<div class="container theme-showcase" role="main">
    
      <div class="jumbotron" style="background-color:#93D0F1">   
        <h1>訂單內容管理系統</h1>
        
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" action="insertOrderItem" id="insertForm">
					<input type="hidden" name="order_id" value="${orderItem.order_id}">
					
					<div class="form-group">
						<label>產品編號</label>
						 <input type="number" name="product_id" placeholder="輸入產品編號" required> 
						 
						<%-- <select class="form-control" name="product_id">
							<c:forEach items="${productList}" var="productItem">
									<option value="${product.product_id}" >${product.product_id}</option>
									
							</c:forEach>
							</select> --%>
						<p class="help-block">產品編號</p>
					</div>
					
					<div class="form-group">
						<label>冰塊:</label>
						<select class="form-control" name="ice">
							<option value="100%" ${orderItem.ice==正常?'selected':''}>100%</option>
							<option value="70%" ${orderItem.ice==少冰?'selected':''}>70%</option>
							<option value="0%" ${orderItem.ice==去冰?'selected':''}>0%</option>
							<option value="hot" ${orderItem.ice==熱?'selected':''}>hot</option>
						</select>
					</div>
					<div class="form-group">
						<label>甜度:</label>
						<select class="form-control" name="sugar">
							<option value="100%" ${orderItem.sugar==正常?'selected':''}>100%</option>
							<option value="70%" ${orderItem.sugar==少糖?'selected':''}>70%</option>
							<option value="50%" ${orderItem.sugar==半糖?'selected':''}>50%</option>
							<option value="30%" ${orderItem.sugar==微糖?'selected':''}>30%</option>
							<option value="0%" ${orderItem.sugar==無糖?'selected':''}>0%</option>
						</select>
					</div>
					
					
					
			  		<button type="submit" class="btn btn-default">確定</button>
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