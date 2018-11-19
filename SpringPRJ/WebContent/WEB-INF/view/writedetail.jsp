<%@page import="poly.dto.MemDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));

%>
<%
	MemDTO mDTO = (MemDTO)request.getAttribute("mDTO");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>write detail</title>
		
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
        
        	<form action="/writelist.do" method="POST">
        	
			<table class="table">
				
				<tr>
					
					<th>����</th>
					<td>
						
					</td>
					<td></td>
					
					<td>
						<a href="/writerevise.do?reviewSeqNo=<%=mDTO.getReviewSeqNo() %>"><input type="button" value="����"></a>
					</td>
					<td>
						<a href="/writedelete.do?reviewSeqNo=<%=mDTO.getReviewSeqNo() %>"><input type="button" value="����"></a>
					</td> 
					<td>
						<a href="writelist.do"><input type="button" value="���"></a>
					</td>
					
					
				</tr>
				
				<tr>
					<td>
						<div class="my-box">
							�̸�(����/�౹)
						</div>	
					</td>
					<td>
					
						<div class="my-box">
				           		<%=mDTO.getReviewName() %>
				        </div>
				           
				           
					</td>
					
					
					<td>
						<div class="my-box">
						����
						</div>
					</td>
					
					<td></td>
				
					<td colspan="2">
						<span class="star-input">
						  <span class="input">
						    <input type="radio" name="star" id="p1" value="1"><label for="p1">1</label>
						    <input type="radio" name="star" id="p2" value="2"><label for="p2">2</label>
						    <input type="radio" name="star" id="p3" value="3"><label for="p3">3</label>
						    <input type="radio" name="star" id="p4" value="4"><label for="p4">4</label>
						    <input type="radio" name="star" id="p5" value="5"><label for="p5">5</label>
						    <input type="radio" name="star" id="p6" value="6"><label for="p6">6</label>
						    <input type="radio" name="star" id="p7" value="7"><label for="p7">7</label>
						    <input type="radio" name="star" id="p8" value="8"><label for="p8">8</label>
						    <input type="radio" name="star" id="p9" value="9"><label for="p9">9</label>
						    <input type="radio" name="star" id="p10" value="10"><label for="p10">10</label>
						  </span>
					</td>
					
					
					</tr>
					<tr>
						<td>
							<div class="my-box">
								����
							</div>
						</td>
						<td colspan="5">
							<div class="my-box">
				           		<%=mDTO.getTitle() %>
				        	</div>
				        </td>
				     </tr>
				     <tr>
				     	<td colspan="6" height="500px">
				     		<div class="my-box" style="height:600px;">
				     			<%=mDTO.getReviewContents() %>
				     		</div>	
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