function myFunction() {
	let input, filter, schede, a, product, textValue;
	input = document.getElementById("search-input");
	filter = input.value.toUpperCase();
	schede = document.getElementById("schedeProdotto");
	product = schede.getElementsByClassName("scheda");

	for (let i = 0; i < product.length; i++) {
		a = product[i].getElementsByClassName("pname")[0];
		textValue = a.textContent || a.innerText;
		if (textValue.toUpperCase().indexOf(filter) > -1) {
			product[i].style.display = "";
		} else {
			product[i].style.display = "none";
		}
	}
}

function filteredSearch(nomeInput, nomeLabel){
	const checkboxes = document.getElementsByClassName(nomeInput);
	const labels = document.getElementsByClassName(nomeLabel);
	for(let i = 0; i < checkboxes.length; i++)
		console.log(labels[i].innerText);
	
}