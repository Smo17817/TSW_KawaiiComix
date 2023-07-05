<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, model.User"%> 
<%	
	User user = (User) session.getAttribute("user");
  	if(user == null)
		response.sendRedirect("login.jsp");
 %>
<jsp:include page="./header.jsp" flush="true" />

<body>
<jsp:include page="./Nav.jsp" flush="true"/>
<script src="./Script/dynamicCode.js"></script>
<script>

	document.addEventListener("DOMContentLoaded", dynamicModificaProdotto("<%=request.getContextPath()%>/NameServlet")); 	

</script>
	<section id="new_product">
		<div class="form-wrapper">
			<form enctype ="multipart/form-data" action="DeleteProductServlet" method="GET">
				<h2>Elimina un Prodotto</h2>
				<div class="form-row">
					<label for="scelta">Prodotto: </label>
					<select id="chooseProduct" name="scelta" required>
						
					</select>
				</div>
				<div class="sub-class"> 
					<button type="submit">Elimina</button>
				</div>
			</form>
		</div>
	</section>
<jsp:include page="./footer.jsp" flush="true" />
</body>
</html>