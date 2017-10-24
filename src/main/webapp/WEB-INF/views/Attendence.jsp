<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.*,java.text.*,java.time.*" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
    	
    <title>到班狀況管理</title>
</head>
<body>
	<%@include file="navbar.jspf" %>
    <div class="container theme-showcase" role="main">
    
      <div class="jumbotron" style="background-color:#93D0F1">
        <h1>到班狀況管理系統</h1>
        <a class="btn btn-info" href="Employee">員工管理系統</a>
        <a class="btn btn-info" href="Attendence">到班狀況系統</a> 
		<a class="btn btn-info" href="Salaries">薪資管理系統</a>
        
      </div>
      
      查詢員工編號<form id="searchForm" action="searchAttendence" method="post">
     	 <input type="number" name="employee_id">
     	 <input type="submit">
     	 
      </form>
      
      
	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-12">
	  			<!-- <a class="btn btn-primary" href="insertAttendence">新增</a> -->
				<table class="table">
				  	<tr>
				  		<th>員工編號</th>
				  		<th>日期</th>
				  		<th>上班時間</th>
				  		<th>下班時間</th>
				  		<th>時數</th>
				  		
				  	</tr>
				  	<c:forEach items="${attendenceList}" var="attendence">
					  	<tr>
					  		<td>${attendence.employee_id}</td>
					  		<td>${attendence.date}</td>
					  		<td>${attendence.arrivaltime}</td>
					  		<td>${attendence.leavetime}</td>
					  		<td>${attendence.diff}</td> 
					  		
					  		<%-- <td>${attendence.leavetime-attendence.arrivaltime}</td> --%>
					  		
					  		<td>
					  			<a class="btn btn-sm btn-danger deleteBtn" href="#" data-toggle="modal" data-target="#deleteModal" data-id="${attendence.employee_id}">刪除</a>
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
	                <form id="deleteForm" action="deleteAttendence" method="post">
	            		<input type="hidden" name="employee_id" id="deleteID">
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
