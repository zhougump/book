<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!--格式化时间  -->
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>	
		<table border="1" align="center">	 <!-- border是边间距的意思,就是外面的那个框   align是挨近那边显示的意思 center是居中显示-->
		<c:if test="${book!=null}">
			<caption><h1>查询结果是</h1></caption>
			<tr>
			<th>书名</th><th>作者</th><th>出版社</th><th>出版日期</th><th>页数</th><th>价格</th><th>操作</th>
			</tr>
			<c:forEach var="book" items="${book}">
			<tr>
				<td>《${book.name}》</td>
				<td>${book.author}</td>
				<td>${book.publish}</td>
				<td><fmt:formatDate value="${book.publishdate}" pattern="yyyy—MM—dd"/></td>
				<td>${book.page}页</td>
				<td>${book.price}元</td>
 
				<td>
						<a href="<%=basePath%>user/bookUpdate?id=${book.id}">修改</a>	&nbsp	
 						<a href="javascript:void(0);" onclick="de(${book.id})" title="删除">删除</a>
			 	</td>
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${book==null}">没有符合的图书</c:if>
		</table>
		
			<div style="margin-top: 82px;text-align: center;">
			<input type="button" name="Sumbit" onclick="javascript:history.back(-1);" value="返回主界面">
		</div>
		
		<script type="text/javascript">
				function de(id)
				{
					if(confirm("确定删除?"))
					{
						window.location.href="<%=basePath%>user/bookDelete?id="+id;
						/* alert("删除成功。") */
					}
					else
					{
						alert("不删除。");
					}					
				}
				
		</script>
		
			
</body>
</html>