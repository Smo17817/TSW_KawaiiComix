<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% 
 %>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
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
				<tbody>
					<tr>
					<td><a href="#"><img src="./icons/trash.ico" class="trash"></a></td>
					<td><img src=""></td>
					<td><h5>nome</h5></td>
					<td><h5>&#8364 prezzo</h5></td>
					<td><h5><input type="number"></h5></td>
					<td><h5>&#8364 totale</h5></td>
					</tr>
				</tbody>
			</table>
		</section>
	</main>
</body>
</html>