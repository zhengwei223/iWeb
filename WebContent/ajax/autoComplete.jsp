<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var compUsername = function(){
	//1.创建XMLHttpRequest对象
	var xmlRequest = new XMLHttpRequest();
	//alert(xmlRequest);
	//2.发送请求
	var username = document.getElementById("username").value;
	if(username==''){
		return;
	}
	xmlRequest.open("POST","/iWeb/servlet/CompleteUsername",true); 
	xmlRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded"); 
	xmlRequest.send("username="+username+"&r="+new Date());

	xmlRequest.onreadystatechange=function(){
		if(xmlRequest.readyState==4){//如果响应状态为4,说明响应成功
			var resp = xmlRequest.responseText;
			var rst = eval("("+resp+")");//转换json字符串为js对象
			var nameArray = rst.list;
			var i;
			var nameList = document.getElementById("nameList");
			nameList.innerHTML='';
			for(i=0;i<nameArray.length;i++){
				//alert(nameArray[i]);
				var newP = document.createElement("p");
				newP.innerHTML = nameArray[i];
				newP.onclick=function(){
					//alert();
					document.getElementById("username").value=this.innerHTML;
					nameList.style.display='none';
				};
				nameList.appendChild(newP);
			}
			nameList.style.display='block';
			//解析
			//alert(resp);
			
		}
	};
	};
	function selectName(html){
		document.getElementById("username").value=html;
		var nameList = document.getElementById("nameList");
		nameList.style.display='none';
		}
</script>
</head>
<body>
用户名：<input type="text" id="username" name="username" onkeyup="compUsername()">
<div id="nameList" style="width: 200px;height: auto;/* background-color: red; */position: relative;left: 65px;top:-18px;display: none;">
	<p onclick="selectName(this.innerHTML)">Abel1</p>
</div>
</body>
</html>