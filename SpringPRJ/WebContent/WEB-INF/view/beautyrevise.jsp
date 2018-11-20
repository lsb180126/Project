<%@page import="poly.dto.BeautyDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));

%>
<%
	BeautyDTO bDTO = (BeautyDTO)request.getAttribute("bDTO");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>beauty revise</title>
		
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
              <a class="nav-link" href="useful.do">������ ����</a>
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
	              <a class="dropdown-item" href="writelist.do">�� �ۼ� ���</a>
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
        
        	<form action="/beautyrevise2.do" method="POST">
        	
			<table class="table">
				
				<tr>
					
					<th>�̿� ���� ����</th>
					<td>
						
					</td>
					<td></td>
					
					<td>
						
					</td>
					<td>
						<input type="hidden" value="<%=bDTO.getBeautySeqNo()%>" name="beautySeqNo">
						<input type="submit" value="����">
					</td>
					<td>
						<a href="/beautydetail2.do?beautySeqNo=<%=bDTO.getBeautySeqNo() %>"><input type="button" value="����"></a>
					</td>
					
					
				</tr>
				
				<tr>
						<td colspan="6">
							<div class="form-group">
				           		<label class="sr-only" for="exampletext"></label>
				           		<input type="text" class="form-control" id="exampletext" name="title" value="<%=bDTO.getTitle()%>">
				        	</div>
				        </td>
				     </tr>
				     <tr>
				     	<td colspan="6">
				     		<textarea class="form-control"  rows="20" cols="100" name="content"><%=bDTO.getBeautyContents() %></textarea>
				     	</td>
			     	</tr>
			     	<tr>
			     		<td></td>
			     		<td></td>
			     		<td></td>
			     		<td></td>
			     		<td></td>
			     		<td>
			     			
			     		</td>
			     		
		     		</tr>
				</table>
				</form>
				<form enctype="multipart/form-data" method="POST" action="/reviewlist.do">
				     			<input type="file" name="file" id="file" >
				     			<input type="submit" value="���� ���ε�">
				     		</form>
				    <br/>
			     	<br/>
			     	<br/>
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