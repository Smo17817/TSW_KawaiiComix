function myFunction(){
	let input, filter, schede, single, nome;
	input = document.getElementById("search-input");
	filter = input.value.toUpperCase();
	schede = document.getElementById("schedeProdotto");
	product = schede.getElementsByClassName("scheda");
	
	for(let i = 0; i < product.length; i++){
		nome = product[i].getElementsByClassName("pname")[0];
		textValue = a.textContent || a.innerText;
		if(textValue.toUpperCase().indexOf(filter) > -1){
			product[i].style.display = "";
		}else{
			product[i].style.display = "none";
		}
	}
}