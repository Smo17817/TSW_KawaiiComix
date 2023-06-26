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
				contenutoHtml += "<h4 class=\"pname\">" + p.getNome() + "</h4>" + "\n";
				contenutoHtml += "<p> &#8364 " + p.getPrezzo() + "</p>" + "\n";
				contenutoHtml += "<a href=\"CartServlet?isbn=" + p.getIsbn() + "\">Carrello</a>" + "\n";
				contenutoHtml += "</div>" + "\n";
				contenutoHtml += "</div>" + "\n";
			}
		%>
		
		const content = '<%=contenutoHtml.replace("'", "\\'").replace("\n", "\\n")%>';
		
		function myFunction(){
			let input, filter, schede, single, a, nome;
			input = document.getElementById("search-input");
			filter = input.value.toUpperCase();
			schede = document.getElementById("schedeProdotto");
			product = schede.getElementsByClassName("scheda");
			
			for(let i = 0; i < product.length; i++){
				a = product[i].getElementsByClassName("pname")[0];
				textValue = a.textContent || a.innerText;
				if(textValue.toUpperCase().indexOf(filter) > -1){
					product[i].style.display = "";
				}else{
					product[i].style.display = "none";
				}
			}
		}
		
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