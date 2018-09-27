<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.10.2/jquery-1.10.2.js"></script>
<script type="text/javascript">
			function delqq(id){
				alert(id);
				$.ajax({ 
					type:"POST",
					url:"<%=basePath%>user/bookDelete", 
					datatype:"json",
					data:{"id":id},
					success: function(data){
						alert(data);
				        if("success" == data){
				        	alert("删除");
				        	window.location.href="${pageContext.request.contextPath}/user/welcomePage";
				        }
					},
					error: function(){
		                alert("服务器异常");
		            } 
				});
			}
</script>
</head>

<body>
<div class="text" style=" text-align:center;">
<!-- style=" cursor: pointer; "是鼠标点击事件 -->
	<img  src="${pageContext.request.contextPath}/static/image/timg.jpg"  style=" cursor: pointer; ">
	<br/>	
	<table align="center" valign="center" border="1px">
		<tr>
			<td>序号</td>
			<td>书名</td>
			<td>作者</td>
			<td>出版社</td>
			<td>出版日期</td>
			<td>页数</td>
			<td>价格</td>
			<td>操作</td>
			<td>操作</td>
		</tr>

<!-- 要跟controller里的名字相对应   依次取出列表中的值赋给item -->		
	<c:forEach begin="0" step="1" items="${bookList}" var="list" varStatus="bookList"> 
			<tr>
            	<td>${bookList.count}</td>
            	<td>${list.name}</td>
            	<td>${list.author}</td>
            	<td>${list.publish}</td>
           	    <td>${list.publishdate}</td>
           	    <td>${list.page}</td>
           	    <td>${list.price}</td>
			    <td><a href="<%=basePath%>user/bookUpdate?id=${list.id}">修改 &nbsp</td>
			    <%-- <td><a href="javascript:void(0);" onclick="delbb(${list.id})" title="删除">删除</a></td> --%>
			    <td><input type="button" value="删除" onclick="delqq(${list.id});"/></td>
			 </tr>	
		</c:forEach>
		
		</table>
        <p>一共${page.pages}页</p>
        <a href="welcomePage?page=${page.firstPage}">第一页</a>
        <a href="welcomePage?page=${page.prePage}">上一页</a>
        <a href="welcomePage?page=${page.nextPage}">下一页</a>
        <a href="welcomePage?page=${page.lastPage}">最后页</a>
		
		<tr>
				<td align="left">
					<button><a href="${pageContext.request.contextPath}/book/add">增加图书</a></button>
		     	</td>
		
			<form action="${pageContext.request.contextPath}/book/MHchaxun" method="get">  
				请输入要查询的书名：<input type="text" name="chazhao" placeholder="请输入要查询的图书的关键" required><input type="submit" value="确认">
			</form>	
		</tr>	
	</table>		
			<form action="${pageContext.request.contextPath}/file/fileupload.do" method="post" enctype="multipart/form-data">  
	       		 选择图片:<input type="file" name="file" width="120px" required>  
	        	 <input type="submit" value="确定">
	        </form> 
	        <hr>
		     <form action="${pageContext.request.contextPath}/file/upload.do" method="post" >
				<input type="submit" value="图片下载列表"> 
			 </form>
		     
	       </div>     
</body>
</html>