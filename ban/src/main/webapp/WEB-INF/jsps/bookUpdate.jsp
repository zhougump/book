<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <!--格式化时间  -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改页面</title>
	</head>
<body>
<div>
	<h3>修改图书信息</h3>
	
	 <form action="${pageContext.request.contextPath}/user/bookupd" method="get">
	       <input type="hidden" name="id" value="${bookUpdate.id}">
			图书名：<input type="text" name="name" value="${bookUpdate.name}"><br/>
			作者：<input type="text" name="author" value="${bookUpdate.author}"><br/>
			出版社：<input type="text" name="publish" value="${bookUpdate.publish}"><br/>
			 出版日期：<input type="date" name="publishdate" value="${bookUpdate.publishdate}"><br/>
			页数：<input type="text" name="page" value="${bookUpdate.page}"><br/>
			价格：<input type="text" name="price" value="${bookUpdate.price}"><br/>
			<input type="submit" value="确认" onclick="u(${bookUpdate.id})"> 
			<input type="button" value="返回" onclick="javascript:history.go(-1);"/>
			<input type="reset" name="button" id="button" value="重置">
	</form>	
</div>
</script>
</body>
</html>