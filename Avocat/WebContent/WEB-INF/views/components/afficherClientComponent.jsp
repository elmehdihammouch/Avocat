<%@page import="models.Compte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.daoClient"%>



    <section class="wrapper 000" style="display: none;">
     <div class="row" id="affichage" style="display: none;">
			<div class="col-lg-12">
				<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
				<div class="custom-box" id="ClientBox">
				<div class="servicetitle">
                  <h4>Client</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">C</span>
                </div>	
				<%ArrayList<Compte> list = daoClient.listClient();
                                        	for(int i =0 ; i<list.size();i++){%>
                                        	<div style="display: none;" class="search">
                                        	 <p style="display: none;">ID Client  :<input type="text" readonly="readonly" value="<%=list.get(i).getClient().getId()%>"></p>
												<ul class="pricing">
													<li ><span class="procesTitles">Nom : </span><div class="titlesContent"><%=list.get(i).getClient().getNom()%></div></li>
													<li > <span class="procesTitles">Prenom : </span><div class="titlesContent"><%=list.get(i).getClient().getPrenom()%></div></li>
													<li > <span class="procesTitles">CIN :  </span><div class="titlesContent"><%=list.get(i).getClient().getCin()%></div></li>
													<li > <span class="procesTitles">EMAIL : </span><div class="titlesContent"><%=list.get(i).getClient().getEmail()%></div></li>
													<li > <span class="procesTitles">Adresse : </span><div class="titlesContent"><%=list.get(i).getClient().getAdresse()%></div></li>
													<li > <span class="procesTitles">Municipale :</span><div class="titlesContent"><%=list.get(i).getClient().getMunicipale()%></div></li>
													<li > <span class="procesTitles">Lieu de naissance :</span><div class="titlesContent"><%=list.get(i).getClient().getLieuNais()%></div></li>
													<li > <span class="procesTitles">Nationalité : </span><div class="titlesContent"><%=list.get(i).getClient().getNationalite()%></div></li>
													<li > <span class="procesTitles">Telephone :</span><div class="titlesContent"><%=list.get(i).getClient().getTelephone()%></div></li>
													<li > <span class="procesTitles">Date de naissance : </span><div class="titlesContent"><%=list.get(i).getClient().getDateNais()%></div></li>
													<li > <span class="procesTitles">EMAIL Client : </span><div class="titlesContent"><%if(list.get(i).getEmailCl() != null){%><%=list.get(i).getEmailCl()%><%}else{ %><%="-----------------------------"%><%} %></div></li>
													<li > <span class="procesTitles">Password :</span><div class="titlesContent"><%if(list.get(i).getEmailCl() != null){%><%=list.get(i).getPasswordCl()%><%}else{ %><%="----------------------------- "%><%} %></div></li>
													<li > <span class="procesTitles">Statut : </span><div class="titlesContent"><%if(list.get(i).getEmailCl() != null){%><%=list.get(i).getStatut()%><%}else{ %><%="Compte  pas crée "%><%} %></div></li>
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
