function myFunction() {
	let input, filter, schede, product;
	input = document.getElementById("search-input");
	filter = input.value.toUpperCase();
	schede = document.getElementById("schedeProdotto");
	product = schede.querySelectorAll(".scheda");

	for (const item of product) {
		let a = item.querySelector(".pname");
		let textValue = a.textContent || a.innerText;
		if (textValue.toUpperCase().indexOf(filter) > -1) {
			item.style.display = "";
		} else {
			item.style.display = "none";
		}
	}
}


function filteredSearch() {
  // Ottieni i valori dei filtri
  const selectedCategories = Array.from(document.querySelectorAll('input.cat:checked')).map(input => input.value);
  const selectedGenres = Array.from(document.querySelectorAll('input.gen:checked')).map(input => input.value);

  // Rimuovi le schede dei prodotti esistenti
  const schedeProdotto = document.getElementById('schedeProdotto');
  schedeProdotto.innerHTML = '';

  // Filtra i prodotti in base alle categorie e ai generi selezionati
  const prodotti = document.querySelectorAll('.scheda');
  prodotti.forEach(prodotto => {
    const prodottoCategoria = prodotto.dataset.categoria;
    const prodottoGenere = prodotto.dataset.genere;

    if (
      (selectedCategories.length === 0 || selectedCategories.includes(prodottoCategoria)) &&
      (selectedGenres.length === 0 || selectedGenres.includes(prodottoGenere))
    ) {
      schedeProdotto.appendChild(prodotto.cloneNode(true));
    }
  });
}






