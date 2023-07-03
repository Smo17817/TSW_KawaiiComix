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
		<section id="new_article">
			<form action="AddNewsServlet" method="POST">
				<div class="form-wrapper">
					<h2>Aggiungi un Articolo</h2>
					<div class="form-row">
						<label for="titolo">Titolo: </label> <input type="text"
							name="titolo" placeholder="Titolo" required>
					</div>
					<div class="form-row">
						<label for="sottotitolo">Sottotitolo: </label> <input type="text"
							name="sottotitolo" placeholder="Sottotitolo" required>
					</div>
					<div class="form-row">
						<label for="immagine">Immagine: </label> <input type="text"
							name="immagine" placeholder="./images/nome_img.formato">
					</div>
					<div class="form-row">
						<label for="video">Video: </label> <input type="text" name="video"
							placeholder="./video/nome_img.formato OPPURE youtube_link">
					</div>
					<div class="article">
						<textarea id ="corpo" name="corpo" placeholder="Scrivi qui il tuo articolo..."></textarea>
					</div>
					<div class="sub-class">
						<button type="submit">Aggiungi</button>
					</div>
				</div>
			</form>
		</section>
	</div>
<jsp:include page="./footer.jsp" flush="true" />
</body>
</html>