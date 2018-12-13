<%@page import="poly.dto.BeautyDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
%>
<%
	BeautyDTO bDTO = (BeautyDTO)request.getAttribute("bDTO");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>beauty detail</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
	     <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    
	    <!-- starRev CSS -->
	    <link href="css/starRev.css" rel="stylesheet">
	    
	    <style>
	    .my-box { border:1px solid; padding: 5px;  }
	    
		table.type03 {
		    border-collapse: collapse;
		    text-align: left;
		    line-height: 1.5;
		    border-top: 1px solid #ccc;
		    border-left: 3px solid #369;
		  margin : 20px 10px;
		}
		table.type03 th {
		    width: 147px;
		    padding: 10px;
		    font-weight: bold;
		    vertical-align: top;
		    color: #153d73;
		    border-right: 1px solid #ccc;
		    border-bottom: 1px solid #ccc;
		
		}
		table.type03 td {
		    width: 349px;
		    padding: 10px;
		    vertical-align: top;
		    border-right: 1px solid #ccc;
		    border-bottom: 1px solid #ccc;
		}
	    
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
        
        	<form action="/writelist.do" method="POST">
        	
			<table class="type03">
				
				<tr>
					
					<th scope="row">미용 정보</th>
						<td colspan="5">
							
						</td>
					
					
					
				</tr>
				
				<tr>
					<th scope="row">
						
							작성자
							
					</th>
					<td colspan="2">
					
						
				           		<%=bDTO.getUserName() %>
				        
				           
				           
					</td>
					
					
					<th scope="row">
						
						작성일
						
					</td>
					
					
				
					<td colspan="2">
						
							<%=bDTO.getChgDt() %>
						
					</td>
					
					
					</tr>
					<tr>
						<th scope="row">
							
								제목
							
						</th>
						<td colspan="5">
							
				           		<%=bDTO.getTitle() %>
				        	
				        </td>
				     </tr>
				     <tr>
				     	
				     		<% if(bDTO.getChgName() != null) {%>
				     		<td colspan="6" height="500px">
				     		<div style="height:600px;">
				     		<br/>
				     		<img src="/upload/<%=bDTO.getChgName()%>" height="400" width="900" >
				     		
				     		
				     			
				     		</div>	
				     	</td>
				     	<%} %>
			     	</tr>
			     	<tr>	
							<th scope="row">
								내용
							</th>
							<td colspan="5" height="350px" id="contents" style="white-space: pre-wrap">
									

							</td>

						</tr>
			     	


				</table>
				
				<td>
						<a href="/beautyrevise.do?beautySeqNo=<%=bDTO.getBeautySeqNo() %>"><input class="btn btn-primary"  type="button" value="수정"></a>
					</td>
					<td>
						<a href="/beautydelete.do?beautySeqNo=<%=bDTO.getBeautySeqNo() %>&fileSeq=<%=bDTO.getFileSeq()%>"><input class="btn btn-primary"  type="button" value="삭제"></a>
					</td> 
					<%if(id.equals("33333")) { %>
					<td>
						<a href="beauty.do"><input class="btn btn-primary" style="float: right; margin-right: 100px; " type="button" value="목록"></a>
					</td>
					<%} else { %>
					<td>
						<a href="writelist.do?pageCount=${pageCount}&pageNum=${pageNum}"><input class="btn btn-primary"  type="button" value="목록"></a>
					</td>
					<%  }  %>
					
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
    
    <script>
		var temp = '<%=bDTO.getBeautyContents().replace("\"","\\\"").replace("'","\\\'").replace("<br>","\\r\\n") %>';
		$('#contents').text(temp);
	</script>
	
	</body>
</html>