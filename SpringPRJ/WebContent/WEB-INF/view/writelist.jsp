<%@page import="poly.dto.HomegoodsDTO"%>
<%@page import="poly.dto.BeautyDTO"%>
<%@page import="poly.dto.SellDTO"%>
<%@page import="poly.dto.EatDTO"%>
<%@page import="poly.dto.TalkDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="poly.dto.MemDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	List<TalkDTO> tList = (List<TalkDTO>)request.getAttribute("tList");
	
	if (tList==null){
		tList = new ArrayList<TalkDTO>();
		
	}
%>
<%
	List<EatDTO> eList = (List<EatDTO>)request.getAttribute("eList");
	
	if (eList==null){
		eList = new ArrayList<EatDTO>();
		
	}
%>
<%
	List<SellDTO> sList = (List<SellDTO>)request.getAttribute("sList");
	
	if (sList==null){
		sList = new ArrayList<SellDTO>();
		
	}
%>
<%
	List<BeautyDTO> bList = (List<BeautyDTO>)request.getAttribute("bList");
	
	if (bList==null){
		bList = new ArrayList<BeautyDTO>();
		
	}
%>
<%
	List<HomegoodsDTO> hList = (List<HomegoodsDTO>)request.getAttribute("hList");
	
	if (hList==null){
		hList = new ArrayList<HomegoodsDTO>();
		
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		


		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>write list</title>
	
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
	              <a class="dropdown-item" href="writelist.do">글 작성 목록</a>
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
        
			<table class="table">
				<tr>
					<td>작성 목록</td>
					<td>
						
					</td>
					
					<td></td>
					<td>
						
					</td>
					<td>
						
					</td>
					
					<td>
						
					</td>
				</tr>
				
				<% for(MemDTO m : mList) { %>
				<tr>
					<th>번호</th>
					<th>이름(병원/약국)</th>
					<th colspan="2">제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
				<tr>
					<td><%=m.getReviewSeqNo() %></td>
					<td><%=m.getReviewName() %></td>
					<td colspan="2"><a href="/writedetail.do?reviewSeqNo=<%=m.getReviewSeqNo() %>"><%=m.getTitle() %></a></td>
					<td><%=m.getUserName() %></td>
					<td><%=m.getChgDt() %></td>
				</tr>
				<% } %> 
				
				<% for(TalkDTO t : tList) { %>
				<tr>
					<th>번호</th>
					<th colspan="3">제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
				<tr>
					
					<td><%=t.getTalkSeqNo() %></td>
					<td colspan="3"><a href="/talkdetail2.do?talkSeqNo=<%=t.getTalkSeqNo() %>"><%=t.getTitle() %></a></td>
					<td><%=t.getUserName() %></td>
					<td><%=t.getChgDt() %></td>
				</tr>
				<% } %>
				
				<% for(EatDTO e : eList) { %>
				
				<tr>
					
					<td><%=e.getEatSeqNo() %></td>
					<td colspan="3"><a href="/eatdetail2.do?eatSeqNo=<%=e.getEatSeqNo() %>"><%=e.getTitle() %></a></td>
					<td><%=e.getUserName() %></td>
					<td><%=e.getChgDt() %></td>
				</tr>
				<% } %>	
				
				<% for(SellDTO s : sList) { %>
				<tr>
					
					<td><%=s.getSellSeqNo() %></td>
					<td colspan="3"><a href="/selldetail2.do?sellSeqNo=<%=s.getSellSeqNo() %>"><%=s.getTitle() %></a></td>
					<td><%=s.getUserName() %></td>
					<td><%=s.getChgDt() %></td>
				</tr>
				<% } %>
				
				<% for(BeautyDTO b : bList) { %>
				<tr>
					
					<td><%=b.getBeautySeqNo() %></td>
					<td colspan="3"><a href="/beautydetail2.do?beautySeqNo=<%=b.getBeautySeqNo() %>"><%=b.getTitle() %></a></td>
					<td><%=b.getUserName() %></td>
					<td><%=b.getChgDt() %></td>
				</tr>
				<% } %>
				
				<% for(HomegoodsDTO h : hList) { %>
				<tr>
					
					<td><%=h.getHomegoodsSeqNo() %></td>
					<td colspan="3"><a href="/homegoodsdetail2.do?homegoodsSeqNo=<%=h.getHomegoodsSeqNo() %>"><%=h.getTitle() %></a></td>
					<td><%=h.getUserName() %></td>
					<td><%=h.getChgDt() %></td>
				</tr>
				<% } %>
				
			</table>
			
	 	</div>
      </div>
    </div>
    
    
    

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>
</html>