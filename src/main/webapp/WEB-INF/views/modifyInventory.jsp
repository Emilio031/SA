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
    
	<title>Modify Product</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
	<div class="container theme-showcase" role="main">
    
      <div class="jumbotron" style="background-color:#93D0F1">  
        <h1>產品管理系統</h1>
      
      </div>
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form method="post" action="modifyInventory" id="updateForm">
					<input type="hidden" name="inventory_id" value="${inventory.inventory_id}">
					
<!-- will need this part later
				  	<div class="form-group">
					    <label for="articleCategory.id">分類</label>
				  		<select class="form-control" id="articleCategory.id" name="articleCategory.id">
				  		<c:forEach items="${articleCategoryList}" var="articleCategory">
					  		<option value="${articleCategory.id}" ${article.articleCategory.id==articleCategory.id?'selected':''}>
					  			${articleCategory.name}
				  			</option>
				  		</c:forEach>
						</select>
				  	</div>
-->

					<div class="form-group">
						<label>存貨名稱:</label>
						<input type="text" name="inventory_name" placeholder="輸入產品敘述" value="${inventory.inventory_name}" required>
						<p class="help-block">產品敘述</p>
					</div>
					<div class="form-group">
						<label>庫存量:</label>
						<input type="number" name="quantity" placeholder="0" value="${inventory.quantity}" required>
						<p class="help-block">目前庫存數量</p>
					</div>
					<div class="form-group">
						<label>成本:</label>
						<input type="number" name="price" placeholder="0" value="${inventory.price}" required>
						<p class="help-block">目前成本</p>
					</div>
					<button type="submit" class="btn btn-primary">修改</button>
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
	$("#updateForm").validate();
	</script>
</body>
</html>