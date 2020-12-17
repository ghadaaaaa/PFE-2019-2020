<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib
	          prefix="c"
	          uri="http://java.sun.com/jsp/jstl/core" 
	        %>
<!DOCTYPE html>
<html lang="fr">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Header</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/business-casual.min.css" rel="stylesheet">

</head>

<body>
 <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
    <div class="container">
 
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" 
      aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav mx-auto">
          <li class="nav-item active px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="Accueil">Accueil
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="Espaces">Les Espaces </a>
           
          </li>
          <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="MaisonsArchitecte">Les Maisons traditionnelles</a>
          </li>
          <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="Monuments">Les Monuments historiques</a>
          </li>
          <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="Sites">Les Sites archéologiques</a>
          </li>
           <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="Contact">Contact</a>
          </li>
          
          <li class="nav-item px-lg-4">
          <c:if test="${(!empty sessionScope.architectLog) || (!empty sessionScope.adminLog) || (!empty sessionScope.expertLog)}"> 
          <div class="dropdown">
         <!--    <a class="nav-link text-uppercase text-expanded" href="#"> --> <img class=" rounded" src="img/avatar.jpg" alt=""> <h5>${sessionScope.prenom}</h5> <!--  </a>-->
           <div class="dropdown-content">
		    <a href="ajoutMai">Ajouter Elements</a>
		    <a href="Logout" onclick="return confirm('Etes vous sûr de vouloir se déconnecter de votre compte?'); ">Se déconnecter</a>
			</div>
		  </div>
           </c:if>
           <!-- && (empty sessionScope.expertLog) -->
           <c:if test="${(empty sessionScope.architectLog) && (empty sessionScope.adminLog) && (empty sessionScope.expertLog) }">
            <a class="nav-link text-uppercase text-expanded" href="login">Se connecter</a>
            </c:if>
          </li>
          
          
        </ul>
      </div>
    </div>
  
  </nav>

</body>
</html>