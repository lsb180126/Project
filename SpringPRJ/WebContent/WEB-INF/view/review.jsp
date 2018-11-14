<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		
		


		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>review</title>
	
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
        <a class="navbar-brand" href="#">pet clinic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          	
          	<li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">����������</a>
              <div class="dropdown-menu dropdown-menu-right">
	              <a class="dropdown-item" href="#">ȸ������</a>
	              <a class="dropdown-item" href="#">�� �ۼ� ���</a>
              </div>
            </li>
            
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
              <a class="nav-link" href="#">������ ����</a>
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
	
	
	<br/>
	
	<div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
        
			<table class="table">
				<tr>
					<td><input type="checkbox"></td>
					<td>���� ����</td>
					<td>
						<select>
							<option>�̸�</option>
							<option>����</option>
							<option>����</option>
							<option>�ۼ���</option>
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
						<a href="reviewregister.do"><input type="button" value="���"></a>
					</td>
				</tr>
			
				<tr>
					<th><input type="checkbox"></th>
					<th>��ȣ</th>
					<th>�̸�(����/�౹)</th>
					<th colspan="2">����</th>
					<th>����</th>
					<th>�ۼ���</th>
				</tr>
				
			
					
		
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