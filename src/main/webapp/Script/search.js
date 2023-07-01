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

function filteredSearch(nomeInput, nomeLabel) {
	const checkboxes = document.getElementsByClassName(nomeInput);
	const labels = document.getElementsByClassName(nomeLabel);
	for (let i = 0; i < checkboxes.length; i++)
		console.log(labels[i].innerText);

}