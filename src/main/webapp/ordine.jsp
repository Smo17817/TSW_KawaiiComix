<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, servlet.User" %>    
 <% if(session.getAttribute("user")==null)
		response.sendRedirect("login.jsp");
 %>
<jsp:include page="./header.jsp" flush="true"/>
<body>
<jsp:include page="./Nav.jsp" flush="true"/>
	<h2>Ordini</h2>
		

</body>
</html>