<%@page import="DAO.daoAjouterDossier"%>
<%@page import="DAO.daoAjouterDossier.MyResult"%>
<%@page import="java.util.ArrayList"%>



    <section class="wrapper">
     <div class="row" id="affichage" style="display: none;">
			<div class="col-lg-12">
				<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
					<div class="custom-box" id="DossierBox">
						<div class="servicetitle">
                  			<h4>Dossier</h4>
                  			<hr>
                		</div>
                		<div class="icn-main-container">
                  			<span class="icn-container">D</span>
                		</div>	
						<%ArrayList<MyResult> list = daoAjouterDossier.listDossier();
						String stat = null ;
		                                        	for(int i =0 ; i<list.size();i++){
		                                        	if(list.get(i).getStatut()==1){
		                                        		stat ="Premiere Instance";}else if(list.get(i).getStatut()==2){stat="Deuxieme instance";}else if(list.get(i).getStatut()==3){stat="troisieme instance";}
		                                        	%>
		                                        	
		                                        	<div style="display: none;" class="search">
		                                        	 <p style="display: none;">ID Client  :<input type="text" readonly="readonly" value="<%=list.get(i).getDossier().getIdDos()%>"></p>
														<ul class="pricing">
															<li ><span class="procesTitles">Nom : </span><div class="titlesContent"><%=list.get(i).getDossier().getClient().getNom()%></div></li>
															<li > <span class="procesTitles">Prenom : </span><div class="titlesContent"><%=list.get(i).getDossier().getClient().getPrenom()%></div></li>
															<li > <span class="procesTitles">CIN :  </span><div class="titlesContent"><%=list.get(i).getDossier().getClient().getCin()%></div></li>
															<li > <span class="procesTitles">EMAIL : </span><div class="titlesContent"><%=list.get(i).getDossier().getClient().getEmail()%></div></li>
															<li > <span class="procesTitles">Telephone :</span><div class="titlesContent"><%=list.get(i).getDossier().getClient().getTelephone()%></div></li>
															<li > <span class="procesTitles">Type de proces : </span><div class="titlesContent"><%=list.get(i).getDossier().getTypeProces()%></div></li>
															<li > <span class="procesTitles">Statut : </span><div class="titlesContent"><%=stat%></div></li>
															<li > <span class="procesTitles">Description :</span><div class="titlesContent"><%=list.get(i).getDossier().getDescription()%></div></li>
															
														</ul>
														
		                                        	
		                                               </div>
		                                            	
		                                            <%} %>
		                                            <a class="btn btn-theme" href="#" id="print">Imprimer</a>
		                                            
		            		
					</div>
					
            		
            
				</div>
				<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
            			<button class="btn btn-theme" id="prev" style="white-space: pre;height100%;width: 100%;">Precedent</button>
            	</div>
			</div>
		</div>
	</section>
