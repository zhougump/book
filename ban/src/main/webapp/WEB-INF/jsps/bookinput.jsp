<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>增加页面</title>

<style type="text/css">
	.error
		{
			background-color: yellow;
			font-family:  "楷体";
			color: green;
			font-size: 28px;
		}
</style>
		
		<script type="text/javascript">
			function bname() {
				var name=document.getElementById("Name").value.trim();
				if(name.length==0)
				{
					document.getElementById("Bname").style.display="";
					document.getElementById("Bname").innerHTML="No null";
					return false;
				}
				else
				{
					document.getElementById("Bname").style.display="none";
					return true;
				}
			}
			
			function bauthor() {
				var name=document.getElementById("Author").value.trim();
				if(name.length==0)
				{
					document.getElementById("Bauthor").style.display="";
					document.getElementById("Bauthor").innerHTML="No null";
					return false;
				}
				else
				{
					document.getElementById("Bauthor").style.display="none";
					return true;
				}
			}
			
			function bpublish() {
				var name=document.getElementById("Publish").value.trim();
				if(name.length==0)
				{
					document.getElementById("Bpublish").style.display="";
					document.getElementById("Bpublish").innerHTML="No null";
					return false;
				}
				else
				{
					document.getElementById("Bpublish").style.display="none";
					return true;
				}
			}
			
			function bpage() {
				var name=document.getElementById("Page").value.trim();
				if(name.length==0)
				{
					document.getElementById("Bpage").style.display="";
					document.getElementById("Bpage").innerHTML="No null";
					return false;
				}
				else
				{
					document.getElementById("Bpage").style.display="none";
					return true;
				}
			}
			
			function bprice() {
				var name=document.getElementById("Price").value.trim();
				if(name.length==0)
				{
					document.getElementById("Bprice").style.display="";
					document.getElementById("Bprice").innerHTML="No null";
					return false;
				}
				else
				{
					document.getElementById("Bprice").style.display="none";
					return true;
				}
			}
			
			function chankSubmit() {
				if(bname() && bauthor() && bpublish() && bpage() && bprice()){
				document.getElementById("inputForm").submit();
				}
			}
		</script>
		
	</head>
<body>
<div class="text" style="text-align: center;">
<h3>增加图书</h3>
	<div class="text" style="text-align: center;">
		<form id="inputForm" action="${pageContext.request.contextPath}/user/bookinput" method="get" name="myform" onsubmit="return add()" enctype="multipart/form-data">
			<div class="text" style="text-align: center;">
				<span>图书名:</span><input id="Name" name="name" type="text" onblur="bname();" placeholder="请输入图书名">
				<label id="Bname"  class="error" style="display: none"></label>
			</div>
			<div class="text" style="text-align: center;">
				<span>作者：</span><input id="Author" name="author" type="text" onblur="bauthor();" placeholder="请输入作者姓名">
				<label id="Bauthor" class="error" style="display: none"></label>
			</div>
			<div class="text" style="text-align: center;">
				<span>出版社信息：</span><input id="Publish" name="publish" type="text" onblur="bpublish();" placeholder="请输入出版社信息">
				<label id="Bpublish" class="error" style="display: none"></label>
			</div>
			<div class="text" style="text-align: center;">
				出版日期：<input type="date" name="publishdate">
			</div>
			<div class="text" style="text-align: center;">
				<span>页数：</span><input id="Page" name="page" type="text" onblur="bpage();" placeholder="请输入页数">
				<label id="Bpage"  class="error" style="display: none"></label>
			</div>
			<div class="text" style="text-align: center;">
				<span>价格：</span><input id="Price" name="price" type="text" onblur="bprice();" placeholder="请输入价格">
				<label id="Bprice" class="error" style="display: none"></label>
			</div>
			<div class="text" style="text-align: center;">
					<input type="button" value="添加" onclick="chankSubmit();">
					&nbsp&nbsp
			<input type="button" value="返回" onclick="javascript:history.go(-1);"/><!-- 返回上一页面 -->
		</form>
	</div>
</div>	
</body>
</html>