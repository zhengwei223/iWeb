<%@ page language="java" contentType="text/html; charset=GBK"%>
<html>
	<head>
		<title>��Աע��</title>
	</head>
	<body>
		<div align="center">������ǻ�Աע��
			<form name="reg" method="post" action="regShow.jsp">
				<table  border="0" align="center">
					<tr> 
						<td>�û�����</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr> 
						<td>���룺</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr> 
						<td>ȷ�����룺</td>
						<td><input type="password" name="pwd2"></td>
					</tr>
					<tr> 
						<td>�������䣺</td>
						<td><input type="text" name="email"></td>
					</tr>	
					<tr> 
						<td>�Ա�</td>
						<td>
							<input name="gen" type="radio" value="��" checked="checked">��&nbsp;&nbsp; 
							<input name="gen" type="radio" value="Ů" >Ů
						<td>
					</tr>
					<tr> 
						<td>���ã�</td>
						<td> 
							<input type="checkbox" name="like" value="����">���� 
							<input type="checkbox" name="like" value="����">���� 
							<input type="checkbox" name="like" value="��Ϸ">��Ϸ<br/> 
							<input type="checkbox" name="like" value="����">���� 
							<input type="checkbox" name="like" value="������">������ 
							<input type="checkbox" name="like" value="�Ķ�">�Ķ�
						</td>
					</tr>
					<tr> 
						<td colspan="2" align="center"> 
							<input type="submit" name="Submit" value="�ύ">
							<input type="reset" name="Reset" value="ȡ��">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
