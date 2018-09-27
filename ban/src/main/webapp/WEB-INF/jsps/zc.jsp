<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
 
<script type="text/javascript">
		/* trim是消除空格 */
		/* function后面跟的id是onblur里的 */
		/* document里的id是labl里的id */
		/* .submit()就是提交，死方法 */
		function checkName() {
			var name=document.getElementById("username").value.trim();
			if(name.length==0)
			{
				document.getElementById("uName").style.display="";
				document.getElementById("uName").innerHTML="NO NULL";
				return false;
			}
			else
			{
				document.getElementById("uName").style.display="none";
				return true;
			}
		}
		function checkPassWord() {
			var name=document.getElementById("password").value.trim();
			if(name.length==0)
			{
				document.getElementById("uPass").style.display="";
				document.getElementById("uPass").innerHTML="NO NULL";
				return false;
			}
			else
			{
				document.getElementById("uPass").style.display="none";
				return true;
			}
		}
		//这里的id是根据form表单最外围的那个id来的
		function chankSubmit() {
			if(checkName() && checkPassWord()){
			document.getElementById("inputForm").submit();
			}
		}
	</script>
</head>
<body>
	 <div style="text-align: center;">
		<form id="inputForm" action="${pageContext.request.contextPath}/user/zc" method="post">
		<!-- onblur事件失去焦点时触发 -->	
		<!-- display 属性规定元素应该生成的框的类型 none为其中的一个属性 -->	
		<!-- label是个标签，一般跟着input使用 -->
				<div>
				<span>用户账号：</span><input id="username" name="username" type="text"  onblur="checkName();" />
				<label id="uName"  style="display:none"></label>
				</div>
				<br>
				<div class="text" style="text-align: center;">
					<span>用户密码：</span><input id="password" name="password" type="text" onblur="checkPassWord();" />
					<label id="uPass"  style="display:none"></label>
				</div> 
				<br/>
				<div class="text" style="text-align: center;">
					<input type="button" value="注册" onclick="chankSubmit();">
					<input type="button" value="返回" onclick="javascript:history.go(-1);"/><!-- 返回上一页面 -->
				</div><br/>
				
		</form>
	</div>

</body>
</html>