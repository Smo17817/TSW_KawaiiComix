<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.Prodotto,model.Catalogo"%>
<%@ page import="com.google.gson.Gson" %>


<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<script src="./Script/search.js"></script>
	<script>
		<%
			Catalogo catalogo = (Catalogo) session.getAttribute("catalogo");
			ArrayList<Prodotto> list = (ArrayList<Prodotto>) catalogo.getCatalogo();
			
			String contenutoHtml = "";
			for(Prodotto p : list){
				Gson gson = new Gson();
				String prodottoJson = gson.toJson(p);
				contenutoHtml += "<div class=\"scheda\" data-prodotto='"+ prodottoJson +"'>" + "\n";
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
				filtriGenere += "<input type=\"checkbox\" class=\"gen\" name=\"genere\" onchange=filteredSearch()>"; 
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
			document.getElementsByTagName("tbody")[0].innerHTML = categorie;
			document.getElementsByTagName("tbody")[1].innerHTML = generi;
			
		});
	
		document.addEventListener("DOMContentLoaded", function() {
		    filteredSearch("gen", "firstset");
		});
	</script>
	<main>
	<section id="container">
		<div id="filtri">
			<h2>Filtra Per</h2>
			<table>
				<tbody>
				
				</tbody>
			</table>
			<table>
				<tbody>
				
				</tbody>
			</table>
	
			</div>
		</section>
		
		<section id="prodotti">	
			<div id="schedeProdotto">
	
			</div>
		</section>
			
	</main>
	<jsp:include page="./footer.jsp" flush="true"/>	
</body>
</html>