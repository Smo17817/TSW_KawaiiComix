<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.apache.commons.text.StringEscapeUtils"%>
<%@ page import="java.util.*,model.Prodotto,model.Catalogo"%>
<%@ page import="com.google.gson.Gson"%>



<jsp:include page="./header.jsp" flush="true" />
<body>
	<jsp:include page="./Nav.jsp" flush="true" />
	<script src="./Script/search.js"></script>
	<script src="./Script/dynamicCode.js"></script>
	<script>
		$(document).ready(function() {
		  	dynamicCatalog("<%=request.getContextPath()%>/CatalogServlet");
		  	dynamicCategorie("<%=request.getContextPath()%>/CategoriaServlet");
		 	dynamicGeneri("<%=request.getContextPath()%>/GenereServlet");
		});
	</script>
	<main>
		<section id="container">
			<div id="filtri">
				<h2>Filtra Per</h2>
				<table>
					<tbody id="categorie">

					</tbody>
				</table>
				<table>
					<tbody id="generi">

					</tbody>
				</table>

			</div>
		</section>

		<section id="prodotti">
			<div id="schedeProdotto"></div>
		</section>

	</main>
	<jsp:include page="./footer.jsp" flush="true" />
</body>
</html>