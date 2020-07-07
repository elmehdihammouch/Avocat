<%@page import="DAO.daoAjouterConsultation"%>
<%@page import="models.Consultation"%>
<%@page import="models.Compte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.daoClient"%>



    <section class="wrapper">
     <div class="row" id="affichage" style="display: none;">
			<div class="col-lg-12">
				<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
				<div class="custom-box" id="ConsultationBox">
				<div class="servicetitle">
                  <h4>Consultation</h4>
                  <hr>
                </div>
                <div class="icn-main-container">
                  <span class="icn-container">C</span>
                </div>	
				<%ArrayList<Consultation> list = daoAjouterConsultation.listConsultation();
                                        	for(int i =0 ; i<list.size();i++){%>
                                        	<div style="display: none;" class="search">
                                        	 <p style="display: none;">ID Client  :<input type="text" readonly="readonly" value="<%=list.get(i).getIdConsultation()%>"></p>
												<ul class="pricing">
													<li ><span class="procesTitles">Nom : </span><div class="titlesContent"><%=list.get(i).getClient().getNom()%></div></li>
													<li > <span class="procesTitles">Prenom : </span><div class="titlesContent"><%=list.get(i).getClient().getPrenom()%></div></li>
													<li > <span class="procesTitles">CIN :  </span><div class="titlesContent"><%=list.get(i).getClient().getCin()%></div></li>
													<li > <span class="procesTitles">EMAIL : </span><div class="titlesContent"><%=list.get(i).getClient().getEmail()%></div></li>
													<li > <span class="procesTitles">Telephone :</span><div class="titlesContent"><%=list.get(i).getClient().getTelephone()%></div></li>
													<li > <span class="procesTitles">Type de proces : </span><div class="titlesContent"><%=list.get(i).getTypeProces()%></div></li>
													<li > <span class="procesTitles">Description :</span><div class="titlesContent"><%=list.get(i).getDescription()%></div></li>
													<li > <span class="procesTitles">Frais : </span><div class="titlesContent"><%=list.get(i).getFrais()%></div></li>
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
