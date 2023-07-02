<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./header.jsp" flush="true"/>
<body>
	<header class="main-head">
		<nav>
			<h1 id="logo">KawaiiComix</h1>
			<ul class="links">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="catalogo.jsp">Catalogo</a></li>
				<li><a href="NewsServlet">News</a></li>
			</ul>
			<ul class="utilities">
				<li class="searchbar">
					<div class="navsearch">
						<button class="icon"></button>
						<div class="input">
							<input type="text" id="search-input" onkeyup="myFunction()"
								placeholder="Inserisci il nome del prodotto">
						</div>
						<span class="clear" onclick="document.getElementById('search-input').value = '' "></span>
					</div> 
					<script>
						const icon = document.querySelector(".icon");
						const search = document.querySelector(".navsearch");
						icon.onclick = function(){
							search.classList.toggle("active");
						}
					</script>
				</li>
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