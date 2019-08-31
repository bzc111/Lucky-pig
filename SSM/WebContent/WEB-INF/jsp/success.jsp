<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String patd = request.getContextPath();
String basePatd = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+patd+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePatd%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success.jsp</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("input:button").on("click",function(){
			$.ajax({
			   type: "POST",
			   url: "user/getAll",
			   dataType: "json",
			   success: function(data){
				   $("tbody").empty();
				   $.each(data,function(){
					   var note = "<tr><td>"+this.id+"</td><td>"+this.name+"</td><td>"+this.age+"</td><td>"+this.dob+"</td></tr>";
					   $("tbody").append(note);
				   });
				   $("tbody tr").hide().fadeIn(2000);
			   }
			});
		});
		
	});
</script>

<style type="text/css">
	td{
		border:1px solid red;
		width: 100px;
		height: 40px;
		text-align: center;
	}
</style>

</head>
<body>
	
	<h1>success!${msg }</h1>
	<input type="button" value="查看所有用户">
	<table>
		<thead>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>age</td>
				<td>dob</td>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	
	
</body>
</html>