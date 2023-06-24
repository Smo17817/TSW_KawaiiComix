<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*, servlet.Prodotto, servlet.Carrello"%>
 <% if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
 %>
 
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>

	<script>
		<% 
			Carrello carrello = (Carrello) session.getAttribute("carrello");
			ArrayList<Prodotto> list = carrello.getCarrello();
			
			String contenutoHtml = "";
			for(Prodotto p : list){
				contenutoHtml += "<tr>" + "\n";
				contenutoHtml += "<td> <button><img src=\"./icons/trash.ico\" class=\"trash\"></button>" + "\n";
				contenutoHtml += "<td> <img src=\"" + p.getImg() + "\" class=\"thumbnail\" height=\"250px\"></td>" + "\n";
				contenutoHtml += "<td>" + p.getNome() + "</td>" + "\n";
				contenutoHtml += "<td> &#8364 " + p.getPrezzo() + "</td>" + "\n";
				contenutoHtml += "<td> <h5> <input type=\"number\" min=\"1\"> </h5> </td>" + "\n";
				contenutoHtml += "<td> <h5> &#8364 totale </h5> </td>" + "\n";
				contenutoHtml += "</tr>" + "\n";
			}
		%>
		
		const content = '<%=contenutoHtml.replace("'", "\\'").replace("\n", "\\n")%>';

		
		$(document).ready(function(){
			document.getElementById("dinamico").innerHTML = content;
		});
	</script>

	<main>
		<section id="container">
			<h2>Carrello</h2>
			<table>
				<thead>
					<tr>
					<td>Elimina</td>
					<td>Immagine</td>
					<td>Prodotto</td>
					<td>Prezzo</td>
					<td>Quantità</td>
					<td>Totale</td>
					</tr>
				</thead>
				<tbody id="dinamico">
				
					
				</tbody>
			</table>
		</section>
		
		<section id="bottom">
			<div class="row">
				<div class="promozione">
					<div>
						<h5>CODICE PROMOZIONALE</h5>
						<p>Inserisci il codice</p>
						<input type="text" placeholder="codice">
						<button>Applica</button>
					</div>
				</div>	
				
				<div class="cassa">
					<h5>TOTALE</h5>
					<div class="totale">
						<h6>Prodotti: </h6>
						<p>&#8364 totale</p>
					</div>
					<div class="totale">
						<h6>Spedizione: </h6>
						<p>&#8364 totale</p>
					</div>
					<hr>
					<div class="totale">
						<h6>Totale: </h6>
						<p>&#8364 totale</p>
					</div>
					<button>Procedi al Pagamento</button>
						
				</div>
			</div>
		</section>
	</main>
	
</body>
</html>