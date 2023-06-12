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
<link rel="stylesheet" href="./CSS/datipersonali.css">
<link rel="icon" href="./icons/Luffys_flag_2_icon-icons.com_76119.ico" />
<title>Kawaii Comix</title>
</head>
<body>
	<div class="justaimg">
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
      <section id="personal-info">
      		<div class="form-wrapper">
      			<form>
      			<h2>Informazioni personali</h2>
	   			<div class="nome-form">
		      		<label for="nome">Nome:</label>
		      		<input type="text" id="nome" required/>
	      		</div>
	      		<div class="cognome-form">
		      		<label for="cognome">Cognome:</label>
		      		<input type="text" id="cognome" required/>
	      		</div>
	      		<div class="email-form">
		      		<label for="email">Email:</label>
		      		<input type="email" id="email" required/>
	      		</div>
	      		<div class="pass-form">
		      		<label for="password">Password:</label>
		      		<input type="password" id="password" required/>
	      		</div>
	      		<div class="conf-pass-form">
		      		<label for="conferma-pass">Conferma Password:</label>
		      		<input type="password" id="conferma-pass" required/>
	      		</div>
   				</form>
   				<button type="submit">Invia</button>
   			</div>
   			
      </section>
	</main>
	</div>
</body>
</html>