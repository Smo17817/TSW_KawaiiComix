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
<title>Kawaii Comix</title>
</head>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
		<section class=""></section>
	</main>
	<div class="signup">
		<h3>Iscrizione</h3>
		<form action="" name="login" method="get">
			<fieldset>					
				<p>Nome <input type="text"> </p>
				<p>Cognome <input type="text"> </p>
				<p>E-mail <input type=email placeholder="E-mail"> </p>
				<p>Password <input type=password placeholder="Password"> 	
				<input type="button" value="Salva"> 
			</fieldset>
			
			<p> Sei iscritto? <a href="login.jsp">Accedi</a>
		</form>
	</div>
</body>
</html>