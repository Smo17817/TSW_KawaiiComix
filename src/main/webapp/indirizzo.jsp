<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<%@ page import="java.util.*,model.Indirizzo"%>
<% if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
 %>
<% Indirizzo indirizzo = (Indirizzo) session.getAttribute("indirizzo"); %>
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel ="stylesheet" href="alert/dist/sweetalert.css">
<%String status = (String) request.getAttribute("status");%>
<script type ="text/javascript">
	if('<%= status %>' == 'Invalid_address')
		swal("Spiacente!", "Inserire l'indirizzo", "error");
	else if('<%= status %>' == 'Invalid_citta')
		swal("Spiacente!", "Inserire nome città", "error");
	else if('<%= status %>' == 'Invalid_provincia')
		swal("Spiacente!", "Inserire nome provincia", "error");
	else if('<%= status %>' == 'Invalid_cap')
		swal("Spiacente!", "Inserire CAP valido", "error");
	else if('<%= status %>' == 'Invalid_nazione')
		swal("Spiacente!", "Inserire nazione", "error");
	else if('<%= status %>' == 'success')
		swal("Congratulazione!", "Dati registrati correttamente", "success");
	else if('<%= status %>' == 'failed')
		swal("Siamo spiacenti!", "Dati non registrati , reinserire", "error");

	
		
</script>
<body>
	<div class="justaimg">
		<jsp:include page="./Nav.jsp" flush="true"/>
		<main>
			<section id= "address-info">
				<div class="form-wrapper">
					<h2>I tuoi dati</h2>
					<form action="AddressServlet" name="login" method="get">
						<div class="form-row">
							<label for="indirizzo">Indirizzo:</label>		
							<input type="text"   id= "indirizzo" placeholder="<%=indirizzo.getIndirizzo()%>" name="indirizzo">
						</div>
						<div  class="form-row">
							<label for="citta">Città:</label>
							<input type="text" id ="citta" placeholder="<%=indirizzo.getCitta()%>" name="citta"> 
						</div>
						<div  class="form-row">
							<label for="provincia">Provincia:</label>
							<input type="text" id="provincia"placeholder="<%=indirizzo.getProvincia()%>" name="provincia"> 
						</div>
						<div  class="form-row">
							<label for="cap">CAP:</label>
							<input type="text" id="cap" placeholder="<%=indirizzo.getCap()%>" name="cap">
						</div>
						<div  class="form-row">
							<label for="nazione">Nazione:</label>
							<select name="nazione">
								<option>-effettua una scelta-</option>
								<option>Italia<option>
							</select>
						</div>
						<div class="sub-class">
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