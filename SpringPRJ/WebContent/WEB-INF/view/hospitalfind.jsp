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
		<title>hospital find</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	
    	<!-- Bootstrap core CSS -->
    	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    	<!-- Custom styles for this template -->
    	<link href="css/small-business.css" rel="stylesheet">
		
		
		
		
		
		
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
           
           
            
            <li class="nav-item">
              <a class="nav-link" href="hospitalfind.do">병원 찾기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">약국 찾기</a>
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
            
             
          </ul>
        </div>
      </div>
    </nav>
	
	<!-- Page Content -->
    <div class="container">
    
    

      <!-- Heading Row -->
      <div class="row my-4">
      
      <input type="text" id="sample5_address" placeholder="주소">
	  <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
	  <div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
      
      
      <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
      <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a4413e4e0e67bc463b4de3edc57e890&libraries=services"></script>
      <script>
			var container = document.getElementById('map');
			var options = {
				center: new daum.maps.LatLng(37.549868, 126.842262),
				level: 3
			};
	
			var map = new daum.maps.Map(container, options);
			
			var geocoder = new daum.maps.services.Geocoder(), // 좌표계 변환 객체를 생성합니다
		    
			//마커를 미리 생성
		    var marker = new daum.maps.Marker({
		        position: new daum.maps.LatLng(37.549868, 126.842262),
		        map: map
		    });
			
			function sample5_execDaumPostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var fullAddr = data.address; // 최종 주소 변수
		                var extraAddr = ''; // 조합형 주소 변수

		                // 기본 주소가 도로명 타입일때 조합한다.
		                if(data.addressType === 'R'){
		                    //법정동명이 있을 경우 추가한다.
		                    if(data.bname !== ''){
		                        extraAddr += data.bname;
		                    }
		                    // 건물명이 있을 경우 추가한다.
		                    if(data.buildingName !== ''){
		                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                    }
		                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
		                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
		                }

		                // 주소 정보를 해당 필드에 넣는다.
		                document.getElementById("sample5_address").value = fullAddr;
		                // 주소로 상세 정보를 검색
		                geocoder.addressSearch(data.address, function(results, status) {
		                    // 정상적으로 검색이 완료됐으면
		                    if (status === daum.maps.services.Status.OK) {

		                        var result = results[0]; //첫번째 결과의 값을 활용

		                        // 해당 주소에 대한 좌표를 받아서
		                        var coords = new daum.maps.LatLng(result.y, result.x);
		                        // 지도를 보여준다.
		                        mapContainer.style.display = "block";
		                        map.relayout();
		                        // 지도 중심을 변경한다.
		                        map.setCenter(coords);
		                        // 마커를 결과값으로 받은 위치로 옮긴다.
		                        marker.setPosition(coords)
		                    }
		                });
		            }
		        }).open();
		    }
			
		</script>
		
       <!--  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
        
        services 라이브러리 불러오기
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
		
		services와 clusterer, drawing 라이브러리 불러오기
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script> -->
       
      </div>
     
      

      

      </div>

    

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
  



</body>
</html>