<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Inscription Admin</title>
        <link href="dist/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
		.btn {
		  background-color: #e6a756;
		  border: none;
		  color: white;
		  padding: 12px 30px;
		  cursor: pointer;
		  font-size: 20px;
		}
		
		/* Darker background on mouse-over */
		.btn:hover {
		  background-color: RoyalBlue;
		}
				a {
		  text-decoration: none;
		  display: inline-block;
		  padding: 8px 16px;
		}
		
		a:hover {
		  background-color: #ddd;
		  color: black;
		}
		
		.previous {
		  background-color: #e6a756;
		  color: black;
		}
		
		.next {
		  background-color: #4CAF50;
		  color: white;
		}
		
		.round {
		  border-radius: 50%;
		}
		</style>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                	
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">  <a href="#" class="previous round">&#8249;</a>   Ajout d'un nouvel élément patrimonial </h3></div>
                                   <!--  <div class="col-xl-9 col-lg-10 mx-auto">   -->
                                    	<div class="card-body">
                                        <form class=" form-a" action="RegistrationAdmin" method="post" enctype="multipart/form-data" > 
                                            
      	<!--  <p class="h5 mb-6">Ajout d'un nouvel élément patrimonial :</p>--><br>
      		<div class="form-row mb-4">
      
			       <div class="form-group">
			      <div class="col-lg-30">
			            <p >Type de l'élément :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Maison traditionnelle"  name="nom_mai" id="nom_mai">
			          </p>
			        </div>
			      <div class="col-lg-30">
			            <p >Nom de l'élément :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Dar Hassan Pacha"  name="nom_mai" id="nom_mai">
			          </p>
			        </div>
			
			<input type="checkbox" onchange="handleNom(this);"> Cet élément a un autre nom.<br><br>
				<div id="autre_nom" style="visibility:hidden;class=""col-lg-30">
					<p >Le deuxième nom de l'élément :
					<input type="text" class="form-control form-control-lg form-control-a" placeholder="Le deuxième nom de la maison"  name="nom_deux_mai" id="nom_deux_mai">
					 </p>
				</div>      
			
			             <p >La description de l'élément :
			              <textarea  class="form-control" name="description_mai"  id="description_mai" 
			              data-rule="required"  placeholder="Dar Hassen Pacha « le palais d’hiver »se situe dans la basse Casbah, dans le quartier Souk-el-Djemâa, en face Dar Aziza, mitoyenne à la mosquée Ketchaoua, bordant la place Cheikh Ben Badis.
Ce palais fût construit en 1791 par le Dey d’Alger Hassen El-Kheznadji dit Baba Hassen ;"></textarea>
			              </p>
			              
			              <p >Le type de la maison:
			              <select class="form-control form-control-lg form-control-a" name="type_mai" id="type_mai">
			                  <option value="1">Maison à West Eddar</option>
			                  <option value="2">Maison Alawi</option>
			                  <option value="3">Maison à Chbek</option>
			              </select>
			              </p>
			              
			            
			                 
			           <div class="col-lg-30">
			            <p> Altitude :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="36.785045"  name="altitude_mai" id="altitude_mai">
			            </p>
						 </div>
						 <div class="col-lg-30">
			            <p> Longitude:
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="3.061544"  name="longitude_mai" id="longitude_mai">
			            </p>
			            </div>
			       
			           <div class="col-lg-30">
			             <p> Date de la construction :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="1791"  name="date_const_mai" id="date_const_mai">
			            </p>
			            </div>
			            <div class="col-lg-30">
			            <p> Période de la construction :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Ottomane"  name="période_const_mai" id="période_const_mai">
			            </p>
			            </div>
			            <div class="col-lg-30">
			            <p> Constructeur :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="Hassen El-Kheznadji"  name="période_const_mai" id="période_const_mai">
			            </p>
			            
			         </div>
			         
			          
			            <div class="col-lg-30">
			             <p> Surface du sol :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="non renseigné"  name="surface_sol" id="surface_sol">
			            </p>
			            </div>
			            <div class="col-lg-30">
			            <p> Surface de la maison :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="non renseigné"  name="surface_mai" id="surface_mai">
			            </p>
			         </div>
			         <p> Image de l'élément : </p>
				   <div class="form-group">
				     
		             Dar_hassan_pacha.png          
         		  <button class="btn"><i class="fa fa-download"></i> Download</button>
          			  <div id="list"></div>   
       				 </div>
				    <div class="col-lg-30">
			             <p> Source :
			            <input type="text" class="form-control form-control-lg form-control-a" placeholder="http://cnra.dz/atlas/868-2/"  name="surface_sol" id="surface_sol">
			            </p>
			            </div>
				    <input type="checkbox" onchange="handleNom(this);"> Une autre source.<br><br>
						<div id="autre_src" style="visibility:hidden;class=""col-lg-30">
							<p >Les autres sources
							<input type="text" class="form-control form-control-lg form-control-a" placeholder="Les autres sources" >
							 </p>
						</div>    
			         
			          </div>
			           </div>
			 
			 
			       <!--  <div id="buttonSubmit" class="col center">
			                <button type="submit" class="btn btn-success">Valider</button>
			                   
			    </div>-->
			     <div class="col center">
			      <a href="Dashboard?val=1&mail=${sessionScope.listArchi.get(i-1).getMail()}" class="button button1"  role="button" >Valider</a>
                                                <a href="Dashboard?val=0&mail=${sessionScope.listArchi.get(i-1).getMail()}"  class="button button2"  role="button">Refuser</a>
                   
			     </div>
			                                 
   </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="DashboardExpert">Retour au tableau de bord</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
           
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="dist/js/scripts.js"></script>
        <script>
         function handleNom(checkbox){
	 if (checkbox.checked==true){
		 document.getElementById("autre_nom").style.visibility="visible";
	 }else{
		 document.getElementById("autre_nom").style.visibility="hidden";
	 }
 }
        </script>
        <script>
        function handleSrc(checkbox){
       	 if (checkbox.checked==true){
       		 document.getElementById("autre_src").style.visibility="visible";
       	 }else{
       		 document.getElementById("autre_src").style.visibility="hidden";
       	 }
        }
          
        </script>
        <script>
            /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img height="60" src="' + event.target.result + '" />';
                        imageList.appendChild( span );
                    });

                    reader.readAsDataURL( file );
                }
            }
        </script>
    </body>
</html>
