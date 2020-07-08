<%@page import="models.Compte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.daoClient"%>
<%@page import="models.Client"%>


    <section class="wrapper site-min-height 001" style="display : none">
     <div class="row" id="mod" style="display: none;">
			<div class="col-lg-12">
				<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
					<div class="custom-box" id="procesBoxM">
						<div class="servicetitle">
	                  		<h4>Client</h4>
	                  		<hr>
	                	</div>
		                <div class="icn-main-container">
		                  <span class="icn-container">C</span>
		                </div>	
						<%ArrayList<Compte> list = daoClient.listClient();
						for(int i =0 ; i<list.size();i++){%>
						<div style="display: none;" class="update">
							<p style="display: none;">ID Client  :<input type="text" readonly="readonly" value="<%=list.get(i).getClient().getId()%>"></p>
							<ul class="pricingM">
								<li > <span class="procesTitles"><span class="spanM">Nom               : 	</span><input type="text" value="<%=list.get(i).getClient().getNom()%>" name=""></span><br></li>
								<li > <span class="procesTitles"><span class="spanM">Prenom            : 	</span><input type="text" value="<%=list.get(i).getClient().getPrenom()%>"></span><br></li>
								<li > <span class="procesTitles"><span class="spanM">EMAIL             : 	</span><input type="text" value="<%=list.get(i).getClient().getEmail() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Adresse           : 	</span><input type="text" value="<%=list.get(i).getClient().getAdresse() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Municipale        : 	</span><input type="text" value="<%=list.get(i).getClient().getMunicipale() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Lieu de naissance : 	</span><input type="text" value="<%=list.get(i).getClient().getLieuNais() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Telephone         : 	</span><input type="text" value="<%=list.get(i).getClient().getTelephone() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Date de naissance : 	</span><input type="date" value="<%=list.get(i).getClient().getDateNais() %>"></span></li>
								<%if(list.get(i).getEmailCl() != null){%>
								<li > <span class="procesTitles"><span class="spanM">EMAIL Client      : 	</span><input type="text" value="<%=list.get(i).getEmailCl()%>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Password          : 	</span><input type="text" value="<%=list.get(i).getPasswordCl()%>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Statut            :    </span><input type="text" value="<%=list.get(i).getStatut()%>"></span></li>
							<%}else{ %><%=""%><%} %>
							</ul>
							
						                            	
						</div>
                                
                                <%} %>
                       <button class="btn btn-theme" id="modifierCl">modifier</button>
         		
				</div>
				
			</div>
			
		</div>
		<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
            		<button class="btn btn-theme" id="previous" style="white-space: pre;height100%;width: 100%;">Precedent</button>
            </div>
		</div>
	</section>
	
