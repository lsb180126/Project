<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>review register</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
	     <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    
	    <!-- starRev CSS -->
	    <link href="css/starRev.css" rel="stylesheet">
	    
	    <style>
	    .my-box { border:1px solid; padding: 5px; position: fixed; }
	    
	    
	    </style>
	    
	    <script>
		    
	    
	    
	    </script>
	</head>
	<body>
	
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
      <div class="container">
        <a class="navbar-brand" href="#">pet clinic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          	
          	<li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지</a>
              <div class="dropdown-menu dropdown-menu-right">
	              <a class="dropdown-item" href="#">회원정보</a>
	              <a class="dropdown-item" href="#">글 작성 목록</a>
              </div>
            </li>
            
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
              <a class="nav-link" href="#">유용한 정보</a>
            </li>
            
             <li class="nav-item active">
              <a class="nav-link" href="index.do">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            
            <li class="nav-item active">
              <a class="nav-link" href="login.do">Login
                <span class="sr-only">(current)</span>
              </a>
            </li>
            
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
        
        <form action="/talklist.do" method="POST">
        	
			<table class="table">
				<tr>
					<th>자유 토크 등록</th>
					<td>
						
					</td>
					<td></td>
					<td>
						
					</td>
					<td>
						<input type="submit" value="등록">
					</td>
					<td>
						<a href="talk.do"><input type="button" value="목록"></a>
					</td>
				</tr>
				
				
					<tr>
						<td colspan="6">
							<div class="form-group">
				           		<label class="sr-only" for="exampletext"></label>
				           		<input type="text" placeholder="제목을 입력해 주세요." class="form-control" id="exampletext" name="title">
				        	</div>
				        </td>
				     </tr>
				     <tr>
				     	<td colspan="6">
				     		<textarea class="form-control"  rows="3" placeholder="내용을 입력해 주세요." name="content"></textarea>
				     	</td>
			     	</tr>
			     	<tr>
			     		<td></td>
			     		<td></td>
			     		<td></td>
			     		<td></td>
			     		<td></td>
			     		<td>
			     			<form enctype="multipart/form-data" method="post" action="">
			     				<input type="file" name="file_input" id="f1" >
			   			
			     			</form>
			     		</td>
			     		
		     		</tr>
				</table>
				
				</form>
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