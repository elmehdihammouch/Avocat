    <div class="container">
      <section id="main-content">
        <section class="wrapper">
          <img alt="" src="resources/images/img.jpg" id="img_display" style="height: 150px;"> 
            <hr>
              <h3 style="text-align: center" id="titre_display" ><i class="fa fa-angle-right"></i> Ajouter une consultation</h3>
              <div class="row mt"><hr style="margin-top: -4px">
          

                <div class="row">
<!------------------------------formulaire du precision du dossier cible------------------------>                  
                  <div id="choixConsultaion" style="display:block">
                    <div class="col-xs-12 titles-style">
                      <h5>veillez entrer le CIN</h5>
                    </div> 


                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-consultation">
                       <input class="effect-16 " type="text" placeholder="" name="" id="cinAC" >
                        <label>CIN</label>
                        <span class="focus-border"></span>
                    </div>
                  </div>
                  <div class="col-xs-12">
              	  </div> 
                  <div class="col-xs-4 col-xs-offset-8 herite-ajout-proces" id="divadd">
                	<button type="button" class="btn btn-theme02" id="nouveauClientAD" value="">Nouveau client?</button>
             	  </div>
<!------------------------------premier formulaire de remplisssion d'un proces------------------------>
 
                  <div id="consultation" style="display:none">                     

                     

                    <div class="col-xs-12 titles-style">
                      <h5>informatons relatives au Consultation</h5>
                    </div>

                     <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-proces">
                  <select class="effect-16 input-effect" id="type" style="width:100%" name="typeProces"><option></option> <option value="proces en droit de la famille" >proces en droit de la famille</option>  <option value="proces en droit civil" >proces en droit civil</option>  <option value="proces en droit du travail" >proces en droit du travail</option>  <option value="procès en droit administratif" >procès en droit administratif</option>  <option value="procès en droit commercial" >procès en droit commercial</option>  <option value="procès en droit pénal" >procès en droit pénal</option></select>
                  <label id="type">type du proces</label>
                  <span class="focus-border"></span>
                	</div>
                      <div class="col-xs-12">
                    </div>
                    
                     <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-consultation">
                       <input class="effect-16 " type="text" placeholder="" name="" id="desc" >
                        <label id="desc">Description</label>
                        <span class="focus-border"></span>
                    </div>
                    <div class="col-xs-12">
                    </div>
                    <div class="col-xs-4 col-xs-offset-1 input-effect herite-ajout-consultation">
                       <input class="effect-16 " type="number" placeholder="" name="" id="frais" >
                        <label id="frais">Frais</label>
                        <span class="focus-border"></span>
                    </div>

                    <div class="col-xs-12">
                    </div>                   
                  </div>
                   
                   <div class="col-xs-12">
                  </div>


                   <div class="col-xs-3 col-xs-offset-5 herite-ajout-consultation" id="divsuiv">
                    <button type="button" class="btn btn-primary" id="changeDisplay1" value="valider">Suivant</button>
                   </div>  
                   <div class="col-xs-3 col-xs-offset-5 herite-ajout-consultation" id="divconf" style="display: none">
                    <button type="button" class="btn btn-primary" id="confirmer" value="confirmer">Confirmer</button>
                   </div>
     
            </div>  
          </div>
          </section>
        </section>
    </div>
