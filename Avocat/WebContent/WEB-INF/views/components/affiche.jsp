<%@page import="models.Compte"%>
<%@page import="DAO.daoAjouterDossier"%>
<%@page import="DAO.daoAjouterDossier.MyResult"%>
<%@page import="java.util.ArrayList"%>
<% HttpSession ses = request.getSession();
	 Compte client = null;
	 client = (Compte)session.getAttribute("client"); 
	%> 
<%@page import="DAO.daoAjouterDossier.MyResult"%>
<%@page import="DAO.daoAjouterDossier"%>
<%@page import="DAO.daoAjouterProces"%>
<%@page import="models.Dossier"%>
<%@page import="DAO.daoAjouterConsultation"%>
<%@page import="models.Consultation"%>
<%@page import="models.Client"%>
<%@page import="DAO.daoClient"%>
<%@page import="java.util.ArrayList"%>
<div id="tab" >

	<section class="wrapper">
	        <div class="row mb">
	          <!-- page start-->
	          <div class="content-panel">
	            <div class="adv-table">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        
<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Dossier</h3>
                                <div class="table-responsive">
                                <form action="AccueilClient" method="post">
                                <%ArrayList<MyResult> list = daoAjouterDossier.listDossier(client.getIdClient()); %>
                                <span style="display : none" id="mapSize"><%=list.size()%></span>
                                    <table class="table table-data2" id="tableAvocat">
                                        <thead>
                                            <tr>
                                                <th>
                                                    
                                                </th>
                                                <th>Id Dossier</th>
                                                <th>Type de procés</th>
                                                <th>Etat Avancemant</th>
                                              
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                        String stat = null;
                                        	for(int i =0 ; i<list.size();i++){
                                        	if(list.get(i).getStatut()==1){
                                        		stat ="Premiere Instance";}else if(list.get(i).getStatut()==2){stat="Deuxieme instance";}else if(list.get(i).getStatut()==3){stat="troisieme instance";}%>
											<tr class="tr-shadow trowM trow">
                                                <td>
                                                    <i class="fa fa-folder-open" aria-hidden="true"></i>
                             					</td>
                                                <td><%=list.get(i).getDossier().getIdDos()%></td>
                                                <td class="5"><%=list.get(i).getDossier().getTypeProces() %></td>
                                                <td class="6">
                                                    <span style="font-size: 1em"><%=stat %></span>
                                                </td>
                                            </tr>
                                           
                                            <%} %>
                                        </tbody>
                                    </table>
                                    <input type="hidden" value="" name="num" id="num">
                                    <input type="submit" style="display:none" id="submit"> 
                                    </form>
                                </div>
                            </div>
                        </div>
						</div>
					</div>
				</div>
        	</div>
    	</div>
	</section>            
</div>
