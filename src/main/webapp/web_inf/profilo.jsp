<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name=" description" content="Vendita Manga al Dettaglio" />
<meta name="robots" content="index,follow" />
<link rel="stylesheet" href="./CSS/profilo.css" />
<title>Kawaii Comix</title>
</head>
<body>
	<div class="justaimg">
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
		<section class="mid">
			<img  id="maschotte" src="./images/luffy.png">
			<div class="account">
				<h2>Il mio Account</h2>
				<ul>
					<li><img src= "./icons/profile.ico"><a href="datipersonali.jsp"> 
							 Dati porcodio
					</a></li>
					<li><img src="./icons/address.ico"><a href="indirizzo.jsp">
							Indirizzo
					</a></li>
					<li><img src="./icons/cart.ico"><a href="carrello.jsp"> 
							Carrello
					</a></li>
					<li><img src="./icons/calendar.ico"> <a href="">
							miei Ordini
					</a></li>
					<li><img src="./icons/exit.ico"><a href=""> Esci
					</a></li>
				</ul>
			</div>
			</section>
		</div>
	</main>
</body>
</html>