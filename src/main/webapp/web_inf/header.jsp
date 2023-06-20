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
 <% 
   String currentPage = request.getServletPath(); // Ottieni il percorso della tua pagina JSP corrente
   String cssFile = "";
   boolean AdditionalCss = false;
   
   if (currentPage.equals("/web_inf/profilo.jsp")) {
       cssFile = "profilo.css";
       AdditionalCss = true;
   } else if(currentPage.equals("/web_inf/datipersonali.jsp")){
	   cssFile = "datipersonali.css";
	   AdditionalCss = true;
   } else if(currentPage.equals("/web_inf/login.jsp")){
	   cssFile = "login.css";
	   AdditionalCss = true;
   }  else if(currentPage.equals("/web_inf/index.jsp")){
	   AdditionalCss = true;
   }  else if(currentPage.equals("/web_inf/indirizzo.jsp")){
	   AdditionalCss = true;
   }  else if(currentPage.equals("/web_inf/carrello.jsp")){
	   AdditionalCss = true;
   }  else if(currentPage.equals("/web_inf/news.jsp")){
	   AdditionalCss = true;
   }  else if(currentPage.equals("/web_inf/signup.jsp")){
	   AdditionalCss = true;
   }  else if(currentPage.equals("/web_inf/catalogo.jsp")){
	   AdditionalCss = true;
   }
   
%>
<% if(AdditionalCss){%>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/web_inf/CSS/style.css">
 <%}%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/web_inf/CSS/<%=cssFile%>">
<link rel="icon" href="<%=request.getContextPath()%>/web_inf/icons/Luffys_flag_2_icon-icons.com_76119.ico"/>
<link
	href="https://fonts.googleapis.com/css2?family=Pattaya&display=swap"
	rel="stylesheet" />
<title>Kawaii Comix</title>
</head>

<!--  <%= request.getAttribute("title") %>  da ricordare per fare cambio del titolo "dinamico"-->