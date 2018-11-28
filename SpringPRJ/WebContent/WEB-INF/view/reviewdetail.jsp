<%@page import="poly.dto.MemDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
%>
<%
	String keyword = CmmUtil.nvl( request.getParameter("keyword"),"");
	int pageCount = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageCount"),"10"));
	int pageNum = Integer.parseInt(CmmUtil.nvl(request.getParameter("pageNum"),"1"));

	MemDTO mDTO = (MemDTO)request.getAttribute("mDTO");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>review detail</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
	     <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    
	    <!-- starRev CSS -->
	    <link href="css/starRev.css" rel="stylesheet">
	    
	    <style>
	    .my-box { border:1px solid; padding: 5px;}
	    
		
	    
	    </style>
	    
	    
		<script type="text/javascript">
				
				
				function goPage(){
					var pageCount = '<%=pageCount%>';
					location.href="/review.do?pageCount="+pageCount+"&pageNum="+<%=pageNum%> +"&keyword="+"<%=keyword%>";
				}
			   
			   
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
       
        	<form action="/reviewlist.do" method="POST">
        	
			<table class="table">
				
				<tr>
					
					<th>리뷰</th>
					<td>
						
					</td>
					<td></td>
					
					<%if(id.equals("33333")) { %> 
					<td>
						<a href="/writerevise.do?reviewSeqNo=<%=mDTO.getReviewSeqNo()%>"><input type="button" value="수정"></a>
					</td>
					<td>
						<a href="/writedelete.do?reviewSeqNo=<%=mDTO.getReviewSeqNo()%>&fileSeq=<%=mDTO.getFileSeq()%>"><input type="button" value="삭제"></a>
					</td>
					<td>
						<a href="javascript:goPage();"><input type="button" value="목록"></a>
					</td>
					<%} else { %>
					<td>
						<a href="javascript:goPage();"><input type="button" value="목록"></a>
					</td>
					<%  }  %>
				</tr>
				
				<tr>
					<td>
						<div class="my-box">
							이름(병원/약국)
						</div>	
					</td>
					<td colspan="5">
					
						<div class="my-box">
				           		<%=mDTO.getReviewName() %>
				        </div>
				           
				           
					</td>
					</tr>
					<tr>
					<td>
						<div class="my-box">
							작성자
						</div>	
					</td>
					<td colspan="2">
					
						<div class="my-box">
				           		<%=mDTO.getUserName() %>
				        </div>
				           
				           
					</td>
					
					
					
					<td>
						<div class="my-box">
						작성일
						</div>
					</td>
					
					
				
					<td colspan="2">
						<div class="my-box">
							<%=mDTO.getChgDt() %>
						</div>
					</td>
					
					
					</tr>
					
					<tr>
						<td>
							<div class="my-box">
								제목
							</div>
						</td>
						<td colspan="5">
							<div class="my-box">
				           		<%=mDTO.getTitle() %>
				        	</div>
				        </td>
				     </tr>
				     
				     <tr>
				     <% if(!(CmmUtil.nvl(mDTO.getChgName())).equals("") ) { %>
				     	<td colspan="6" height="500px">
				     
				     		<div class="my-box" style="height:600px;">
				     			<br/>
				     			<img src="/upload/<%=mDTO.getChgName()%>" height="200" width="200"><br/><br/>
				     			<%=mDTO.getReviewContents() %>
				     			
				     		</div>	
				     	</td>
				     <%} else { %>
				     	<td colspan="6" height="500px">
				     		<%=mDTO.getReviewContents() %>
				     	</td>
				    <% }%>
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