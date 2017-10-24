<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
    
    <title>訂單管理</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
	
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" style="background-color:#93D0F1">
        <h1>訂單管理系統🍶</h1>
        <a class="btn btn-info" href="Order">訂單管理系統</a>
         <a class="btn btn-info" href="OrderItem">詳細訂單管理系統</a>
   		<a class="btn btn-info" href="Product">產品管理系統</a>
      </div>
	<div class="container">
	
		<div class="row">
			<br>
			<div class="col-md-12">
	  			<a class="btn btn-primary" href="insertOrder">新增</a>
				<table class="table">
				  	<tr>
				  		<th>編號</th>
				  		<th>日期</th>
				  		<th>時間</th>
				  		<th>總金額</th>
				  		<th>杯數</th>
				  		
				  	</tr>
				  	<c:forEach items="${orderList}" var="order">
					  	<tr>
					  		<td>${order.order_id}</td>
					  		<td>${order.date}</td>
					  		<td>${order.time}</td>
					  		<td>${order.price}</td>
					  		<td>${order.cups}</td>
					  		<td>
					  			<a class="btn btn-default" href="modifyOrder?order_id=${order.order_id}">修改</a>
					  			<a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${order.order_id}">刪除</a>
					  			<%-- <a class="btn btn-success" href="searchOrderItem?order_id=${order.order_id}">詳細 --%>
					  			<form action="searchOrderItem" method="post" style="display:inline-block">
									<input type="hidden" name="order_id" value="${order.order_id}">
									<input class="btn btn-success" type="submit" value="詳細">
								</form>
					  			
					  			</a>
					  			<a class="btn btn-warning" href="insertOrderItem?order_id=${order.order_id}">新增內容</a>
					  			
					  			<%-- <form action="insertOrderItem" method="post" style="display:inline-block">
									<input type="hidden" name="order_id" value="${order.order_id}">
									<input class="btn btn-warning" type="submit" value="新增內容">
								</form> --%>
					  		</td>
					  	</tr>
				  	</c:forEach>
				</table>
			</div>
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
	                <form id="deleteForm" action="deleteOrder" method="post">
	            		<input type="hidden" name="order_id" id="deleteID">
	                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	                    <button type="submit" class="btn btn-danger">確認刪除</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
	

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script>
    $(function(){
    	$(".deleteBtn").click(function(){
    		//alert($(this).attr("data-id"));
    		$("#deleteID").val($(this).attr("data-id"));
    	});
    });
    </script>


</body>
</html>
