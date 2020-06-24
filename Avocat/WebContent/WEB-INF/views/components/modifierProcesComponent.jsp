
			
				
				
<div id="modificationDiv"	style="display:none;"	>
	<section id="main-content">
      <section class="wrapper site-min-height">
        <div class="row">
          <div class="col-lg-10 col-lg-offset-2">
            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
              <div class="custom-box" id="procesBoxM">
                <div class="servicetitle">
                  <h4>Proces</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">P</span>
                </div>
                <p><span class="procesTitles"><span class="spanM"></span><span></span></span> </p>
                <ul class="pricingM">
                 <li id="clientM" ><span class="procesTitles"><span class="spanM">Client : </span><span style="color : red"></span></span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Date de creation : </span><span style="color : red"></span></span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Date d'acceptation : </span><input type="datetime-local" value="" name="dateAcceptationM" id="dateAcceptationM"  ></span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Date de notification : </span><input type="datetime-local" value="" name="dateNotifM" id="dateNotifM" >  </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Numero du proces : </span><input type="text" placeholder="---" value="" name="numeroProcesM" id="numeroProcesM"> </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Instance : </span><span style="color : grey"></span></span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Nom du advairsaire : </span><input type="text" placeholder="---" value="" name="nomAdvM" id="nomAdvM"> </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Prenom du advairsaire : </span><input type="text" placeholder="---" value="" name="prenomAdvM" id="prenomAdvM"> </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">CIN advairsaire : </span><input type="text" placeholder="---" value="" name="cinAdvM" id="cinAdvM" > </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Adresse adversaire : </span><input type="text" placeholder="---" value=""  name="adresseAdvM" id="adresseAdvM"> </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Avocat advairsaire : </span><input type="text" placeholder="---" value="" name="avocatAdvM" id="avocatAdvM" > </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Tribunal : </span><input type="text" placeholder="---" value="" name="tribunalM"  id="tribunalM"> </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Ville : </span><input type="text" placeholder="---" value="" name="villeM" id="villeM" > </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Numero de la salle : </span><input type="text" placeholder="---" value="" name="numeroSalM"  id="numeroSalM"> </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Date de la seance : </span><input type="datetime-local" value="" name="dateSeaM" id="dateSeaM" > </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Jugement : </span><input type="text" placeholder="---" value="" name="jugementM" id="jugementM"> </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Date du jugement : </span><input type="datetime-local" value="" name="dateJugM" id="dateJugM"> </span><br></li>
                  <li > <span class="procesTitles"><span class="spanM">Date de la seance suivante : </span><input type="datetime-local" value="" name="dateSuivM" id="dateSuivM" > </span><br></li>
                   <li > <span class="procesTitles"><span class="spanM">Description: </span><input type="text" placeholder="---" value="" name="descriptionM" id="descriptionM"> </span><br></li>
				 </ul>
                <button class="btn btn-theme" id="modifierProces" onclick="modifierProces()">modifier</button>
              </div>
              <!-- end custombox -->
            </div>
            <!-- end col-4 -->
            <div class="col-lg-8 col-md-12 col-sm-12 col-xs-12">
              <div class="custom-box" id="factureBoxM">
                <div class="servicetitle">
                  <h4>Facture</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">F</span>
                </div>
                <p></p>
                <ul class="pricingM">
                  <li > <span class="procesTitles"><span class="spanM">Numero de la  facture : </span><span id="idFacture"></span></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Montant de base :  </span><span id="montantBaseM"></span></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Longueur par Km :</span><input type="text" placeholder="-" value="" name="lgKmM" id="lgKmM"></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Prix par Km : </span><input type="text" placeholder="-" value="" name="prixKmM" id="prixKmM"></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Indemnité kilométrique :</span><span id="IndemniteKmM"></span></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Duree par jour par jour :</span><input type="text" placeholder="-" value="" name="dureeJrM" id="dureeJrM"></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Prix par jour :</span><input type="text" placeholder="-" value="" name="prixJrM" id="prixJrM"></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Frais du logement:</span><span id="fraisLogM"></span></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Montant Global :  </span><span  id="mtGlobalM"></span></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Montant payé : </span><input type="text" placeholder="-" value="" name="mtPayeM" id="mtPayeM"></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Montant restant : </span><span id="mtRestantM"></span></span><br></li>
                <li > <span class="procesTitles"><span class="spanM">Date de payement : </span><input type="datetime-local" value="" name="datePayM" id="datePayM"></span><br></li>
                </ul>
                <button class="btn btn-theme" id="modifierFacture" onclick="modifierFacture()">modifier</button>
              </div>
              <!-- end custombox -->
            </div>
            <!-- end col-4 -->
            <div class="col-lg-8 col-md-12 col-sm-12 col-xs-12">
              <div class="custom-box" id="filesBoxM">
                <div class="servicetitle">
                  <h4>Files</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">FS</span>
                </div>
                <p></p>
                <ul class="pricingM">
                
                </ul>
                <button class="btn btn-theme" >modifier</button>
              </div>
              <!-- end custombox -->
            </div>
            <div class="col-xs-12">
                    </div>
            
            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 col-lg-offset-6 col-md-offset-6 col-sm-offset-6">
            <button class="btn btn-theme" onclick="precedent()">Precedent</button>
            </div>
            <!-- end col-4 -->
          </div>
          <!--  /col-lg-12 -->
        </div>
        <!--  /row -->
      </section>
      <!-- /wrapper -->
    </section>
</div>		    
				
				
				

			