<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ID 찾기</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        
        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
        
        <script>
        
        $(function() {
      		
      		var check=false;
      		 
      		$("#find").click(function(event){
      			var name  = $("#name").val();
      			var email  = $("#email").val();
      			
  			if(name == "") {
  				alert("이름을 입력해주세요");
  				return;
  			}
  			if(email == "") {
  				alert("이메일을 입력해주세요");
  				return;
  			}
  			
  			$("#f2").submit();
      		})
      		})
        
        
        </script>
        
        
	</head>
	<body>
		<!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1></h1>
                            <div class="description">
                            	<p>
	                            
                            	</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>ID 찾기</h3>
                            		<p>Enter your name and email to find id:</p>       
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            
                            <div class="form-bottom">
			                    <form role="form" action="/idfind2.do" method="POST" class="login-form" id="f2">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="r-form-1-email">name</label>
			                        	<input type="text" name="name" placeholder="이름" class="r-form-1-email form-control" id="name">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="r-form-1-email">email</label>
			                        	<input type="text" name="email" placeholder="이메일" class="r-form-1-email form-control" id="email">
			                        </div>
			                        <button type="button" class="btn" id="find">ID 찾기</button> &nbsp;
			                        <a href="login.do"><button type="button" class="btn">로그인</button></a>
			                    </form>
		                    </div>
		                    
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>


        
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
	</body>
</html>