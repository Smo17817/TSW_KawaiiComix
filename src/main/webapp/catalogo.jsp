<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, servlet.Prodotto, servlet.Catalogo"%>

<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<script>
		<%
			Catalogo catalogo = (Catalogo) session.getAttribute("catalogo");
			ArrayList<Prodotto> list = catalogo.getCatalogo();
	
			int index = 0;
		%>
		let n = <%=list.size()%>
		console.log(n);
		let prodotti = [];
		
		for(let j=0; j < n; j++){
			const elem = {
				isbn: "<%=list.get(index).getIsbn()%>",
				img: "<%=list.get(index).getImg()%>",
				nome: "<%=list.get(index).getNome()%>",
				prezzo: <%=list.get(index).getPrezzo()%>
			};
				prodotti.push(elem);
			console.log(elem);
		}	
		
		let contenutoHtml = '';
		for (let i = 0; i < n; i++) {	
			contenutoHtml += '<div class="scheda">';
			contenutoHtml += '<a href="ProductServlet?isbn=' + prodotti[i].isbn + '"><img src="' + prodotti[i].img +'" class="trash"></a>';
			contenutoHtml += '<div class="info">' 
			contenutoHtml += '<h4>' + prodotti[i].nome + '</h4>';
			contenutoHtml += '<p> &#8364 ' + prodotti[i].prezzo + '</p>';
			contenutoHtml += '<a href="CartServlet?isbn=' + prodotti[i].isbn + '">Carrello</a>';
			contenutoHtml += '</div>';
			contenutoHtml += '</div>';
		}
			
		$(document).ready(function(){
			document.getElementById("schedeProdotto").innerHTML = contenutoHtml;
		});
	</script>
	
	<section>
		<h2>Catalogo</h2>
		<div id="schedeProdotto">
		
		</div>
	</section>
	
</body>
</html>