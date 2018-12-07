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
	<style>
		#password, #passwordcheck {
			height: 50px;
			border-radius: 0px;
		    font-size: 15px;
		    padding-left: 21px;
		}
		::selection {
		    background: #e36da1;
		    color: #fff;
		    text-shadow: none;
		    border: 3px solid #e36da1;
		}
		#password:focus, #passwordcheck:foucs {
			border: 3px solid #e36da1;
		}
		
		label {
		    padding: 10px 24px; 
		    color: #999999;
		    font-weight:normal;
		}
		</style>
		
      <script>
      //아이디 중복
      
   		var check = false;	
   		checkId = function() {
      		var id  = $("#idcheck").val();
  			$.ajax({
  				data:{"id":id},
  				url:"/ajaxTest.do",
  				type:"POST",
  				dataType:"json",
  				success:function(data) {
  					
  					if(data==0) {
  						check = true;
  						alert("사용 가능한 아이디입니다.");
  						return check;
  					}
  					else {
  						check = false;
  						alert("중복되는 아이디입니다.");  
  						return check;
  					}
  					
  					
  					
  				},
  				error:function(error) {
  					console.log(error);
  				}
  				
  			})  
      	}
      
      
      //이름 중복
      	 $(function() {
      		
      		var check = false;
      		 
      		$("#checkIdName").click(function(){
      			var name  = $("#name").val();
      			
      			$.ajax({
      				data:{"name":name},
      				url:"/checkIdName.do",
      				type:"POST",
      				dataType:"json",
      				success:function(data) {
      					
      					if(data==0) {
      						alert("사용 가능한 이름 입니다.");
      						
      						check = true;
      					}
      					else {
      						alert("중복된 이름 입니다.");
      						
      						
      					}
      					
      					
      					
      				},
      				error:function(error) {
      					console.log(error);
      				}
      				
      			})
      				
      			
      		})
      		
      	})	
      //이메일 중복
       $(function() {
      		
      		var check = false;
      		 
      		$("#checkIdEmail").click(function(){
      			var email = $("#email").val();
      			
      			$.ajax({
      				data:{"email":email},
      				url:"/checkIdEmail.do",
      				type:"POST",
      				dataType:"json",
      				success:function(data) {
      					
      					if(data==0) {
      						alert("사용 가능한 이메일입니다.");
      						
      						check = true;
      					}
      					else {
      						alert("중복된 이메일입니다.");
      						
      						
      					}
      					
      					
      					
      				},
      				error:function(error) {
      					console.log(error);
      				}
      				
      			})
      				
      			
      		})
      		
      	})	
      
      
      $(function() {
      		
      		var checkId2 = false;
      		 
      		$("#ok").click(function(event){
      			
      			var id  = $("#idcheck").val();
      			$.ajax({
      				data:{"id":id},
      				url:"/ajaxTest.do",
      				type:"POST",
      				dataType:"json",
      				success:function(data) {
      					
      					if(data==0) {
      						checkId2 = true;
      					}
      					else {
      						checkId2 = false;
      						alert("중복되는 아이디입니다.");  
      						
      					}
      					
      					
      					
      				},
      				error:function(error) {
      					console.log(error);
      				}
      				
      			});
      			
      			if(checkId2 == false) {
      				return ;
      			}
      			
      			var id  = $("#idcheck").val();
      			var password  = $("#password").val();
      			var passwordcheck  = $("#passwordcheck").val();
      			var name  = $("#name").val();
      			var email  = $("#email").val();
      			var gender = $('input[name="gender"]:checked').val(); 
      			
      			var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      			
      			  // 검증에 사용할 정규식 변수 regExp에 저장
      			var passwordregExp = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;

      			  
      			if(id == "") {
      				alert("아이디를 입력해주세요");
      				return;
      			}else if(id.length <4) {
      				alert("id를 4자리이상 입력해주세요");
      				return;
      			}
      			
      			if(password == "") {
      				alert("비밀번호를 입력해주세요");
      				return;
      			}else if(password.length <2) {
      				alert("비밀번호를 2자리 이상 입력해주세요");
      				return;
      			}
      			
      			
      			if(!password.match(passwordregExp) ) {
      				alert("비밀번호를 6~20 영문 대소문자와 최소 1개의 숫자 혹은 특수 문자를 포함해야합니다");
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
      			}else if(!email.match(regExp)) {
      				alert("이메일을 올바르게 입력해주세요");
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
									<button type="button" name="check" class="btn" id="check" onclick="checkId();">중복확인</button>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-last-name">password</label>
									<input type="password" name="password" placeholder="비밀번호" class="r-form-1-last-name form-control" id="password">
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-last-name">passwordcheck</label>
									<input type="password" name="passwordcheck" placeholder="비밀번호확인" class="r-form-1-last-name form-control" id="passwordcheck">
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-email">name</label>
									<input type="text" name="name" placeholder="이름" class="r-form-1-email form-control" id="name">
								</div>
								<div class="form-group">
									<button type="button" class="btn" id="checkIdName">이름 중복확인</button>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-email">email</label>
									<input type="text" name="email" placeholder="이메일" class="r-form-1-email form-control" id="email">
								</div>
								<div class="form-group">
									<button type="button" class="btn" id="checkIdEmail">이메일 중복확인</button>
								</div>
    							<div class="" id="labelMan" style="color:black; font-size:16px; height:50px; background:#fff; margin-bottom: 15px;">
									<input type="radio" class="gender" name="gender" value="man" id="man" style="display:none;">
									<label  for="man" style=" width:100%">남자</label>
								</div>
    							<div class="" id="labelWoman" style="color:black; font-size:16px; height:50px; background:#fff; margin-bottom: 15px;">
									<input type="radio" class="gender" name="gender" value="woman" id="woman" style="display:none;">
									<label for="woman" style=" width:100%; ">여자</label>
								</div>
								<div class="form-group">
									<button type="button" class="btn" id="ok">등록</button>
									
								</div>
								<div class="form-group">
									<a href="index.do"><button type="button" class="btn" id="home">HOME</button></a>
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
        
        <script>
        	$('.gender').change(function() {
        		if($('#man').prop('checked')) {
        			$('#labelMan').css('background', '#e36da1');
        			$('#labelMan>label').css('color', 'white');
        			
        			$('#labelWoman').css('background', 'white');
        			$('#labelWoman>label').css('color', '#999999');
        		} else {
        			$('#labelMan').css('background', 'white');
        			$('#labelWoman>label').css('color', 'white');
        			
        			$('#labelWoman').css('background', '#e36da1');
        			$('#labelMan>label').css('color', '#999999');
        		};
        		
        	})
        </script>
	</body>
</html>