<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Inscription</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.min.css" rel="stylesheet">

  </head>

  <body>

    <%@include file= 'header.jsp' %>

    <section class="page-section cta">
       <div class="container" style="border-left-width: 0.50px;border-left-style: solid;border-right-width: 0.5px;border-right-style: solid;margin-right: 100px;margin-left: 100px;margin-top: 100px;margin-bottom: 100px;border-bottom-width: 2px;border-bottom-style: solid;border-top-width: 2px;border-top-style: solid; background-color: #f8f9fa">
        
     <!--   <div class="container" style ="border-radius:.5rem;content:'';position:absolute;top:-.5rem;bottom:-.5rem;left:-.5rem;right:-.5rem;border:.25rem solid rgba(255,255,255,.85)">
      --><div class="row">
          <div class="col-xl-9 mx-auto">
            <!--    <div class="cta-inner text-center rounded" > -->
              <h2 class="section-heading mb-5">
                <span class="section-heading-lower" style="padding-left: 300px;">S'inscrire</span>
              </h2>
			  
			  <!-- Modal Content -->
			   <form action="Registration" method="post">
				  				
				  <div class="container">
				    <label for="email" style="padding-left: 1px;padding-right: 650px;"><b>Email</b></label>
				    <input type="text" placeholder="Entrer l'email" name="email" required>
				
				    <label for="password" style="padding-left: 0px;padding-right: 559px;border-right-width: 0px;margin-right: 20px;"><b>Mot de passe</b></label>
				    <input type="password" placeholder="Entrer le mot de passe" name="password" required>
					
					<label for="nom" style="padding-left: 0px;padding-right: 559px;border-right-width: 0px;margin-right: 20px;"><b>Nom</b></label>
				    <input type="text" placeholder="Entrer le nom" name="nom" required>
				    
				    <label for="prenom" style="padding-left: 0px;padding-right: 559px;border-right-width: 0px;margin-right: 20px;"><b>Prénom</b></label>
				    <input type="text" placeholder="Entrer le prenom" name="prenom" required>
				    
				    <label for="etablissement" style="padding-left: 0px;padding-right: 559px;border-right-width: 0px;margin-right: 20px;"><b>Etablissement</b></label>
				    <input type="text" placeholder="Entrer l'etablissement" name="etablissement" required>
					<c:if test="${sessionScope.exist== true}"> <font
				          face="verdana"
				          color="red"> Compte qui existe déja !</font></c:if>
				    <button type="submit">S'inscrire</button>
				   </div>

				</form> 
			</div>
              
            </div>
          </div>
  
     
    </section>

   <%@include file= 'footer.jsp' %>

    

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

  <!-- Script to highlight the active date in the hours list -->
  <script>
    $('.list-hours li').eq(new Date().getDay()).addClass('today');
  </script>

</html>
