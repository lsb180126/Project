<%@page import="poly.dto.ComDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	List<ComDTO> rList = (List<ComDTO>)request.getAttribute("rList");
	




%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/submit.do" method="POST">
	
		id     :<input type="text" name="id" /> <br/>
		name   :<input type="text" name="name" /> <br/>
		gender : <input type="text" name="gender" /> <br/>
		password    : <input type="password" name="password" /> <br/>
		<input type="submit" value="등록" />
	
	</form>
	
	<br/><br/><br/>
	<table border="1" width="300">
		<tr>
			<td>아이디 </td>
			<td>이름</td>
			<td>성별</td>
			<td>비밀번호</td>
		</tr>
		<% for(ComDTO c : rList) { %>
		<tr>
			<td><%=c.getId() %></td>
			<td><%=c.getMemberName() %></td>
			<td><%=c.getGender() %></td>
			<td><%=c.getPassword() %></td>
		</tr>
		<% } %>
		
	</table>
</body>
</html>