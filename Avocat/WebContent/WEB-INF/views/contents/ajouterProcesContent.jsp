<%@page import="models.Dossier"%>
<%@page import="java.util.ArrayList"%>
<div class="container">
      <section id="main-content">
        <section class="wrapper">
			 <img alt="" src="resources/images/img.jpg" id="img_display" style="height: 150px;"> 
			<hr>
              <h3 style="text-align: center" id="titre_display" ><i class="fa fa-angle-right"></i> Ajouter d'un proces</h3>
              <div class="row mt">
            <hr style="margin-top: -4px">
          

          <div class="row">
<!------------------------------formulaire du precision du dossier cible------------------------>                  
   <form action="AjouterProces" method="post" >
                  <div id="choixClient" style="display:block">
   
	                    <div class="col-xs-12 titles-style">
	                      <h5>veillez preciser le dossier cible</h5>
	                    </div> 
	
	
	                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
	                       <input class="effect-16" type="text"  id="cinClient" name="cinClient" <%if (request.getAttribute("cinClient")!=null){ %>value="<%=request.getAttribute("cinClient")%>"<%} %>>
	                       <label id="">cin Client</label>
	                       <span class="focus-border"></span>
	                    </div>
	                    
                  </div>
                   
                 <div id="clientValide" style="display:none">
                  <table class="table table-striped table-bordered table-hover table-sm table-responsive " >
						<thead class="thead-dark">
							<tr>
								<th>id</th>
								<th>Nom</th>
								<th>Prenom</th>
							</tr>
						</thead>
		
						<tbody class="">

                    		<tr class="trow">
								<td id="idClient"></td>
								<td id="nomClient"></td>
								<td id="prenomClient"></td>
							</tr>

                    	</tbody>
					</table>	 
                  
                  
                  <input type="hidden" name="action" value="validationClient">
        		</div>        
             
                                   
                   <div class="col-xs-12">
                   </div>
                   
                   
                   <div class="col-xs-3 col-xs-offset-2 herite-ajout-proces" style="display:none">
                    <button type="button" class="btn btn-primary" id="changeDisplay2" value="precedant" >précedant</button>
                   </div>
                   
                   <div class="col-xs-3 col-xs-offset-2 herite-ajout-proces" style="display:none">
                    <button type="submit" class="btn btn-primary" id="submitButton" value="oui" >chercher dossiers</button>
                   </div> 
                 
                   <div class="col-xs-3 col-xs-offset-5 herite-ajout-proces">
                    <button type="button" class="btn btn-primary" id="changeDisplay1" value="valider" >Suivant</button>
                   </div>  
	 </form>  

				</div>  
          	</div>   
          </section>
       </section>
    </div>
