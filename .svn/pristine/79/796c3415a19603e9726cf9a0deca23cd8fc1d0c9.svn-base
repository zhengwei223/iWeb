<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
var compUsername = function(){
	var username = $("#username").val();
	if(username==''){
		return;
	}
	
	$.post("/iWeb/servlet/CompleteUsername",
			{username:username,r:new Date()},
			function(data){
				$("#nameList").empty();//将所选的元素的子元素删掉,相当于依次调用子元素的remove方法
				var nameArray = data.list;//得到一个数组
				/* 
				var i;
				for(i=0;i<nameArray.length;i++){
					//$("#nameList").append("<p >"+nameArray[i]+"</p>");
					$("<p >"+nameArray[i]+"</p>").appendTo("#nameList").click(function(){
						$('#username').val($(this).text());//$(this)指的是触发当前函数的对象
						$("#nameList").css('display','none');
					});
				} */
				//遍历数组或者对象
				$.each(nameArray,function(i,n){
					//可以在选择的对象上多次调用不同的函数
					$("<p >"+n+"</p>").appendTo("#nameList").click(function(){
						$('#username').val(n);//$(this)指的是触发当前函数的对象
						$("#nameList").css('display','none');
					}).css('background-color','red');
				});
				$("#nameList").css('display','block');
			},
			'json'
	); 
};
</script>
</head>
<body>
用户名：<input type="text" id="username" name="username" onkeyup="compUsername()">
<div id="nameList" style="width: 200px;height: auto;/* background-color: red; */position: relative;left: 65px;top:-18px;display: none;">
	<p onclick="selectName(this.innerHTML)">Abel1</p>
</div>
</body>
</html>