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
                  <div id="choixClient" style="display:block">
                    <div class="col-xs-12 titles-style">
                      <h5>veillez preciser le dossier cible</h5>
                    </div> 


                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder=""  id="cinClient" name="cinClient" >
                        <label id="">cin Client</label>
                        <span class="focus-border"></span>
                    </div>
                  </div>
                  
                  <div id="choixDossier" style="display:none">
                    <div class="col-xs-12 titles-style">
                      <h5>liste des dossiers du client choisit</h5>
                    </div> 


                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder=""  name="" >
                        <label>id dossier</label>
                        <span class="focus-border"></span>
                    </div>
                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder=""   name="" >
                        <label >id dossier</label>
                        <span class="focus-border"></span>
                    </div>
                  </div>
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                   
<!------------------------------premier formulaire de remplisssion d'un proces------------------------>
 
                  <div id="proces" style="display:none">                     

                    <div class="col-xs-12 titles-style">
                      <h5>informatons relatives au advairsaire</h5>
                    </div>

                    <div class="col-xs-2 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="nom" id="nom" >
                        <label id="">Nom</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-2 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="prenom" id="prenom" >
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
                       <input class="effect-16" type="text" placeholder="" name="adresse" id="adresse" >
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

                     

                     <div class="col-xs-9 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="description" id="description" >
                        <label id="">Description</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-12">
                    </div>

                    <div class="col-xs-8 col-xs-offset-2 input-effect herite-ajout-proces date form_datetime-component">
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
                    </div>
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
                      <h5>informatons relatives � la facture</h5>
                    </div>

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="FMB" id="FMB" >
                        <label id="">montant de base</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="FFL" id="FFL" >
                        <label id="">frais du logement</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-12">
                    </div>

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="FIK" id="FIK" >
                        <label id="">indemnit� kilom�trique</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="FPJ" id="FPJ" >
                        <label id="">prix par jour</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-12">
                    </div>

                    <div class="col-xs-5 col-xs-offset-3 input-effect herite-ajout-proces">
                       <input class="effect-16 " type="text" placeholder="" name="FMG" id="FMG" >
                        <label id="">Montant global</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-5 col-xs-offset-3 input-effect herite-ajout-proces date form_datetime-component">
                        <input type="text" class="form-control" readonly="" size="16">
                      <span class="input-group-btn">
                        <button type="button" class="btn btn-theme date-set"><i class="fa fa-calendar"></i></button>
                        </span>
                    </div>

                   </div> 

                   <div class="col-xs-12">
                   </div>

                   <div class="col-xs-3 col-xs-offset-2 herite-ajout-proces" style="display:none">
                    <button type="button" class="btn btn-primary" id="changeDisplay2" value="precedant" >pr�cedant</button>
                   </div>

                   <div class="col-xs-3 col-xs-offset-5 herite-ajout-proces">
                    <button type="button" class="btn btn-primary" id="changeDisplay1" value="valider" >Suivant</button>
                   </div>  


				</div>  
          	</div>
          </section>
        </section>
    </div>