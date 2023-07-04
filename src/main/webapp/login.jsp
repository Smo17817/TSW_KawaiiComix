<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">
<%String status = (String) request.getAttribute("status");%>
<script type ="text/javascript">
	if('<%= status %>' == 'failed'){
		Swal.fire("Spiacente!", "Email o Password errati", "error");
	}
</script>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>	
	<main>
		<section id="login">
			<div id="login-img"><img src="./images/anya.jpg"/></div>
				<h3>Accedi al tuo account</h3>
				<form action="Login" name="login" method="POST" class="login-form" >
					<input type="email" name="email" placeholder="E-mail">
					<input type="password" name="password" placeholder="Password">
					<button type="submit">Invia</button>
				</form>
				<div class="links">
					<a href="richiestapassword.jsp">Hai dimenticato la password?</a>
					<p>Non sei iscritto? <a href="signup.jsp">Iscriviti!</a></p>	
				</div>	
		</section>
	</main>
</body>
</html>