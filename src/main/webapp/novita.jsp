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
				contenutoHtml += "<div class=\"scheda\"> <article>";
				contenutoHtml += "<h2>" + a.getTitolo() + "</h2>";
				contenutoHtml += "<h1>" + a.getSottotitolo() + "</h1>";
				contenutoHtml += "<p> Data Pubblicazione: " + a.getData() + "</p>";
				if(a.getImmagine() != null){
					contenutoHtml += "<img src=\"" + a.getImmagine() + "\">";	
				}
				if(a.getVideo() != null){
					contenutoHtml += "<div class=\"video-container\">";
					contenutoHtml += "<iframe width=560 height=315 src = \"" + a.getVideo() + "\" frameborder=0 allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen> </iframe>";
					contenutoHtml += "</div>";
				}
				
				contenutoHtml += "<p>" + a.getCorpo() + "</p>";
				contenutoHtml += "</article> </div>";	
			}
		%>
		const content = '<%=contenutoHtml.replace("'", "\\'").replace("\n", "\\n")%>';
		$(document).ready(function(){
			document.getElementById("scheda-news").innerHTML = content;
		});	
	</script>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<section id="articles">
		<h2>Novità</h2>
		<div id="scheda-news">
		</div>
	</section>
<jsp:include page="./footer.jsp" flush="true"/>	
</body>
</html>