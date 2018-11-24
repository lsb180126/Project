<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		
		<meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>register</title>

        <!-- CSS -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,700">
        <link rel="stylesheet" href="register/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="register/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="register/css/animate.css">
        <link rel="stylesheet" href="register/css/style.css">
        <link rel="stylesheet" href="register/css/media-queries.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

      <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

		
      <script>
      	 $(function() {
      		
      		var check = false;
      		 
      		$("#check").click(function(){
      			var id  = $("#idcheck").val();
      			alert (id);
      			
      			$.ajax({
      				data:{"id":id},
      				url:"/ajaxTest.do",
      				type:"POST",
      				dataType:"json",
      				success:function(data) {
      					
      					if(data==0) {
      						alert("사용 가능한 아이디입니다.");
      						
      						check = true;
      					}
      					else {
      						alert("중복되는 아이디입니다.");
      						
      						
      					}
      					
      					
      					
      				},
      				error:function(error) {
      					console.log(error);
      				}
      				
      			})
      				
      			
      		})
      		
      	})	
      
      $(function() {
      		
      		var check=false;
      		 
      		$("#ok").click(function(event){
      			var id  = $("#idcheck").val();
      			var password  = $("#password").val();
      			var passwordcheck  = $("#passwordcheck").val();
      			var name  = $("#name").val();
      			var email  = $("#email").val();
      			var gender = $('input[name="gender"]:checked').val(); 
      				
      			if(id == "") {
      				alert("아이디를 입력해주세요");
      				return;
      			}else if(id.length <5) {
      				alert("id를 5자리이상 입력해주세요");
      				return;
      			}
      			
      			if(password == "") {
      				alert("비밀번호를 입력해주세요");
      				return;
      			}
      			
      			if(passwordcheck == "") {
      				alert("비밀번호를 확인해주세요");
      				return;
      			} else if(passwordcheck != password) {
      				alert("비밀번호가 맞지 않습니다.");
      				return;
      			} 
      			
      			if(name == "") {
      				alert("이름을 입력해주세요");
      				return;
      			}
      			
      			if(email == "") {
      				alert("이메일을 입력해주세요");
      				return;
      			}
      			
      			if(gender == null) {
      				alert("성별을 선택해주세요.");
      				return;
      			}
      				
      			$("#form").submit();	
      		})
      		
      })
      </script>
      
      
        
        

	</head>
	<body>
	
				
				
        <!-- Top content -->
        <div class="top-content">
        	<div class="container">
        	
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1 class="wow fadeInLeftBig"></h1>
						<div class="description wow fadeInLeftBig">
							<p>
								
							</p>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 r-form-1-box wow fadeInUp">
						<div class="r-form-1-top">
							<div class="r-form-1-top-left">
								<h3>회원가입</h3>
								<p>Fill in the form below to get instant access:</p>
							</div>
							<div class="r-form-1-top-right">
								<i class="fa fa-pencil"></i>
							</div>
						</div>
						<div class="r-form-1-bottom">
							<form  action="/rc.do" method="POST" id="form">
								<div class="form-group">
									<label class="sr-only" for="r-form-1-first-name">id</label>
									<input type="text" name="id" placeholder="아이디" class="r-form-1-first-name form-control" id="idcheck" >
								</div>
								<div class="form-group">
									<button type="button" class="btn" id="check">중복확인</button>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-last-name">password</label>
									<input type="text" name="password" placeholder="비밀번호" class="r-form-1-last-name form-control" id="password">
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-last-name">passwordcheck</label>
									<input type="text" name="passwordcheck" placeholder="비밀번호확인" class="r-form-1-last-name form-control" id="passwordcheck">
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-email">name</label>
									<input type="text" name="name" placeholder="이름" class="r-form-1-email form-control" id="name">
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-email">email</label>
									<input type="text" name="email" placeholder="이메일" class="r-form-1-email form-control" id="email">
								</div>
								<div class="form-group">
									<button type="button" class="btn" id="emailcheck">이메일 인증</button>
								</div>
    							<div class="">
									<input type="radio" name="gender" value="man">남자
									<input type="radio" name="gender" value="woman">여자
								</div>
								<div class="form-group">
									<button type="button" class="btn" id="ok">등록</button>
									<a href="index.do">HOME</a>
								</div>
								
							</form>
						</div>
					</div>
				</div>
                
            </div>
        </div>

        

		
        


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
	</body>
</html>