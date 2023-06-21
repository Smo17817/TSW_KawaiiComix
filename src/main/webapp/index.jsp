<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <jsp:include page="./header.jsp" flush="true"/>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
		<section class=""></section>
		<form action="/ProductServlet" method="get">
		<a href="prodotto.jsp?isbn=12345678901234567">Clicca qui</a>
		</form>
		
	</main>
</body>
</html>
