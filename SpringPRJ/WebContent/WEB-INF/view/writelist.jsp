<%@page import="poly.dto.AllDTO"%>
<%@page import="poly.dto.PagingDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="poly.dto.MemDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
	PagingDTO paging = (PagingDTO) request.getAttribute("paging");
	
%>
<%
	
	List<AllDTO> aList = (List<AllDTO>)request.getAttribute("aList");
	
	if (aList==null){
		aList = new ArrayList<AllDTO>();
		
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
	    
	    .layer {text-align:center; }
	    
	    .row > .col-3, .row > .col-2 {
		    text-overflow: ellipsis;
		    overflow: hidden;
		    white-space: nowrap;
		    font-size: 17px;
	    }
	    
	    .row > .col-1 {
	    	font-size: 12px;
	    }
	    .row {
	    	padding: 10px 0;
	    }
	    </style>
	    
	     <script type="text/javascript">
		
		
		function goPage(page){
			var pageCount = <%=paging.getPage_count()%>;
			location.href="/writelist.do?pageCount="+pageCount+"&pageNum="+page;
		}
	   
	   
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
	
	
	<br/>
	
	<div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
        
				<table class="table table-hover" style="table-layout-fixed">
					<tr>
						<th scope="row" colspan="2">작성 목록</th>
						<td>
							
						</td>
						
						
						<td>
							
						</td>
						<td>
							
						</td>
						
						<td>
							
						</td>
				</tr>
				
				<tr style="border-bottom:2px solid #dee2e6;">
				
						<th>게시판 이름</th>
						<th>게시판 번호</th>
						<th colspan="2">제목</th>
						<th>작성일</th>
						<th>이름(병원/약국)</th>
						
				</tr>
				
				<% for(AllDTO a : aList) { %>
				<tr>
					<td><%=a.getBoardName() %></td>
					<td width="100" style="text-overflow:ellipsis; overflow:hidden; width: 110px;"><%=a.getReviewSeqNo() %></td>
					<td colspan="2" width="100" style="text-overflow:ellipsis; overflow:hidden">
						<%if(("리뷰").equals(a.getBoardName())) { %>
							<a href="/writedetail.do?reviewSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("자유토크").equals(a.getBoardName())) { %>
							<a href="/talkdetail2.do?talkSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("간식").equals(a.getBoardName())) { %>
							<a href="/eatdetail2.do?eatSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("분양").equals(a.getBoardName())) { %>
							<a href="/selldetail2.do?sellSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("미용").equals(a.getBoardName())) { %>
							<a href="/beautydetail2.do?beautySeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("생활용품").equals(a.getBoardName())) { %>
							<a href="/homegoodsdetail2.do?homegoodsSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} %>
						<%=a.getTitle() %>
						
					</td>
					
					<td><%=a.getChgDt() %></td>
					<td width="100" style="text-overflow:ellipsis; overflow:hidden;  width: 140px;"><%=( (a.getReviewName() == null) ? " " : a.getReviewName())%><td>
				</tr>
				<% } %> 
						
				<!-- <div class="row">
					<div class="col-2">게시판 이름</div>
					<div class="col-2">게시판 번호</div>
					<div class="col-3">제목</div>
					
					<div class="col-2">작성일</div>
					<div class="col-3">이름(병원/약국)</div>
				</div> -->
				<%-- <% for(AllDTO a : aList) { %>
				<div class="row">
					<div class="col-2"><%=a.getBoardName() %></div>
					<div class="col-2"><%=a.getReviewSeqNo() %></div>
					<div class="col-3">
						<%if(("리뷰").equals(a.getBoardName())) { %>
							<a href="/writedetail.do?reviewSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("자유토크").equals(a.getBoardName())) { %>
							<a href="/talkdetail2.do?talkSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("간식").equals(a.getBoardName())) { %>
							<a href="/eatdetail2.do?eatSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("분양").equals(a.getBoardName())) { %>
							<a href="/selldetail2.do?sellSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("미용").equals(a.getBoardName())) { %>
							<a href="/beautydetail2.do?beautySeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} else if( ("생활용품").equals(a.getBoardName())) { %>
							<a href="/homegoodsdetail2.do?homegoodsSeqNo=<%=a.getReviewSeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>">
						<%} %>
						<%=a.getTitle() %>
						</a>
					</div>
					
					<div class="col-2"><%=a.getChgDt() %></div>
					<div class="col-3"><%=( (a.getReviewName() == null) ? " " : a.getReviewName())%></div>
				</div>
				<% } %>  --%>
				
				
				
				
			</table>
			
	 	</div>
      </div>
    </div>
    <div class="layer">
    	<div class="btn-group">
		<%=
			fnPaging(paging.getPage_count(), 10, paging.getPage_num(), paging.getTotal_count())
		 %>
		 </div>
	</div>
    
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<br/>
  </body>
</html>

<%!
	//페이지num, 전체Data count만 전달받아 출력.
	private String fnPaging(int pageNum, int totalCount){
		int pageCount = 10; // 페이지별 출력 row 수
	 int blockCount = 10; // 화면에 출력할 block 수
	 return fnPaging(pageCount, blockCount, pageNum, totalCount);
	}
	//pageCount, blockCount, pageNum, totalCount 를 전달받아 출력.
	private String fnPaging(int pageCount, int blockCount, int pageNum, int totalCount){
		
		String pagingStr = "";
		
		// 전체 페이지수
		int totalPageCount = totalCount / pageCount; // 전체 페이지 수
		if(totalCount % pageCount > 0) totalPageCount ++ ; // 전체 페이지수+1 (나머지가 있을 경우.)
		
		// 전체 블럭수
		int totalBlockCount = totalPageCount / blockCount; // 전체 블럭수
		if(totalBlockCount % blockCount > 0) totalBlockCount ++ ; // 전체 블럭수+1 (나머지가 있을 경우.)
		
		// 현재 블럭의 시작 페이지
		int startPage = pageNum / blockCount * blockCount + 1;
		if(pageNum % blockCount == 0) startPage -= blockCount;
		
		// 현재 블럭의 마지막 페이지.
		int endPage = startPage + blockCount - 1;
		if(endPage > totalPageCount) endPage = totalPageCount;
		
		//만약 현재 블럭의 시작 페이지가 1보다 크다면. 이전 블럭 . 처음 블럭 버튼 생성.
		if(startPage > 1){
			//pagingStr = "[<<1][<"+(startPage-1)+"]";
			pagingStr =  "<input class='btn btn-outline-dark' type=button value=<< onclick='goPage(1);'>";
			pagingStr += "<input class='btn btn-outline-dark' type=button value=<  onclick='goPage("+(startPage-1)+");'>";
		}
		
		for(int i = startPage ; i <= endPage ; i++){
			
			if(i == pageNum )pagingStr += "<input class='btn btn-outline-dark' type='button' value='현재'>";
			//else pagingStr += "["+i+"]";
			else pagingStr += "<input class='btn btn-outline-dark' type='button' value="+i+" onclick='goPage("+i+");'>";
		}
		
		//만약 현재 블럭의 마지막 페이지가 전체 마지막 페이지보다 작다면. 다음블럭, 마지막 블럭 버튼 생성. 
		if(endPage < totalPageCount){
			//pagingStr += "[>"+(endPage+1)+"][>>"+totalPageCount+"]";
			pagingStr += "<input class='btn btn-outline-dark' type=button value='>'  onclick='goPage("+(endPage+1)+");'>";
			pagingStr += "<input class='btn btn-outline-dark' type=button value='>>' onclick='goPage("+totalPageCount+");'>";
		}
		
		return pagingStr;
	}
%>