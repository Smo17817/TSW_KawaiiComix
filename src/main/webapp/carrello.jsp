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
			int index = 1; 
		%>
		let n = <%=list.size()%>
		let prodotti = [];
		
		for(let j=1; j < n; j++){
			const elem = {
					isbn: "<%=list.get(index).getIsbn()%>",
					img: "<%=list.get(index).getImg()%>",
					nome: "<%=list.get(index).getNome()%>",
					prezzo: <%=list.get(index).getPrezzo()%>
			};
			
			if(!prodotti.includes(elem)) //se il prodotto è già presente non viene nuovamente aggiunto
				prodotti.push(elem);
			<%index++;%>
		}
		
		let contenutoHtml = '';
		for (let i = 0; i < n; i++) {	
			contenutoHtml += '<tr>';
			contenutoHtml += '<td><button onclick="message()"><img src="./icons/trash.ico" class="trash"></button></td>';
			contenutoHtml += '<td><img src="' + prodotti[i].img + '"></td>';
			contenutoHtml += '<td>' + prodotti[i].nome + '</td>';
			contenutoHtml += '<td>' + prodotti[i].prezzo + '</td>';
			contenutoHtml += '<td><h5><input type="number" min="1"></h5></td>';
			contenutoHtml += '<td><h5>&#8364 totale</h5></h5></td>';
			contenutoHtml += '</tr>';
		}
		
		
			
		$(document).ready(function(){
			document.getElementById("dinamico").innerHTML = contenutoHtml;
		});
		
		function message(){
			<%System.out.println("ciao");%>
		}
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