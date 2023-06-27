function totaleParziale(){
	let product, elem1, elem2, elem3, costo, quantita, totParz = 0, tot = 0;
		
	product = document.getElementById("dinamico");
	elem1 = product.getElementsByClassName("costo");
	elem2 = document.querySelectorAll('.quantita');
	
	for(let i = 0; i < elem1.length; i++){
		costo = parseFloat(elem1[i].textContent.split(' ')[1]);
		quantita = parseInt(elem2[i].value)
		totParz += costo * quantita;
		tot += totParz;
		
		product.getElementsByClassName("totProd")[i].innerHTML = "&#8364 " + totParz;
		totParz = 0;
	}
	
	let cassa, spedizione = 10;
	
	cassa = document.getElementById("cassa");
	cassa.getElementsByClassName("tot")[0].innerHTML = "&#8364 " + tot;
	if(tot == 0) // se non ci sono elementi nel carrello il totale è 0
		spedizione = 0;	
	cassa.getElementsByClassName("totCumul")[0].innerHTML = "&#8364 " + (tot + spedizione);
}

function eliminaRiga(button) {
	var row = button.parentNode.parentNode;
	row.parentNode.removeChild(row);
	totaleParziale();
}

function checkout(url) {
	let element = document.getElementsByClassName("totCumul")[0];
	let text = element.textContent;
	let numericValue = parseFloat(text.split(' ')[1]);
	
	if(numericValue > 0)
		window.location.href = "AddOrdineServlet?totale=" + numericValue;
}