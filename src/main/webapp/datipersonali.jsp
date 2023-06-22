<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, servlet.User" %>    
 <% if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
 %>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<div class="justaimg">
	<jsp:include page="./Nav.jsp" flush="true"/>
	<% User user = (User) session.getAttribute("user");%>
	<main>
      <section id="personal-info">
      		<div class="form-wrapper">
      			<form>
      			<h2>Informazioni personali</h2>
	   			<div class="form-row">
		      		<label for="nome">Nome:</label>
		      		<input type="text" id="nome" required placeholder="<%=user.getNome()%>"/>
	      		</div>
	      		<div class="form-row">
		      		<label for="cognome">Cognome:</label>
		      		<input type="text" id="cognome" required placeholder="<%=user.getCognome()%>"/>
	      		</div>
	      		<div class="form-row">
		      		<label for="email">Email:</label>
		      		<input type="email" id="email" required placeholder="<%=user.getEmail()%>"/>
	      		</div>
	      		<div class="form-row">
		      		<label for="password">Password:</label>
		      		<input type="password" id="password" required/>
	      		</div>
	      		<div class="form-row">
		      		<label for="conferma-pass">Conferma Password:</label>
		      		<input type="password" id="conferma-pass" required/>
	      		</div>
	      		<div class= "sub-class">
	      			<button type="submit">Invia</button>
      			</div>
   				</form>
   			</div>
   			
      </section>
	</main>
	</div>
</body>
</html>