<div class="container">
      <section id="main-content">
        <section class="wrapper">
          <img alt="" src="resources/images/img.jpg" id="img_display" style="height: 150px;"> 
            <hr>
              <h3 style="text-align: center;" id="titre_display" ><i class="fa fa-angle-right"></i> Ajout d'un dossier</h3>
          <div class="row mt">
            <hr style="margin-top: -4px">
            <div class="row">
<form action="AD" method="post" enctype="multipart/form-data">              

              <div id="choixClient" style="display:block">
                <div class="col-xs-12 titles-style">
                  <h5>veillez precisez le client a qui appartient ce dossier</h5>
                </div> 


                <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                  <input class="effect-16 " type="text" placeholder="" name="cinClientAD" id="cinClientAD" name="cinClientAD" >
                  <label id="">cin client</label>
                  <span class="focus-border"></span>
                </div>
             

              <div class="col-xs-12">
              </div>

              <div class="col-xs-4 col-xs-offset-8 herite-ajout-proces" >
                <button type="button" class="btn btn-theme02" id="nouveauClientAD" value="">Nouveau client?</button>
              </div>

              

              <div class="col-xs-12">
              </div>
             
             </div>


             <div id="dossier" style="display:none">

                <div class="col-xs-12 titles-style">
                  <h5>informations relatives au dossier</h5>
                </div>

               <!-- <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                  <input class="effect-16 " type="text" placeholder="" name="" id="" >
                  <label id="">Date de creation du dossier</label>
                  <span class="focus-border"></span>
                </div>-->

                <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                  <select class="effect-16 input-effect" id="" style="width:100%" name="typeProces"><option></option> <option value="proces en droit de la famille" >proces en droit de la famille</option>  <option value="proces en droit civil" >proces en droit civil</option>  <option value="proces en droit du travail" >proces en droit du travail</option>  <option value="procès en droit administratif" >procès en droit administratif</option>  <option value="procès en droit commercial" >procès en droit commercial</option>  <option value="procès en droit pénal" >procès en droit pénal</option></select>
                  <label id="">type du proces</label>
                  <span class="focus-border"></span>
                </div>

                <div class="col-xs-8 col-xs-offset-2 input-effect herite-ajout-proces">
                  <input class="effect-16 " type="text" placeholder="" name="Description" id="desc" >
                  <label id="">Description</label>
                  <span class="focus-border"></span>
                </div>

                <div class="col-xs-12">
                </div>

            </div>
<!------------------------------------------------------------------------------ajout du proces----------------------------------------------->
            <div id="procesAD" style="display:none">

<!------------------------------premier formulaire de remplisssion d'un proces------------------------>
 
                  <div id="proces" style="display:block">                     

                    <div class="col-xs-12 titles-style">
                      <h5>informatons relatives au advairsaire</h5>
                    </div>

                    <div class="col-xs-2 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="nomAdv" id="nomAdv" >
                        <label id="cin1">Nom</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-2 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="prenomAdv" id="prenomAdv" >
                        <label id="cin1">Prenom</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-2 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="cinAdv" id="cinAdv" >
                        <label id="cin1">CIN</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-12">
                    </div>

                    

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16" type="text" placeholder="" name="adresseAdv" id="adresseAdv" >
                        <label id="cin1">Adresse</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="avocatAdv" id="avocatAdv" >
                        <label id="cin1">Avocat</label>
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
               		 <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
			        	<input class="effect-16" type="text" placeholder="" id="dateNotif" name="dateNotif">
			            <label>Date de notification</label>
			            <span class="focus-border"></span>
			        </div>
                    <!-- <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="" id="cin" >
                        <label id="cin1">Type de dossier</label>
                        <span class="focus-border"></span>
                    </div>-->
                    <div class="col-xs-12">
                    </div>
                     <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="description" id="description" >
                        <label id="cin1">Description</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-12">
                    </div>

                    <!--<div class="col-xs-8 col-xs-offset-2 input-effect herite-ajout-proces date form_datetime-component">
                       <div class="form-group">
                  <label class="control-label col-md-3"> Date d'ajout </label>
                  <div class="col-md-4">
                    <div class="input-group date form_datetime-component">
                      <input type="text" class="form-control" readonly="" size="16">
                      <span class="input-group-btn">
                        <button type="button" class="btn btn-theme date-set"><i class="fa fa-calendar"></i></button>
                        </span>
                    </div>
                  </div>
                </div>
                    </div>-->
                   </div> 
                   
                   <div class="col-xs-12">
                  </div>

                   <div id="file_upload" style="display:none"> 

                    <div class="col-xs-12 titles-style">
                      <h5>fichiers relatifs au proces</h5>
                    </div>

                    <div class="col-xs-8 col-xs-offset-1 input-effect herite-ajout-proces ">
                      <div class="abox">
                        <div class="aboxv">
                          <input type="file" name="file" id="video" class="inputfile" data-multiple-caption="{count} files selected" multiple accept="video/*" />
                          <label for="video" class="f_u_label"><i class="fas fa-video"></i> video</label>
                        </div>

                        <div class="aboxi">
                          <input type="file" name="file" id="image" class="inputfile" data-multiple-caption="{count} files selected" multiple  accept="image/*"/>
                          <label for="image" class="f_u_label"><i class="fas fa-images"></i> photo</label>
                        </div>

                        <div class="aboxw">
                          <input type="file" name="file" id="fword" class="inputfile"  accept=".docx,.doc"/>
                          <label for="fword" class="f_u_label"><i class="fas fa-file-word"></i> document word</label>
                        </div>

                        <div class="aboxp">
                          <input type="file" name="file" id="fpdf" class="inputfile" data-multiple-caption="{count} files selected" multiple  accept=".pdf"/>
                          <label for="fpdf" class="f_u_label"><i class="fas fa-file-pdf"></i> pdf</label>
                        </div>
                      </div>    
                   
                   </div> </div>

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
                       <input class="effect-16 " type="text" placeholder="" name="mtGlobal" id="mtGlobal" >
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
					
					
                    <div class="col-xs-5 col-xs-offset-3 input-effect herite mg">
			        	<input class="effect-16" type="text" placeholder="" id="datePay" name="datePay">
			            <label>Date de payement</label>
			            <span class="focus-border"></span>
			        </div>
			
                   </div> 

                   <div class="col-xs-12">
                   </div>


            </div>
            <input type="hidden" name="operation" value="addDF">
     
<!----------------------------------------------------------------------------fin d'ajout du proces-------------------------------------------->

            <div class="col-xs-12">
            </div>

            <div class="col-xs-3 col-xs-offset-2 herite-ajout-proces" style="display:none;">
                <button type="button" class="btn btn-primary" id="changeDisplay2AD" value="precedant">précedant</button>
            </div>


            <div class="col-xs-4 col-xs-offset-5 herite-ajout-proces" >
                <button type="button" class="btn btn-primary" id="changeDisplay1AD" value="suivant">suivant</button>
            </div>
            <div class="col-xs-4 col-xs-offset-5 herite-ajout-proces" style="display: none" >
                <button type="submit" class="btn btn-primary" id="SUBMIT" value="Confirmer">Confirmer</button>
            </div>
            </form>   
            </div>  
          </div>
        </section>
      </section>
  </div>  