<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, java.text.SimpleDateFormat,model.User,model.OrdiniList,model.Ordine,model.OrdineSingolo" %>    
<% 
 	User user = (User) session.getAttribute("user");
 	if(user == null)
		response.sendRedirect("login.jsp");
%>
<jsp:include page="./header.jsp" flush="true"/>
<script>
	<% 
 		OrdiniList ordiniList = (OrdiniList) session.getAttribute("ordini");
 		ArrayList<Ordine> ordini = ordiniList.getOrdiniList();
 		Collections.reverse(ordini);
 			
 		String contenutoHtml = "";
 		for(Ordine o : ordini){
 			if(o.getUserId() == user.getId()){
 				contenutoHtml += "<div class=\"ordine\">";
 				contenutoHtml += "<h3> ID: " + o.getId() + "</h3>";
 				for(OrdineSingolo os : o.getSingoli()){
 					contenutoHtml += "<div class=\"product\">";
 					contenutoHtml += "<img class=\"orderImg\" src=\""+ os.getProdotto().getImg() +"\">";
 					contenutoHtml += "<p> Nome: " + os.getProdotto().getNome() + " x" + os.getQuantita() +"</p>";
 					contenutoHtml += "<p> &#8364 " + os.getTotParziale() + "</p>";
 					contenutoHtml += "</div>";
 				}
 				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 				contenutoHtml += "<p>" + sdf.format(o.getData()) + "</p>";
 				contenutoHtml += "<h4> Totale: &#8364 " + o.getTotale() + "</h4>";
 				contenutoHtml += "</div>";
 			}
 		}
	 %> 

	const content = '<%=contenutoHtml.replace("'", "\\'").replace("\n", "\\n")%>';
	console.log(content);
	$(document).ready(function(){
		document.getElementById("container").innerHTML = content;
	});
</script>

<body>
<jsp:include page="./Nav.jsp" flush="true"/>
	<h2>Ordini</h2>	
	<section id="container">
	
	
	</section>	

</body>
</html>