<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, servlet.Prodotto, servlet.Catalogo"%>

<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<script src="./Script/search.js"></script>
	<script>
		<%
			Catalogo catalogo = (Catalogo) session.getAttribute("catalogo");
			ArrayList<Prodotto> list = catalogo.getCatalogo();
			
			String contenutoHtml = "";
			for(Prodotto p : list){
				contenutoHtml += "<div class=\"scheda\">" + "\n";
				contenutoHtml += "<a href=\"ProductServlet?isbn=" + p.getIsbn() + "\"><img src=\"" + p.getImg()+ "\" class=\"trash\"></a>" + "\n";
				contenutoHtml += "<div class=\"info\">" + "\n"; 
				contenutoHtml += "<h4 class=\"pname\">" + p.getNome() + "</h4>" + "\n";
				contenutoHtml += "<p> &#8364 " + p.getPrezzo() + "</p>" + "\n";
				contenutoHtml += "<a href=\"CartServlet?isbn=" + p.getIsbn() + "\">Carrello</a>" + "\n";
				contenutoHtml += "</div>" + "\n";
				contenutoHtml += "</div>" + "\n";
			}
			
			String filtriGenere = "<tr> <td> <h4> Genere </h4> </td> </tr>";
			for(String genere : (ArrayList<String>) session.getAttribute("generi")){
				filtriGenere +=  "<tr> <td>";
				filtriGenere += "<input type=\"checkbox\" class=\"gen\" name=\"genere\" onchange=\"filteredSearch(\"gen\", \"firstset\")\">"; 
				filtriGenere += "<label class=\"firstset\">" + genere + "</label>";
				filtriGenere += "</td> </tr>";
			}
			String filtriCategoria = "<tr> <td> <h4> Categoria </h4> </td> </tr>";
			for(String categoria : (ArrayList<String>) session.getAttribute("categorie")){
				filtriCategoria +=  "<tr> <td>";
				filtriCategoria += "<input type=\"checkbox\" class=\"cat\" name=\"categoria\">"; 
				filtriCategoria += "<label class=\"secondset\">" + categoria + "</label>";
				filtriCategoria += "</td> </tr>";
			}
		%>
		
		const content = '<%=contenutoHtml.replace("'", "\\'").replace("\n", "\\n")%>';
		const generi = '<%=filtriGenere.replace("'", "\\'").replace("\n", "\\n")%>';
		const categorie = '<%=filtriCategoria.replace("'", "\\'").replace("\n", "\\n")%>';	
		
		$(document).ready(function(){
			document.getElementById("schedeProdotto").innerHTML = content;
			document.getElementsByTagName("tbody")[0].innerHTML = categorie + generi;
			
		});
	
		document.addEventListener("DOMContentLoaded", function() {
		    filteredSearch("gen", "firstset");
		});
	</script>
	
	<h2>Catalogo</h2>
	<section id="container">
		<div id="filtri">
			<table>
				<thead>
					<tr> <td> <h3> Filtri </h3> </td> </tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		
		
		</div>
		
		
		<div id="schedeProdotto">
		
		</div>
	</section>
	
</body>
</html>