
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, java.text.SimpleDateFormat,model.OrdiniList,model.Ordine,model.OrdineSingolo, model.User"%>
<jsp:include page="./header.jsp" flush="true" />
<%
User user = (User) session.getAttribute("user");
if (user == null)
	response.sendRedirect("login.jsp");
%>
<script src="./Script/ordini.js"></script>
<script>
	<%	OrdiniList ordiniList = (OrdiniList) session.getAttribute("ordini");
		ArrayList<Ordine> ordini = (ArrayList<Ordine>) ordiniList.getOrdiniList();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Collections.reverse(ordini);
		String stato = "Annullato";

		String contenutoHtml = "";
		for (Ordine o : ordini) {
			contenutoHtml += "<tr>";
			contenutoHtml += "<td> <h4>" + sdf.format(o.getData()) + "</h4> </td>";
			contenutoHtml += "<td> <h4>" + o.getId() + "</h4> </td>";
			contenutoHtml += "<td>";
			for (OrdineSingolo os : o.getSingoli()) 
				contenutoHtml += "<p>" + os.getProdotto().getNome() +"</p>";
			contenutoHtml += "</td> <td>";
			for (OrdineSingolo os : o.getSingoli())
				contenutoHtml += "<p> &#8364 " + os.getProdotto().getPrezzo() +"</p>";
			contenutoHtml += "</td>";
			contenutoHtml += "<td> &#8364 " + o.getTotale() + "</td>";
			if (o.getStato() == 1) stato = "Completato";
			contenutoHtml += "<td>" + stato + "</td>";
			contenutoHtml += "<td> <button onclick=\"annullaordine(this)\"> Annulla </button> </td> </tr>";
		}
	%>
	const content = '<%=contenutoHtml.replace("'", "\\'").replace("\n", "\\n")%>';

	$(document).ready(function() {
		document.getElementById("container").innerHTML = content;
	});
</script>

<jsp:include page="./Nav.jsp" flush="true" />

<body>
<section>
<h2> Controlla Ordini</h2>
	<table>
		<thead>
			<tr>
				<td>Data</td>
				<td>Codice Ordine</td>
				<td>Nome</td>
				<td>Totale Parziale</td>
				<td>Totale</td>
				<td>Stato</td>
				<td>Annulla ordine</td>
			</tr>
		</thead>
		<tbody id="container">

		</tbody>
	</table>
</section>

	<jsp:include page="./footer.jsp" flush="true" />
</body>
</html>