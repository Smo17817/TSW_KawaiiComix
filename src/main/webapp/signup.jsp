<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
		<section id="signup">
		<div>		
			<h3>Iscrizione</h3>
			<form method="get" action="Signup" name="signup" class="signup-form">				
					<p>Nome <input type="text"> </p>
					<p>Cognome <input type="text"> </p>
					<p>E-mail <input type=email placeholder="E-mail"> </p>
					<p>Password <input type=password placeholder="Password"> 	
					<button type="submit">Salva</button> 
			
				<p> Sei iscritto? <a href="login.jsp">Accedi</a>
			</form>
		</div>
		</section>
	</main>
</body>
</html>