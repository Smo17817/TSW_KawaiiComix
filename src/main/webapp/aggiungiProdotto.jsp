<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, model.User"%>
<%
User user = (User) session.getAttribute("user");
if (user == null)
	response.sendRedirect("login.jsp");
%>
<jsp:include page="./header.jsp" flush="true" />
<body>
	<jsp:include page="./Nav.jsp" flush="true" />
	<div class="justaimg">
		<section id="new_product">
			<div class="form-wrapper">
				<form action="AddProductServlet" method="POST">
					<h2>Aggiungi un Prodotto</h2>
					<div class="form-row">
						<label for="isbn">ISBN: </label> <input type="text" name="isbn"
							placeholder="00000000000000000" required>
					</div>
					<div class="form-row">
						<label for="nome">Nome: </label> <input type="text" name="nome"
							required>
					</div>
					<div class="form-row">
						<label for="descrizione">Descrizione: </label> <input type="text"
							name="descrizione" required>
					</div>
					<div class="form-row">
						<label for="immagine">Immagine: </label> <input type="text"
							name="immagine" placeholder="./images/nome_img.formato" required>
					</div>
					<div class="form-row">
						<label for="prezzo">Prezzo: </label> <input type="number"
							step="0.01" min="0" name="prezzo" required>
					</div>
					<div class="form-row">
						<label for="quantita">Quantità: </label> <input type="number"
							min="0" name="quantita" required>
					</div>
					<div class="form-row">
						<label for="genere">Genere: </label> <input type="text"
							name="genere" required>
					</div>
					<div class="form-row">
						<label for="categoria">Categoria: </label> <input type="text"
							name="categoria" required>
					</div>
					<div class="sub-class">
						<button type="submit">Aggiungi</button>
					</div>
				</form>
			</div>
		</section>
	</div>
</body>
</html>