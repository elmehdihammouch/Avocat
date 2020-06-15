<%@page import="java.sql.Date"%>
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
                 
                  
                
                  <div id="choixDossier" style="display:block">
					
					<div class="col-xs-12 titles-style">
                      <h5>liste des dossiers du client choisit</h5>
                    </div> 


                    <div class="col-xs-12  input-effect herite-ajout-proces">
                      <table class="table table-striped table-bordered table-hover table-sm table-responsive " >
						<thead class="thead-dark">
							<tr>
								<th>id</th>
								<th>etat avancement</th>
								<th>type du proces</th>
							</tr>
						</thead>
		
						<tbody class="">
<%ArrayList<Dossier> dossiers = new ArrayList<Dossier>();
  dossiers = (ArrayList<Dossier>)request.getAttribute("dossiers");
  int [] statut = new int[dossiers.size()];
	statut = (int[])request.getAttribute("statut");
     if(dossiers != null){
    	 int i =0;
     for(Dossier d : dossiers){%>
                    	
                    
							<tr class="trow">
								<td class="dossierContent"><%=d.getIdDos()%></td>
								<td class="dossierContent"><%=statut[i]%></td>
								<td class="dossierContent"><%=d.getDescription()%></td>
							</tr>
<% i++;	}} %>	
                    
                    
						</tbody>
					</table>	
                  </div>
                </div>
                  
                  
                  
                  
                  
                  
                  
                  
                
                  
                   
<!------------------------------premier formulaire de remplisssion d'un proces------------------------>
<form action="AjouterProces" method="post" enctype="multipart/form-data">
          <!-- input de precision du dossier cible -->         
                   <input class="effect-16 " type="hidden"  name="idDossierClicked" id="idDossierClicked"> 
                    <input class="effect-16 " type="hidden"  name="action" id="" value="donneesProces" > 
                    
                    
                  
                  <div id="proces" style="display:none">                     

                    <div class="col-xs-12 titles-style">
                      <h5>informatons relatives au advairsaire</h5>
                    </div>

                    <div class="col-xs-2 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="nomAdv" id="nom" >
                        <label id="">Nom</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-2 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="prenomAdv" id="prenom" >
                        <label id="">Prenom</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-2 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="cinAdv" id="cinAdv" >
                        <label id="">CIN</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-12">
                    </div>

                    

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16" type="text" placeholder="" name="adresseAdv" id="adresse" >
                        <label id="">Adresse</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="avocatAdv" id="avocatAdv" >
                        <label id="">Avocat</label>
                        <span class="focus-border"></span>
                    </div>

                     

                    <div class="col-xs-12 titles-style">
                      <h5>informatons relatives au proces</h5>
                    </div>
                    
                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
	                  <select class="effect-16 input-effect" id="statut" style="width:100%" name="statut"><option></option><option value="premiere Instance">premiere Instance</option> <option value="deuxieme Instance" >deuxieme Instance</option>  <option value="troisieme Instance" >troisieme Instance</option></select>
	                  <label id="">type du proces</label>
	                  <span class="focus-border"></span>
               		 </div>
                
                	<div class="col-xs-4 col-xs-offset-1 input-effect herite mg">
			        	<input class="effect-16" type="text" placeholder="" id="dateNotif" name="dateNotif">
			            <label>Date de notification</label>
			            <span class="focus-border"></span>
			        </div>
			        
			         <div class="col-xs-12">
                    </div>

                     

                     <div class="col-xs-9 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="description" id="description" >
                        <label id="">Description</label>
                        <span class="focus-border"></span>
                    </div>
                    
                    

                    <div class="col-xs-12">
                    </div>

                    
                </div>
                    
                 
                   
                   <div class="col-xs-12">
                  </div>

                   <div id="file_upload" style="display:none"> 

                    <div class="col-xs-12 titles-style">
                      <h5>fichiers relatifs au proces</h5>
                    </div>

                    <div class="col-xs-10 col-xs-offset-1 input-effect herite-ajout-proces ">
                      <div class="container-fluid">
                         <div class="row">
                         	 <div class="abox ">

                     
                      <div class="col-xs-2 col-xs-offset-1">  
                        <div class="aboxv">
                          <input type="file" name="file" id="video" class="inputfile" data-multiple-caption="{count} files selected" multiple accept="video/*" />
                          <label for="video" class="f_u_label"><i class="fas fa-video"></i> video</label>
                        </div>
                      </div>  
