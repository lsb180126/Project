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
		
		


		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>keyword</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/cs	s/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	    
	    
	    
	    <style>
	    	
	    	* {
				  box-sizing: border-box;
				}
				
				/* Style the search field */
				form.example input[type=text] {
				  padding: 10px;
				  font-size: 17px;
				  border: 1px solid grey;
				  
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
				    border-bottom: none;
				}
				table.type01 td {
				    width: 350px;
				    padding: 10px;
				    vertical-align: top;
				    border-bottom: none;
				}
				
				.wrap {
				    position: absolute;
				    top: 40%;
				    left: 16%;
				    margin-top: -86px;
				    margin-left: -89px;
				    text-align: center;
				}
				
				a.button1 {
				    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    display: block;
				    margin: 20px auto;
				    max-width: 180px;
				    text-decoration: none;
				    border-radius: 4px;
				    padding: 20px 30px;
				}
				
				
				a.button1 {
				    color: rgba(30, 22, 54, 0.6);
				    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
				}
				
				a.button1:hover {
				    color: rgba(255, 255, 255, 0.85);
				    box-shadow: rgba(30, 22, 54, 0.7) 0 80px 0px 2px inset;
				}
				
				.wrap2 {
				    position: absolute;
				    top: 40%;
				    left: 50%;
				    margin-top: -86px;
				    margin-left: -89px;
				    text-align: center;
				}
				
				a.button2 {
				    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    display: block;
				    margin: 20px auto;
				    max-width: 180px;
				    text-decoration: none;
				    border-radius: 4px;
				    padding: 20px 30px;
				}
				
				a.button2 {
				    color: rgba(30, 22, 54, 0.6);
				    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
				}
				
				a.button2:hover {
				    color: rgba(255, 255, 255, 0.85);
				    box-shadow: rgba(30, 22, 54, 0.7) 0 80px 0px 2px inset;
				}
				
				.wrap3 {
				    position: absolute;
				    top: 80%;
				    left: 16%;
				    margin-top: -86px;
				    margin-left: -89px;
				    text-align: center;
				}
				
				a.button3 {
				    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    display: block;
				    margin: 20px auto;
				    max-width: 180px;
				    text-decoration: none;
				    border-radius: 4px;
				    padding: 20px 30px;
				}
				
				a.button3 {
				    color: rgba(30, 22, 54, 0.6);
				    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
				}
				
				a.button3:hover {
				    color: rgba(255, 255, 255, 0.85);
				    box-shadow: rgba(30, 22, 54, 0.7) 0 80px 0px 2px inset;
				}
				
				.wrap4 {
				    position: absolute;
				    top: 80%;
				    left: 50%;
				    margin-top: -86px;
				    margin-left: -89px;
				    text-align: center;
				}
				
				a.button4 {
				    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
				    display: block;
				    margin: 20px auto;
				    max-width: 180px;
				    text-decoration: none;
				    border-radius: 4px;
				    padding: 20px 30px;
				}
				
				a.button4 {
				    color: rgba(30, 22, 54, 0.6);
				    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
				}
				
				a.button4:hover {
				    color: rgba(255, 255, 255, 0.85);
				    box-shadow: rgba(30, 22, 54, 0.7) 0 80px 0px 2px inset;
				}

				
				
				/*----*/
				@import url(https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css);
				@import url(https://fonts.googleapis.com/css?family=Lato:300,400,700);
				
				
				.jumbotron h1 {
					color: #353535;
				}
				footer {
				  margin-bottom: 0 !important;
				  margin-top: 80px;
				}
				footer p {
				  margin: 0;
				  padding: 0;
				}
				span.icon {
					margin: 0 5px;
					color: #D64541;
				}
				h2 {
					color: #BDC3C7;
				  text-transform: uppercase;
				  letter-spacing: 1px;
				}
				.mrng-60-top {
					margin-top: 60px;
				}
				/* Global Button Styles */
				a.animated-button:link, a.animated-button:visited {
					position: relative;
					display: block;
					margin: 30px auto 0;
					padding: 14px 15px;
					color: #fff;
					font-size:14px;
					font-weight: bold;
					text-align: center;
					text-decoration: none;
					text-transform: uppercase;
					overflow: hidden;
					letter-spacing: .08em;
					border-radius: 0;
					text-shadow: 0 0 1px rgba(0, 0, 0, 0.2), 0 1px 0 rgba(0, 0, 0, 0.2);
					-webkit-transition: all 1s ease;
					-moz-transition: all 1s ease;
					-o-transition: all 1s ease;
					transition: all 1s ease;
				}
				a.animated-button:link:after, a.animated-button:visited:after {
					content: "";
					position: absolute;
					height: 0%;
					left: 50%;
					top: 50%;
					width: 150%;
					z-index: -1;
					-webkit-transition: all 0.75s ease 0s;
					-moz-transition: all 0.75s ease 0s;
					-o-transition: all 0.75s ease 0s;
					transition: all 0.75s ease 0s;
				}
				a.animated-button:link:hover, a.animated-button:visited:hover {
					color: #FFF;
					text-shadow: none;
				}
				a.animated-button:link:hover:after, a.animated-button:visited:hover:after {
					height: 450%;
				}
				a.animated-button:link, a.animated-button:visited {
					position: relative;
					display: block;
					margin: 30px auto 0;
					padding: 14px 15px;
					color: #fff;
					font-size:14px;
					border-radius: 0;
					font-weight: bold;
					text-align: center;
					text-decoration: none;
					text-transform: uppercase;
					overflow: hidden;
					letter-spacing: .08em;
					text-shadow: 0 0 1px rgba(0, 0, 0, 0.2), 0 1px 0 rgba(0, 0, 0, 0.2);
					-webkit-transition: all 1s ease;
					-moz-transition: all 1s ease;
					-o-transition: all 1s ease;
					transition: all 1s ease;
				}
				
				/* Victoria Buttons */
				
				a.animated-button.victoria-one {
					border: 2px solid #D24D57;
				}
				a.animated-button.victoria-one:after {
					background: #D24D57;
					-moz-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					-ms-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					-webkit-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					transform: translateX(-50%) translateY(-50%) rotate(-25deg);
				}
				a.animated-button.victoria-two {
					border: 2px solid #D24D57;
				}
				a.animated-button.victoria-two:after {
					background: #D24D57;
					-moz-transform: translateX(-50%) translateY(-50%) rotate(25deg);
					-ms-transform: translateX(-50%) translateY(-50%) rotate(25deg);
					-webkit-transform: translateX(-50%) translateY(-50%) rotate(25deg);
					transform: translateX(-50%) translateY(-50%) rotate(25deg);
				}
				a.animated-button.victoria-three {
					border: 2px solid #D24D57;
				}
				a.animated-button.victoria-three:after {
					background: #D24D57;
					opacity: .5;
					-moz-transform: translateX(-50%) translateY(-50%);
					-ms-transform: translateX(-50%) translateY(-50%);
					-webkit-transform: translateX(-50%) translateY(-50%);
					transform: translateX(-50%) translateY(-50%);
				}
				a.animated-button.victoria-three:hover:after {
					height: 140%;
					opacity: 1;
				}
				a.animated-button.victoria-four {
					border: 2px solid #D24D57;
				}
				a.animated-button.victoria-four:after {
					background: #D24D57;
					opacity: .5;
					-moz-transform: translateY(-50%) translateX(-50%) rotate(90deg);
					-ms-transform: translateY(-50%) translateX(-50%) rotate(90deg);
					-webkit-transform: translateY(-50%) translateX(-50%) rotate(90deg);
					transform: translateY(-50%) translateX(-50%) rotate(90deg);
				}
				a.animated-button.victoria-four:hover:after {
					opacity: 1;
					height: 600% !important;
				}
				/* Sandy Buttons */
				
				a.animated-button.sandy-one {
					border: 2px solid #AEA8D3;
					color: #FFF;
				}
				a.animated-button.sandy-one:after {
					border: 3px solid #AEA8D3;
					opacity: 0;
					-moz-transform: translateX(-50%) translateY(-50%);
					-ms-transform: translateX(-50%) translateY(-50%);
					-webkit-transform: translateX(-50%) translateY(-50%);
					transform: translateX(-50%) translateY(-50%);
					
				}
				a.animated-button.sandy-one:hover:after {
					height: 120% !important;
					opacity: 1;
					color: #FFF;
				}
				a.animated-button.sandy-two {
					border: 2px solid #AEA8D3;
					color: #FFF;
				}
				a.animated-button.sandy-two:after {
					border: 3px solid #AEA8D3;
					opacity: 0;
					-moz-transform: translateY(-50%) translateX(-50%) rotate(90deg);
					-ms-transform: translateY(-50%) translateX(-50%) rotate(90deg);
					-webkit-transform: translateY(-50%) translateX(-50%) rotate(90deg);
					transform: translateY(-50%) translateX(-50%) rotate(90deg);
				}
				a.animated-button.sandy-two:hover:after {
					height: 600% !important;
					opacity: 1;
					color: #FFF;
				}
				a.animated-button.sandy-three {
					border: 2px solid #AEA8D3;
					color: #FFF;
				}
				a.animated-button.sandy-three:after {
					border: 3px solid #AEA8D3;
					opacity: 0;
					-moz-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					-ms-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					-webkit-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					transform: translateX(-50%) translateY(-50%) rotate(-25deg);
				}
				a.animated-button.sandy-three:hover:after {
					height: 400% !important;
					opacity: 1;
					color: #FFF;
				}
				a.animated-button.sandy-four {
					border: 2px solid #AEA8D3;
					color: #FFF;
				}
				a.animated-button.sandy-four:after {
					border: 3px solid #AEA8D3;
					opacity: 0;
					-moz-transform: translateY(-50%) translateX(-50%) rotate(25deg);
					-ms-transform: translateY(-50%) translateX(-50%) rotate(25deg);
					-webkit-transform: translateY(-50%) translateX(-50%) rotate(25deg);
					transform: translateY(-50%) translateX(-50%) rotate(25deg);
				}
				a.animated-button.sandy-four:hover:after {
					height: 400% !important;
					opacity: 1;
					color: #FFF;
				}
				/* Gibson Buttons */
				
				a.animated-button.gibson-one {
					border: 2px solid #65b37a;
					color: #FFF;
				}
				a.animated-button.gibson-one:after {
					opacity: 0;
					background-image: -webkit-linear-gradient( transparent 50%, rgba(101,179,122,0.2) 50%);
					background-image: -moz-linear-gradient(transparent 50%, rgba(101,179,122,0.2) 50%);
					background-size: 10px 10px;
					-moz-transform: translateX(-50%) translateY(-50%) rotate(25deg);
					-ms-transform: translateX(-50%) translateY(-50%) rotate(25deg);
					-webkit-transform: translateX(-50%) translateY(-50%) rotate(25deg);
					transform: translateX(-50%) translateY(-50%) rotate(25deg);
				}
				a.animated-button.gibson-one:hover:after {
					height: 600% !important;
					opacity: 1;
					color: #FFF;
				}
				a.animated-button.gibson-two {
					border: 2px solid #65b37a;
					color: #FFF;
				}
				a.animated-button.gibson-two:after {
					opacity: 0;
					background-image: -webkit-linear-gradient( transparent 50%, rgba(101,179,122,0.2) 50%);
					background-image: -moz-linear-gradient(transparent 50%, rgba(101,179,122,0.2) 50%);
					background-size: 10px 10px;
					-moz-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					-ms-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					-webkit-transform: translateX(-50%) translateY(-50%) rotate(-25deg);
					transform: translateX(-50%) translateY(-50%) rotate(-25deg);
				}
				a.animated-button.gibson-two:hover:after {
					height: 600% !important;
					opacity: 1;
					color: #FFF;
				}
				a.animated-button.gibson-three {
					border: 2px solid #65b37a;
					color: #FFF;
				}
				a.animated-button.gibson-three:after {
					opacity: 0;
					background-image: -webkit-linear-gradient( transparent 50%, rgba(101,179,122,0.2) 50%);
					background-image: -moz-linear-gradient(transparent 50%, rgba(101,179,122,0.2) 50%);
					background-size: 10px 10px;
					-moz-transform: translateX(-50%) translateY(-50%) rotate(90deg);
					-ms-transform: translateX(-50%) translateY(-50%) rotate(90deg);
					-webkit-transform: translateX(-50%) translateY(-50%) rotate(90deg);
					transform: translateX(-50%) translateY(-50%) rotate(90deg);
				}
				a.animated-button.gibson-three:hover:after {
					height: 600% !important;
					opacity: 1;
					color: #FFF;
				}
				a.animated-button.gibson-four {
					border: 2px solid #65b37a;
					color: #FFF;
				}
				a.animated-button.gibson-four:after {
					opacity: 0;
					background-image: -webkit-linear-gradient( transparent 50%, rgba(101,179,122,0.2) 50%);
					background-image: -moz-linear-gradient(transparent 50%, rgba(101,179,122,0.2) 50%);
					background-size: 10px 10px;
					-moz-transform: translateX(-50%) translateY(-50%);
					-ms-transform: translateX(-50%) translateY(-50%));
					-webkit-transform: translateX(-50%) translateY(-50%);
					transform: translateX(-50%) translateY(-50%);
				}
				a.animated-button.gibson-four:hover:after {
					height: 600% !important;
					opacity: 1;
					color: #FFF;
				}
				/* Thar Buttons */
				
				a.animated-button.thar-one {
					color: #fff;
					cursor: pointer;
					display: block;
					position: relative;
					border: 2px solid #F7CA18;
					transition: all 0.4s cubic-bezier(0.215, 0.61, 0.355, 1) 0s;
				}
				a.animated-button.thar-one:hover {
					color: #000 !important;
					background-color: transparent;
					text-shadow: none;
				}
				a.animated-button.thar-one:hover:before {
					bottom: 0%;
					top: auto;
					height: 100%;
				}
				a.animated-button.thar-one:before {
					display: block;
					position: absolute;
					left: 0px;
					top: 0px;
					height: 0px;
					width: 100%;
					z-index: -1;
					content: '';
					color: #000 !important;
					background: #F7CA18;
					transition: all 0.4s cubic-bezier(0.215, 0.61, 0.355, 1) 0s;
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
				a.animated-button.thar-three {
					color: #fff;
					cursor: pointer;
					display: block;
					position: relative;
					border: 2px solid #F7CA18;
					transition: all 0.4s cubic-bezier(0.42, 0, 0.58, 1);
				0s;
				}
				a.animated-button.thar-three:hover {
					color: #000 !important;
					background-color: transparent;
					text-shadow: nthree;
				}
				a.animated-button.thar-three:hover:before {
					left: 0%;
					right: auto;
					width: 100%;
				}
				a.animated-button.thar-three:before {
					display: block;
					position: absolute;
					top: 0px;
					right: 0px;
					height: 100%;
					width: 0px;
					z-index: -1;
					content: '';
					color: #000 !important;
					background: #F7CA18;
					transition: all 0.4s cubic-bezier(0.42, 0, 0.58, 1);
				0s;
				}
				a.animated-button.thar-four {
					color: #fff;
					cursor: pointer;
					display: block;
					position: relative;
					border: 2px solid #F7CA18;
					transition: all 0.4s cubic-bezier(0.42, 0, 0.58, 1);
				0s;
				}
				a.animated-button.thar-four:hover {
					color: #000 !important;
					background-color: transparent;
					text-shadow: nfour;
				}
				a.animated-button.thar-four:hover:before {
					right: 0%;
					left: auto;
					width: 100%;
				}
				a.animated-button.thar-four:before {
					display: block;
					position: absolute;
					top: 0px;
					left: 0px;
					height: 100%;
					width: 0px;
					z-index: -1;
					content: '';
					color: #000 !important;
					background: #F7CA18;
					transition: all 0.4s cubic-bezier(0.42, 0, 0.58, 1);
				0s;
				}
				
	    </style>
	    <style>
	    	a.animated-button.thar-four, a.animated-button.thar-three, a.animated-button.thar-two, a.animated-button.thar-one {
	    		color:#a5a2af;
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
	
	
	<br/>
	
	<div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
        
			<!-- <table class="type01" style="width:90%">
			
			    <tr>
			        <th scope="row">키워드</th>
			    </tr>
			   
			    <tr>
			        <th scope="row" height="300">
			        	<div class="wrap">
			        		<a href="eat.do" class="button1">&nbsp;&nbsp;&nbsp;간식&nbsp;&nbsp;&nbsp;</a>
		        		</div>
			        </th>
			    </tr>
   			    <tr>
			        <th scope="row">
			        	<div class="wrap2">
			        		<a href="sell.do" class="button2">&nbsp;&nbsp;&nbsp;분양&nbsp;&nbsp;&nbsp;</a>
		        		</div>
			        </th>
			    </tr>
   			    <tr>
			        <th scope="row">
			        	<div class="wrap3">
			        		<a href="beauty.do" class="button3">&nbsp;&nbsp;&nbsp;미용&nbsp;&nbsp;&nbsp;</a>
		        		</div>
			        </th>
			    </tr>
				<tr>
			        <th scope="row">
			        	<div class="wrap4">
			        		<a href="homegoods.do" class="button4">생활용품</a>
		        		</div>
			        </th>
			    </tr>
			    
			   
			    
			  
			</table> -->

				<div class="container">
					<!-- Example row of columns -->
					<div class="row">
						<div class="col-md-12 text-center">
							<h2 class="mrng-60-top" style="color: #a5a2af; ">키워드</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<a href="eat.do" class="btn btn-sm animated-button thar-one">
								<i class="fas fa-dog" style="font-size: 48px;"></i>
								<span style="font-size:38px;">간식</span>
							</a>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<a href="sell.do" class="btn btn-sm animated-button thar-two">
							<i class="fas fa-home" style="font-size: 48px;"></i>
								<span style="font-size:38px;">분양</span>
							</a>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<a href="beauty.do" class="btn btn-sm animated-button thar-three">
							<i class="fas fa-cut" style="font-size: 48px;"></i>
							<span style="font-size:38px;">미용</span>
							</a>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<a href="homegoods.do" class="btn btn-sm animated-button thar-four">
							<i class="fas fa-boxes" style="font-size: 48px;"></i>
							<span style="font-size:38px;">생활용품</span>
							</a>
						</div>
					</div>
				</div>

			</div>
      </div>
    </div>
    

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>
</html>