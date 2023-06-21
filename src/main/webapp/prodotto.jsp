<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
		<form action="ProductServlet" method="GET">
			<h3>${prodotto}</h3>
			<h3>ciao</h3>
		</form>
	</main>

</body>
</html>