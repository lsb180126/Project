<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//�� jsp�� ���ڿ� 2���� ���� ���� 
	//1���� ���â ����
	//�ٸ� 1���� ���â�� ���� �̵��� Controller
	String msg = (String)request.getAttribute("msg");//���â ����
	String url = (String)request.getAttribute("url");//���â�� ���� �̵��� Controller
%>
<script>
	var msg = '<%=msg%>';
	var url = '<%=url%>';
	alert(msg);
	location.href=url;
</script>