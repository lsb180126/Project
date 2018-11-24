<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
	String password = (String) request.getAttribute("password");
	String pwid = (String) request.getAttribute("pwid");
	
%>




<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>PASSWORD ����</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

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
                        			<h3>PASSWORD ����</h3>
                            		<p>Enter your new password and new password check:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>      
                            <div class="form-bottom">
			                    <form role="form" action="/pwrevise2.do" method="POST" class="login-form" >
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-password">new password</label>
			                        	<input type="password" name="password" placeholder="�� ��й�ȣ" class="form-password form-control" id="password" >
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">new password check</label>
			                        	<input type="password" name="passwordcheck" placeholder="�� ��й�ȣ Ȯ��" class="form-password form-control" id="passwordcheck">
			                        </div>
			                        <input type="hidden" name="userId" value="<%=pwid%>">
			                        <button type="submit" class="btn" id="ok">PASSWORD ����</button> &nbsp;
			                        <a href="login.do"><button type="button" class="btn">�α���</button></a>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <script>
        	
			$(function() {
		      		
		      		
		      		 
		      		$("#ok").click(function(){
		      	
		      			var password  = $("#password").val();
		      			var passwordcheck  = $("#passwordcheck").val();
		      			
		      			if(password == "") {
		      				alert("��й�ȣ�� �Է����ּ���");
		      				return false;
		      			}
		      			
		      			if(passwordcheck == "") {
		      				alert("��й�ȣ�� Ȯ�����ּ���");
		      				return false;
		      			} else if(passwordcheck != password) {
		      				alert("��й�ȣ�� ���� �ʽ��ϴ�.");
		      				return false;
		      			} 
		      		})
		      		})
        
        
        
        </script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
	</body>
</html>