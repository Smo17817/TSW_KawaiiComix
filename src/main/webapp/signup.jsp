<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.12/dist/sweetalert2.all.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.12/dist/sweetalert2.min.css">
<%String status = (String) request.getAttribute("status");%>
<script type ="text/javascript">
	if('<%= status %>' == 'success'){
		alert("bravo");
	}
</script>
<body>
	<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
		<section id="signup">
		<div>		
			<h3>Iscrizione</h3>
			<form method="POST" action="SignupServlet" name="signup" class="signup-form">				
					<p>Nome <input type="text" name="nome"> </p>
					<p>Cognome <input type="text" name="cognome"> </p>
					<p>E-mail <input type=email placeholder="E-mail" name="email"> </p>
					<p>Password <input type=password placeholder="Password" name="password"> 	
					<button type="submit">Salva</button> 
			
				<p> Sei iscritto? <a href="login.jsp">Accedi</a>
			</form>
		</div>
		</section>
	</main>
</body>
</html>