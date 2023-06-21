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
	<section id ="signup">
 			<div id="signup-img"><img src="./images/anya-signup.png"/></div>
 			<form  action = "" method = "POST" class = "signup-form">
 			<h3>Iscrizione</h3>
 			<div class="form-row">
 		      		<label for="nome">Nome:</label>
 		      		<input type="text" id="nome" required placeholder="Nome"/>
 	      		</div>
 	      		<div class="form-row">
 		      		<label for="cognome">Cognome:</label>
 		      		<input type="text" id="cognome" required placeholder="Cognome"/>
 	      		</div>
 	      		<div class="form-row">
 		      		<label for="email">Email:</label>
 		      		<input type="email" id="email" required placeholder="E-mail"/>
 	      		</div>
 	      		<div class="form-row">
 		      		<label for="password">Password:</label>
 		      		<input type="password" id="password" required placeholder="Password"/>
 	      		</div>
 	      		<div class= "sub-class">
 	      			<button type="submit">Invia</button>
       			</div>
    			</form>
 		</section>
 	</main>
	</main>
</body>
</html>