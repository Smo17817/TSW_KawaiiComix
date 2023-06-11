<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name=" description" content="Vendita Manga al Dettaglio" />
<meta name="robots" content="index,follow" />
<link rel="stylesheet" href="./CSS/datipersonali.css">
<title>Kawaii Comix</title>
</head>
<body>
	<jsp:include page="./Nav.jsp" flush="true"/>
	<main>
      <section id="personal-info">
        <div class="form-wrapper">
          <header class="form-head">
            <h2>Informazioni personali</h2>
            <form action="" method="POST">
                <label for="name">Name:</label>
                <input id="name" type="text" name="name" required />
              <div class="email-form">
                <label for="email">Email:</label>
                <input
                  id="email"
                  type="email"
                  name="email"
                  required
                  autocomplete="off
                "
                />
              </div>
              <button type="submit">Invia</button>
            </form>
          </header>
        </div>
      </section>
	</main>
</body>
</html>