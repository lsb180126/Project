<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.MemDTO"%>
<%@page import="poly.dto.UserDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));

%>
<%
	
	List<MemDTO> mList = (List<MemDTO>)request.getAttribute("mList");
	
	if (mList==null){
		mList = new ArrayList<MemDTO>();
		
	}
%> 
<%
	String name = (String) request.getAttribute("name");
	String title = (String) request.getAttribute("title");
	String content = (String) request.getAttribute("content");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>review revise</title>
		
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
	
	
	<div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
        
        	<form action="/writerevise2.do" method="POST">
        	
			<table class="table">
				
				<tr>
					
					<th>리뷰 수정</th>
					<td>
						
					</td>
					<td></td>
					<td>
						
					</td>
					<td>
						<input type="submit" value="수정">
					</td>
					<td>
						<a href="writelist.do"><input type="button" value="이전"></a>
					</td>
					
					
				</tr>
				
				<tr>
					
					<td>
					
						<div class="form-group">
				           		<label class="sr-only" for="examplename"></label>
				           		<input type="text" class="form-control" id="examplename" name="name" value="<%=mDTO.getReviewName%>">
				        </div>
				           
				           
					</td>
					<td></td>
					
					<td>
						<div class="my-box">
						별점
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
						<td colspan="6">
							<div class="form-group">
				           		<label class="sr-only" for="exampletext"></label>
				           		<input type="text" class="form-control" id="exampletext" name="title" value="<%=mDTO.getTitle%>">
				        	</div>
				        </td>
				     </tr>
				     <tr>
				     	<td colspan="6">
				     		<textarea class="form-control"  rows="20" cols="100" name="content" value="<%=mDTO.getReviewContents%>"></textarea>
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
				     		<input type="submit" value="파일 업로드">
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