<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		
		


		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>keyword</title>
	
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
	    
	    		table.type01 {
				    border-collapse: collapse;
				    text-align: left;
				    line-height: 1.5;
				    margin : 20px 10px;
				    border-top: none;
 				 	margin : 20px 10px;
				}
				table.type01 th {
				    width: 150px;
				    padding: 10px;
				    font-weight: bold;
				    vertical-align: top;
				    border-bottom: 1px solid #ccc;
				}
				table.type01 td {
				    width: 350px;
				    padding: 10px;
				    vertical-align: top;
				    border-bottom: 1px solid #ccc;
				}
				
				
				
				
				a.animated-button.thar-two {
					color: #fff;
					cursor: pointer;
					display: block;
					position: relative;
					border: 2px solid #F7CA18;
					transition: all 0.4s cubic-bezier(0.215, 0.61, 0.355, 1) 0s;
				}
				a.animated-button.thar-two:hover {
					color: #000 !important;
					background-color: transparent;
					text-shadow: ntwo;
				}
				a.animated-button.thar-two:hover:before {
					top: 0%;
					bottom: auto;
					height: 100%;
				}
				a.animated-button.thar-two:before {
					display: block;
					position: absolute;
					left: 0px;
					bottom: 0px;
					height: 0px;
					width: 100%;
					z-index: -1;
					content: '';
					color: #000 !important;
					background: #F7CA18;
					transition: all 0.4s cubic-bezier(0.215, 0.61, 0.355, 1) 0s;
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
	              <a class="dropdown-item" href="mylist">회원정보</a>
	              <a class="dropdown-item" href="#">글 작성 목록</a>
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
        
			<table class="type01" >
			
			    <tr>
			        <th scope="row">키워드</th>
			        <td></td>
			        <td></td>
			        <td></td>
			    </tr>
			   
    		
			    <tr>
			        <th scope="row" height="300">
			        	<div class="row">
				        	<div class="col-md-3 col-sm-3 col-xs-6"> 
				        		<a href="#" class="btn btn-sm animated-button thar-two">Login</a> 
			        		</div>
			        	</div>
			        </th>
			        <td></td>
			        <td></td>
			        <td></td>
			    </tr>
			    
			   
			    <tr>
			        <th scope="row" height="300"></th>
			        <td></td>
			        <td></td>
			        <td></td>
			    </tr>
			  
			</table>
			
			
			
			
	 	</div>
      </div>
    </div>
    

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>
</html>