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
		<div class="login">
			<h3>Accedi al tuo account</h3>
			<form action="" name="login" method="get">
				<fieldset>
					<input type=email placeholder="E-mail"> <br> 
					<input type=password placeholder="Password"> <br> 
					<input type="button" value="Accedi">
					<p> Hai dimenticato la password? 
					<a href="">Richiedi una nuova Password</a>
					</p>
				</fieldset>
			<p>
				Non sei iscritto? <a href="signup.jsp">Iscriviti</a>
			</p>
		</form>
	</div>
</body>
</html>