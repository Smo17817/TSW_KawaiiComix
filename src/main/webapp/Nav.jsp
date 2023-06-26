<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<header class="main-head">
		<nav>
			<h1 id="logo">KawaiiComix</h1>
			<ul class="links">
				<li><a href="./index.jsp">Home</a></li>
				<li><a href="CatalogServlet">Catalogo</a></li>
				<li><a href="NewsServlet">News</a></li>
			</ul>
			<ul class="utilities">
				<li class="search">
					<div class="icon"></div>
					<div class="input"></div>
				</a></li>
				<li><a href="./profilo.jsp"><img
						src="./icons/user_person_profile_avatar_icon_190943.ico"
						alt="avatar utente" /></a></li>
				<li><a href="CartServlet"><img
						src="./icons/shopping-cart_icon-icons.com_65051.ico" alt="" /></a>
				</li>
			</ul>
		</nav>
	</header>
</body>