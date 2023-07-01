<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.User, model.Prodotto"%> 

<jsp:include page="./header.jsp" flush="true"/>
<body>
<jsp:include page="./Nav.jsp" flush="true"/>
<script src="./Script/dynamicCode.js"></script>
<script>
		document.addEventListener("DOMContentLoaded", dynamicIndex("<%=request.getContextPath()%>/IndexServlet"));
</script>
<main>
	<section class="banner">
	<div class="slider">
			<div class="content" id="slide1">
				<div class="textbox">
					<h2>Dragon Ball</h2>
					<p>Con la sua fusione unica di azione, umorismo e avventura, Dragon Ball è una serie senza tempo che ha conquistato il cuore di milioni di fan in tutto il mondo.<p>
					<a href="ProductServlet?isbn=10000000000000001"> Acquista ora</a>
				</div>
				<div class="imgbox">
					<img src="./images/db1.jpg" class="db">
				</div>
			</div>
			 <div class="content" id="slide2">
				<div class="textbox">
					<h2>One Piece</h2>
					<p> Imbarcati nell'incredibile mondo di One Piece e diventa parte dell'equipaggio di Monkey D. Luffy, un giovane pirata determinato a trovare il leggendario tesoro chiamato "One Piece".<p>
					<a href="ProductServlet?isbn=10000000000000006"> Acquista ora</a>
				</div>
				<div class="imgbox">
					<img src="./images/op1.jpg" class="db">
				</div>
			</div>
			<div class="content" id="slide3">
				<div class="textbox">
					<h2>Naruto</h2>
					<p> Entra nel mondo ninja di Naruto, un giovane combattente con un sogno ardente: diventare il miglior ninja del suo villaggio e guadagnarsi il rispetto di tutti.<p>
					<a href="ProductServlet?isbn=10000000000000004"> Acquista ora</a>
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
		<div id="schedeProdotto">
			
		</div>
	</section>
</main>	
	
<jsp:include page="./footer.jsp" flush="true"/>
</body>
</html>
