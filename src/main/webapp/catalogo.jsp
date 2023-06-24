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
			
			String contenutoHtml = "";
			for(Prodotto p : list){
				contenutoHtml += "<div class=\"scheda\">" + "\n";
				contenutoHtml += "<a href=\"ProductServlet?isbn=" + p.getIsbn() + "\"><img src=\"" + p.getImg()+ "\" class=\"trash\"></a>" + "\n";
				contenutoHtml += "<div class=\"info\">" + "\n"; 
				contenutoHtml += "<h4>" + p.getNome() + "</h4>" + "\n";
				contenutoHtml += "<p> &#8364 " + p.getPrezzo() + "</p>" + "\n";
				contenutoHtml += "<a href=\"CartServlet?isbn=" + p.getIsbn() + "\">Carrello</a>" + "\n";
				contenutoHtml += "</div>" + "\n";
				contenutoHtml += "</div>" + "\n";
			}
		%>
		
		const content = '<%=contenutoHtml.replace("'", "\\'").replace("\n", "\\n")%>';

		
		$(document).ready(function(){
			document.getElementById("schedeProdotto").innerHTML = content;
		});
	</script>
	
	<section>
		<h2>Catalogo</h2>
		<div id="schedeProdotto">
		
		</div>
	</section>
	
</body>
</html>