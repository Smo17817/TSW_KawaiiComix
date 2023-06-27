<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, servlet.User"%> 
<%		
	int flag = 0;
	User user = (User) session.getAttribute("user");
  	
	if(user == null)
		response.sendRedirect("login.jsp");
  	else{
  		flag = user.getId();
  	}
 %>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<script>
		let id = <%=flag%>
		
		let contenutoHtml = '';
		  contenutoHtml += '<li> <img src="./icons/upload.ico"> <a href="aggiungiProdotto.jsp"> Aggiungi Prodotto (ADMIN)</a> </li>';
		  contenutoHtml += '<li> <img src="./icons/news.ico"> <a href="aggiungiNovita.jsp"> Aggiungi Notizie (ADMIN)</a> </li>';
		  contenutoHtml += '<li> <img src="./icons/logistic.ico"> <a href=""> Controlla Ordini (ADMIN)</a> </li>';

		  if (id == 1) {
			  $(document).ready(function(){
		  		document.getElementById("admin").innerHTML = contenutoHtml;
			  });
		  }
	
	</script>
	
	<div class="justaimg">
	<jsp:include page="./Nav.jsp" flush="true"/>
	<section class="mid">
		<img  id="maschotte" src="./images/luffy.png">
			<div class="account">
				<h2>Il mio Account</h2>
				<ul>
				<li><img src= "./icons/profile.ico"><a href="datipersonali.jsp"> 
						 Dati personali
				</a></li>
				<li><img src="./icons/address.ico"><a href="indirizzo.jsp">
						Indirizzo
				</a></li>
				<li><img src="./icons/cart.ico"><a href="carrello.jsp"> 
						Carrello
				</a></li>
				<li><img src="./icons/calendar.ico"> <a href="ordine.jsp">
						miei Ordini
				</a></li>
				<li><img src="./icons/exit.ico"><a href="ExitServlet"> Esci
				</a></li>
			</ul>
			<ul id="admin">
				
			</ul>
		</div>
	</section>
	</div>
</body>
</html>