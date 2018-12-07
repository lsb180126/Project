<%@page import="poly.dto.FileDTO"%>
<%@page import="poly.dto.MemDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
%>
<%
	MemDTO mDTO = (MemDTO)request.getAttribute("mDTO");
%>
<%
	FileDTO fDTO = (FileDTO)request.getAttribute("fDTO");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>write revise</title>
		
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
          	
          	
            
            <%if(id.equals("33333")) { %> 
            	<li class="nav-item">
	              <a class="nav-link" href="userlist.do">회원 관리</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="hospitalSearch.do">병원 찾기 관리</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="pharmacySearch.do">약국 찾기 관리</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="review.do">리뷰 관리</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="talk.do">자유 토크 관리</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="useful.do">유용한 정보 관리</a>
	            </li>
	             
	            <%if("".equals(id) || id == null) { %>
	            <li class="nav-item active">
	              <a class="nav-link" href="login.do">Login
	             	 <span class="sr-only">(current)</span>
	              </a>
	            </li>
	            <%} else { %>
	             <li class="nav-item active">
	              <a class="nav-link" href="logout.do"><%="관리자 님 환영합니다." %> &nbsp; Logout
	             	 <span class="sr-only">(current)</span>
	              </a>
	            </li>
	             <%  }  %>
	            <li class="nav-item active">
	              <a class="nav-link" href="register.do">Register
	                <span class="sr-only">(current)</span>
	              </a>
	            </li>
            
            
            <%} else { %>
	            <li class="nav-item">
	              <a class="nav-link" href="hospitalSearch.do">병원 찾기</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="pharmacySearch.do">약국 찾기</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="review.do">리뷰 </a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="talk.do">자유 토크 </a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="useful.do">유용한 정보 </a>
	            </li>
	             
	            <%if("".equals(id) || id == null) { %>
	            <li class="nav-item active">
	              <a class="nav-link" href="login.do">Login
	             	 <span class="sr-only">(current)</span>
	              </a>
	            </li>
	            <%} else { %>
	             <li class="nav-item active">
	              <a class="nav-link" href="logout.do"><%=id + "님 환영합니다." %> &nbsp; Logout
	             	 <span class="sr-only">(current)</span>
	              </a>
	            </li>
	            <li class="nav-item dropdown">
	              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지
	              	 <span class="sr-only">(current)</span>
	           	  </a>
	              <div class="dropdown-menu dropdown-menu-right">
		              <a class="dropdown-item" href="mylist.do">회원정보</a>
		              <a class="dropdown-item" href="writelist.do">글 작성 목록</a>
	              </div>
	            </li>
	             <%  }  %>
	            <li class="nav-item active">
	              <a class="nav-link" href="register.do">Register
	                <span class="sr-only">(current)</span>
	              </a>
	            </li>
            
          <%  }  %>
            
          </ul>
        </div>
      </div>
    </nav>
	
	
	<div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
        
        	<form action="/writerevise2.do" method="POST" enctype="multipart/form-data">
        	
			<table class="table">
				
				<tr>
					
					<th>리뷰 수정</th>
					<td>
						
					</td>
					<td></td>
					
					<td>
						
					</td>
					<td>
						
						
						<input type="hidden" value="<%=mDTO.getReviewSeqNo()%>" name="reviewSeqNo">
						<input class="btn btn-outline-primary" type="submit" value="수정">
					</td>
					<td>
						<a href="/writedetail.do?reviewSeqNo=<%=mDTO.getReviewSeqNo() %>"><input class="btn btn-outline-primary" type="button" value="이전"></a>
					</td>
					
					
				</tr>
				
				<tr>
					<td>
						<div class="my-box">
							이름(병원/약국)
						</div>	
					</td>
					<td colspan="5">
						 
				         <input type="text" class="form-control" id="examplename" name="name" value="<%=mDTO.getReviewName() %>">
				     
				           
					</td>
					
					
					</tr>
					
					
					
					
					<tr>
						<td>
							<div class="my-box">
								제목
							</div>
						</td>
						<td colspan="5">
							
				           		<input type="text" class="form-control" id="exampletext" name="title" value="<%=mDTO.getTitle() %>">
				        	
				        </td>
				     </tr>
				     <tr>
				     	<td colspan="6">
				     		
				     		<textarea class="form-control"  rows="20" cols="100" name="content"><%=mDTO.getReviewContents() %></textarea>
				     		
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
					<%-- <img src="/upload/<%=mDTO.getChgName()%>" height="200" width="200" id="chgName"> --%> 
					<input type="file" name="file" id="file" >
					<input type="hidden" value="review" name="kind">
					<input type="hidden" value="<%=mDTO.getOriName()%>" name="oriName">
					<input type="hidden" value="<%=mDTO.getFileSize()%>" name="fileSize">
					<input type="hidden" value="<%=mDTO.getFileSeq()%>" name="fileSeq">
				    <input type="hidden" value="<%=mDTO.getChgName()%>" name="chgName">
				    <input type="hidden" value="<%=mDTO.getFilePath()%>" name="path">
				    <input type="hidden" value="<%=mDTO.getExtension()%>" name="extension"> 
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