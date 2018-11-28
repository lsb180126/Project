<%@page import="poly.dto.PharmacyDTO"%>
<%@page import="poly.dto.HospitalDTO"%>
<%@page import="java.util.List"%>
<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = CmmUtil.nvl((String)session.getAttribute("id"));
	List<PharmacyDTO> pList = (List<PharmacyDTO>)request.getAttribute("pList"); 

%>
<!DOCTYPE html>

<html>

	<head>
	
		<meta charset="UTF-8">
		<title>pharmacy find</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta name="description" content="">
    	<meta name="author" content="">
		<!-- Bootstrap core JavaScript -->
	    <script src="vendor/jquery/jquery.min.js"></script>
	    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    	<!-- Bootstrap core CSS -->
    	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    	<!-- Custom styles for this template -->
    	<link href="css/small-business.css" rel="stylesheet">
		<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a4413e4e0e67bc463b4de3edc57e890&libraries=services"></script>
		<style>
			.wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
			.wrap * {padding: 0;margin: 0;}
			.wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
			.wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
			.info .title {padding: 5px 0 0 10px;height: 36px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
			.info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
			.info .close:hover {cursor: pointer;}
			.info .body {position: relative;overflow: hidden;}
			.info .desc {position: relative; margin: 27px 0px; height: 37px;}
			.desc .ellipsis {overflow: hidden;text-overflow: ellipsis; white-space: nowrap;}
			.desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
			.info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
			.info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
			.info .link {color: #5085BB;}
			table.type01 {
			    border-collapse: collapse;
			    text-align: left;
			    line-height: 1.5;
			    margin : 20px 10px;
			}
			table.type01 th {
			    width: 150px;
			    padding: 10px;
			    font-weight: bold;
			    vertical-align: top;
			    border: 1px solid #ccc;
			}
			table.type01 td {
			    width: 900px;
			    padding: 10px;
			    vertical-align: top;
			    border: 1px solid #ccc;
			}
		</style>
		
	</head>
	
<body>

	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
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
	
	<!-- Page Content -->
    <div class="container">
    
    

      <!-- Heading Row -->
      <div class="row my-4">
      <form action="/pharmacySearch.do" method="post">
	      <input type="text" name="address" placeholder="주소검색" style="width:500px;">
		  <input type="submit" value="검색"><br><br/>
	  </form>
	  
	  <div id="map" style="width:100%;height:350px;"></div>
 	  <!-- <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> -->
     
       <!--  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
        
        services 라이브러리 불러오기
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
		
		services와 clusterer, drawing 라이브러리 불러오기
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script> -->
       
      </div>
     
      <% for (PharmacyDTO pDTO : pList) {%>
      
      <table class="type01">
	    <tr>
	        <th scope="row">약국 이름</th>
	        <td><%=pDTO.getPharmacyName() %></td>
	    </tr>
	    <tr>
	        <th scope="row">전화번호</th>
	        <td><%=pDTO.getPharmacyPhone() %></td>
	    </tr>
	    <tr>
	        <th scope="row">주소</th>
	        <td><%= "".equals(pDTO.getPharmacyAllAddress()) ? pDTO.getPharmacyRodAddress() : pDTO.getPharmacyAllAddress() %></td>
	    </tr>
	</table> 
      
      <%-- <br/><%=pDTO.getPharmacyAllAddress() %> 
      <br/><%=pDTO.getPharmacyName() %>
      <br/><%=pDTO.getPharmacyPhone() %>
      <br/><%=pDTO.getPharmacyPosition1() %>
      <br/><%=pDTO.getPharmacyPosition2() %>
      <br/><%=pDTO.getPharmacyRodAddress() %>
      <br/><%=pDTO.getPharmacySituation() %> --%>
      
      <hr/>
      
      
      <% } %>

      

      </div>

    

    



</body>


		<script>
		
		
		
		
		
		
		//////////////////////////////////////////////////////////
		<% for (int i = 0; i < pList.size(); i++) { %>
			var coords<%=i%> = new daum.maps.Coords(<%=pList.get(i).getPharmacyPosition1()%> * 2.5, <%=pList.get(i).getPharmacyPosition2()%> * 2.5);
		<%}%>
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	    mapOption = { 
	        center: new daum.maps.Coords(coords0.getX(), coords0.getY()), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };

		var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		
		
		// 마커를 표시할 위치와 title 객체 배열입니다 
		var positions = [
			<% for (int i = 0; i < pList.size(); i++) { %>
		    {
		        title: '<%=pList.get(i).getPharmacyName()%>', 
		        address: '<%= "".equals(pList.get(i).getPharmacyAllAddress()) ? pList.get(i).getPharmacyRodAddress() : pList.get(i).getPharmacyAllAddress() %>',
		        latlng: new daum.maps.Coords(coords<%=i%>.getX(),  coords<%=i%>.getY())
		    },
		    <% } %>
		];
	
		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		
		positions.forEach(function(pos) {

			  // 중략
	
			 var marker = new daum.maps.Marker({
	
			        map: map, // 마커를 표시할 지도
	
			        position: pos.latlng // 마커의 위치
	
			    });
	
			  var customOverlay = new daum.maps.CustomOverlay({
	
			    position: pos.latlng
	
			  });
	
			    // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
	
			    daum.maps.event.addListener(marker, 'click', function() {
	
			        customOverlay.setMap(map);
	
			    });
	
	
			  var wrap = document.createElement('div');
	
			  wrap.classList.add("wrap");
	
			  var info = document.createElement('div');
	
			  info.classList.add("info");
	
			  wrap.appendChild(info);
	
	
			  var title = document.createElement('div');
	
			  title.classList.add("title");
	
			  info.appendChild(title);
	
			  title.appendChild(document.createTextNode(pos.title));  
	
	
			  var body = document.createElement('div');
	
			  body.classList.add("body");
	
			  info.appendChild(body);
	
	
			  var desc = document.createElement('div');
			  
			  desc.classList.add("desc");
	
			  body.appendChild(desc);
	
			    
			  var ellipsis = document.createElement('div');
	
			  ellipsis.classList.add("desc");
	
			  ellipsis.appendChild(document.createTextNode(pos.address));  
			  
			  desc.appendChild(ellipsis);
	
	
			  var close = document.createElement('div');
	
			  close.classList.add("close");
	
			  close.onclick = function() { customOverlay.setMap(null); };
	
	
			  title.appendChild(close);
	
			  
			  customOverlay.setContent(wrap);
	
			  customOverlay.setMap(map);


			});
		
		
		
		
		
		
		</script>
</html>
