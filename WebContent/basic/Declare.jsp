<%@ page contentType= "text/html;charset=GB2312"%>
<html>
	<head>
		<title>JSP脚本——声明</title>
	</head>
	<body>
		<%! 
			//此处声明的变量将成为此JSP页面的全局变量 
			int age1 = 21; 
			int age2 = 16;
			String msg = "提醒：";  
		%> 
		<%! 
			//此处声明的方法将成为此JSP页面的公共方法
			String printStr(int age){
				if(age < 18) { 
					return "你是未成年人，不可以购买香烟！"; 
				}else{ 
					return "你已经成年了，可以购买香烟!"; 
				} 
	    	}
		%>
		你的年龄是：<%=age1%>，<%=msg%><%=printStr(age1)%><br>
		你的年龄是：<%=age2%>，<%=msg%><%=printStr(age2)%>
	</body>
</html>
