<%@ page contentType= "text/html;charset=GB2312"%>
<html>
	<head>
		<title>JSP�ű���������</title>
	</head>
	<body>
		<%! 
			//�˴������ı�������Ϊ��JSPҳ���ȫ�ֱ��� 
			int age1 = 21; 
			int age2 = 16;
			String msg = "���ѣ�";  
		%> 
		<%! 
			//�˴������ķ�������Ϊ��JSPҳ��Ĺ�������
			String printStr(int age){
				if(age < 18) { 
					return "����δ�����ˣ������Թ������̣�"; 
				}else{ 
					return "���Ѿ������ˣ����Թ�������!"; 
				} 
	    	}
		%>
		��������ǣ�<%=age1%>��<%=msg%><%=printStr(age1)%><br>
		��������ǣ�<%=age2%>��<%=msg%><%=printStr(age2)%>
	</body>
</html>
