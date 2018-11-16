<%@page import="poly.dto.UserDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
%>
<%
	UserDTO uDTO = (UserDTO)request.getAttribute("uDTO");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>mypage revise</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
	     <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    
	    <!-- starRev CSS -->
	    <link href="css/starRev.css" rel="stylesheet">
	    
	    <style>
	    .my-box { border:1px solid; padding: 5px;  }
	    
		
	    
	    </style>
	    
	    <script>
	    
		    
	    
	    
	    </script>
	    
	</head>
	<body>
	
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
      <div class="container">
        <a class="navbar-brand" href="index.do">pet clinic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          	
          	
            
            <li class="nav-item">
              <a class="nav-link" href="#">���� ã��</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="#">�౹ã��</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="review.do">����</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="talk.do">���� ��ũ</a>
            </li>
            
             <li class="nav-item">
              <a class="nav-link" href="#">������ ����</a>
            </li>
            
             <%if("".equals(id) || id == null) { %>
            <li class="nav-item active">
              <a class="nav-link" href="login.do">Login
             	 <span class="sr-only">(current)</span>
              </a>
            </li>
            <%} else { %>
             <li class="nav-item active">
              <a class="nav-link" href="logout.do"><%=id + "�� ȯ���մϴ�." %> &nbsp; Logout
             	 <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">����������
              	 <span class="sr-only">(current)</span>
           	  </a>
              <div class="dropdown-menu dropdown-menu-right">
	              <a class="dropdown-item" href="mylist.do">ȸ������</a>
	              <a class="dropdown-item" href="#">�� �ۼ� ���</a>
              </div>
            </li>
             <%  }  %>
            <li class="nav-item active">
              <a class="nav-link" href="register.do">Register
                <span class="sr-only">(current)</span>
              </a>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
	
	
	<div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
        
        <form action="">
        	
			<table class="table">
				
				<tr>
					
					<th><%=id + "���� ȸ������" %></th>
					<td>
					</td>
					
				</tr>
					
				<tr>
					
					<td>���̵�</td>
					<td><%=id %></td>
					
					
				</tr>
				<tr>
				
					<td>�̸�</td>
					<td><input type="text" name="name" value="<%=uDTO.getUserName()%>" readonly></td>
					
				</tr>
				<tr>
				     <td>����</td>
					 <td><input type="text" name="gender" value="<%=uDTO.getGender()%>"readonly></td>	
				     	
			    </tr>
			    <tr>
			     	<td>�̸���</td>
					<td><input type="text" name="email" value="<%=uDTO.getEmail()%>"></td>		
		     	</tr>
		     	<tr>
					<td><input type="submit" value="����"></td>
					<td><input type="button" value="����"></td>
				</tr>
				</table>
				
				</form>
			</div>
		</div>
	</div>
	
	
	<!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
    <!--starRev JavaScript -->
    <script type="text/javascript" src="javascript/starRev.jsp"></script>
    
    
	
	</body>
</html>