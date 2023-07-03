function annullaordine(button) {
	let tr = button.parentNode.parentNode;
	let id = tr.getElementsByTagName("td")[1].getElementsByTagName("h4")[0].innerText;
	window.location.replace("AnnullaOrdineServlet?id=" + id);

}