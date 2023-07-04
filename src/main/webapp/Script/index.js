function disableVerticalScroll() {
	// Salva la posizione verticale corrente della pagina
	var scrollTop = window.pageYOffset || document.documentElement.scrollTop;

	// Aggiungi la classe CSS per disabilitare lo scorrimento verticale
	document.body.classList.add("no-scroll");

	// Ripristina la posizione verticale dopo un ritardo di 0 millisecondi
	setTimeout(function() {
		window.scrollTo(0, scrollTop);
	}, 0);
}