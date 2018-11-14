<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>main</title>


    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    
    
   

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/full-slider.css" rel="stylesheet">

</head>
<body>
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">pet clinic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
           
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지</a>
              <div class="dropdown-menu dropdown-menu-right">
	              <a class="dropdown-item" href="#">회원정보</a>
	              <a class="dropdown-item" href="#">글 작성 목록</a>
              </div>
            </li>
            
            <li class="nav-item">
              <a class="nav-link" href="#">병원 찾기</a>
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
              <a class="nav-link" href="#">유용한 정보 </a>
            </li>
             <li class="nav-item active">
              <a class="nav-link" href="index.do">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="login.do">Login
             	 <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="register.do">Register
                <span class="sr-only">(current)</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
    
    <header>
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <!-- Slide One - Set the background image for this slide in the line below -->
          <div class="carousel-item active" style="background-image: url('https://postfiles.pstatic.net/20110214_264/qqaaww7_1297685783738ksUVq_PNG/B0ADBEC6C1F6BBE7C1F8_282629.png?type=w2')">
            <div class="carousel-caption d-none d-md-block">
              <h3></h3>
              <p></p>
            </div>
          </div>
          <!-- Slide Two - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('https://postfiles.pstatic.net/20160130_202/teamgk15_1454125394947nvCYk_PNG/2016-01-28_14%3B20%3B15.PNG?type=w1')">
            <div class="carousel-caption d-none d-md-block">
              <h3></h3>
              <p></p>
            </div>
          </div>
          <!-- Slide Three - Set the background image for this slide in the line below -->
          <div class="carousel-item" style="background-image: url('http://blogfiles.naver.net/20130422_246/wjdwo9636_136663826666053A9g_JPEG/%C5%E4%B3%A2%C0%C7%B1%CD1.jpg')">
            <div class="carousel-caption d-none d-md-block">
              <h3></h3>
              <p></p>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </header>

    <!-- Page Content -->
    <section class="py-5">
      <div class="container">
        <h1>환영합니다</h1>
        <p>pet clinic은 애완동물에 관한 정보를 제공하는 사이트입니다.</p>
      </div>
    </section>

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white"> &copy; pet clinic</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
	
</body>
</html>