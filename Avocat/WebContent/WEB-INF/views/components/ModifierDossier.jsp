    <%@page import="DAO.daoAjouterDossier"%>
<%@page import="DAO.daoAjouterDossier.MyResult"%>
<%@page import="java.util.ArrayList"%>
<section class="wrapper site-min-height">
     <div class="row" id="mod" style="display: none;">
			<div class="col-lg-12">
				<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
					<div class="custom-box" id="procesBoxM">
						<div class="servicetitle">
	                  		<h4>Dossier</h4>
	                  		<hr>
	                	</div>
		                <div class="icn-main-container">
		                  <span class="icn-container">D</span>
		                </div>	
						<%ArrayList<MyResult> list = daoAjouterDossier.listDossier();
						for(int i =0 ; i<list.size();i++){%>
						<div style="display: none;" class="update">
							<p style="display: none;">ID Client  :<input type="text" readonly="readonly" value="<%=list.get(i).getDossier().getIdDos()%>"></p>
							<ul class="pricingM">
								<li > <span class="procesTitles"><span class="spanM">Etat avancement           : 	</span><select><option value="1" <%if(list.get(i).getStatut()==1){ %><%="selected"%> <%}%>>premiere Instance</option> <option value="2" <% if(list.get(i).getStatut()==2){ %><%="selected" %> <%}%>>deuxieme Instance</option>  <option value="3"<% if(list.get(i).getStatut()==3){ %> <%="selected" %> <%}%>>troisieme Instance</option></select></span><br></li>
								<li > <span class="procesTitles"><span class="spanM">Type de proces            : 	</span><select><option value="proces en droit de la famille" <%if(list.get(i).getDossier().getTypeProces().equals("proces en droit de la famille")){ %><%="selected"%> <%}%> >proces en droit de la famille</option>  <option value="proces en droit civil" <%if(list.get(i).getDossier().getTypeProces().equals("proces en droit civil")){ %><%="selected"%> <%}%>>proces en droit civil</option>  <option value="proces en droit du travail" <%if(list.get(i).getDossier().getTypeProces().equals("proces en droit du travail")){ %><%="selected"%> <%}%>>proces en droit du travail</option>  <option value="procès en droit administratif" <%if(list.get(i).getDossier().getTypeProces().equals("procès en droit administratif")){ %><%="selected"%> <%}%>>procès en droit administratif</option>  <option value="procès en droit commercial" <%if(list.get(i).getDossier().getTypeProces().equals("procès en droit commercial")){ %><%="selected"%> <%}%>>procès en droit commercial</option>  <option value="procès en droit pénal" <%if(list.get(i).getDossier().getTypeProces().equals("procès en droit pénal")){ %><%="selected"%> <%}%>>procès en droit pénal</option></select></span><br></li>
								<li > <span class="procesTitles"><span class="spanM">Description           	   : 	</span><input type="text" value="<%=list.get(i).getDossier().getDescription() %>"></span></li>
							</ul>
							
						                            	
						</div>
                                
                                <%} %>
                       <button class="btn btn-theme" id="modifierCl">modifier</button>
         		
					</div>
				
				</div>
				<div class="col-lg-8 col-md-8 col col-sm-8 col-xs-12 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
            		<button class="btn btn-theme" style="white-space: pre;height100%;width: 100%;" id="previous">Precedent</button>
            	</div>
			</div>
		</div>
	</section>