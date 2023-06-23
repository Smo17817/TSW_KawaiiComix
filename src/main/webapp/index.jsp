<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
	<section class="banner">
	<div class="slider">
		<div class="content" id="slide1">
			<div class="textbox">
				<h2>Dragon Ball</h2>
				<p> placeholder placeholder<p>
				<a href="ProductServlet?isbn=12345678901234567"> Acquista ora</a>
			</div>
			<div class="imgbox">
				<img src="./images/db1.jpg" class="db">
			</div>
		</div>
		<div class="content" id="slide2">
			<div class="textbox">
				<h2>One Piece</h2>
				<p> placeholder placeholder<p>
				<a href="ProductServlet?isbn=97889252856410000"> Acquista ora</a>
			</div>
			<div class="imgbox">
				<img src="./images/op1.jpg" class="db">
			</div>
		</div>
		<div class="content" id="slide3">
			<div class="textbox">
				<h2>Dragon Ball 3</h2>
				<p> placeholder placeholder<p>
				<a href="ProductServlet?isbn=12345678901234567"> Acquista ora</a>
			</div>
			<div class="imgbox">
				<img src="./images/db3.jpg" class="db">
			</div>
		</div>
	</div>	
	<div class="sliderNav">
		<a href="#slide1"></a>
		<a href="#slide2"></a>
		<a href="#slide3"></a>
	</div>
	</section>
	
	<section id="prodotti">
		<h2> Ultime Uscite </h2>
		<div class="schedeProdotto">
			<div class="scheda">
				<a href="ProductServlet?isbn=12345678901234567"><img src="./images/db1.jpg"> </a>
				<div class="info">
					<h4> Dragon Ball </h4>
					<p> 5.45 </p>
					<a href="#"> Carrello</a>
				</div>
			</div>
			
			<div class="scheda">
				<a href="ProductServlet?isbn=12345678901234567"><img src="./images/db1.jpg"> </a> 
				<div class="info">	
					<h4> Dragon Ball </h4>
					<p> 5.45 </p>
					<a href="#"> Carrello</a>
				</div>	
			</div>
			
			<div class="scheda">
				<a href="ProductServlet?isbn=12345678901234567"><img src="./images/db1.jpg"> </a>
				<div class="info">
					<h4> Dragon Ball </h4>
					<p> 5.45 </p>
					<a href="#"> Carrello</a>
				</div>
			</div>
	
		</div>
		
	</section>
</body>
</html>
