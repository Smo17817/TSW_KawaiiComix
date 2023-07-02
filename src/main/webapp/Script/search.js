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
  // Recupera tutti gli elementi con classe 'scheda'
  var items = document.getElementsByClassName('scheda');

  // Recupera i valori delle checkbox dei generi
  var generi = Array.from(document.querySelectorAll('.gen:checked')).map(function (element) {
    return element.getAttribute('value');
  });

  // Recupera i valori delle checkbox delle categorie
  var categorie = Array.from(document.querySelectorAll('.cat:checked')).map(function (element) {
    return element.getAttribute('value');
  });

  // Nascondi tutti gli elementi
  for (var i = 0; i < items.length; i++) {
    items[i].style.display = 'none';
  }

  // Mostra gli elementi che corrispondono alle condizioni
  for (var i = 0; i < items.length; i++) {
    var prodotto = JSON.parse(items[i].getAttribute('data-prodotto'));
    var genere = prodotto.genere;
    var categoria = prodotto.categoria;

    var showItem = false;

    // Controlla se l'elemento corrisponde a uno dei generi selezionati
    if (generi.length === 0 || generi.includes(genere)) {
      showItem = true;
    }

    // Controlla se l'elemento corrisponde a una delle categorie selezionate solo se l'elemento deve già essere mostrato
    if (showItem && categorie.length > 0) {
      showItem = categorie.includes(categoria);
    }

    // Mostra o nascondi l'elemento in base al risultato
    if (showItem) {
      items[i].style.display = 'block';
    }
  }
}


