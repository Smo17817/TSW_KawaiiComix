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


/*function filteredSearch(nomeInput, nomeLabel){
	const checkboxes = document.getElementsByClassName(nomeInput);
	const labels = document.getElementsByClassName(nomeLabel);
	for (let i = 0; i < checkboxes.length; i++)
		console.log(labels[i].innerText);

}*/

function filteredSearch() {
  // Recupera tutti gli elementi con classe 'scheda'
  var items = document.getElementsByClassName('scheda');

  // Recupera le checkbox dei generi
  var generi = document.querySelectorAll('.gen:checked');

  // Recupera le checkbox delle categorie
  var categorie = document.querySelectorAll('.cat:checked');

  // Mostra tutti gli elementi
  for (var i = 0; i < items.length; i++) {
    items[i].style.display = 'block';
  }

  // Filtra gli elementi in base ai generi selezionati
  if (generi.length > 0) {
    for (var i = 0; i < items.length; i++) {
      var prodotto = JSON.parse(items[i].getAttribute('data-prodotto'));
      console.log(items[i].getAttribute('data-prodotto'));
      var genere = prodotto.genere;
      if (!Array.from(generi).some(function (element) {
        return element.value === genere;
      })) {
        items[i].style.display = 'none';
      }
    }
  }

  // Filtra gli elementi in base alle categorie selezionate
  if (categorie.length > 0) {
    for (var i = 0; i < items.length; i++) {
      var prodotto = JSON.parse(items[i].getAttribute('data-prodotto'));
      var categoria = prodotto.categoria;
      if (!Array.from(categorie).some(function (element) {
        return element.value === categoria;
      })) {
        items[i].style.display = 'none';
      }
    }
  }
}