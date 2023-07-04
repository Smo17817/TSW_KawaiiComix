function annullaordine(button) {
	let tr = button.parentNode.parentNode;
	let id = tr.getElementsByTagName("td")[2].getElementsByTagName("h4")[0].innerText;
	window.location.replace("AnnullaOrdineServlet?id=" + id);
}

function filterRows() {
  	let input = document.getElementById("searchInput").value.toLowerCase();
  	let startDateString = document.getElementById("startDateInput").value;
  	let endDateString = document.getElementById("endDateInput").value;
  	let rows = document.querySelectorAll("#container tr");
	
	let startDate = new Date(startDateString);
	let endDate = new Date(endDateString);
	let formattedStartDate = formatDate(startDate);
	let formattedEndDate = formatDate(endDate);

  	for (let i = 0; i < rows.length; i++) {
    	let userId = rows[i].getAttribute("data-utente");
    	let giorno = rows[i].getAttribute("data-giorno");
    	if (userId.toLowerCase().includes(input) && giorno >= formattedStartDate && giorno <= formattedEndDate) {
    		rows[i].style.display = "";
    	} else {
      		rows[i].style.display = "none";
    	}
  	}
}

function formatDate(date) {
  let day = String(date.getDate()).padStart(2, '0');
  let month = String(date.getMonth() + 1).padStart(2, '0');
  let year = date.getFullYear();
  
  return `${day}/${month}/${year}`;
}
