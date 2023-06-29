<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.Articolo,model.Novita"%>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<script>
		<% 
			Novita novita = (Novita) session.getAttribute("novita");
			ArrayList<Articolo> list = (ArrayList<Articolo>) novita.getNovita();
			
			String contenutoHtml = "";
			for(Articolo a : list){
				contenutoHtml += "<article>";
				contenutoHtml += "<h1>" + a.getTitolo() + "</h1>";
				if(a.getImmagine() != null){
					contenutoHtml += "<img src=\"" + a.getImmagine() + "\">";	
				}
				if(a.getVideo() != null)
					contenutoHtml += "<video> <source src = \"" + a.getVideo() + "\"> </video>";
				
				contenutoHtml += "<p>" + a.getCorpo() + "</p>";
				contenutoHtml += "<article>";	
			}
		%>
		const content = '<%=contenutoHtml.replace("'", "\\'").replace("\n", "\\n")%>';
		$(document).ready(function(){
			document.getElementById("articles").innerHTML = content;
		});	
	</script>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<h2>Novità</h2>
	<section id="articles">
	
	</section>
	
</body>
</html>