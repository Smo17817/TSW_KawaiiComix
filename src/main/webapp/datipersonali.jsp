<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.User" %>    
 <% if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
 %>
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel ="stylesheet" href="alert/dist/sweetalert.css">
<%String status = (String) request.getAttribute("status");%>
<script type ="text/javascript">
	if('<%= status %>' == 'Invalid_nome')
		swal("Spiacente!", "Inserire nome ", "error");
	else if('<%= status %>' == 'Invalid_cognome')
	swal("Spiacente!", "Inserire cognome", "error");
	else if('<%= status %>' == 'Invalid_email')
		swal("Spiacente!", "Inserire email", "error");
	else if('<%= status %>' == 'Invalid_password')
		swal("Spiacente!", "Inserire password", "error");
	else if('<%= status %>' == 'Invalid_password2')
		swal("Spiacente!", "Le password non combaciano", "error");
	else if('<%= status %>' == 'success')
		swal("Congratulazione!", "Dati registrati correttamente", "success");
	else if('<%= status %>' == 'failed')
		swal("Siamo spiacenti!", "Dati non registrati , reinserire", "error");
	
</script>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<div class="justaimg">
	<jsp:include page="./Nav.jsp" flush="true"/>
	<% User user = (User) session.getAttribute("user");%>
	<main>
      <section id="personal-info">
      		<div class="form-wrapper">
      			<form action="DatiPersonaliServlet" method="POST">
      			<h2>Informazioni personali</h2>
	   			<div class="form-row">
		      		<label for="nome">Nome:</label>
		      		<input type="text" id="nome" name="nome"  placeholder="<%=user.getNome()%>"/>
	      		</div>
	      		<div class="form-row">
		      		<label for="cognome">Cognome:</label>
		      		<input type="text" id="cognome" name="cognome"  placeholder="<%=user.getCognome()%>"/>
	      		</div>
	      		<div class="form-row">
		      		<label for="email">Email:</label>
		      		<input type="email" id="email"name="email"  placeholder="<%=user.getEmail()%>"/>
	      		</div>
	      		<div class="form-row">
		      		<label for="password">Password:</label>
		      		<input type="password" id="password" name="password1" />
	      		</div>
	      		<div class="form-row">
		      		<label for="conferma-pass">Conferma Password:</label>
		      		<input type="password" id="conferma-pass" name="password2" />
	      		</div>
	      		<div class= "sub-class">
	      			<button type="submit">Invia</button>
      			</div>
   				</form>
   			</div>
   			
      </section>
	</main>
	</div>
<jsp:include page="./footer.jsp" flush="true"/>
</body>
</html>