<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter élément</title>
</head>
<body>
<%@include file="headerArchitecte.jsp" %>
  <br>
  <br>
<div class="container"> 

       <div class="col-xl-9 col-lg-10 mx-auto">
	  	<form class=" form-a"  method="post" action="ajoutMai" enctype="multipart/form-data" >
  	
  		<div class="bg-faded p-5">
  
      	<p class="h5 mb-6">Ajouter une maison traditionnelle :</p>
      <div class="form-row mb-4">

        </div>
         <div class="row">
          <p >Le nom de la maison:
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Nom de la maison"  name="nom_mai" id="nom_mai">
          </p>
            <p> Source:
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Source du nom"  name="sourceNom" id="SourceNom">
            </p>
            </div>

<input type="checkbox" onchange="handleNom(this);"> Cette maison a un autre nom.<br><br>
<!--  <div id="autre_nom" style="visibility:hidden;class=col-lg-30">
<p >Le deuxième nom de la maison:
<input type="text" class="form-control form-control-lg form-control-a" placeholder="Le deuxième nom de la maison"  name="nom_deux_mai" id="nom_deux_mai">
 </p>
</div>    -->  

             <p >La description de la maison:
              <textarea  class="form-control" name="description_mai"  id="description_mai" 
              data-rule="required"  placeholder="Description de la maison"></textarea>
              </p>
                <p> Source de la description:
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Source de la description"  name="sourceDesc" id="SourceDesc">
            </p>
         <div class="row"> 
              <p >Le type de la maison:
              <select class="form-control form-control-lg form-control-a" name="type_mai" id="type_mai">
                  <option value="1">Maison à West Eddar</option>
                  <option value="2">Maison Alawi</option>
                  <option value="3">Maison à Chbek</option>
              </select>
              </p>
              
            <p> Source:
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Source du type"  name="sourceType" id="sourceType">
            </p>
            </div>

            
                 
           <div class="row">
            <p> Altitude:
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Altitude"  name="altitude_mai" id="altitude_mai">
            </p>
            <p> Longitude:
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Longitude"  name="longitude_mai" id="longitude_mai">
            </p>
             <p> Source:
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Source des coordonnées"  name="sourceCoord" id="sourceCoord">
            </p>
            </div>
       
           <div class="row">
             <p> Date de la construction :
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Date de la construction"  name="date_const_mai" id="date_const_mai">
            </p>
            <p> Période de la construction :
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Période de la construction"  name="période_const_mai" id="période_const_mai">
            </p>
         </div>
         
          <div class="row">
             <p> Surface du sol :
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Surface du sol"  name="surface_sol" id="surface_sol">
            </p>
            <p> Surface de la maison :
            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Surface de la maison"  name="surface_mai" id="surface_mai">
            </p>
         </div>
         
         <div class="form-group">
          <p> Image de la maison :  
	          <input type="file" name="image_mai" id="image_mai" class="form-control form-control-lg form-control-a" 
	          placeholder="Uploader l'image de la maison">
	          </p>
	          <div class="validation"></div>
	     
	    </div>
	    
         
          </div>
           </div>
 
 
        <div id="buttonSubmit" class="col center">
                <button type="submit" class="btn btn-success">Valider</button>
                   
    </div>
  	</form>
</div>
</div>

<br>
<%@include file="footer.jsp" %>
<!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script>
 function handleNom(checkbox){
	 if (checkbox.checked==true){
		 document.getElementById("autre_nom").style.visibility="visible";
	 }else{
		 document.getElementById("autre_nom").style.visibility="hidden";
	 }
 }

 
</script>
</body>
</html>
