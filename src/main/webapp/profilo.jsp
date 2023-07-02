<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.User"%>
<%
User user = (User) session.getAttribute("user");
int flag = 0;
if (user == null)
	response.sendRedirect("login.jsp");
else if (user.getId() == 1) {
	flag = 1;
}
%>
<jsp:include page="./header.jsp" flush="true" />
<body>
	<script>
		let id =<%=flag%>;
		if (id == 1) {
			$(document).ready(function() {
				let contenutoHtml = '';
				contenutoHtml += '<li> <img class=\"adimg\" src="./icons/upload.ico"> <a href="aggiungiProdotto.jsp"> Aggiungi Prodotto <p> (ADMIN) </p></a> </li>';
				contenutoHtml += '<li> <img class=\"adimg\" src="./icons/news.ico"> <a href="aggiungiNovita.jsp"> Aggiungi Notizie <p> (ADMIN) </p></a> </li>';
				contenutoHtml += '<li> <img class=\"adimg\" src="./icons/logistic.ico"> <a href="CheckOrders"> Controlla Ordini <p> (ADMIN) </p> </a> </li>';
				document.getElementById("admin").innerHTML = contenutoHtml;
			});
		}
	</script>

	<div class="justaimg">
		<jsp:include page="./Nav.jsp" flush="true" />
		<section class="mid">
			<h2>Il mio Account</h2>
			<div class="banner">
				<video autoplay>
    				<source src="./video/banner.mp4" type="video/mp4">
 	 			</video>
			</div>
			<div class="account">
				<ul>
					<li><img class="proimg" src="./icons/profile.ico"><a
						href="datipersonali.jsp"> Dati personali </a></li>
					<li><img class="proimg" src="./icons/address.ico"><a
						href="indirizzo.jsp"> Indirizzo </a></li>
					<li><img class="proimg" src="./icons/cart.ico"><a href="carrello.jsp">
							Carrello </a></li>
					<li><img class="proimg" src="./icons/calendar.ico"> <a
						href="OrdineServlet"> miei Ordini </a></li>
					<li><img class="proimg" src="./icons/exit.ico"><a href="ExitServlet">
							Esci </a></li>
				</ul>
				<ul id="admin">

				</ul>
			</div>
		</section>
	</div>
	<jsp:include page="./footer.jsp" flush="true" />
</body>
</html>