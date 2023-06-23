<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name=" description" content="Vendita Manga al Dettaglio" />
<meta name="robots" content="index,follow" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
 <% 
   String currentPage = request.getServletPath(); // Ottieni il percorso della tua pagina JSP corrente
   String cssFile = "";
   boolean AdditionalCss = false;
   
   if (currentPage.equals("/profilo.jsp")) {
       cssFile = "profilo.css";
       AdditionalCss = true;
   } else if(currentPage.equals("/datipersonali.jsp")){
	   cssFile = "datipersonali.css";
	   AdditionalCss = true;
   } else if(currentPage.equals("/login.jsp")){
	   cssFile = "login.css";
	   AdditionalCss = true;
   }  else if(currentPage.equals("/index.jsp")){
	   cssFile = "index.css";
	   AdditionalCss = true;
   }  else if(currentPage.equals("/indirizzo.jsp")){
	   AdditionalCss = true;
   }  else if(currentPage.equals("/carrello.jsp")){
	   cssFile = "carrello.css";
	   AdditionalCss = true;
   }  else if(currentPage.equals("/news.jsp")){
	   AdditionalCss = true;
   }  else if(currentPage.equals("/signup.jsp")){
	   cssFile = "signup.css";
	   AdditionalCss = true;
   }  else if(currentPage.equals("/catalogo.jsp")){
	   cssFile = "catalogo.css";
	   AdditionalCss = true;
   }  else if(currentPage.equals("/prodotto.jsp")){
	   cssFile = "prodotto.css";
	   AdditionalCss = true;
   }
   
%>
<% if(AdditionalCss){%>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/style.css">
 <%}%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/<%=cssFile%>">
<link rel="icon" href="<%=request.getContextPath()%>/icons/Luffys_flag_2_icon-icons.com_76119.ico"/>
<link
	href="https://fonts.googleapis.com/css2?family=Pattaya&display=swap"
	rel="stylesheet" />
<title>Kawaii Comix</title>
</head>

<!--  <%= request.getAttribute("title") %>  da ricordare per fare cambio del titolo "dinamico"-->