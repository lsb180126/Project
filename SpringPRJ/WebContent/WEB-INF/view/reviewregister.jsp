<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>review register</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
	     <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    
	    <!-- starRev CSS -->
	    <link href="css/starRev.css" rel="stylesheet">
	    
	    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
    <!--starRev JavaScript -->
    <script type="text/javascript" src="javascript/starRev.jsp"></script>
	    
	    <style>
	    .my-box { border:1px solid; padding: 5px;  }
	    
		
		#name {
		    white-space: nowrap; 
		    overflow: hidden;
		    text-overflow: ellipsis;
		}
		#title {
		    white-space: nowrap; 
		    overflow: hidden;
		    text-overflow: ellipsis;
		}
		#content {
		    white-space: nowrap; 
		    overflow: hidden;
		    text-overflow: ellipsis;
		}
		
		
	    </style>
	    
	    <script>
	    
	   
		$(function() {
      		
      		var check=false;
      		 
      		$("#hi").click(function(event){
      			var name  = $("#name").val();
      			var title  = $("#title").val();
      			var content  = $("#content").val();
    
      			
      			if(name == "") {
      				alert("병원이름이나 약국이름을 입력해주세요");
      				return;
      			}
      			if(title == "") {
      				alert("제목을 입력해주세요");
      				return;
      			}
      			if(content == "") {
      				alert("내용을 입력해주세요");
      				return;
      			}
      			
		    
      			$("#f1").submit();	
      		})
      		
      })
	    
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
        
        	<form action="/reviewlist.do" method="POST" enctype="multipart/form-data" id="f1">
        	
			<table class="table">
				
				<tr>
					
					<th>리뷰 등록</th>
					<td>
						
					</td>
					<td></td>
					<td>
						
					</td>
					<td>
						<input class="btn btn-outline-primary" type="button" value="등록" id="hi">
					</td>
					<td>
						<a href="review.do"><input class="btn btn-outline-primary" type="button" value="목록"></a>
					</td>
					
					
				</tr>
				
				<tr>
					
					<td colspan="6">
					
						<div class="form-group">
				           		<label class="sr-only" for="examplename"></label>
				           		<input type="text" placeholder="이름(병원/약국)을 입력해 주세요" class="form-control" id="name" name="name" maxlength="200">
				        </div>
				           
				           
					</td>
					<td></td>
					
					
					
					</tr>
					<tr>
						<td colspan="6">
							<div class="form-group">
				           		<label class="sr-only" for="exampletext"></label>
				           		<input type="text" placeholder="제목을 입력해 주세요." class="form-control" id="title" name="title" maxlength="200">
				        	</div>
				        </td>
				     </tr>
				     <tr>
				     	<td colspan="6">
				     		<textarea class="form-control"  rows="20" cols="100" placeholder="내용을 입력해 주세요."  id="content" name="content" maxlength="1000"></textarea>
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
					
					<input type="file" name="file" id="file">
					<input type="hidden" value="review" name="kind">
					
				</form>
						
				     		
				     		
				     	
			     	<br/>
			     	<br/>
			     	<br/>
			</div>
		</div>
	</div>
	
	
	
    
    
	
	</body>
</html>