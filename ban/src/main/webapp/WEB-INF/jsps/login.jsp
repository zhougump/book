<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login on</title>
</head>
<body>
		<!-- required是必填选项 -->
		<div class="text" style=" text-align:center;">
				<h1>login  on</h1>
		 	<form action="${pageContext.request.contextPath}/user/getlogin" method="post" enctype="multipart/form-data">
			用户名称:<input  type="text" name="username" id="username" required/>
			用户密码:<input  type="password" name="password" id="password" required/>
					<input type="submit" value="登录">
			</form><br/>
			<form action="${pageContext.request.contextPath}/book/zcyh" method="post" enctype="multipart/form-data">
				<input type="submit" value="注册">
			</form>
		</div>
		<br/>
		<div class="text" style=" text-align:center;">
			<button onclick="displayDate()">what time it is?</button>
		<p id="demo"></p>
		</div>
		<script>
			function displayDate()
				{
					document.getElementById("demo").innerHTML=Date();
				}
		</script>
</body>
</html>