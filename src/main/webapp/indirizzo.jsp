<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<%@ page import="java.util.*, servlet.Indirizzo"%>
<% Indirizzo indirizzo = (Indirizzo) session.getAttribute("indirizzo"); %>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
		<section class=""></section>
	</main>
	<div>
		<h2>I tuoi dati</h2>
		<form action="AddressServlet" name="login" method="get">
			<fieldset>					
				<p>Indirizzo <input type="text" placeholder="<%=indirizzo.getIndirizzo()%>" name="indirizzo"> </p>
				<p>Città <input type="text" placeholder="<%=indirizzo.getCitta()%>" name="citta"> </p>
				<p>Provincia <input type="text" placeholder="<%=indirizzo.getProvincia()%>" name="provincia"> </p>
				<p>CAP <input type="text" placeholder="<%=indirizzo.getCap()%>" name="cap"> </p>
				<p>Nazione 
					<select name="nazione">
						<option>-effettua una scelta-</option>
						<option>Italia<option>
					</select>	
				<input type="submit" value="Salva"> 
			</fieldset>
		</form>
	</div>
</body>
</html>