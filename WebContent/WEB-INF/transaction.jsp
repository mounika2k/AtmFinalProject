<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#FBFAE4   ">

<div style="text-align:center">
<table border="0" style="width: 100%">
		<tr>
		<td><h1>Make Payment</h1>
		<center>
			<sf:form method="post" action="${pageContext.request.contextPath}/index" modelAttribute="account">
			Receipient Account Number: <sf:input type="text" path="id"/><sf:errors path="id"/><br/><br/>
			Ammount to be transferred: <sf:input type="name" path="name"/><sf:errors path="name"/><br/><br/>
			
<div class="form-group"> 
<div class="col-sm-offset-2 col-sm-10">
<input type="submit"class="btn btn-success"  value="Transfer">
</div>
</div>
			
				</sf:form>
			</center>
			</td> 
			
		</tr>
		</table>
		</div>
</body>
</html>