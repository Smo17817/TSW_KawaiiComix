function dynamicIndex(url) {
	$.ajax({
		url: url,
		type: 'GET',
		contentType: 'application/json; charset=utf-8'
	}).done((response) => {
		response = JSON.parse(response);
		let contenutoHtml = "";

		for (const prodotto of response) {
			contenutoHtml += "<div class=\"scheda\">";
			contenutoHtml += "<a href=\"ProductServlet?isbn=" + prodotto.isbn + "\"><img src=\"" + prodotto.img + "\"> </a>";
			contenutoHtml += "<div class=\"info\">";
			contenutoHtml += "<h4>" + prodotto.nome + "</h4>";
			contenutoHtml += "<p>&#8364 " + prodotto.prezzo + "</p>";
			contenutoHtml += "<a href=\"CartServlet?isbn=" + prodotto.isbn + "\"> Carrello</a>";
			contenutoHtml += "</div> </div>";
		}

		$("#schedeProdotto").append(contenutoHtml);
	});
}

function dynamicNews(url) {
	$.ajax({
		url: url,
		type: 'GET',
		contentType: 'application/json; charset=utf-8'
	}).done((response) => {
		response = JSON.parse(response);
		let contenutoHtml = "";

		for (const articolo of response) {
			contenutoHtml += "<div class=\"scheda\"> <article>";
			contenutoHtml += "<h2>" + articolo.titolo + "</h2>";
			contenutoHtml += "<h1>" + articolo.sottotitolo + "</h1>";
			contenutoHtml += "<p> Data Pubblicazione: " + articolo.data + "</p>";
			if (articolo.immagine != null) {
				contenutoHtml += "<img src=\"" + articolo.immagine + "\">";
			}
			if (articolo.video != null) {
				contenutoHtml += "<div class=\"video-container\">";
				contenutoHtml += "<iframe width=560 height=315 src = \"" + articolo.video + "\" frameborder=0 allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen> </iframe>";
				contenutoHtml += "</div>";
			}

			contenutoHtml += "<p>" + articolo.corpo + "</p>";
			contenutoHtml += "</article> </div>";
		}

		$("#scheda-news").append(contenutoHtml);
	});
}
