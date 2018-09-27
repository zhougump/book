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
<title>下载页面</title>

		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.10.2/jquery-1.10.2.js"></script>
		<script type="text/javascript">
			function del(id){
				alert(id);
				$.ajax({ 
					type:"POST",
					url:"<%=basePath%>file/delete", 
					datatype:"json",
					data:{"id":id},
					success: function(data){
						alert(data);
				        if("success" == data){
				        	alert("删除");
				        	window.location.href="${pageContext.request.contextPath}/file/upload.do";
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
		<table align="center" valign="center" width="400" border="1px">
		<tr>
			<td>编号</td>
			<td>图片</td>
			<td>下载</td>
			<td>删除</td>
		</tr>

<!-- 要跟controller里的名字相对应   依次取出列表中的值赋给item -->		
	<c:forEach begin="0" step="1" items="${pictureList}" var="list" varStatus="pictureList"> 
			<tr>
            	<td>${list.id}</td>
            	<td><img src="${list.pic}" height="90"  width="150"/></td>
            	<td><form action="${pageContext.request.contextPath}/file/down.do?id=${list.id}" method="post" enctype="multipart/form-data">  
      				  <input type="submit" value="下载">  
   			     </form></td>
			 	<td><input type="button" value="删除" onclick="del(${list.id});"/></td>
			 </tr>	
		</c:forEach>		
		</table>	
        <p>一共${page.pages}页</p>
        <a href="upload.do?page=${page.firstPage}">第一页</a>
        <a href="upload.do?page=${page.prePage}">上一页</a>
        <a href="upload.do?page=${page.nextPage}">下一页</a>
        <a href="upload.do?page=${page.lastPage}">最后页</a>
        </br></br>
        <a>
        	<form action="${pageContext.request.contextPath}/user/welcomePage" method="post">
        		<input type="submit" value="返回主界面">
        	</form>
        </a>
 </div>
</body>
</html>