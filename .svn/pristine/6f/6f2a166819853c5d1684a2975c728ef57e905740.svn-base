<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登录</title>
		<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript">
			var flag = true;
			function checkUsername(){
				var username = $("#username").val();
				if(username==''){
					flag=false;
					return;
				}
				$.post("/iWeb/servlet/CheckUsername",
						{username:username,r:new Date()},
						function(data){//data是服务端回传的数据其格式取决于第四个参数json/text/html/xml
							if(data.result){
								flag = true;
								$("#checkInfo").text('');//更改选择到的元素的文本值
							}else{
								flag = false;
								$("#checkInfo").text('用户名不可用');
							}
						},
						'json'
				);	
			}

			function checkSubmit(){
				checkUsername();
				return flag;
			}

			$(function(){
				$("#username").blur(function(){//绑定blur事件
					checkUsername();
				});
				$("form").submit(function(){//绑定提交事件
					return checkSubmit();
				});
			});
		</script>
	</head>
	<body>
		<form name="register" method="post" action="/iWeb/ijdbc/select.jsp">
			用户名：<input type="text" id="username" name="username">
			<span style="color: red" id="checkInfo"></span>
			<br>
			密码：&nbsp;&nbsp;<input type="password" name="password"><br>
			<input type="submit" value="提交">
		</form>
	</body>
</html>