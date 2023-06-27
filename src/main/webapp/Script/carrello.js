function totaleParziale(){
	let product, elem1, elem2, elem3, costo, quantita, totParz = 0, tot = 0;
		
	product = document.getElementById("dinamico");
	elem1 = product.getElementsByClassName("costo");
	elem2 = document.querySelectorAll('.quantita');
	
	for(let i = 0; i < elem1.length; i++){
		costo = parseFloat(elem1[i].innerText);
		quantita = parseInt(elem2[i].value)
		totParz += costo * quantita;
		tot += totParz;
		
		product.getElementsByClassName("totProd")[i].innerHTML = "&#8364 " + totParz;
		totParz = 0;
	}
	
	let cassa;
	
	cassa = document.getElementById("cassa");
	cassa.getElementsByClassName("tot")[0].innerHTML = "&#8364 " + tot;
	cassa.getElementsByClassName("totCumul")[0].innerHTML = "&#8364 " + (tot + 10);
}


