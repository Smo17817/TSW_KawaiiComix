<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, model.User"%> 
<%	
	User user = (User) session.getAttribute("user");
  	if(user == null)
		response.sendRedirect("login.jsp");
 %>
<jsp:include page="./header.jsp" flush="true" />

<body>
<jsp:include page="./Nav.jsp" flush="true"/>
<script src="./Script/dynamicCode.js"></script>
<script>

	document.addEventListener("DOMContentLoaded", dynamicModificaProdotto("<%=request.getContextPath()%>/NameServlet")); 	

</script>
	<section id="new_product">
		<div class="form-wrapper">
			<form enctype ="multipart/form-data" action="EditProductServlet" method="GET">
				<h2>Modifica un Prodotto</h2>
				<div class="form-row">
					<label for="scelta">Prodotto: </label>
					<select id="chooseProduct" name="scelta" required>
						
					</select>
				</div>
				<div class="form-row">
					<label for="nome">Nome: </label>
					<input type="text" name="nome" required>
				</div>
				<div class="form-row">
					<label for="descrizione">Descrizione: </label>
					<textarea id ="descrizione" name="descrizione"></textarea>
				</div>
				<div class="form-row">
					<label for="immagine">Immagine: </label>
					<input type="text" name="immagine" placeholder="./images/nome_img.formato" required>
				</div>
				<div class="form-row">
					<label for="prezzo">Prezzo: </label>
					<input type="number" step="0.01" min="0" name="prezzo" required>
				</div>
				<div class="form-row">
					<label for="quantita">Quantità: </label>
					<input type="number" min="0" name="quantita" required>
				</div>
				<div class="form-row">
					<label for="genere">Genere: </label>
					<select name="genere" required>
						<option>-scegliere genere-</option>
						<option>Avventura</option>
						<option>Azione</option>
						<option>Combattimento</option>
						<option>Commedia</option>
						<option>Crimine</option>
						<option>Drammatico</option>
						<option>Fantascienza</option>
						<option>Fantastico</option>
						<option>Fantasy</option>
						<option>Gang Giovanili</option>
						<option>Giallo</option>
						<option>Guerra</option>
						<option>Horror</option>
						<option>Magia</option>
						<option>Mecha</option>
						<option>Mistero</option>
						<option>Musicale</option>
						<option>Poliziesco</option>
						<option>Psicologico</option>
						<option>Scolastico</option>
						<option>Sentimentale</option>
						<option>Sportivo</option>
						<option>Storico</option>
						<option>Supereroi</option>
						<option>Thriller</option>					
					</select>
				</div>
				<div class="form-row">
					<label for="categoria">Categoria: </label>
						<select name="categoria" required>
							<option>-scegliere categoria-</option>
							<option>Art Book</option>
							<option>Character Book</option>
							<option>Josei</option>
							<option>Kodomo</option>
							<option>Manga</option>
							<option>Manga Italiani</option>
							<option>Manhwa</option>
							<option>Novel</option>
							<option>Seinen</option>
							<option>Shoujo</option>
							<option>Shoujo-Ai</option>
							<option>Shonen</option>
							<option>Web Comic</option>	
							<option>Manga Magazine</option>			
					</select>
				</div>
				<div class="sub-class"> 
					<button type="submit">Modifica</button>
				</div>
			</form>
		</div>
	</section>
<jsp:include page="./footer.jsp" flush="true" />
</body>
</html>