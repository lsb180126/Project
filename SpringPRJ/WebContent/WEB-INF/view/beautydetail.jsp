<%@page import="poly.dto.BeautyDTO"%>
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
	    
		
	    
	    </style>
	    
	     <script type="text/javascript">
				
				
				function goPage(){
					var pageCount = '<%=pageCount%>';
					location.href="/beauty.do?pageCount="+pageCount+"&pageNum="+<%=pageNum%> +"&keyword="+"<%=keyword%>";
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
          	
          	
            
            <li class="nav-item">
              <a class="nav-link" href="#">병원 찾기</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="#">약국찾기</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="review.do">리뷰</a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="talk.do">자유 토크</a>
            </li>
            
             <li class="nav-item">
              <a class="nav-link" href="useful.do">유용한 정보</a>
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
            
          </ul>
        </div>
      </div>
    </nav>
	
	
	<div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
        
        	<form action="/beautylist.do" method="POST">
        	
			<table class="table">
				
				<tr>
					
					<th>미용 정보</th>
					<td>
						
					</td>
					<td></td>
					<td>
						
					</td>
					<td>
						
					</td>
					<td>
						<a href="javascript:goPage();"><input type="button" value="목록"></a>
					</td>
					
					
				</tr>
				
				<tr>
					<td>
						<div class="my-box">
							작성자
						</div>	
					</td>
					<td>
					
						<div class="my-box">
				           		<%=bDTO.getUserName() %>
				        </div>
				           
				           
					</td>
					
					
					<td>
						<div class="my-box">
						작성일
						</div>
					</td>
					
					<td></td>
				
					<td colspan="2">
						<div class="my-box">
							<%=bDTO.getChgDt() %>
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
				           		<%=bDTO.getTitle() %>
				        	</div>
				        </td>
				     </tr>
				     <tr>
				     	<td><%=bDTO.getBeautyContents() %></td>
				     </tr>
				     
				     <tr>
				     <% if(!(CmmUtil.nvl(bDTO.getChgName())).equals("") ) { %>
				     	<td colspan="6" height="500px">
				     		<div class="my-box" style="height:600px;">
				     		<img src="/upload/<%=bDTO.getChgName()%>" height="200" width="200" >
				     			
				     		</div>	
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