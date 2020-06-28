<%@page import="java.util.ArrayList"%>
<%@page import="DAO.daoClient"%>
<%@page import="models.Client"%>


    <section class="wrapper site-min-height">
     <div class="row" id="mod" style="display: none;">
			<div class="col-lg-12">
				<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
					<div class="custom-box" id="procesBox">
						<div class="servicetitle">
	                  		<h4>Client</h4>
	                  		<hr>
	                	</div>
		                <div class="icn-main-container">
		                  <span class="icn-container">C</span>
		                </div>	
						<%ArrayList<Client> list = daoClient.listClient();
						for(int i =0 ; i<list.size();i++){%>
						<div style="display: none;" class="update">
							<p style="display: none;">ID Client  :<input type="text" readonly="readonly" value="<%=list.get(i).getId()%>"></p>
							<ul class="pricingM">
								<li > <span class="procesTitles"><span class="spanM">Nom               : 	</span><input type="text" value="<%=list.get(i).getNom()%>" name=""></span><br></li>
								<li > <span class="procesTitles"><span class="spanM">Prenom            : 	</span><input type="text" value="<%=list.get(i).getPrenom()%>"></span><br></li>
								<li > <span class="procesTitles"><span class="spanM">EMAIL             : 	</span><input type="text" value="<%=list.get(i).getEmail() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Adresse           : 	</span><input type="text" value="<%=list.get(i).getAdresse() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Municipale        : 	</span><input type="text" value="<%=list.get(i).getMunicipale() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Lieu de naissance : 	</span><input type="text" value="<%=list.get(i).getLieuNais() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Telephone         : 	</span><input type="text" value="<%=list.get(i).getTelephone() %>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Date de naissance : 	</span><input type="date" value="<%=list.get(i).getDateNais() %>"></span></li>
								<%if(list.get(i).getCompte().getEmailCl() != null){%>
								<li > <span class="procesTitles"><span class="spanM">EMAIL Client      : 	</span><input type="text" value="<%=list.get(i).getCompte().getEmailCl()%>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Password          : 	</span><input type="text" value="<%=list.get(i).getCompte().getPasswordCl()%>"></span></li>
								<li > <span class="procesTitles"><span class="spanM">Statut            :    </span><input type="text" value="<%=list.get(i).getCompte().getStatut()%>"></span></li>
							<%}else{ %><%=""%><%} %>
							</ul>
							
						                            	
						</div>
                                
                                <%} %>
                       <button class="btn btn-theme" id="modifierCl">modifier</button>
         		
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 col-lg-offset-6 col-md-offset-6 col-sm-offset-6">
            <button class="btn btn-theme" id="previous">Precedent</button>
            </div>
			</div>
		</div>
		</div>
	</section>
	
