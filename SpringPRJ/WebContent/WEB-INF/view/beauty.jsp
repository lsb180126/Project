<%@page import="poly.dto.PagingDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.BeautyDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
%>
<%
	String keyword = CmmUtil.nvl( request.getParameter("keyword"),"");
	List<BeautyDTO> bList = (List<BeautyDTO>)request.getAttribute("bList");
	
	PagingDTO paging = (PagingDTO) request.getAttribute("paging");
	
	if (bList==null){
		bList = new ArrayList<BeautyDTO>();
		
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		


		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>beauty</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    
	    <style>
	    	
	    	* {
				  box-sizing: border-box;
				}
				
				/* Style the search field */
				form.example input[type=text] {
				  padding: 7px;
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
				  padding: 7px;
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
	    
	    #hmm1 {
		 	white-space: nowrap; 
		    overflow: hidden;
		    text-overflow: ellipsis;
		}
		#hmm2 {
			white-space: nowrap; 
		    overflow: hidden;
		    text-overflow: ellipsis;
		}
		.row div {
			text-overflow:ellipsis;
			overflow:hidden;
			white-space:nowrap;
			padding:16px 0;
			text-align:center;
		}
		.row {
			border-bottom: 1px solid #eeeeee;
		}
	    
	    
	    </style>
	    <script src="vendor/jquery/jquery.min.js"></script>
	    <script>
	   
		   $(function(){
			   
			   $("#search").click(function() {
				   
				   var keyword = $("#keyword").val();
				   
				   console.log(keyword);
				   location.href="beauty.do?keyword=" + keyword;
				   
				   
			   })
			   
		   })
	   
	   </script>
	   
	   <script type="text/javascript">
		
		
		function goPage(page){
			var pageCount = <%=paging.getPage_count()%>;
			location.href="/beauty.do?pageCount="+pageCount+"&pageNum="+page+"&keyword="+"<%=keyword%>";
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
	
	<div class="container table-hover">
      <div class="row">
        <div class="col-md-6">미용 정보</div>
				<div class="col-md-4">	
						<form class="example" action="/beauty.do" method="POST"  >
						  <input type="text" placeholder="Search.." name="keyword" id="keyword">
						  <button type="button" id="search"><i class="fa fa-search"></i></button>
						</form>
				</div>	
				<div class="col-md-2" style="text-align:right;"><a href="beautyregister.do"><input class="btn btn-outline-primary" type="button" value="등록"></a></div>	
			</div>			
				
				<div class="row" style="border-top: 1px solid black; border-bottom: 1px solid #989b9e;">	
					<div class="col-md-2">번호</div>
					<div class="col-md-4">제목</div>
					<div class="col-md-3">작성자</div>
					<div class="col-md-3">작성일</div>	
				</div>
				
				
				
				<% for(BeautyDTO b : bList) { %>
				<div class="row">
					
					<div class="col-md-2"><%=b.getBeautySeqNo() %></div>
					<div class="col-md-4"><a href="/beautydetail.do?beautySeqNo=<%=b.getBeautySeqNo() %>&pageCount=<%=paging.getPage_count()%>&pageNum=<%=paging.getPage_num()%>&keyword=<%=keyword%>"><%=b.getTitle() %></a></div>
					<div class="col-md-3"><%=b.getUserName() %></div>
					<div class="col-md-3"><%=b.getChgDt() %></div>
				</div>
				<% } %>
					
			<div class="layer"  style="padding:10px 0;">
					<div class="btn-group">
						<%=
							fnPaging(paging.getPage_count(), 10, paging.getPage_num(), paging.getTotal_count())
						%>
					</div>
			</div>
			
			
	 	</div>
      </div>
    </div>
     
    
    

    <!-- Bootstrap core JavaScript -->
    
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

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
			else pagingStr += "<input class='btn btn-outline-dark' type=button value="+i+" onclick='goPage("+i+");'>";
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
