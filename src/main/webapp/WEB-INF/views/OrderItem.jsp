<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
    
    <title>訂單產品管理</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" style="background-color:#93D0F1">
        <h1>詳細訂單產品管理系統</h1>
     	 <a class="btn btn-info" href="Order">訂單管理系統</a>
         <a class="btn btn-info" href="OrderItem">詳細訂單管理系統</a>
   		 <a class="btn btn-info" href="Product">產品管理系統</a>
      </div>
      
      	 查詢第<form id="searchForm" action="searchOrderItem" method="post">
     	 	<input type="number" name="order_id">
     	 	<br>筆訂單
     		<input type="submit">
     	 
      	</form> 
     
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-12">
	  			<a class="btn btn-primary" href="insertOrderItem">新增</a>
				<table class="table">
				  	<tr>
				  		<th>訂單編號</th>
				  		<th>產品編號</th>
				  		<th>第幾杯</th>
				  		<th>冰塊</th>
				  		<th>甜度</th>
				  		
				  	</tr>
				  	<c:forEach items="${orderItemList}" var="orderItem">
					  	<tr>
					  		<td>${orderItem.order_id}</td>
					  		<td>${orderItem.product_id}</td>
					  		<td>${orderItem.item_id}</td>
					  		<td>${orderItem.ice}</td>
					  		<td>${orderItem.sugar}</td>
					  		<td>
					  			<a class="btn btn-default" href="modifyOrderItem?id=${orderItem.order_id}">修改</a>
					  			<a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${orderItem.order_id}">刪除</a>
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
	                <form id="deleteForm" action="deleteProduct" method="post">
	            		<input type="hidden" name="id" id="deleteID">
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
