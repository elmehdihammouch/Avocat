<%@page import="java.util.ArrayList"%>
<%@page import="DAO.daoClient"%>
<%@page import="models.Client"%>


    <section class="wrapper">
     <div class="row" id="affichage" style="display: none;">
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
                                        	<div style="display: none;" class="search">
                                        	 <p style="display: none;">ID Client  :<input type="text" readonly="readonly" value="<%=list.get(i).getId()%>"></p>
												<ul class="pricing">
													<li ><span class="procesTitles">Nom : </span><div class="titlesContent"><%=list.get(i).getNom()%></div></li>
													<li > <span class="procesTitles">Prenom : </span><div class="titlesContent"><%=list.get(i).getPrenom()%></div></li>
													<li > <span class="procesTitles">CIN :  </span><div class="titlesContent"><%=list.get(i).getCin()%></div></li>
													<li > <span class="procesTitles">EMAIL : </span><div class="titlesContent"><%=list.get(i).getEmail()%></div></li>
													<li > <span class="procesTitles">Adresse : </span><div class="titlesContent"><%=list.get(i).getAdresse()%></div></li>
													<li > <span class="procesTitles">Municipale :</span><div class="titlesContent"><%=list.get(i).getMunicipale()%></div></li>
													<li > <span class="procesTitles">Lieu de naissance :</span><div class="titlesContent"><%=list.get(i).getLieuNais()%></div></li>
													<li > <span class="procesTitles">Nationalité : </span><div class="titlesContent"><%=list.get(i).getNationalite()%></div></li>
													<li > <span class="procesTitles">Telephone :</span><div class="titlesContent"><%=list.get(i).getTelephone()%></div></li>
													<li > <span class="procesTitles">Date de naissance : </span><div class="titlesContent"><%=list.get(i).getDateNais()%></div></li>
													<li > <span class="procesTitles">EMAIL Client : </span><div class="titlesContent"><%if(list.get(i).getCompte().getEmailCl() != null){%><%=list.get(i).getCompte().getEmailCl()%><%}else{ %><%="Compte desactivé ou ne pas crée "%><%} %></div></li>
													<li > <span class="procesTitles">Password :</span><div class="titlesContent"><%if(list.get(i).getCompte().getEmailCl() != null){%><%=list.get(i).getCompte().getPasswordCl()%><%}else{ %><%="Compte desactivé ou ne pas crée "%><%} %></div></li>
													<li > <span class="procesTitles">Statut : </span><div class="titlesContent"><%if(list.get(i).getCompte().getEmailCl() != null){%><%=list.get(i).getCompte().getStatut()%><%}else{ %><%="Compte desactivé ou ne pas crée "%><%} %></div></li>
												</ul>
												<a class="btn btn-theme" href="#" onClick="imprimer('procesBox')">Imprimer</a>
                                        	
                                               </div>
                                            	
                                            <%} %>
                                            
                                            
            		
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 col-lg-offset-6 col-md-offset-6 col-sm-offset-6">
            <button class="btn btn-theme" id="prev">Precedent</button>
            </div>
            
			</div>
		</div>
		</div>
	</section>
