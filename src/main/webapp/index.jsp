<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

 <jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>

	<section class="banner">
	<div class="slider">
				 <div class="content" id="slide1">
				<div class="textbox">
					<h2>Dragon Ball</h2>
					<p>Con la sua fusione unica di azione, umorismo e avventura, Dragon Ball è una serie senza tempo che ha conquistato il cuore di milioni di fan in tutto il mondo.<p>
					<a href="ProductServlet?isbn=12345678901234567"> Acquista ora</a>
				</div>
				<div class="imgbox">
					<img src="./images/db1.jpg" class="db">
				</div>
			</div>
			 <div class="content" id="slide2">
				<div class="textbox">
					<h2>One Piece</h2>
					<p> Imbarcati nell'incredibile mondo di One Piece e diventa parte dell'equipaggio di Monkey D. Luffy, un giovane pirata determinato a trovare il leggendario tesoro chiamato "One Piece".<p>
					<a href="ProductServlet?isbn=97889252856410000"> Acquista ora</a>
				</div>
				<div class="imgbox">
					<img src="./images/op1.jpg" class="db">
				</div>
			</div>
			<div class="content" id="slide3">
				<div class="textbox">
					<h2>Naruto</h2>
					<p> Entra nel mondo ninja di Naruto, un giovane combattente con un sogno ardente: diventare il miglior ninja del suo villaggio e guadagnarsi il rispetto di tutti.<p>
					<a href="ProductServlet?isbn=97835517625110000"> Acquista ora</a>
				</div>
				<div class="imgbox">
					<img src="./images/naruto1.jpg" class="db">
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
					<a href="CartServlet?isbn=12345678901234567"> Carrello</a>
				</div>
			</div>
			
			<div class="scheda">
				<a href="ProductServlet?isbn=12345678901234567"><img src="./images/db1.jpg"> </a> 
				<div class="info">	
					<h4> Dragon Ball </h4>
					<p> 5.45 </p>
					<a href="CartServlet?isbn=12345678901234567"> Carrello</a>
				</div>	
			</div>
			
			<div class="scheda">
				<a href="ProductServlet?isbn=97889252856410000"><img src="./images/op1.jpg"> </a>
				<div class="info">
					<h4> One Piece </h4>
					<p> 5.45 </p>
					<a href="CartServlet?isbn=97889252856410000"> Carrello</a>
				</div>
			</div>
	
		</div>
		
	</section>
</body>
</html>
