<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
		<section class=""></section>
	</main>
	<div class="signup">
		<h3>Iscrizione</h3>
		<form method="get" action="Signup" name="signup">
			<fieldset>					
				<p>Nome <input type="text"> </p>
				<p>Cognome <input type="text"> </p>
				<p>E-mail <input type=email placeholder="E-mail"> </p>
				<p>Password <input type=password placeholder="Password"> 	
				<input type="submit" value="Salva"> 
			</fieldset>
			
			<p> Sei iscritto? <a href="login.jsp">Accedi</a>
		</form>
	</div>
</body>
</html>