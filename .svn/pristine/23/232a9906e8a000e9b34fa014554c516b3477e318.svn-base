<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登录</title>
		<script type="text/javascript">
			var flag = true;
			function checkUsername(){
				//1.创建XMLHttpRequest对象
				var xmlRequest = new XMLHttpRequest();
				//alert(xmlRequest);
				//2.发送请求
				var username = document.getElementById("username").value;
				if(username==''){
					flag=false;
					return;
				}
					
				//xmlRequest.open("GET", "/iWeb/servlet/CheckUsername?username="+username+"&r="+new Date(),true);
				//xmlRequest.send();
				xmlRequest.open("POST","/iWeb/servlet/CheckUsername",true); 
				xmlRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded"); 
				xmlRequest.send("username="+username+"&r="+new Date()); 
				//3.接收返回的数据,并改变页面的效果
				//服务端响应状态改变,则触发指定的函数
				xmlRequest.onreadystatechange=function(){
					if(xmlRequest.readyState==4){//如果响应状态为4,说明响应成功
						var resp = xmlRequest.responseText;//得到服务端写出的字符串//{"result":true}
						var rst = eval("("+resp+")");//转换json字符串为js对象
						if(!rst.result){
							//alert('用户名不可用');
							flag = false;
							document.getElementById("checkInfo").innerHTML='用户名不可用';
						}else{
							//alert('用户名可用');
							flag = true;
							document.getElementById("checkInfo").innerHTML='';
						}
					}
				};
			}

			function checkSubmit(){
				checkUsername();
				return flag;
			}
		</script>
	</head>
	<body>
		<form name="register" method="post" action="/iWeb/ijdbc/select.jsp" onsubmit="return checkSubmit();">
			用户名：<input type="text" id="username" name="username" onblur="checkUsername()"><span style="color: red" id="checkInfo"></span>
			<br>
			密码：&nbsp;&nbsp;<input type="password" name="password"><br>
			<input type="submit" value="提交">
		</form>
	</body>
</html>