<div class="col-xs-12"></div>
                    
                    <div class="col-xs-2 col-xs-offset-3">
                        <div class="aboxi ">
                          <input type="file" name="file" id="image" class="inputfile" data-multiple-caption="{count} files selected" multiple  accept="image/*"/>
                          <label for="image" class="f_u_label"><i class="fas fa-images"></i> photo</label>
                        </div>
                    </div> 
                       
    <div class="col-xs-12"></div>
                       
                    <div class="col-xs-2 col-xs-offset-5">                 
						<div class="aboxw">
                          <input type="file" name="file" id="fword" class="inputfile"  accept=".docx,.doc,.txt"/>
                          <label for="fword" class="f_u_label"><i class="fas fa-file-word"></i> text</label>
                        </div>
                    </div>    
                    
<div class="col-xs-12"></div>

                    <div class="col-xs-2 col-xs-offset-7">
                        <div class="aboxp">
                          <input type="file" name="file" id="fpdf" class="inputfile" data-multiple-caption="{count} files selected" multiple  accept=".pdf"/>
                          <label for="fpdf" class="f_u_label"><i class="fas fa-file-pdf"></i> pdf</label>
                        </div>
                    </div>  
                      
   <div class="col-xs-12"></div>
   
                    <div class="col-xs-2 col-xs-offset-9">                   
                        <div class="aboxa ">
                          <input type="file" name="file" id="faudio" class="inputfile" data-multiple-caption="{count} files selected" multiple  accept="audio/*"/>
                          <label for="faudio" class="f_u_label"><i class="fas fa-file-audio"></i>audio</label>
                        </div>
                    </div>    
<div class="col-xs-12"></div>
                                      
                        
                       </div> 
                      </div>    
                   	</div>
                   </div> 
              </div>

                   <div id="facture" style="display:none"> 

                    <div class="col-xs-12 titles-style">
                      <h5>informatons relatives à la facture</h5>
                    </div>

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="FMB" id="FMB" >
                        <label id="">montant de base</label>
                        <span class="focus-border"></span>
                    </div>

                   
                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="prixKm" id="prixKm" >
                        <label id="">prix par Km</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-12">
                    </div>
                    
                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="mtGlobal" id="mtGlobal" value="0" >
                        <label id="">montant global</label>
                        <span class="focus-border"></span>
                    </div>
                    
                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="mtPaye" id="mtPaye" >
                        <label id="">montant payé</label>
                        <span class="focus-border"></span>
                    </div>
                    
                    <div class="col-xs-12">
                    </div>
                    
                    <div class="col-xs-5 col-xs-offset-3 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="mtRestant" id="mtRestant" value="0" >
                        <label id="">montant Restant</label>
                        <span class="focus-border"></span>
                    </div>
                    
                     
                   <div class="col-xs-12">
                    </div>
					
					
                    <div class="col-xs-5 col-xs-offset-3 input-effect herite mg">
			        	<input class="effect-16" type="text" placeholder="" id="datePay" name="datePay">
			            <label>Date de payement</label>
			            <span class="focus-border"></span>
			        </div>

                   </div> 
                   
                   <div class="col-xs-12">
                   </div>
                   
                   
                   <div class="col-xs-3 col-xs-offset-2 herite-ajout-proces" style="display:none">
                    <button type="button" class="btn btn-primary" id="changeDisplay2" value="precedant" >précedant</button>
                   </div>
                   
                   <div class="col-xs-3 col-xs-offset-2 herite-ajout-proces" style="display:none">
                    <button type="button" class="btn btn-primary" id="submitButton" value="valider" >Ajouter le proces</button>
                   </div> 
                 
                 </form>  
			<!-- ---------------------------------------------------------------------------------------- -->
                    <form action="AjouterProces" method="post">
	                   <div class="col-xs-3 col-xs-offset-2 herite-ajout-proces" style="display:block">
	                    <button type="submit" class="btn btn-primary" id="backSubmitButton" name="action" value="backSubmitButton" >précedent</button>
	                    <input class="effect-16 " type="hidden"  id="cinClient" name="cinClient" <%if (request.getAttribute("cinClient")!=null){ %>value="<%=request.getAttribute("cinClient")%>"<%} %>> 
	                   </div> 
	                </form>
                   
                   
                   <div class="col-xs-3 col-xs-offset-2 herite-ajout-proces">
                    <button type="button" class="btn btn-primary" id="changeDisplay1" value="valider" >Suivant</button>
                   </div>  
                   
                  
                   


				</div>  
          	</div>
          </section>
       </section>
    </div>