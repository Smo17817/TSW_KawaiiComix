<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ page import="java.util.*, servlet.Prodotto" %>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>

	<% Prodotto p = (Prodotto) request.getAttribute("prodotto");%>
	<main>
		<div class="prod_img">
			<img src="<%=p.getImg()%>" alt=""/>
		</div>
		<div class="specs">
			<h3><%=p.getNome()%></h3>
			<h4>&#8364 <%=p.getPrezzo()%></h4>
			<p>Genere: <%=p.getGenere()%><p>
			<p>Categoria: <%=p.getCategoria()%></p>
			<a href="CartServlet"> Aggiungi al Carrello</a>
		</div>
		
	</main>
	
</body>
</html>