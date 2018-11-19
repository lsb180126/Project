<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.HomegoodsDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));

%>
<%

	List<HomegoodsDTO> hList = (List<HomegoodsDTO>)request.getAttribute("hList");
	
	if (hList==null){
		hList = new ArrayList<HomegoodsDTO>();
		
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		
		


		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>homegoods</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    
	    <style>
	    	
	    	* {
				  box-sizing: border-box;
				}
				
				/* Style the search field */
				form.example input[type=text] {
				  padding: 10px;
				  font-size: 17px;
				  border: 1px solid grey;
				  float: left;
				  width: 80%;
				  background: #f1f1f1;
				}
				
				/* Style the submit button */
				form.example button {
				  float: left;
				  width: 20%;
				  padding: 10px;
				  background: #2196F3;
				  color: white;
				  font-size: 17px;
				  border: 1px solid grey;
				  border-left: none; /* Prevent double borders */
				  cursor: pointer;
				}
				
				form.example button:hover {
				  background: #0b7dda;
				}
				
				/* Clear floats */
				form.example::after {
				  content: "";
				  clear: both;
				  display: table;
				}
	    
	    
	    </style>
	    
	   
	    
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
	
	
	<br/>
	
	<div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
        
			<table class="table">
				<tr>
					
					<td>생활용품 정보</td>
					<td>
						<select>
							<option>제목</option>
							<option>작성자</option>
							<option>작성일</option>
						</select>
					</td>
					
					<td></td>
					<td>
						<form class="example" action="action_page.php">
						  <input type="text" placeholder="Search.." name="search">
						  <button type="submit"><i class="fa fa-search"></i></button>
						</form>
					</td>
					<td>
					</td>
					
					<td>
						<a href="homegoodsregister.do"><input type="button" value="등록"></a>
					</td>
				</tr>
				
				<tr>
				<div>
					
					<th>번호</th>
					<th colspan="3">제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</div>
				</tr>
				
				<% for(HomegoodsDTO h : hList) { %>
				<tr>
					
					<td><%=h.getHomegoodsSeqNo() %></td>
					<td colspan="3"><a href="/homegoodsdetail.do?homegoodsSeqNo=<%=h.getHomegoodsSeqNo() %>"><%=h.getTitle() %></a></td>
					<td><%=h.getUserName() %></td>
					<td><%=h.getChgDt() %></td>
				</tr>
				<% } %>
					
		
			</table>
			<hr/>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
				 <li class="page-item">
		      		<a class="page-link" href="#" aria-label="Previous" >
		        		<span aria-hidden="true">&laquo;</span>
		        		<span class="sr-only">Previous</span>
		      		</a>
		   		 </li> 
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">4</a></li>
					<li class="page-item">
		      			<a class="page-link" href="#" aria-label="Next">
		        			<span aria-hidden="true">&raquo;</span>
		        			<span class="sr-only">Next</span>
		      			</a>
		    		</li>
				</ul>
			</nav>
	 	</div>
      </div>
    </div>
    

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>
</html>