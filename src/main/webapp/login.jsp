<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>	
	<main>
		<section id="login">
			<div id="login-img"><img src="./images/anya.jpg"/></div>
			<h3>Accedi al tuo account</h3>
				<form action="Login" name="login" method="POST" class="login-form" >
						<input type="email" placeholder="E-mail" name="email">
						<input type="password" placeholder="Password" name="password">
						<button type="submit">Invia</button>
				</form>
				<div class="links">
						<p> <a href="">Hai dimenticato la password?</a> </p>
						<p>Non sei iscritto? <a href="signup.jsp">Iscriviti!</a></p>	
				</div>	
			</section>
		</main>
	</body>
</html>