<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//이 jsp는 문자열 2개를 전송 받음 
	//1개는 경고창 문구
	//다른 1개는 경고창을 띄운뒤 이동할 Controller
	String msg = (String)request.getAttribute("msg");//경고창 문구
	String url = (String)request.getAttribute("url");//경고창을 띄운뒤 이동할 Controller
%>
<script>
	var msg = '<%=msg%>';
	var url = '<%=url%>';
	alert(msg);
	location.href=url;
</script>